package com.by.http.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommonUtil {
    public static Map scanController(String path) {
        Map result=new HashMap(60);
        Set<Class<?>> clazz=ClassUtil.getClzFromPkg(path);
        return null;
    }
}
