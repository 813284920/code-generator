package com.wen.codegenerator.bean;

/**
 * 属性类，用于封装数据库中的字段
 *
 * @author 温欣悦
 * @date 2018/11/13
 */
public class Field {
    // 字段名
    private String filedName;
    // 字段名首字母大写
    private String filedNameUpperFirstChar;
    // 字段类型
    private String filedType;
    // 字段注释
    private String filedRemarks;

    public String getFiledName() {
        return filedName;
    }

    public void setFiledName(String filedName) {
        this.filedName = filedName;
    }

    public String getFiledNameUpperFirstChar() {
        return filedNameUpperFirstChar;
    }

    public void setFiledNameUpperFirstChar(String filedNameUpperFirstChar) {
        this.filedNameUpperFirstChar = filedNameUpperFirstChar;
    }

    public String getFiledType() {
        return filedType;
    }

    public void setFiledType(String filedType) {
        this.filedType = filedType;
    }

    public String getFiledRemarks() {
        return filedRemarks;
    }

    public void setFiledRemarks(String filedRemarks) {
        this.filedRemarks = filedRemarks;
    }
}
