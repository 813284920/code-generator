package com.wen.test;

import com.wen.codegenerator.template.model.Field;
import com.wen.codegenerator.template.util.BaseDataUtils;
import com.wen.codegenerator.template.util.CodeGeneration;
import com.wen.codegenerator.template.util.FreeMarkerUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class MyTest {
    @Autowired
    private CodeGeneration codeGeneration;
    @Autowired
    private FreeMarkerUtil freeMarkerUtil;

    @Autowired
    private BaseDataUtils baseDataUtils;

    @Test
    public void test1() throws SQLException {
        codeGeneration.generate();
    }

    @Test
    public void testU() {
        List<Field> fields = baseDataUtils.getFields("jk_house");
    }
}
