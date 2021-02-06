package com.fh.controller;

import com.fh.service.UserService;
import com.fh.utils.PageBean;
import com.fh.utils.ResultData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("queryUser")
    public ResultData queryUser(PageBean pa){
        return userService.queryUser(pa);
    }
}
