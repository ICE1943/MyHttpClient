package com.by.http.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;

public class ClassUtil {
    public static Set<Class<?>> getClzFromPkg(String path) throws IOException, ClassNotFoundException {
        Set<Class<?>> classes = new LinkedHashSet<>();
        String pagDirName = path.replace(',', '/');
        Enumeration<URL> urls = ClassUtil.class.getClassLoader().getResources(pagDirName);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            String protocol = url.getProtocol();
            if ("file".equals(protocol)) {
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");
                findClassesByFile(filePath, path, classes);
            }
        }
        return classes;
    }

    /**
     *
     * @param pkgName   包名
     * @param pkgPath   绝对路径
     * @param classes   储存类的集合
     * @throws ClassNotFoundException
     */
    private static void findClassesByFile(String pkgName, String pkgPath, Set<Class<?>> classes) throws ClassNotFoundException {
        File file = new File(pkgPath);
        if (!file.exists() || !file.isDirectory()) {
            return;
        }
        // 声明一个数组 然后把文件夹或者是.class结尾的文件添加到这个数组中
        File[] classes1 = file.listFiles(pathname -> pathname.isDirectory() || pathname.getName().endsWith("class"));
        if (classes1 == null || classes1.length == 0) {
            return;
        }
        for (File file1 : classes1) {
            if (file1.isDirectory()) {
                findClassesByFile(pkgName+"."+file1.getName(),pkgPath+"/"+file1.getName(),classes);
            } else {
                String className = file1.getName();
                className = className.substring(0, className.length() - 6);
                Class<?> c = Thread.currentThread().getContextClassLoader().loadClass(className+"."+pkgName);
                classes.add(c);
            }
        }
    }

}
