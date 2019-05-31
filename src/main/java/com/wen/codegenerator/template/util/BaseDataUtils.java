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
        // 获取表数据
        try {
            ResultSet columnsResultSet = metaData.getColumns(null, "%", tableName, "%");
            while (columnsResultSet.next()) {
                // 字段名
                String fieldName = columnsResultSet.getString("COLUMN_NAME");
                // 类型
                String typeName = columnsResultSet.getString("TYPE_NAME");
                // 注释
                String remarks = columnsResultSet.getString("REMARKS");
                // 封装为属性类
                Field field = new Field();
                field.setFieldName(fieldName);
                field.setAttributeName(FieldUtil.field2Attribute(fieldName, true));
                field.setAttributeMethodName(FieldUtil.field2Attribute(fieldName, false));
                field.setAttributeType(FieldUtil.fieldType2AttributeType(typeName, false));
                field.setAttributeTypePackage(FieldUtil.fieldType2AttributeType(typeName, true));
                field.setComment(remarks);
                fieldList.add(field);
            }
        } catch (SQLException e) {
        }
        return fieldList;
    }

    public String getPrimaryKey(String tableName) {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseMetaData metaData = null;
        try {
            metaData = connection.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 获取表主键
        try {
            String catalog = connection.getCatalog();
            ResultSet primaryKeyResultSet = metaData.getPrimaryKeys(catalog, null, tableName);
            while (primaryKeyResultSet.next()) {
                return primaryKeyResultSet.getString("COLUMN_NAME");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
