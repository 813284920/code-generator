package com.wen.codegenerator.util;

import com.wen.codegenerator.bean.Field;
import com.wen.codegenerator.bean.MyClass;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sound.midi.SoundbankResource;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class GenerateCode {
    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private String tableName = "third_auth";

    public static final Configuration configuration = new Configuration(Configuration.getVersion());

    public void beanTest() {
        System.out.println("测试Bean");
    }

    /**
     * 根据模板生成文件
     *
     * @param templatePath 模板文件路径
     * @param targetPath 要生成的文件的路径
     * @param data 模板所需要的参数
     * @return
     * @author wxy
     */
    public void createFile(File templatePath, File targetPath, Object data) {
        try {
            // 设置模板文件所在包路径
            configuration.setDirectoryForTemplateLoading(templatePath);
            // 设置模板文件的默认字符集
            configuration.setDefaultEncoding("utf-8");
            // 获取模板对象
            Template template = configuration.getTemplate("dto.ftl");
            // 创建目标路径的输出流对象
            Writer writer = new FileWriter(targetPath.getPath());
            // 生成模板
            template.process(data, writer);
            // 关闭输出流
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   public Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Map generate() throws SQLException {
        Connection connection = getConnection();
        DatabaseMetaData metaData = connection.getMetaData();
        // 获取数据库元数据
        ResultSet resultSet = metaData.getColumns(null, "%", tableName, "%");
        // 封装数据库字段数据
        List<Field> fieldList = new ArrayList<Field>();
        while (resultSet.next()) {
            // 列名
            String columnName = resultSet.getString("COLUMN_NAME");
            // 类型
            String typeName = resultSet.getString("TYPE_NAME");
            // 注释
            String remarks = resultSet.getString("REMARKS");

            // 封装为属性类
            Field field = new Field();
            field.setVariableName(columnName);
            field.setVariableNameUpperFirstChar(FieldUtil.toUpperFirstLetter(columnName));
            field.setVariableType(FieldUtil.ColumnTypeToFiledType(typeName));
            field.setVariableRemarks(remarks);

            fieldList.add(field);
        }

        String className = FieldUtil.toUpperFirstLetter(FieldUtil.tableNameToClassName(tableName)) + "DTO";

        MyClass myClass = new MyClass();
        myClass.setClassName(className);
        myClass.setFields(fieldList);
        myClass.setPackagePath("com.wen.codegenerator.dto");


        File templatePath = new File("E:"+ File.separator+"workspace"+File.separator+"code-generator"+
                File.separator+"src"+File.separator+"main"+File.separator+
                "webapp"+File.separator+"WEB-INF"+File.separator+"template");
        File targetPath = new File("E:"+File.separator+"workspace"+File.separator+"code-generator"+File.separator+
                "src"+File.separator+"main"+File.separator+"java"+File.separator+"com"+File.separator+"wen"+File.separator+
                "codegenerator"+File.separator+"dto"+File.separator+"" + className + ".java");

        createFile(templatePath, targetPath, myClass);

        System.out.println(myClass.getFields().size());
        
        return null;
    }
}
