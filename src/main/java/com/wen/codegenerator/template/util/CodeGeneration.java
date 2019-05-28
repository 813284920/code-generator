package com.wen.codegenerator.template.util;

import com.wen.codegenerator.template.model.Field;
import com.wen.codegenerator.template.common.FileType;
import com.wen.codegenerator.template.model.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CodeGeneration {

    @Autowired
    private BaseDataUtils baseDataUtils;

    @Autowired
    private FreeMarkerUtil freeMarkerUtil;

    /**
     * 要生成的表名
     */
    private static final String[] tableNames = {"jk_community"};
    /**
     * 要生成的文件类型[dto|service]
     */
    private static final FileType[] fileTypes = {FileType.DTO, FileType.MODEL, FileType.SERVICEIMPL};

    public void generate() {
        for (String tableName : tableNames) {
            // 获取文件名
            String fileName = FieldUtil.field2Attribute(tableName, false);

            // 获取数据表元数据
            List<Field> fieldList = baseDataUtils.getFields(tableName);
            for (FileType fileType : fileTypes) {
                Param param = new Param();
                param.setFileName(fileName + fileType.getFileNameSuffix());
                param.setFieldList(fieldList);
                param.setPackagePath(fileType.getPackagePath());
                param.setTableName4J(FieldUtil.field2Attribute(tableName, false));
                param.setTableName(tableName);
                freeMarkerUtil.createFile(fileType, param);
            }
        }
    }
}
