package com.wen.codegenerator.util;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.wen.codegenerator.bean.Field;
import com.wen.codegenerator.bean.MyClass;
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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class CodeGeneration {
    @Autowired
    private BaseDataUtils baseDataUtils;
    @Autowired
    private FreeMarkerUtil freeMarkerUtil;

    private String tableName = "third_auth";

    public void generate() throws SQLException {


        List<String> fileTypes = new ArrayList<>();
        fileTypes.add("dto");
        fileTypes.add("model");
        // 判断是要生成什么文件
        if (fileTypes.contains("dto") ) {
            // 获取数据表元数据
            List<Field> fieldList = baseDataUtils.getMetadataToField(tableName, true);
            // 生成DTO文件
            MyClass myClass = new MyClass();
            myClass.setClassName(FieldUtil.tableNameToClassName(tableName) + "DTO");
            myClass.setSuffix(".java");
            myClass.setFields(fieldList);
            freeMarkerUtil.createFile(myClass);
        }
        if (fileTypes.contains("model")) {
            // 获取数据表元数据
            List<Field> fieldList = baseDataUtils.getMetadataToField(tableName, false);
            // 生成DTO文件
            MyClass myClass = new MyClass();
            myClass.setClassName(FieldUtil.tableNameToClassName(tableName));
            myClass.setSuffix(".java");
            myClass.setFields(fieldList);
            freeMarkerUtil.createFile(myClass);
        }
        if (fileTypes.contains("mapper")) {

        }
        if (fileTypes.contains("controller")) {

        }
        if (fileTypes.contains("service")) {

        }
        if (fileTypes.contains("serviceImpl")) {

        }
        if (fileTypes.contains("dao")) {

        }
    }
}
