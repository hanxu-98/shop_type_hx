package com.fh.service.impl;

import com.fh.dao.LoginDao;
import com.fh.model.po.User;
import com.fh.service.LoginService;
import com.fh.utils.CodeUtil;
import com.fh.utils.MD5Util;
import com.fh.utils.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginDao loginDao;

    @Override
    public Map valUserName(String name) {
        Map map=new HashMap();
        List<User> li=loginDao.valUserName(name);
        if (li.size()>0){
            map.put("code", CodeUtil.USER_EXIST_CODE);
            return map;
        }
        map.put("code",CodeUtil.SUCCESS_CODE);
        return map;
    }

    @Override
    public ResultData registerUser(User user) {
        user.setCreateDate(new Date());
        user.setUpdateDate(new Date());
        user.setPassword(MD5Util.MD5Encode(user.getPassword()));
        loginDao.registerUser(user);
        return ResultData.success(null);
    }
}
