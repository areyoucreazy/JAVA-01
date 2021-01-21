package com.hf.job04.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author hfzhang
 * @date 2021/1/18
 */
public class HttpInitlalizer extends ChannelInitializer<SocketChannel> {

    private final String proxyServer;

    public HttpInitlalizer(String proxyServer){
        this.proxyServer = proxyServer;
    }

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline p = socketChannel.pipeline();
        p.addLast(new HttpServerCodec());
//        p.addLast(new HttpServerExpectContinueHandler());
        p.addLast(new HttpObjectAggregator(1025*1024));
        p.addLast(new HttpHandler(this.proxyServer));
    }
}
