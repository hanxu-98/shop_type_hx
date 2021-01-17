package com.fh.dao;

import com.fh.model.po.Attr;
import com.fh.model.po.Attr_Value;
import com.fh.model.vo.AttrPageBean;
import com.fh.model.vo.Attr_ValuePageBean;

import java.util.List;

public interface AttrDao {
    List<Attr> queryAttrData(AttrPageBean pa);

    Long queryAttrCount(AttrPageBean pa);

    Integer saveAttr(Attr attr);

    void updateAttr(Attr attr);

    Attr echoAttr(Integer id);

    void delAttr(Integer id);

    List<Attr_Value> queryAttrValueData(Attr_ValuePageBean pa);

    Long queryAttrValueCount(Attr_ValuePageBean pa);
}
