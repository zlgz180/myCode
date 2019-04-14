package com.code.nio.ch02.splicing.fixed;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 作者：Mark/Maoke 创建日期：2018/08/26 类说明：
 */
public class FixedLengthClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private AtomicInteger counter = new AtomicInteger(0);

    /*** 客户端读取到网络数据后的处理 */
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println("client Accept[" + msg.toString(CharsetUtil.UTF_8) + "] and the counter is:"
                + counter.incrementAndGet());
    }

    /*** 客户端被通知channel活跃后，做事 */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf msg = null;
        for (int i = 0; i < 10; i++) {
            msg = Unpooled.buffer(FixedLengthEchoClient.REQUEST.length());
            msg.writeBytes(FixedLengthEchoClient.REQUEST.getBytes());
            ctx.writeAndFlush(msg);
        }
    }

    /*** 发生异常后的处理 */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
