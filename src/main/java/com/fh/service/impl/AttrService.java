package com.fh.service.impl;

import com.fh.model.po.Attr;
import com.fh.model.vo.AttrPageBean;
import com.fh.utils.ResultData;

public interface AttrService {
    ResultData queryAttr(AttrPageBean pa);

    ResultData saveAttr(Attr attr);

    ResultData updateAttr(Attr attr);

    ResultData echoAttr(Integer id);
}
