package com.fh.service.impl;

import com.fh.dao.ProductDao;
import com.fh.model.po.Attr;
import com.fh.model.po.Product;
import com.fh.model.vo.PageData;
import com.fh.model.vo.ProductPageBean;
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

    @Override
    public ResultData saveProductData(Product product) {

        productDao.saveProductData(product);
        return ResultData.success(null);
    }

    @Override
    public ResultData queryProduct(ProductPageBean pa) {
        pa.compute();
        List<Product> li=productDao.queryProduct(pa);
        Long count=productDao.queryProductCount(pa);
        PageData pd=new PageData();
        pd.setTotalPage(count);
        pd.setData(li);
        return ResultData.success(pd);
    }
}
