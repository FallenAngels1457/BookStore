package com.jp.service;


import com.jp.po.User;

public interface UserService {
	public User getUserByLoginname(String loginname) throws Exception;
	public boolean modifyPassword(String loginname,String newPassword) throws Exception;
	public boolean modifyPersonalInformation(User user) throws Exception;
	User login(String loginname, String password) throws Exception;
}
