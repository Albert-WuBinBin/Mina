package com.wbb.HelloMina.client;



import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class MsgHandler extends IoHandlerAdapter {


	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("client exception---");
		System.out.println(cause.toString());
	}

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
	     System.out.println("client receiced---"+message.toString());
	     super.messageReceived(session, message);
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		  // 往服务器中发送消息
        System.out.println("client send----- ");
        super.messageSent(session, message);
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		 // 当session被创建的时候调用
       System.out.println("session create----");
        super.sessionCreated(session);
	}

}
