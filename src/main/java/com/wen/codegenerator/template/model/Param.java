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

    public List<Field> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }
}
