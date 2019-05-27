package com.wen.codegenerator.template.util;


/**
 * 操作字段的工具类
 *
 * @author 温欣悦
 * @date 2018/11/13
 */
public class FieldUtil {

    /**
     * 将字段名转换为JavaBean的属性名的格式
     *
     * @param fieldName 数据库字段名
     * @param isCamel   属性名是否为驼峰命名规则。true=是，属性名首字母小写；false=不是，属性名首字母大写。
     * @author wxy
     */
    public static String field2Attribute(String fieldName, boolean isCamel) {
        fieldName = fieldName.toLowerCase();
        String[] fieldNamePieces = fieldName.split("_");
        StringBuilder attributeNameSB = new StringBuilder();
        for (int i = 0; i < fieldNamePieces.length; i++) {
            String fieldNamePiece = fieldNamePieces[i];
            int indexNotUp = fieldNamePieces.length;
            if (isCamel) {
                indexNotUp = 0;
            }
            if (i != indexNotUp) {
                char[] chars = fieldNamePiece.toCharArray();
                if (chars[0] >= 'a' && chars[0] <= 'z') {
                    chars[0] = (char) (chars[0] - 32);
                }
                attributeNameSB.append(new String(chars));
            } else {
                attributeNameSB.append(fieldNamePiece);
            }

        }
        return attributeNameSB.toString();
    }

    /**
     * 将数据库中的列字段类型转换成Java数据类型
     *
     * @param columnType
     * @param isPackagingClass
     * @return
     * @author wxy
     */
    public static String fieldType2AttributeType(String columnType, Boolean isPackagingClass) {
        String filedType = null;
        columnType = columnType.toLowerCase();
        if (isPackagingClass) {
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
        } else {
            switch (columnType) {
                case "varchar":
                    filedType = "String";
                    break;
                case "char":
                    filedType = "String";
                    break;
                case "int":
                    filedType = "int";
                    break;
                case "bigint":
                    filedType = "long";
                    break;
                case "tinyint":
                    // 0:false,1:true
                    filedType = "boolean";
                    break;
                case "double":
                    filedType = "double";
                    break;
                case "date":
                    filedType = "Date";
                    break;
            }
        }

        return filedType;
    }
}
