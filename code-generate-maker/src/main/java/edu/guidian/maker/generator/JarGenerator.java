package edu.guidian.maker.generator;

import java.io.*;

public class JarGenerator {

    public static void doGenerate(String projectDir) throws IOException, InterruptedException {
        String winMavenCommand = "mvn.cmd clean package -DskipTests=true";
        String otherMavenCommand = "mvn clean package -DskipTests=true";
        String manvenCommand = winMavenCommand;
        ProcessBuilder processBuilder = new ProcessBuilder(manvenCommand.split(" "));
        processBuilder.directory(new File(projectDir));
        Process process = processBuilder.start();

        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        int exitCode = process.waitFor();
        System.out.println("命令执行结束，退出码：" + exitCode);

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        doGenerate("E:\\星球项目\\code-generate\\generated\\acm-template-pro-generator");

    }

}
