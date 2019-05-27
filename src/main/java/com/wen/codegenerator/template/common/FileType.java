package com.wen.codegenerator.template.common;

public enum FileType {

    DTO("DTO", "dto.ftl", "com.wen.codegenerator.dto"),
    MODEL("", "model.ftl", "com.wen.codegenerator.model"),
    SERVICE("Service", "service.ftl", "com.wen.codegenerator.service"),
    CONTROLLER("Controller", "controller.ftl", "com.wen.codegenerator.controller"),
    SERVICEIMPL("ServiceImpl", "serviceImpl.ftl", "com.wen.codegenerator.service.impl"),
    DAO("Dao", "dao.ftl", "com.wen.codegenerator.dao")
    ;

    private String fileSuffix = ".java";
    private String fileNameSuffix;
    private String templateName;
    private String packagePath;

    FileType(String fileNameSuffix, String templateName, String packagePath) {
        this.fileNameSuffix = fileNameSuffix;
        this.templateName = templateName;
        this.packagePath = packagePath;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public String getFileNameSuffix() {
        return fileNameSuffix;
    }

    public String getTemplateName() {
        return templateName;
    }

    public String getPackagePath() {
        return packagePath;
    }
}
