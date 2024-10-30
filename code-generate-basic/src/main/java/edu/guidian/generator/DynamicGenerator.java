package edu.guidian.generator;

import edu.guidian.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class DynamicGenerator {

    public static void main(String[] args) throws IOException, TemplateException {
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        // 指定模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(new File("code-generate-basic/src/main/resources/templates"));
        configuration.setDefaultEncoding("UTF-8");
        // 通过模板名称，获取模板对象
        Template template = configuration.getTemplate("MainTemplate.java.ftl");
        //创建数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("yupi");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果");

        Writer out = new FileWriter("MainTemplate.java");
        template.process(mainTemplateConfig, out);
        out.close();

    }
}
