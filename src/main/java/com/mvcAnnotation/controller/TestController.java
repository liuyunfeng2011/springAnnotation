package com.mvcAnnotation.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvcAnnotation.service.HelloService;

@Controller
public class TestController {
	@Resource(name="helloService")
	private HelloService helloService;
	  @ResponseBody
	 @RequestMapping(value = "sayHello.do", method = RequestMethod.GET)
	public String sayHello() {
		return "hello world";
	}
}
