package com.fh.dao;

import com.fh.model.po.TypeData;

import java.util.List;

public interface TypeDataDao {
    List<TypeData> getData(Integer pid);

    int addTypeData(TypeData tdata);

    void updateTypeData(TypeData tdata);
}
