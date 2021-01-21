package com.hf.job04.netty;

import com.hf.job04.httpclient.HttpAsyncClientHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;

import java.util.Date;

/**
 * @author hfzhang
 * @date 2021/1/18
 */
public class HttpHandler extends ChannelInboundHandlerAdapter {

    private final String proxyServer;
    private HttpAsyncClientHandler handler;

    public HttpHandler(String proxyServer){
        this.proxyServer = proxyServer;
        handler = new HttpAsyncClientHandler(this.proxyServer);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        try {
            //channelRead流量接口开始请求
            System.out.println("channelRead流量接口请求开始，时间为："+new Date());
            FullHttpRequest fullHttpRequest = (FullHttpRequest)msg;
//            String uri = fullHttpRequest.uri();
//            System.out.println("接收到的请求uri为："+uri);
//            if(uri.contains("/test")){
//                handlerTest(fullHttpRequest, ctx);
//            }
            handler.handle(fullHttpRequest, ctx);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

//    private void handlerTest(FullHttpRequest fullHttpRequest, ChannelHandlerContext ctx) {
//        FullHttpResponse fullHttpResponse = null;
//        try {
//            String value = "hello hfzhang!";
//            HttpAsyncClientHandler clientHandler = new HttpAsyncClientHandler("http://localhost:8801/");
//            clientHandler.handle(fullHttpRequest, ctx);
//            fullHttpResponse = new DefaultFullHttpResponse(HTTP_1_1,OK, Unpooled.wrappedBuffer(value.getBytes("utf-8")));
//            fullHttpResponse.headers().set("Content-Type", "application/json");
//            fullHttpResponse.headers().setInt("Content-Length", fullHttpResponse.content().readableBytes());
//        } catch (Exception e) {
//            System.out.println("处理出错："+e.getMessage());
//            fullHttpResponse = new DefaultFullHttpResponse(HTTP_1_1,NO_CONTENT);
//        } finally {
//            if(fullHttpRequest != null){
//                if(!HttpUtil.isKeepAlive(fullHttpRequest)){
//                    ctx.write(fullHttpResponse).addListener(ChannelFutureListener.CLOSE);
//                }else{
//                    fullHttpResponse.headers().set(CONNECTION, KEEP_ALIVE);
//                    ctx.write(fullHttpResponse);
//                }
//            }
//        }
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
//        cause.printStackTrace();
//        ctx.close();
//    }
}
