package ${basePackage}.generator;


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

String projectPath = System.getProperty("user.dir");
System.out.println(projectPath);
String inputRootPath = projectPath + File.separator + "${fileConfig.inputRootPath}";
String outputRootPath = projectPath + File.separator + "${fileConfig.outputRootPath}";


String inputPath;
String outputPath;
<#list fileConfig.files as fileInfo>





    inputPath = new File(inputRootPath, "${fileInfo.inputPath}").getAbsolutePath();
    outputPath = new File(outputRootPath, "${fileInfo.outputPath}").getAbsolutePath();
    <#if fileInfo.generateType == "static">
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);
    <#else>
        DynamicGenerator.doGenerate(inputPath, outputPath, model);
    </#if>
</#list>
}
}
