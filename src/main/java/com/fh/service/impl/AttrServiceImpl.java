package com.fh.service.impl;

import com.fh.dao.AttrDao;
import com.fh.model.po.Attr;
import com.fh.model.vo.AttrPageBean;
import com.fh.model.vo.PageData;
import com.fh.utils.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AttrServiceImpl implements AttrService{
    @Resource
    private AttrDao attrDao;

    @Override
    public ResultData queryAttr(AttrPageBean pa) {
        pa.compute();
        List<Attr> li=attrDao.queryAttrData(pa);
        Long count=attrDao.queryAttrCount(pa);
        PageData p=new PageData();
        p.setData(li);
        p.setTotalPage(count);
        return ResultData.success(p);
    }
}
