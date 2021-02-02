package com.fh.dao;

import com.fh.model.po.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuDao {
    List<Menu> queryData(Integer pid);

    void updateData(Menu menu);

    void saveData(Menu menu);
}
