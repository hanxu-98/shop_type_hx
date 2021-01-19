package com.fh.dao;

import com.fh.model.po.Attr;

import java.util.List;

public interface ProductDao {
    List<Attr> queryProductData(Integer typeId);
}
