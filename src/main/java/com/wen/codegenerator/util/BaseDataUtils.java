package com.wen.codegenerator.util;

import com.wen.codegenerator.bean.Field;
import org.springframework.beans.factory.annotation.Autowired;

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
public class BaseDataUtils {
    @Autowired
    private static DataSource dataSource;
    private static Connection connection;

    static {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取指定数据表的元数据并将其封装为Java类属性
     *
     * @param tableName 数据表名
     * @return 元数据转换为的Java属性
     * @author wxy
     */
    private List<Field> getMetadataToField(String tableName) {
        // 封装数据库字段数据
        List<Field> fieldList = new ArrayList<Field>();

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fieldList;
    }
}
