package com.fh.service;

import com.fh.model.po.Band;
import com.fh.model.vo.BandPageBean;
import com.fh.utils.ResultData;

public interface BandService {
    ResultData queryBand(BandPageBean bpage);

    ResultData saveBand(Band band);

    ResultData delBand(Integer id);

    ResultData queryBandAll();
}
