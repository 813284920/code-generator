package com.wen.codegenerator.bean;

/**
 * 属性类，用于封装数据库中的字段
 *
 * @author 温欣悦
 * @date 2018/11/13
 */
public class Field {
    // 字段名
    private String variableName;
    // 字段名首字母大写
    private String variableNameUpperFirstChar;
    // 字段类型
    private String variableType;
    // 字段注释
    private String variableRemarks;

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableNameUpperFirstChar() {
        return variableNameUpperFirstChar;
    }

    public void setVariableNameUpperFirstChar(String variableNameUpperFirstChar) {
        this.variableNameUpperFirstChar = variableNameUpperFirstChar;
    }

    public String getVariableType() {
        return variableType;
    }

    public void setVariableType(String variableType) {
        this.variableType = variableType;
    }

    public String getVariableRemarks() {
        return variableRemarks;
    }

    public void setVariableRemarks(String variableRemarks) {
        this.variableRemarks = variableRemarks;
    }
}
