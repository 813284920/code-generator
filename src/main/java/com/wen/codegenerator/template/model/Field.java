package com.wen.codegenerator.template.model;

/**
 * 属性类，用于封装数据库中的字段
 *
 * @author 温欣悦
 * @date 2018/11/13
 */
public class Field {

    /**
     * 字段名（数据库用）
     */
    private String fieldName;

    /**
     * 属性名
     */
    private String attributeName;

    /**
     * 属性方法名
     */
    private String attributeMethodName;

    /**
     * 属性类型
     */
    private String attributeType;

    /**
     * 属性类型（包装类）
     */
    private String attributeTypePackage;

    /**
     * 字段&属性的注释
     */
    private String comment;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeMethodName() {
        return attributeMethodName;
    }

    public void setAttributeMethodName(String attributeMethodName) {
        this.attributeMethodName = attributeMethodName;
    }

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAttributeTypePackage() {
        return attributeTypePackage;
    }

    public void setAttributeTypePackage(String attributeTypePackage) {
        this.attributeTypePackage = attributeTypePackage;
    }
}
