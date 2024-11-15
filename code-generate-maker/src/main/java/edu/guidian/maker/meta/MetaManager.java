package edu.guidian.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

import java.net.URL;
import java.util.Properties;

public class MetaManager {

    private static volatile Meta meta;

    private MetaManager(){

    }
    //双检锁实现外，还有一种很常见的实现方式 —— 饿汉式单例模式
    public static Meta getMetaObject(){
        if (meta == null) {
            synchronized (MetaManager.class) {
                if (meta == null) {
                    return initMeta();
                }
            }
        }
        return meta;
    }

    private static Meta initMeta(){
        String property = System.getProperty("user.dir");

        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
        return newMeta;
    }
}
