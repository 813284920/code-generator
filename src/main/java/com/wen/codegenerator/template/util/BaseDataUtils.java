package com.wen.codegenerator.template.util;

import com.wen.codegenerator.template.model.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * 数据库的工具类
 *
 * @author 温欣悦
 * @date 2018/11/14
 */

/**
 *
 *
 * @author 温欣悦
 * @date 2019/5/14
 */
@Component
public class BaseDataUtils {

    @Autowired
    private DataSource dataSource;

    private static Connection connection;

    /**
     * 封装元素据
     *
     * @param tableName 表名
     * @return
     * @author wxy
     */
    public List<Field> getFields(String tableName) {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 封装数据库字段数据
        List<Field> fieldList = new ArrayList<>();
        DatabaseMetaData metaData = null;
        try {
            metaData = connection.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 获取数据库元数据
        ResultSet resultSet = null;
        try {
            resultSet = metaData.getColumns(null, "%", tableName, "%");
            while (resultSet.next()) {
                // 字段名
                String fieldName = resultSet.getString("COLUMN_NAME");
                // 类型
                String typeName = resultSet.getString("TYPE_NAME");
                // 注释
                String remarks = resultSet.getString("REMARKS");
                // 封装为属性类
                Field field = new Field();
                field.setFieldName(fieldName);
                field.setAttributeName(FieldUtil.field2Attribute(fieldName, true));
                field.setAttributeMethodName(FieldUtil.field2Attribute(fieldName, false));
                field.setAttributeType(FieldUtil.fieldType2AttributeType(typeName, false));
                field.setAttributeTypePackage(FieldUtil.fieldType2AttributeType(typeName, true));
                field.setRemarks(remarks);
                fieldList.add(field);
            }
        } catch (SQLException e) {
        }
        return fieldList;
    }
}
