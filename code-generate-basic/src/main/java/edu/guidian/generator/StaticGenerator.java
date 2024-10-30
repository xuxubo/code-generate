package edu.guidian.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * 静态文件生成
 */
public class StaticGenerator {

    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath,false);
    }

    public  static void copyFilesByRecursive(String inputPath, String outputPath) {
        File input = new File(inputPath);
        File output = new File(outputPath);
        try {
            copyFileByRecursive(input, output);
        } catch (Exception e) {
            System.err.println("copy error");
            e.printStackTrace();
        }
    }

    private static void copyFileByRecursive(File inputPath, File outputPath) throws IOException {
        /**
         * 文件夹
         */
        if (inputPath.isDirectory()) {
            System.out.println(inputPath.getName());
            //输出文件夹地址
            File destOutputFile = new File(outputPath, inputPath.getName());
            //文件夹是否存在
            if (!destOutputFile.exists()) {
                destOutputFile.mkdirs();
            }
            //文件夹下所有文件
            File[] files = inputPath.listFiles();

            if(ArrayUtil.isEmpty(files)){
                return;
            }
            //复制文件夹下所有文件
            for (File file : files) {
                copyFileByRecursive(file, destOutputFile);
            }

        }
        /**
         * 文件
         */
        else {
            //输出文件地址
            Path destPath = outputPath.toPath().resolve(inputPath.getName());
            Files.copy(inputPath.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
        }

    }

}
