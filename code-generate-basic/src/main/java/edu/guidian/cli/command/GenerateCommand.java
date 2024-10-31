package edu.guidian.cli.command;

import cn.hutool.core.bean.BeanUtil;
import edu.guidian.generator.MainGenerator;
import edu.guidian.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "generate", description = "代码生成", mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {

    @CommandLine.Option(names = {"-l", "--loop"}, description = "是否循环",arity = "0..1")
    private boolean loop;
    @CommandLine.Option(names = {"-a", "--author"}, description = "作者",arity = "0..1")
    private String author;
    @CommandLine.Option(names = {"-o", "--outputText"}, description = "输出文本",arity = "0..1")
    private String outputText = "sum = ";


    @Override
    public Integer call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this, mainTemplateConfig);
        System.out.println("配置信息：" + mainTemplateConfig);
        MainGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }
}
