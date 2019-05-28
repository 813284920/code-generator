package ${packagePath};

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.wen.codegenerator.dto.${tableNameU}DTO;
import com.wen.codegenerator.model.${tableNameU};

/**
 *
 *
 * @author 温欣悦
 * @date ${.now?string["yyyy/MM/dd"]}
 */
@Service
public class ${fileName} {
    <#assign tableNameU = tableName4J?cap_first>
    <#assign tableNameL = tableName4J?uncap_first>

    private final Logger LOGGER = LoggerFactory.getLogger(${fileName}.class);

    @Autowired
    private ${tableNameU}Dao ${tableNameL}Dao;

    private ${tableNameU}DTO model2DTO(${tableNameU} model) {
        ${tableNameU}DTO dto = new ${tableNameU}DTO();
    <#list fieldList as field>
        dto.set${field.attributeMethodName}(model.get${field.attributeMethodName}());
    </#list>
        return dto;
    }

    private ${tableNameU} dto2Model(${tableNameU}DTO dto) {
        ${tableNameU} model = new ${tableNameU}();
    <#list fieldList as field>
    <#if field.attributeTypePackage == "Integer">
        model.set${field.attributeMethodName}(dto.get${field.attributeMethodName}() == null ? 0 : dto.get${field.attributeMethodName}().intValue());
        <#elseif field.attributeTypePackage == "Long">
        model.set${field.attributeMethodName}(dto.get${field.attributeMethodName}() == null ? 0L : dto.get${field.attributeMethodName}().longValue());
        <#elseif field.attributeTypePackage == "Boolean">
        model.set${field.attributeMethodName}(dto.get${field.attributeMethodName}() == null ? false : dto.get${field.attributeMethodName}().booleanValue());
        <#elseif field.attributeTypePackage == "Double">
        model.set${field.attributeMethodName}(dto.get${field.attributeMethodName}() == null ? 0.0 : dto.get${field.attributeMethodName}().doubleValue());
        <#else>
        model.set${field.attributeMethodName}(dto.get${field.attributeMethodName}());
    </#if>
    </#list>
        return model;
    }


}

