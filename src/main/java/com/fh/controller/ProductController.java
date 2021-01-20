package com.fh.controller;

import com.fh.model.po.Product;
import com.fh.service.ProductService;
import com.fh.utils.ResultData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("api/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @PostMapping("saveProductData")
    public ResultData saveProductData(Product product){
        return productService.saveProductData(product);
    }


    /*根据分类id 查属性*/
    @GetMapping("queryProductData")
    public ResultData queryProductData(Integer typeId){
        return productService.queryProductData(typeId);
    }
}
