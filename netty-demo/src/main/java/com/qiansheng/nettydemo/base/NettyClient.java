package com.qiansheng.nettydemo.base;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 功能描述 <p> netty client</p>
 * @author sheng.qian01@ucarinc.com
 * @date 2020/7/9 13:40
 */
public class NettyClient {

	public static void main(String[] args) {

		// 事件循环组
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(group)
					.channel(NioSocketChannel.class)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new NettyClientHandler());
						}
					});
			System.out.println("netty client start....");

			//启动客户端去连接服务器端
			ChannelFuture cf = bootstrap.connect("127.0.0.1", 9000).sync();
			//对通道关闭进行监听
			cf.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			group.shutdownGracefully();
		}
	}























}
