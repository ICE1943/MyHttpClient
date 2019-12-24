package com.by.http;

import com.by.http.common.config.ITreeConfig;
import com.by.http.util.CommonUtil;

public class WebApplication {
    public static void run(Class clazz){
        // 启动类
        ITreeConfig.APPLICATION_CLASS = clazz;
        // 初始化 配置文件
        ITreeConfig.init();

        CommonUtil.scanController(clazz.getPackage().getName());
    }
}
