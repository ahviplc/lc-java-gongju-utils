package com.jarvis.base.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.alibaba.fastjson.JSONObject;

public class kuaiDi100Api {
	
	
	public static void getkd100() throws IOException{
		
		//外接口路径  
        String urlStr="http://www.kuaidi100.com/query?type=zhongtong&postid=464586690092";                          
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
	
	  
	
	public static void main(String[] args) throws Exception {  
	          
	  
	        getkd100();  
	            
	      
	    }  
   
}
   
   

