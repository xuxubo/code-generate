package edu.guidian.cli.example;

import picocli.CommandLine;

@CommandLine.Command(name = "main",mixinStandardHelpOptions = true)
public class SubCommandExample implements Runnable {

    @Override
    public void run() {
        System.out.println("run main command");
    }

    @CommandLine.Command(name = "add",mixinStandardHelpOptions = true)
    static class  AddCommand implements Runnable{
        @Override
        public void run() {
            System.out.println("run add command");
        }
    }

    @CommandLine.Command(name = "delete",mixinStandardHelpOptions = true)
    static class DeleteCommand implements Runnable{
        @Override
        public void run() {
            System.out.println("run delete command");
        }
    }

    @CommandLine.Command(name = "query",mixinStandardHelpOptions = true)
    static class QueryCommand implements Runnable{
        @Override
        public void run() {
            System.out.println("run query command");
        }
    }

    public static void main(String[] args) {
        String[] myArgs = new String[]{"--help"};
        // 查看主命令的帮助手册
//        String[] myArgs = new String[] { "--help" };
        // 执行增加命令
//        String[] myArgs = new String[] { "add" };
        // 执行增加命令的帮助手册
//        String[] myArgs = new String[] { "add", "--help" };
        // 执行不存在的命令，会报错
//        String[] myArgs = new String[] { "update" };
        int execute = new CommandLine(new SubCommandExample())
                .addSubcommand(new AddCommand())
                .addSubcommand(new DeleteCommand())
                .addSubcommand(new QueryCommand())
                .execute(myArgs);
        System.exit(execute);
    }
}
