package com.jarvis.base.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class zhiXinTianQiApi {
	
	
	
/*	
 * 之心天气 api
 * #是密钥
 * https://api.seniverse.com/v3/weather/now.json?key=#&location=shanghai&language=zh-Hans&unit=c
*/
	
	
	
	public static void getZXTQ() throws IOException{
	
		//外接口路径  
        String urlStr="https://api.seniverse.com/v3/weather/now.json?key=#8x&location=shanghai&language=zh-Hans&unit=c";                          
        //链接URL  
        URL url=new URL(urlStr);  
        //返回结果集  
        StringBuffer document = new StringBuffer();  
        //创建链接  
       URLConnection conn = url.openConnection();  
       //读取返回结果集  
       BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));  
       String line = null;  
       while ((line = reader.readLine()) != null){  
             document.append(line);  
       }     
           reader.close();  
       System.out.println("api内容："+document); 
	
	}
	
	public static void main(String[] args) throws IOException {
		getZXTQ();
	}
	
}
