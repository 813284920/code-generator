package com.wen.codegenerator.template.util;

import com.wen.codegenerator.template.common.FileType;
import com.wen.codegenerator.template.model.Param;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.stereotype.Component;

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
            new File("E:" + File.separator + "workspace" + File.separator + "code-generator" +
                    File.separator + "src" + File.separator + "main" + File.separator +
                    "webapp" + File.separator + "WEB-INF" + File.separator + "template");
    // 目标的路径 相对于项目TODO
    private static final String targetPath =
            "E:\\workspace\\code-generator\\src\\main\\java\\com\\wen\\codegenerator\\file";

    // FreeMarker配置
    public static final Configuration configuration = new Configuration(Configuration.getVersion());

//    private

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
     * @param param 模板所需要的参数
     * @return true:生成文件成功;false:生成文件失败
     * @author wxy
     */
    public Boolean createFile(FileType fileType, Param param) {
        try {
            // 设置模板文件的默认字符集
            configuration.setDefaultEncoding("utf-8");
            // 获取模板对象
            Template template = configuration.getTemplate(fileType.getTemplateName());
            // 创建目标路径的输出流对象
            String compileteFilePath = getCompletePath(fileType.getPackagePath()) + File.separator + param.getFileName()+ fileType.getFileSuffix();
            Writer writer = new FileWriter(compileteFilePath);
            // 生成模板
            template.process(param, writer);
            // 关闭输出流
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 根据包路径获取项目完全路径
     *
     * @author wxy
     */
    private static String getCompletePath(String packagePath) {
        StringBuilder completePathBuilder = new StringBuilder();
        // 项目根路径
        completePathBuilder.append(System.getProperty("user.dir"));
        // java项目根路径
        completePathBuilder.append(File.separator).append("src").append(File.separator).append("main").append(File.separator).append("java");
        // 包路径
        String[] packageNames = packagePath.split("\\.");
        for (String packageName : packageNames) {
            completePathBuilder.append(File.separator).append(packageName);
        }
        return completePathBuilder.toString();
    }
}
