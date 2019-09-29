package example.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.StringUtil;

/**
 * @author lxp
 * @date 2019/9/5 下午8:05
 * @Version 1.0
 * Handles a server-side channel.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg) {
        //返回接收的msg给client
        System.out.println("channelRead start");
        ctx.write(msg);
        ctx.flush();
        //输出接收的msg
//        ByteBuf in = (ByteBuf) msg;
//        try {
//            while(in.isReadable()) {
//                System.out.print((char)in.readByte());
//                System.out.flush();
//            }
//        } catch (Throwable exception){
//            exception.printStackTrace();
//        } finally {
//            ReferenceCountUtil.release(msg);
//        }
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
