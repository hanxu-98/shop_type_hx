package com.fh.controller;

import com.fh.service.ProductService;
import com.fh.utils.ResultData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("api/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("queryProductData")
    public ResultData queryProductData(Integer typeId){
        return productService.queryProductData(typeId);
    }
}
