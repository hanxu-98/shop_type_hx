package com.fh.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fh.dao.ProductDao;
import com.fh.model.po.Attr;
import com.fh.model.po.Attr_Value;
import com.fh.model.po.Product;
import com.fh.model.po.ProductAttrDatas;
import com.fh.model.vo.PageData;
import com.fh.model.vo.ProductPageBean;
import com.fh.service.ProductService;
import com.fh.utils.ResultData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

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
    @Transactional
    public ResultData saveProductData(Product product,String attr,String sku) {
        product.setCreateDate(new Date());
        product.setUpdateDate(new Date());
        productDao.saveProductData(product);
        // 声明属性数据的对象

        /*"[{"材质":"去玩儿"},{"适用季节":"夏季"}]"*/
        List<ProductAttrDatas> adList=new ArrayList<>();
        JSONArray objects = JSONObject.parseArray(attr);
        for (int i = 0; i < objects.size(); i++) {
            ProductAttrDatas p=new ProductAttrDatas();
            p.setProId(product.getId());
            p.setAttrData(objects.get(i).toString());
            adList.add(p);
        }

        /*[{"颜色":"黑色","尺寸":"中号","storcks":"111","price":"111"},
            {"颜色":"黑色","尺寸":"大号","storcks":"222","price":"222"}]*/
        //将sku的json数组字符串 转为json数组对象
        JSONArray objectssku = JSONObject.parseArray(sku);
        for (int i = 0; i < objectssku.size(); i++) {
            JSONObject dataJs= (JSONObject) objectssku.get(i);

            ProductAttrDatas p=new ProductAttrDatas();
            p.setProId(product.getId());
            p.setPrice(dataJs.getDouble("prices"));
            p.setStorcks(dataJs.getInteger("storcks"));

            dataJs.remove("prices");
            dataJs.remove("storcks");
            p.setAttrData(objectssku.get(i).toString());
            boolean a=dataJs==objectssku.get(i);
            adList.add(p);
        }
        productDao.saveAllData(adList);


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

    @Override
    public ResultData echoProduct(Integer id) {
        Product product=productDao.echoProduct(id);
        return ResultData.success(product);
    }

    @Override
    public ResultData updateProduct(Product product) {
         product.setUpdateDate(new Date());
        productDao.updateProduct(product);
        return ResultData.success(null);
    }

    @Override
    public ResultData delProduct(Integer id) {
        productDao.delProduct(id);

        return ResultData.success(null);
    }

    @Override
    public ResultData getAttrData(Integer proId) {
        List<ProductAttrDatas> li=productDao.getAttrData(proId);
        return ResultData.success(li);
    }

    @Override
    public Map queryProAttrByType(Integer typeId) {
        //声明返回数据
        Map rs=new HashMap();
        List<Attr> li=productDao.queryProAttrByType(typeId);
        //声明skuDatas
        List<Attr> skuDats=new ArrayList<>();
        //声明attrDatas
        List<Attr> attrDatas=new ArrayList<>();
        for (int i = 0; i < li.size(); i++) {
            if (li.get(i).getIsSKU()!=0){
                List<Attr_Value> valist=productDao.queryProAttr_ValueByAttr(li.get(i).getId());
                li.get(i).setValues(valist);
                if (li.get(i).getType()==2){
                    li.get(i).setCheckedValues(new Object[]{});
                }
                skuDats.add(li.get(i));
            }else {
                if (li.get(i).getType()!=3){
                    List<Attr_Value> valist=productDao.queryProAttr_ValueByAttr(li.get(i).getId());
                    li.get(i).setValues(valist);
                    if (li.get(i).getType() == 2) {
                        li.get(i).setCheckedValues(new Object[]{});
                    }
                }

                attrDatas.add(li.get(i));
            }
        }

        //查询sku数据
        rs.put("skuDatas",skuDats);
        //非sku数据
        rs.put("spuDatas",attrDatas);
        return rs;
    }
}
