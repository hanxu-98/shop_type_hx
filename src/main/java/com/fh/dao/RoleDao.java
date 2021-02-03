package com.fh.dao;

import com.fh.model.po.Role;
import com.fh.utils.PageBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface RoleDao {
    @Select("select * from shop_role where isDel=0 limit #{startIndex},#{pageSize}")
    List<Role> queryData(PageBean pa);
    @Select("select count(1) from shop_role where isDel=0")
    Long queryDataCount();
    @Update("update shop_role set name=#{name} where id=#{id}")
    void updateRole(Role role);
    @Insert("insert into shop_role (name,isDel,createDate,author) values (#{name},0,#{createDate},#{author}) ")
    void saveRole(Role role);
}
