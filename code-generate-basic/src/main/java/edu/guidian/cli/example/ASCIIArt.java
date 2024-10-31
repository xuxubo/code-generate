package edu.guidian.cli.example;

import picocli.CommandLine;

//使用 @Command 注解标记该类并为其命名，mixinStandardHelpOptions 属性设置为 true 可以给应用程序自动添加 --help 和 --version 选项。
@CommandLine.Command(name = "ascii-art", version = "1.0.0", mixinStandardHelpOptions = true)
public class ASCIIArt implements Runnable{
//通过 @Option 注解将字段设置为命令行选项，可以给选项设置名称和描述。
    @CommandLine.Option(names = {"-s", "--font-size"}, description = "字体大小", defaultValue = "19")
    int fontSize = 19;
//通过 @Parameters 注解将字段设置为命令行参数，可以指定默认值、描述等信息
    @CommandLine.Parameters(paramLabel = "<words>", description = "要显示的文字",defaultValue = "Hello Picocli")
    private String[]  words = {"Hello", "Picocli"};

    @Override
    public void run() {
        System.out.println("fontSize = " + fontSize);
        System.out.println("words = " + String.join(",", words));
    }

    public static void main(String[] args) {
        //CommandLine.execute 方法返回一个退出代码。可以调用 System.exit 并将该退出代码作为参数，从而向调用进程表示成功或失败。
        int exitCode = new CommandLine(new ASCIIArt()).execute(args);
        System.exit(exitCode);
    }
}
