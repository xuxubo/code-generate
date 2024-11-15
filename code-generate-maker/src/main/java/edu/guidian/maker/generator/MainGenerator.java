package edu.guidian.maker.generator;

import cn.hutool.extra.template.TemplateException;
import edu.guidian.maker.generator.file.DynamicFileGenerator;
import edu.guidian.maker.generator.file.StaticGenerator;
import edu.guidian.maker.model.DataModel;

import java.io.File;
import java.io.IOException;

public class MainGenerator {


    /**
     * 生成
     *
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException, freemarker.template.TemplateException {
        String inputRootPath = "E:\\星球项目\\code-generate\\acm-template";
        String outputRootPath = "E:\\星球项目\\code-generate\\acm-template-pro";

        String inputPath;
        String outputPath;

        inputPath = new File(inputRootPath, "src/com/yupi/acm/MainTemplate.java.ftl").getAbsolutePath();
        outputPath = new File(outputRootPath, "src/com/yupi/acm/MainTemplate.java").getAbsolutePath();
        DynamicFileGenerator.doGenerate(inputPath, outputPath, model);

        inputPath = new File(inputRootPath, ".gitignore").getAbsolutePath();
        outputPath = new File(outputRootPath, ".gitignore").getAbsolutePath();
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);

        inputPath = new File(inputRootPath, "README.md").getAbsolutePath();
        outputPath = new File(outputRootPath, "README.md").getAbsolutePath();
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);
    }

    public static void main(String[] args) throws TemplateException, IOException, freemarker.template.TemplateException {
        DataModel mainTemplateConfig = new DataModel();
        mainTemplateConfig.setAuthor("yupi");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");

        doGenerate(mainTemplateConfig);

    }

}
