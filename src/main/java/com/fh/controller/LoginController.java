package com.fh.controller;

import com.fh.model.po.User;
import com.fh.service.LoginService;
import com.fh.utils.ResultData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("registerUser")
    public ResultData registerUser(User user){

        return loginService.registerUser(user);
    }

    /*验证用户唯一*/
    @GetMapping("valUserName")
    public Map valUserName(String name){
        return loginService.valUserName(name);
    }

}
