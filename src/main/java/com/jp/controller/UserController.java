package com.jp.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jp.po.User;
import com.jp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private UserService userService;
	@RequestMapping("/modifyPassword")
	 public String modifyPassword(HttpSession session,Model model) throws Exception{
		System.out.println("修改密码中");
		return "back/user/modifyPass";
	}
	@RequestMapping(value="/modifyPasswordSubmit")
	 public void modifyPasswordSubmit(String loginname,
			 		String password,String newPassword,PrintWriter pw) throws Exception{
		System.out.println("修改密码提交成功");
		boolean flag=false;
       try{
           User user=userService.login(loginname , password);
           if(user!=null){
           	flag=userService.modifyPassword(loginname , newPassword);
           }else
           	flag = false;
       }catch(Exception e1){
           // TODO Auto-generated catch block
           e1.printStackTrace();
       }
       if(flag)
       	System.out.println("用户 " + loginname+" 修改密码为：" + newPassword);
       else
       	System.out.println("密码输入错误，修改密码失败！");
       Map<String,Object> map=new HashMap<String,Object>();
       map.put("flag" , flag);
       ObjectMapper om=new ObjectMapper();
       try{
           String jsonString =om.writeValueAsString(map);
           pw.write(jsonString);
           pw.flush();
           pw.close();
       }catch(JsonProcessingException e){
           e.printStackTrace();
       }
       return; 
	}
}
