package com.jarvis.base.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class kuaiDi100Api {

	public static void getkd100() throws IOException {

		// 外接口路径
		String urlStr = "http://www.kuaidi100.com/query?type=zhongtong&postid=464586690092";
		// 链接URL
		URL url = new URL(urlStr);
		// 返回结果集
		StringBuffer document = new StringBuffer();
		// 创建链接
		URLConnection conn = url.openConnection();
		// 读取返回结果集
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				conn.getInputStream(), "utf-8"));
		String line = null;
		while ((line = reader.readLine()) != null) {
			document.append(line);
		}
		reader.close();
		System.out.println("api内容：" + document);

		// json 串 document

		JSONObject jsonObj = JSON.parseObject(document.toString());

		System.out.println(jsonObj);

		System.out.println(jsonObj.get("nu"));

		JSONArray jaresult = jsonObj.getJSONArray("data");

		System.out.println(jaresult);

		// 真正开发中 转成一个实体类 List<实体类> 中 处理 或者 传到前台 显示 使用c 标签 遍历显示
		// List<Link> links=
		// JSON.parseArray(jaresult.toJSONString(),Link.class);

		System.out.println(jaresult.get(0));

		// json 下 array get0 tostring 再处理

		String ss = jaresult.get(0).toString();

		JSONObject jsonObj1 = JSON.parseObject(ss);

		System.out.println(jsonObj1);

		System.out.println(jsonObj1.get("time"));

		// for 1 循环 处理 jsonArray jaresult 版本

		for (int i = 0; i < jaresult.size(); i++) {
			Object ob1 = jaresult.get(i);
			System.out.println("第" + i + "-：" + ob1.toString());

			JSONObject forjsonObj = JSON.parseObject(ob1.toString());
			System.out.println(forjsonObj.get("time"));
			System.out.println(forjsonObj.get("location"));
			System.out.println(forjsonObj.get("context"));

		}

		// for 2 循环 处理 jsonArray jaresult 版本
		for (Iterator iterator = jaresult.iterator(); iterator.hasNext();) {
			Object ob2 = (Object) iterator.next();
			System.out.println(ob2.toString());
			JSONObject forjsonObj1 = JSON.parseObject(ob2.toString());
			System.out.println("for2-" + forjsonObj1.get("time"));

		}

		// for 3 循环 处理 jsonArray jaresult 版本
		for (Object ob3 : jaresult) {

			System.out.println(ob3.toString());
			JSONObject forjsonObj2 = JSON.parseObject(ob3.toString());
			System.out.println("for3-" + forjsonObj2.get("time"));

		}

	}

	//测试 main 方法
	public static void main(String[] args) throws Exception {

		getkd100();

	}
	
	
	/*此为这个json
	{
    "nu": "464586690092",
    "message": "ok",
    "ischeck": "1",
    "com": "zhongtong",
    "status": "200",
    "condition": "F00",
    "data": [
        {
            "time": "2017-11-20 20:39:34",
            "location": "徐汇龙华",
            "context": "[上海市] [徐汇龙华]的派件已签收 感谢使用中通快递,期待再次为您服务!",
            "ftime": "2017-11-20 20:39:34"
        },
        {
            "time": "2017-11-20 07:21:58",
            "location": "徐汇龙华",
            "context": "[上海市] 快件已到达[徐汇龙华],业务员刘愿正在第1次派件 电话:13916449442 请保持电话畅通、耐心等待",
            "ftime": "2017-11-20 07:21:58"
        },
        {
            "time": "2017-11-15 13:00:35",
            "location": "上海",
            "context": "[上海市] 快件离开 [上海]已发往[徐汇龙华]",
            "ftime": "2017-11-15 13:00:35"
        },
        {
            "time": "2017-11-15 11:39:49",
            "location": "上海",
            "context": "[上海市] 快件到达 [上海]",
            "ftime": "2017-11-15 11:39:49"
        },
        {
            "time": "2017-11-14 20:02:03",
            "location": "合肥中转部",
            "context": "[合肥市] 快件离开 [合肥中转部]已发往[上海]",
            "ftime": "2017-11-14 20:02:03"
        },
        {
            "time": "2017-11-14 20:00:15",
            "location": "合肥中转部",
            "context": "[合肥市] 快件到达 [合肥中转部]",
            "ftime": "2017-11-14 20:00:15"
        },
        {
            "time": "2017-11-14 16:41:11",
            "location": "合肥瑶海工业区",
            "context": "[合肥市] 快件离开 [合肥瑶海工业区]已发往[上海]",
            "ftime": "2017-11-14 16:41:11"
        },
        {
            "time": "2017-11-14 13:33:06",
            "location": "合肥瑶海工业区",
            "context": "[合肥市] [合肥瑶海工业区]的网腾已收件 电话:18156052850",
            "ftime": "2017-11-14 13:33:06"
        }
    ],
    "state": "3"
} 
	 */

}
