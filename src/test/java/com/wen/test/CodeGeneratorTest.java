package com.wen.test;

import com.wen.codegenerator.util.GenerateCode;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class CodeGeneratorTest {
    public static void main(String[] args) throws SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Application.xml");
        GenerateCode generateCode = (GenerateCode) applicationContext.getBean("GenerateCode");
        generateCode.generate();
    }
}
