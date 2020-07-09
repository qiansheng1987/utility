package com.qiansheng.nettydemo.base;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 功能描述 <p> netty server</p>
 * @author sheng.qian01@ucarinc.com
 * @date 2020/7/9 14:07
 */
public class NettyServer {

	public static void main(String[] args) {
		// bossGroup处理连接请求，真正的和客户端业务处理，交给workgroup完成。
		EventLoopGroup bossGroup = new NioEventLoopGroup(10);
		EventLoopGroup workerGroup = new NioEventLoopGroup(10000);
		ServerBootstrap bootstrap = new ServerBootstrap();
		bootstrap.group(bossGroup, workerGroup)
				.channel(NioServerSocketChannel.class)
				// 初始化服务连接队列的带下，服务端处理客户端的连接请求是顺讯处理的，同一个时间只能处理一个客户端连接
				// 多个客户同时来的时候，服务端将不能处理的客户端连接请求放在队列中等待处理。
				.option(ChannelOption.SO_BACKLOG, 1024)
				.childHandler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						ch.pipeline().addLast(new NettyServerHander());
					}
				});
		try {
			ChannelFuture cf = bootstrap.bind(9000).sync();
			cf.addListener(new ChannelFutureListener() {
				@Override
				public void operationComplete(ChannelFuture future) throws Exception {
					if (cf.isSuccess()) {
						System.out.println("监听端口90000成功");
					} else {
						System.out.println("监听端口9000失败");
					}
				}
			});
			//对通道关闭进行监听，closeFuture是异步操作，监听通道关闭
			// 通过sync方法同步等待通道关闭处理完毕，这里会阻塞等待通道关闭完成
			cf.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

















}
