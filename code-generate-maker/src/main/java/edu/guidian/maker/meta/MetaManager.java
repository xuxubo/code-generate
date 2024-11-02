package edu.guidian.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

import java.util.Properties;

public class MetaManager {

    private static volatile Meta meta;

    private MetaManager(){

    }
    public static Meta getMetaObject(){
        return initMeta();
    }

    private static Meta initMeta(){
        String property = System.getProperty("user.dir");
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
        return newMeta;
    }
}
