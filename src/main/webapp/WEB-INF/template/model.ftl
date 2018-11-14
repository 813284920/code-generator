package ${packagePath};

public class ${className} {
<#if fields?? && fields?size gt 0>
    <#list fields as field>
    // ${field.variableRemarks}
    private ${field.variableType} ${field.variableName};
    </#list>

    <#list fields as field>
    public ${field.variableType} get${field.variableNameUpperFirstChar}() {
    return ${field.variableName};
    }

    public void set${field.variableNameUpperFirstChar}(${field.variableType} ${field.variableName}) {
    this.${field.variableName} = ${field.variableName};
    }

    </#list>
</#if>
}
