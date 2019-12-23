package com.by.http.netty;

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
}
