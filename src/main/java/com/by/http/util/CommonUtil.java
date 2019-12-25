package com.by.http.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommonUtil {
    public static Map scanController(String path) throws IOException, ClassNotFoundException {
        Map result=new HashMap(60);
        // 扫描启动类下面所有的类
        Set<Class<?>> clazz=ClassUtil.getClzFromPkg(path);
        return null;
    }
}
