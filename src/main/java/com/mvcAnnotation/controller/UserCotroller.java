package com.mvcAnnotation.controller;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvcAnnotation.pojo.User;
import com.mvcAnnotation.service.UserService;

@Controller
public class UserCotroller {
	@Autowired
	private UserService userService;
	 @ResponseBody
	    @RequestMapping(value = "login.do", method = RequestMethod.GET)
	    public String login(String userName,String pwd) throws Exception {
		 User user= userService.login(userName, pwd);
		 if(user==null) {
			 return "null user";
		 }
	        return "hello"+user.getUserName() ;
	    }
}
