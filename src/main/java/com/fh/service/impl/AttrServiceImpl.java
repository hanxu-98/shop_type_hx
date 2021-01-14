package com.fh.service.impl;

import com.fh.dao.AttrDao;
import com.fh.model.po.Attr;
import com.fh.model.vo.AttrPageBean;
import com.fh.model.vo.PageData;
import com.fh.utils.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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

    @Override
    public ResultData saveAttr(Attr attr) {

            attr.setCreateDate(new Date());
            attr.setUpdateDate(new Date());
            Integer id=attrDao.saveAttr(attr);


        return ResultData.success(id);
    }

    @Override
    public ResultData updateAttr(Attr attr) {

        attr.setUpdateDate(new Date());
        attrDao.updateAttr(attr);

        return ResultData.success(null);
    }

    @Override
    public ResultData echoAttr(Integer id) {
        Attr attr=attrDao.echoAttr(id);
        return ResultData.success(attr);
    }
}
