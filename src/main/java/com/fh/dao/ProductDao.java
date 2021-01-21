package com.fh.dao;

import com.fh.model.po.Attr;
import com.fh.model.po.Product;
import com.fh.model.po.ProductAttrDatas;
import com.fh.model.vo.ProductPageBean;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ProductDao {
    List<Attr> queryProductData(Integer typeId);
    @Insert("insert  into shop_product  (name,title,bandId,typeId,productdecs,price" +
            ",imgPath,stocks,sortNum,createDate,updateDate,author,isDel)" +
            " value(#{name},#{title},#{bandId},#{typeId},#{productdecs},#{price},#{imgPath},#{stocks},#{sortNum},#{createDate},#{updateDate},#{author},#{isDel})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void saveProductData(Product product);

    List<Product> queryProduct(ProductPageBean pa);

    Long queryProductCount(ProductPageBean pa);
    @Select("select * from shop_product where id=#{id}")
    Product echoProduct(Integer id);
    @Insert("<script>insert into shop_product_attrdatas (proId,attrData,storcks,price) " +
            "values <foreach collection='list' item='a' separator=','> ( #{a.proId},#{a.attrData},#{a.storcks},#{a.price} )  </foreach> </script>")
    void saveAllData(List<ProductAttrDatas> adList);
    @Update("update shop_product set name=#{name},title=#{title},bandId=#{bandId}," +
            "typeId=#{typeId},productdecs=#{productdecs},price=#{price}" +
            ",imgPath=#{imgPath},stocks=#{stocks},,sortNum=#{sortNum},createDate=#{createDate}" +
            ",updateDate=#{updateDate},author=#{author},isDel=#{isDel} " +
            "where id=#{id}")
    void updateProduct(Product product);
    @Update("<script>update shop_product_attrdatas set" +
            " <foreach collection='list' item='a' separator=','>" +
            "  " +
            "where proId=#{proId}" +
            "</foreach>  </script>")
    void updateProductAll(List<ProductAttrDatas> li);
}
