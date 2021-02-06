package com.fh.controller;

import com.fh.service.UserService;
import com.fh.utils.PageBean;
import com.fh.utils.ResultData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("saveUserRole")
    public ResultData saveUserRole(Integer uid ,String rids){
        return userService.saveUserRole(uid,rids);
    }

    @GetMapping("echoUserRole")
    public ResultData echoUserRole(Integer uid){
        return userService.echoUserRole(uid);
    }

    @PostMapping("queryUser")
    public ResultData queryUser(PageBean pa){
        return userService.queryUser(pa);
    }
}
