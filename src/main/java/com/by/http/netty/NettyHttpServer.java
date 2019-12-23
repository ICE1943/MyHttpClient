package com.by.http.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Netty Server Class
 *
 * @author ice
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class NettyHttpServer {
    int port = 8080;

    public void init() throws Exception {
        EventLoopGroup parentGroup = new NioEventLoopGroup();
        EventLoopGroup childGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap server = new ServerBootstrap();
            // 使用两个线程组处理请求通道和io处理
            server.group(parentGroup, childGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            // Http 解析器
                            socketChannel.pipeline().addLast("http-decoder",new HttpRequestDecoder());
                            // 将HTTP消息的多个部分合成一条完整的HTTP消息
                            socketChannel.pipeline().addLast("http-aggregator",new HttpObjectAggregator(65535));
                            // Http 转码
                            socketChannel.pipeline().addLast("http-encoder",new HttpRequestEncoder());
                            // 解决html写入问题
                            socketChannel.pipeline().addLast("http-chunked",new ChunkedWriteHandler());
                        }
                    });
            // 监听端口 返回
            ChannelFuture future=server.bind(this.getPort()).sync();
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
            childGroup.shutdownGracefully();
            parentGroup.shutdownGracefully();
        }
    }
}
