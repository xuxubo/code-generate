


package edu.guidian.maker.generator.file;
import edu.guidian.maker.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 核心生成器
 */
public class MainGenerator {

    /**
     * 生成
     *
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException {
        //String projectPath = System.getProperty("user.dir");
        // 整个项目的根路径
        String projectPath = System.getProperty("user.dir") + File.separator + "code-generate-maker";
        System.out.println("整个项目的根路径:"+projectPath);
        String inputPath = projectPath + File.separator + "/src/main/resources/templates/MainTemplate.java.ftl";
        System.out.println("输入路径"+inputPath);
        String outputPath = projectPath + File.separator + "MainTemplate.java";
        System.out.println("输出路径"+outputPath);
        // 生成静态文件
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);
        // 生成动态文件
        String inputDynamicFilePath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        System.out.println("动态输入路径："+inputDynamicFilePath);
        String outputDynamicFilePath = outputPath ;//+ File.separator+ "acm-template/src/com/yupi/acm/MainTemplate.java"
        System.out.println("动态输出路径"+outputDynamicFilePath);
        DynamicGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        DataModel dataModel = new DataModel();
        dataModel.setAuthor("yupi");
        dataModel.setLoop(false);
        dataModel.setOutputText("求和结果：");
        doGenerate(dataModel);
    }

}

