package com.mvcAnnotation.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.fasterxml.jackson.databind.JavaType;
import com.mvcAnnotation.pojo.User;

public interface UserMapper {
	@Select(" select * from enterUser where enter_email=#{userName} and enter_pass=#{pwd}")
	@Results({
		@Result(column="enter_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
         @Result(property = "userName", column = "enter_email",jdbcType=JdbcType.VARCHAR),
         @Result(property = "userPwd",column = "enter_pass",jdbcType=JdbcType.VARCHAR)
 })
	public User findUserByUserNameAndPwd(@Param("userName") String userName,@Param("pwd")String pwd);
}
