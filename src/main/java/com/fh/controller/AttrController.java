package com.fh.controller;

import com.fh.model.vo.AttrPageBean;
import com.fh.service.impl.AttrService;
import com.fh.utils.ResultData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("api/attr")
public class AttrController {

    @Resource
    private AttrService attrService;


    /*http://localhost:8080/api/attr/queryAttr?currentPage=1&pageSize=2*/
    @PostMapping("queryAttr")
    public ResultData queryAttr(AttrPageBean pa){
        return attrService.queryAttr(pa);
    }
}
