package edu.guidian.cli.example;

import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * 交换式输入
 */
@CommandLine.Command(name = "login", version = "1.0.0", mixinStandardHelpOptions = true)
public class login implements Callable<Integer> {

    @CommandLine.Option(names = {"-u", "--username"}, description = "用户名")
    String username;
//建议给所有需要交互式输入的选项都增加 arity 参数（一般是 arity = "0..1"），这样用户既可以在完整命令中直接给选项填充参数，也可以选择交互式输入。
    @CommandLine.Option(names = {"-p", "--password"}, description = "密码", interactive = true,arity = "0..1")
    String password;
    @Override
    public Integer call() throws Exception {
        System.out.println("Password is " + password + ", username is " + username);
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new login()).execute("-u", "徐振博", "-p");
    }

    /**
     * 强制输入参数未解决，可通过业务逻辑实现
     * public void run() {
     *         if (value == null && System.console() != null) {
     *             // 主动提示用户输入
     *             value = System.console().readLine("Enter value for --interactive: ");
     *         }
     *         System.out.println("You provided value '" + value + "'");
     *     }
     *  或者使用通用校验程序，如果用户输入命令没有包含交互式选项，自动为输入命令补充该选项
     */
}
