package com.fh.controller;

import com.fh.model.po.Product;
import com.fh.model.vo.ProductPageBean;
import com.fh.service.ProductService;
import com.fh.utils.ResultData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/product")
public class ProductController {

    @Resource
    private ProductService productService;


    /*根据分类id 查属性*/
    @GetMapping("queryProAttrByType")
    public Map queryProAttrByType(Integer typeId){
        return productService.queryProAttrByType(typeId);
    }


    @GetMapping("getAttrData")
    public ResultData getAttrData(Integer proId){
        return productService.getAttrData(proId);

    }
    @DeleteMapping("delProduct")
    public ResultData delProduct(Integer id){
        return productService.delProduct(id);
    }

    @PostMapping("updateProduct")
    public ResultData updateProduct(Product product){
        return productService.updateProduct(product);
    }

    @GetMapping("echoProduct")
    public ResultData echoProduct(Integer id){
        return productService.echoProduct(id);
    }

    @PostMapping("queryProduct")
    public ResultData queryProduct(ProductPageBean pa){
            return productService.queryProduct(pa);
    }


    @PostMapping("saveProduct")
    public ResultData saveProductData(Product product,String attr,String sku){
        return productService.saveProductData(product,attr,sku);
    }


    /*根据分类id 查属性*/
    @GetMapping("queryProductData")
    public ResultData queryProductData(Integer typeId){
        return productService.queryProductData(typeId);
    }
}
