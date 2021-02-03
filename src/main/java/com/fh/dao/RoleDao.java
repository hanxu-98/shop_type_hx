package com.fh.dao;

import com.fh.model.po.Role;
import com.fh.utils.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleDao {
    @Select("select * from shop_role where isDel=0 limit #{startIndex},#{pageSize}")
    List<Role> queryData(PageBean pa);
    @Select("select count(1) from shop_role where isDel=0")
    Long queryDataCount();
}
