package com.jp.dao;

import com.jp.po.Type;

public interface TypeMapper {
    int insert(Type record);
    int insertSelective(Type record);
    Type selectByPrimaryKey(Integer id);
	
    
   
}