package com.fh.dao;

import com.fh.model.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoginDao {
    @Select("select * from shop_user where name=#{name}")
    List<User> valUserName(String name);
}
