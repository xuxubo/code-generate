package edu.guidian;

import edu.guidian.cli.CommandExecutor;

import java.io.File;

import static edu.guidian.generator.StaticGenerator.copyFilesByHutool;


public class Main {
    public static void main(String[] args) {
//        String projectPath = System.getProperty("user.dir");
//        File projectFile = new File(projectPath).getParentFile();
//
//        String inputPath = new File(projectFile, "code-generate/acm-template").getAbsolutePath();
//
//        String outputPath = projectPath;
//        copyFilesByHutool(inputPath, outputPath);
        //args = new String[]{"list"};
        //args = new String[]{"config"};
        //args = new String[]{"generate", "-l", "-a", "-o"};
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);


    }
}