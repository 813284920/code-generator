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
    private String tableName = "third_auth";


    public void generate() throws SQLException {
        Set<String> fileTypes = new HashSet<>();
        fileTypes.add("dto");
        fileTypes.add("model");
        // 判断是要生成什么文件
        if (fileTypes.contains("dto") ) {

        }
        if (fileTypes.contains("model")) {

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

        String className = FieldUtil.toUpperFirstLetter(FieldUtil.tableNameToClassName(tableName)) + "DTO";

        MyClass myClass = new MyClass();
        myClass.setClassName(className);
        myClass.setFields(fieldList);
        myClass.setPackagePath("com.wen.codegenerator.dto");


        File targetPath = new File("E:"+File.separator+"workspace"+File.separator+"code-generator"+File.separator+
                "src"+File.separator+"main"+File.separator+"java"+File.separator+"com"+File.separator+"wen"+File.separator+
                "codegenerator"+File.separator+"dto"+File.separator+"" + className + ".java");

        createFile(templatePath, targetPath, myClass);

        System.out.println(myClass.getFields().size());

    }
}
