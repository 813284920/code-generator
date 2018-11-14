package com.wen.codegenerator.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 操作FreeMarker的工具类
 *
 * @author 温欣悦
 * @date 2018/11/14
 */
@Component
public class FreeMarkerUtil {


    // 模板的路径 相对于项目 TODO
    private static final File templatePath =
            new File("E:"+ File.separator+"workspace"+File.separator+"code-generator"+
            File.separator+"src"+File.separator+"main"+File.separator+
            "webapp"+File.separator+"WEB-INF"+File.separator+"template");

    // FreeMarker配置
    public static final Configuration configuration = new Configuration(Configuration.getVersion());

    static {
        try {
            // 设置模板文件所在包路径
            configuration.setDirectoryForTemplateLoading(templatePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成文件
     *
     * @param targetPath   要生成的文件的路径
     * @param data         模板所需要的参数
     * @return true:生成文件成功;false:生成文件失败
     * @author wxy
     */
    public Boolean createFile(String targetPath, Object data) {
        try {
            // 设置模板文件的默认字符集
            configuration.setDefaultEncoding("utf-8");
            // 获取模板对象
            Template template = configuration.getTemplate("dto.ftl");
            // 创建目标路径的输出流对象
            Writer writer = new FileWriter(targetPath);
            // 生成模板
            template.process(data, writer);
            // 关闭输出流
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
