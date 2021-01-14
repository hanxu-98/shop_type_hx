package com.fh.dao;

import com.fh.model.po.Attr;
import com.fh.model.vo.AttrPageBean;

import java.util.List;

public interface AttrDao {
    List<Attr> queryAttrData(AttrPageBean pa);

    Long queryAttrCount(AttrPageBean pa);

    Integer saveAttr(Attr attr);

    void updateAttr(Attr attr);
}
