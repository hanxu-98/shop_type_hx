package com.fh.service.impl;

import com.fh.model.po.Attr;
import com.fh.model.vo.AttrPageBean;
import com.fh.model.vo.Attr_ValuePageBean;
import com.fh.utils.ResultData;

public interface AttrService {
    ResultData queryAttr(AttrPageBean pa);

    ResultData saveAttr(Attr attr);

    ResultData updateAttr(Attr attr);

    ResultData echoAttr(Integer id);

    ResultData delAttr(Integer id);

    ResultData queryAttrValue(Attr_ValuePageBean pa);
}
