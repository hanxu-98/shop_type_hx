package com.fh.dao;

import com.fh.model.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoginDao {
    @Select("select * from shop_user where name=#{name}")
    List<User> valUserName(String name);
    @Insert("INSERT into shop_user (id,name,realName,password,sex," +
            "phone,email,idCard,birthday,imgUrl,eduId,deptId,createDate,updateDate)" +
            " VALUES (#{id},#{name},#{realName},#{password},#{sex}" +
            ",#{phone},#{email},#{idCard},#{birthday},#{imgUrl},#{eduId},#{deptId}," +
            "#{createDate},#{updateDate})")
    void registerUser(User user);
}
