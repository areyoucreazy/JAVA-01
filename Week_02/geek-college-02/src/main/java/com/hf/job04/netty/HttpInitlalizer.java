package com.hf.job04.netty;

import com.hf.job04.filter.HttpRequestFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

import java.util.List;

/**
 * @author hfzhang
 * @date 2021/1/18
 */
public class HttpInitlalizer extends ChannelInitializer<SocketChannel> {

    private final List<String> proxyServerList;

    public HttpInitlalizer(List<String> proxyServerList){
        this.proxyServerList = proxyServerList;
    }

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline p = socketChannel.pipeline();
        p.addLast(new HttpServerCodec());
//        p.addLast(new HttpServerExpectContinueHandler());
        p.addLast(new HttpObjectAggregator(1024*1024));
        p.addLast(new HttpHandler(this.proxyServerList, new HttpRequestFilter() {
            @Override
            public void filter(FullHttpRequest fullHttpRequest, ChannelHandlerContext ctx) {
                fullHttpRequest.headers().set("hfzhang", "job");
            }
        }));
    }
}
