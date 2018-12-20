package com.wen.test;

import com.wen.codegenerator.util.CodeGeneration;
import com.wen.codegenerator.util.FreeMarkerUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileWriter;
import java.io.Writer;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class MyTest {
    @Autowired
    private CodeGeneration codeGeneration;
    @Autowired
    private FreeMarkerUtil freeMarkerUtil;

    @Test
    public void test1() throws SQLException {
        codeGeneration.generate();
    }


    @Test
    public void test2() {
        freeMarkerUtil.createFile2();
    }
}
