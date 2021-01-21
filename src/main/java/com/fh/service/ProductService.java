package com.fh.service;

import com.fh.model.po.Product;
import com.fh.model.vo.ProductPageBean;
import com.fh.utils.ResultData;

public interface ProductService {
    ResultData queryProductData(Integer typeId);

    ResultData saveProductData(Product product,String attr,String sku);

    ResultData queryProduct(ProductPageBean pa);

    ResultData echoProduct(Integer id);

    ResultData updateProduct(Product product);
}
