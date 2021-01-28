package com.fh.service;

import com.fh.model.po.User;
import com.fh.utils.ResultData;

import java.util.Map;

public interface LoginService {

    Map valUserName(String name);

    ResultData registerUser(User user);
}
