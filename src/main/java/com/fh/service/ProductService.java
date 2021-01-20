package com.fh.service;

import com.fh.model.po.Product;
import com.fh.utils.ResultData;

public interface ProductService {
    ResultData queryProductData(Integer typeId);

    ResultData saveProductData(Product product);
}
