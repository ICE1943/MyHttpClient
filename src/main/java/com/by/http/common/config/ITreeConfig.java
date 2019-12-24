package com.by.http.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ITreeConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ITreeConfig.class);

    public static String INDEX_PAGE = "page/index.html";

    /**
     * 判断配置文件有没有index
     */
    public static boolean INDEX_CHANGE=false;

    public static String NOT_FOUND_PAGE = "page/404_page.html";

    public static boolean NOT_FOUND_CHANGE=false;

    public static String UNKOWN_EXCEPTION_PAGE = "page/404_page.html";

    public static boolean UNKOWN_EXCEPTION_CHANGE=false;

    public static int PORT = 8080;

    private static final String DEFAULT_LOCALTION = "/config/itree-config.properties";

    private static final String INDEX_PAGE_KEY = "index.page";

    private static final String NOT_FOUND_PAGE_KEY = "not.found.page";

    private static final String UNKOWN_EXCEPTION_PAGE_KEY = "unkown.exception.page";

    private static final String PORT_KEY = "server.port";
}
