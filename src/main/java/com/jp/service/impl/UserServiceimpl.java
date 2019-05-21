package com.jp.service.impl;

import com.jp.dao.UserMapper;
import com.jp.po.User;
import com.jp.service.UserService;

public  class UserServiceimpl implements UserService{ 
	UserMapper userMapper;
	public  UserServiceimpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public User login(String loginname, String password) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.selectByLoginnameAndPassword(loginname, password);
	}
	@Override
	public boolean modifyPassword(String loginname, String newPassword) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = userMapper.updatePasswordByLoginname(loginname, newPassword);
		return flag;
	}
	@Override
	public boolean modifyPersonalInformation(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(user)>0?true:false;
	}
	@Override
	public User getUserByLoginname(String loginname) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.selectByLoginname(loginname).get(0);
	}
	
}
