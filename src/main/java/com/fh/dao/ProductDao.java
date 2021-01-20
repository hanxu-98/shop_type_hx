package com.fh.dao;

import com.fh.model.po.Attr;
import com.fh.model.po.Product;
import com.fh.model.vo.ProductPageBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ProductDao {
    List<Attr> queryProductData(Integer typeId);
    @Insert("insert  into shop_product  (name,title,bandId,typeId,productdecs,price,imgPath,stocks,sortNum,createDate,updateDate,author,isDel)" +
            " value(#{name},#{title},#{bandId},#{typeId},#{productdecs},#{price},#{imgPath},#{stocks},#{sortNum},#{createDate},#{updateDate},#{author},#{isDel})")
    void saveProductData(Product product);

    List<Product> queryProduct(ProductPageBean pa);

    Long queryProductCount(ProductPageBean pa);
}
