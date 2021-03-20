package org.geek.test.rpc.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.geek.test.rpc.msg.Response;

/**
 * @author hfzhang
 * @date 2021/3/20
 */
public class MyClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object object){
        Response response = (Response)object;
        String requestId = response.getRequestId();
        SyncW
    }

}
