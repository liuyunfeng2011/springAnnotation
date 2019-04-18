package com.mvcAnnotation.service;

import com.mvcAnnotation.pojo.User;

public interface UserService {
	/**
	 * 用户登录
	 * @return
	 */
	public User login(String userName,String pwd);
}
