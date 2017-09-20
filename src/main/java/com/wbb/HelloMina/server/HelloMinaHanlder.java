package com.wbb.HelloMina.server;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import com.wbb.HelloMina.utils.IOUtil;

public class HelloMinaHanlder extends IoHandlerAdapter {
	

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		
		String m=message.toString();
		if(m.equalsIgnoreCase("quit")){
			session.close(true);
			return;
		}
		IOUtil.write(message.toString());
		System.out.println("server---received message "+message);
		String reply="hi,i am server";
		session.write(reply);
		System.out.println("server---message have been written");
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		
		System.out.println("server---session opened:"+session.getRemoteAddress().toString());
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
	
		 System.out.println("server---closed session");
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(session, cause);
		System.out.println(cause.toString());
	}



	

	
}
