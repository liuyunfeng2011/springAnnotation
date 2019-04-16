package com.mvcAnnotation.controller;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HttpController {
	 @ResponseBody
	  @RequestMapping(value = "sendHttp.do", method = RequestMethod.GET)
	public String sendHttp() throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet("https://baidu.com");
		get.addHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36");
		HttpResponse response = client.execute(get);
		String res = EntityUtils.toString(response.getEntity());
		System.out.println(res);
		return res;
	}
	 /**
	  * post方式发送请求
	  * @return
	  * @throws Exception
	  */
	 @ResponseBody
	  @RequestMapping(value = "sendPostHttp.do", method = RequestMethod.GET)
	public String sendPostHttp() throws Exception {
		  CloseableHttpClient client = HttpClients.createDefault();
          HttpPost request = new HttpPost();
          Map<String, String> params = new HashMap<String, String>();
          params.put("pro_id", "1");
          params.put("info_id", "2");
          request.setURI(new URI("http://www.copell.com/pm/"));
          // 设置参数
          List<NameValuePair> nvps = new ArrayList<NameValuePair>();
          for (Iterator<String> iter = params.keySet().iterator(); iter.hasNext();) {
              String name = (String)iter.next();
              String value = String.valueOf(params.get(name));
              nvps.add(new BasicNameValuePair(name, value));
          }
          request.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
          HttpResponse response = client.execute(request);
          String jsonRes = EntityUtils.toString(response.getEntity());
		return null;
	}
	 
	 
}
