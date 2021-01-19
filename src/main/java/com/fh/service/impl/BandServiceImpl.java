package com.fh.service.impl;

import com.fh.dao.BandDao;
import com.fh.model.po.Band;
import com.fh.model.vo.BandPageBean;
import com.fh.model.vo.PageData;
import com.fh.service.BandService;
import com.fh.utils.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class BandServiceImpl implements BandService {

    @Resource
    private BandDao bandDao;


    @Override
    public ResultData queryBand(BandPageBean bpage) {
        bpage.compute();
        List<Band> li=bandDao.queryBandData(bpage);
        Long count=bandDao.queryBandCount(bpage);

        PageData pda=new PageData();
        pda.setData(li);
        pda.setTotalPage(count);
        return ResultData.success(pda);
    }

    @Override
    public ResultData saveBand(Band band) {

        band.setUpdateDate(new Date());
        if (band.getId()!=null){


            bandDao.updateBand(band);
        }else {
            band.setCreateDate(new Date());
            band.setIsdel(0);
            bandDao.saveBand(band);
        }
        return ResultData.success(null);
    }

    @Override
    public ResultData delBand(Integer id) {
        bandDao.delBand(id);
        return ResultData.success(null);
    }

    @Override
    public ResultData queryBandAll() {
        List<Band> li=bandDao.queryBandAll();
        return ResultData.success(li);
    }
}
