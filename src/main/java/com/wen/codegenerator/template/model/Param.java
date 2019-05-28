package com.wen.codegenerator.template.model;

import java.util.List;

public class Param {

    /**
     * 包路径
     */
    private String packagePath;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 表名（Java格式）
     */
    private String tableName4J;

    /**
     * 表名（数据库格式）
     */
    private String tableName;

    /**
     * 表字段
     */
    private List<Field> fieldList;

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTableName4J() {
        return tableName4J;
    }

    public void setTableName4J(String tableName4J) {
        this.tableName4J = tableName4J;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Field> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }
}
