package edu.guidian.cli.command;

import cn.hutool.core.util.ReflectUtil;
import edu.guidian.model.MainTemplateConfig;
import picocli.CommandLine;

/**
 * 通过 Java 的反射机制，在程序运行时动态打印出对象属性的信息。又有 2 种方法：
 * 1）JDK 原生反射语法1643515349355778049_0.589338077488895
 *
 * 示例代码如下：
 *
 * Class<?> myClass = MainTemplateConfig.class;
 * // 获取类的所有字段
 * Field[] fields = myClass.getDeclaredFields();
 * 2）Hutool 的反射工具类（只需一行代码，更推荐）
 *
 * 示例代码如下：
 *
 * Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);
 */
import java.lang.reflect.Field;
@CommandLine.Command(name = "config", description = "查看参数信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{
    @Override
    public void run() {
        // 实现 config 命令的逻辑
        System.out.println("查看参数信息");

//        // 获取要打印属性信息的类
//        Class<?> myClass = MainTemplateConfig.class;
//        // 获取类的所有字段
//        Field[] fields = myClass.getDeclaredFields();

        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);

        // 遍历并打印每个字段的信息
        for (Field field : fields) {
            System.out.println("字段名称：" + field.getName());
            System.out.println("字段类型：" + field.getType());
//            System.out.println("Modifiers: " + java.lang.reflect.Modifier.toString(field.getModifiers()));
            System.out.println("---");
        }
    }
}
