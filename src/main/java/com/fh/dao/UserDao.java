package com.fh.dao;

import com.fh.model.po.User;
import com.fh.utils.PageBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from shop_user   limit #{startIndex},#{pageSize}")
    List<User> queryData(PageBean pa);
    @Select("select count(1) from shop_user ")
    Long queryDataCount();
    @Select("select rid from user_role where uid=#{uid}")
    List<Integer> echoUserRole(Integer uid);
    @Delete("delete from user_role where uid=#{uid}") 
    void delUserRole(Integer uid);

    void saveUserRole(@Param("list") List list);
}
