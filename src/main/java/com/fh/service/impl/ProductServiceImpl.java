package com.fh.service.impl;

import com.fh.dao.ProductDao;
import com.fh.model.po.Attr;
import com.fh.service.ProductService;
import com.fh.utils.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;

    @Override
    public ResultData queryProductData(Integer typeId) {
        List<Attr> li=productDao.queryProductData(typeId);

        return ResultData.success(li);
    }
}
