package com.fh.service;

import com.fh.model.po.TypeData;
import com.fh.utils.ResultData;


public interface TypeDataService {
        ResultData getData(Integer pid);

        ResultData addTypeData(TypeData tdata);

        ResultData updateTypeData(TypeData tdata);
}
