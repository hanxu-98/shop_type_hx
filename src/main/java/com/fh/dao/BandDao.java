package com.fh.dao;

import com.fh.model.po.Band;
import com.fh.model.vo.BandPageBean;

import java.util.List;

public interface BandDao {
    List<Band> queryBandData(BandPageBean bpage);

    Long queryBandCount(BandPageBean bpage);

    void saveBand(Band band);

    void updateBand(Band band);

    void delBand(Integer id);
}
