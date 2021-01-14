package com.fh.controller;

import com.fh.model.po.Attr;
import com.fh.model.vo.AttrPageBean;
import com.fh.service.impl.AttrService;
import com.fh.utils.ResultData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("api/attr")
public class AttrController {

    @Resource
    private AttrService attrService;


    /*查询 属性  分页数据  可条件查询name
    http://localhost:8080/api/attr/queryAttr
    *请求方式   post
    * 参数: currentPage  查询页数
    *       pageSize   查询每页条数
    *
    * 返回值
    *"code": 200, 成功状态码
     "message": "success", 提示
      "data": {
        "data": [],  返回分页数据
        "totalPage": 3  总条数
    }
    * */
    @PostMapping("queryAttr")
    public ResultData queryAttr(AttrPageBean pa){
        return attrService.queryAttr(pa);
    }

     /* 添加属性参数
    * url: http://localhost:8080/api/attr/saveAttr
    * 请求方式   post
    * 参数:
        name  属性名   string

        nameCH  属性中文名   string

        typeId   分类的主键 number

        type     属性的类型   number 0 下拉框     1 单选框      2  复选框   3  输入框

        isSKU  是否为sku属性 number

        返回值 "code": 200, 成功状态码
                "message": "success", 提示
                "data": 1   数据主键


    *
    * */
    @PostMapping("saveAttr")
    public ResultData saveAttr(Attr attr){
        return attrService.saveAttr(attr);
    }
    /* 修改指定id 的参数
    * url: http://localhost:8080/api/attr/updateAttr
    * 请求方式   post
    * 参数:id    主键  number

        name  属性名   string

        nameCH  属性中文名   string

        typeId   分类的主键 number

        type     属性的类型   number 0 下拉框     1 单选框      2  复选框   3  输入框

        isSKU  是否为sku属性 number

        返回值 "code": 200, 成功状态码
                "message": "success", 提示
                "data": null   无


    *
    * */

    @PostMapping("updateAttr")
    public ResultData updateAttr(Attr attr){
        return attrService.updateAttr(attr);
    }
    /*
    * 根据id 查找数据
    * url: http://localhost:8080/api/attr/echoAttr
    * 请求方式   get
    * 参数: id    主键  number

        返回值 "code": 200, 成功状态码
             "message": "success", 提示
              "data": {} 返回的指定ID的数据
    * */
    @GetMapping("echoAttr")
    public  ResultData echoAttr(Integer id){
        return attrService.echoAttr(id);
    }

    /*
    * 根据id 删除数据
    * url: http://localhost:8080/api/attr/delAttr
    * 请求方式   delete
    * 参数: id    主键  number

        返回值 "code": 200, 成功状态码
             "message": "success", 提示
              "data": {} 无
    * */
    @DeleteMapping("delAttr")
    public  ResultData delAttr(Integer id){
        return attrService.delAttr(id);
    }
}
