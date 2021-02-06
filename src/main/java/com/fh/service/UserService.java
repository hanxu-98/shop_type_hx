package com.fh.service;

import com.fh.utils.PageBean;
import com.fh.utils.ResultData;

public interface UserService {
    ResultData queryUser(PageBean pa);

    ResultData echoUserRole(Integer uid);

    ResultData saveUserRole(Integer uid, String rids);
}
