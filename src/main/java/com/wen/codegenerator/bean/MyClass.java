package com.wen.codegenerator.bean;

import java.util.List;

/**
 * 用于封装类的属性
 *
 * @author 温欣悦
 * @date 2018/11/14
 */
public class MyClass {
    private String className;
    private List<Field> fields;
    private String packagePath;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }
}
