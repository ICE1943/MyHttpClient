package com.by.http.core;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest fullHttpRequest) throws Exception {
        String uri = getUri(fullHttpRequest.uri());
        Object object = getClazzFromList(uri);
        String result = "recive msg";
        Object response = null;
    }


    /**
     * 用于截取路由
     * localhost:8080/api/a?a=1    /api/a   3
     * @param uri
     * @return
     */
    public static String getUri(String uri) {
        int pathIndex = uri.indexOf("/");
        int requestIndex = uri.indexOf("?");
        String result;
        if (requestIndex < 0) {
            result = uri.trim().substring(pathIndex);
        } else {
            result = uri.trim().substring(pathIndex, requestIndex);
        }
        return result;
    }


    public static Object getClazzFromList(String uri){
        if(uri.equals("/") || uri.equals("/index")){

        }
        return null;
    }
}
