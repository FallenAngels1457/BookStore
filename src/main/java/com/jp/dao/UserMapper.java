package com.jp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jp.po.User;

public interface UserMapper {
	public List<User> selectByLoginname(@Param("loginname")String loginname) throws Exception;
	int updateByPrimaryKeySelective(User record);
	public boolean updatePasswordByLoginname(@Param("loginname")String loginname,
			@Param("newPassword")String newPassword) throws Exception;
	public User selectByLoginnameAndPassword(@Param("loginname")String loginname,
			@Param("password")String password) throws Exception;
}
