package com.fh.controller;

import com.fh.model.po.Menu;
import com.fh.service.MenuService;
import com.fh.utils.ResultData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("api/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    @PostMapping("updateData")
    public ResultData updateData(Menu menu){
        return menuService.updateData(menu);
    }

    @GetMapping("queryData")
    public ResultData queryData(Integer pid){
        return menuService.queryData(pid);
    }
}
