package com.by.http;

import com.by.http.common.config.ITreeConfig;
import com.by.http.util.CommonUtil;

import java.io.IOException;

public class WebApplication {
    public static void run(Class clazz) throws IOException, ClassNotFoundException {
        // 启动类
        ITreeConfig.APPLICATION_CLASS = clazz;
        // 初始化 配置文件
        ITreeConfig.init();
        // 扫描 控制器
        CommonUtil.scanController(clazz.getPackage().getName());
    }
}
