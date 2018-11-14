package com.wen.codegenerator.util;

import java.util.List;

/**
 * 操作字段的工具类
 *
 * @author 温欣悦
 * @date 2018/11/13
 */
public class FieldUtil {
    /**
     * 将字符串首字母变为大写
     *
     * @param str
     * @return
     * @author wxy
     */
    public static String toUpperFirstLetter(String str) {
        String uppserLetter = str.substring(0, 1).toUpperCase();
        String otherstring = str.substring(1);
        return uppserLetter + otherstring;
    }

    /**
     * 将数据库中的列字段类型转换成Java数据类型
     *
     * @param columnType
     * @return
     * @author wxy
     */
    public static String ColumnTypeToFiledType(String columnType) {
        String filedType = null;
        columnType = columnType.toLowerCase();
        switch (columnType) {
            case "varchar":
                filedType = "String";
                break;
            case "char":
                filedType = "String";
                break;
            case "int":
                filedType = "Integer";
                break;
            case "bigint":
                filedType = "Long";
                break;
            case "tinyint":
                // 0:false,1:true
                filedType = "Boolean";
                break;
            case "double":
                filedType = "Double";
                break;
            case "date":
                filedType = "Date";
                break;
        }

        return filedType;
    }

    /**
     * 将数据库表名转换为类名
     *
     * @param tableName
     * @return
     * @author wxy
     */
    public static String tableNameToClassName(String tableName) {
        StringBuilder className = new StringBuilder();
        String[] words = tableName.split("_");
        if (words != null && words.length > 0) {
            for (String word : words) {
                className.append(FieldUtil.toUpperFirstLetter(word));
            }
        } else {
            className.append(FieldUtil.toUpperFirstLetter(tableName));
        }

        return className.toString();
    }
}
