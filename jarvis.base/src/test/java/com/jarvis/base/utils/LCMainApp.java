package com.jarvis.base.utils;

import org.apache.commons.mail.EmailException;

import com.jarvis.base.util.MailHelper;

public class LCMainApp {
	
	
	
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws EmailException {
		
		MailHelper mm=new MailHelper();
		mm.sendHtmlEmail("smtp.163.com", "ahviplc@163.com", "密码", "ceshi-lc", "测试内容123LC！", "ahlc@sina.cn", "ahviplc@163.com");
		System.out.println("发送成功！");
		
		
	}
	

}
