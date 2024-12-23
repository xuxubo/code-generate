package edu.guidian.maker.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

/**
 * 自动生成脚本文件
 */
public class ScriptGenerator {

    public static void doGenerate(String outputPath, String jarPath) {
        //linux
        StringBuilder sb = new StringBuilder();
        sb.append("#!/bin/bash").append("\n");
        sb.append(String.format(("java -jar %s \"$@\""), jarPath)).append("\n");
        FileUtil.writeBytes(sb.toString().getBytes(StandardCharsets.UTF_8), outputPath);

//        Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rwxrwxrwx");
//        try {
//            Files.setPosixFilePermissions(Paths.get(outputPath), permissions);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        //windows
        sb = new StringBuilder();
        sb.append("@echo off").append("\n");
        sb.append(String.format(("java -jar  %s %%*"), jarPath)).append("\n");
        FileUtil.writeBytes(sb.toString().getBytes(StandardCharsets.UTF_8), outputPath +".bat");

    }
    public static void main(String[] args) throws IOException {
        String outputPath = "E:\\星球项目\\code-generate\\generated\\acm-template-pro-generator\\generator";
        System.out.println(outputPath);
        doGenerate(outputPath, "E:\\星球项目\\code-generate\\generated\\acm-template-pro-generator\\target\\acm-template-pro-generator-1.0-jar-with-dependencies.jar");
    }
}
