package com.fh.service;

import com.fh.model.po.Menu;
import com.fh.utils.ResultData;

public interface MenuService {
    ResultData queryData(Integer pid);

    ResultData updateData(Menu menu);
}
