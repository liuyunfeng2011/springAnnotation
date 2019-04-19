package com.mvcAnnotation.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mvcAnnotation.mapper.UserMapper;
import com.mvcAnnotation.pojo.User;
import com.mvcAnnotation.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	Logger logger=Logger.getLogger(UserServiceImpl.class);
	@Resource
	private UserMapper userMapper;
	public User login(String userName, String pwd) {
		// TODO Auto-generated method stub
		return userMapper.findUserByUserNameAndPwd(userName, pwd);
	}
}
