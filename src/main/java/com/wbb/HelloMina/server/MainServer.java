package com.wbb.HelloMina.server;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MainServer {

	private static final int port=8888;
	public static void main(String[] args) {
		IoAcceptor ioAcceptor=new NioSocketAcceptor();
		System.out.println("begin server....");
		ioAcceptor.getFilterChain().addLast("logger", new LoggingFilter());
		ioAcceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(
				new TextLineCodecFactory(Charset.forName("utf-8"))));
		ioAcceptor.setHandler(new HelloMinaHanlder());
		ioAcceptor.getSessionConfig().setReadBufferSize(2048);
		ioAcceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
		try {
			ioAcceptor.bind(new InetSocketAddress(port));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
