package com.jp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jp.po.Type;
import com.jp.service.TypeService;

@Controller
@RequestMapping("/type")
public class TypeController {
	//添加类型
	@Autowired
	@Qualifier("typeService")
	private TypeService typeService;
	 @RequestMapping("/addType")
	 public String addType(Model model) throws Exception{
		System.out.println("sama添加图书类型信息请求");
		return "back/book/book_type_add"; 
	 }
	 //添加类型提交
	 @RequestMapping("/addTypeSubmit")
    public String addTypeSubmit(Type type, Model model) throws Exception{
		System.out.println("sama添加图书类型信息提交:"+type.getName());
		typeService.addType(type);
		return "forward:/type/toTypeList"; 
	 } 	 
	 
	 
	 
	 
}
