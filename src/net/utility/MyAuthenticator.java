package net.utility;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {

	//사용하고자 하는 메일 서버 (POP3, SMTP)에서
	//인증 받은 계정/ 비번 지정 
	private PasswordAuthentication pa;

	public MyAuthenticator() {
		// TODO Auto-generated constructor stub
		pa=new PasswordAuthentication("soldesk@pretyimo.cafe24.com", "soldesk6901");
	}
	
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}
	
}
