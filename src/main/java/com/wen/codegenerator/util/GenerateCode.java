package com.wen.codegenerator.util;

import com.wen.codegenerator.bean.Field;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("GenerateCode")
public class GenerateCode {
    @Autowired
    private DataSource dataSource;

    private String tableName = "third_auth";

    public static final Configuration configuration = new Configuration(Configuration.getVersion());

    static {
        // 设置模板文件的默认字符集
        configuration.setDefaultEncoding("utf-8");
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
            // 获取模板对象
            Template template = configuration.getTemplate(templatePath.getPath());
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
        // 封装模板类需要的数据
        Map map = new HashMap();

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
            field.setFiledName(columnName);
            field.setFiledNameUpperFirstChar(FieldUtil.toUpperFirstLetter(columnName));
            field.setFiledType(FieldUtil.ColumnTypeToFiledType(typeName));
            field.setFiledRemarks(remarks);

            fieldList.add(field);
        }

        map.put("className", FieldUtil.TableNameToClassName(tableName));
        map.put("fields", fieldList);

        File tempaltePath = new File("E:"+File.separator+"workspace\\code-generator\\src\\main\\webapp\\WEB-INF\\template\\dto.ftl");
        File targetPath = new File("E:\\workspace\\code-generator\\src\\main\\java\\com\\wen\\codegenerator\\dto\\" + map.get("className") + "DTO.java");

        createFile(tempaltePath, targetPath, map);
        
        return null;
    }
}
