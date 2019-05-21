package com.jp.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.dao.TypeMapper;
import com.jp.po.Type;
import com.jp.service.TypeService;

@Service("typeService")
public class TypeServiceImpl implements TypeService {
	@Autowired
	private TypeMapper typeMapper;
	@Override
	public Type getTypeById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return typeMapper.selectByPrimaryKey(id);
	}
	@Override
	public void addType(Type type) throws Exception {
		typeMapper.insertSelective(type);
	}
	
	
	

	
	
	
	

}
