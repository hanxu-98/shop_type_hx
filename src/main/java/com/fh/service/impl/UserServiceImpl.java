package com.fh.service.impl;

import com.fh.dao.UserDao;
import com.fh.model.po.User;
import com.fh.model.vo.PageData;
import com.fh.service.UserService;
import com.fh.utils.PageBean;
import com.fh.utils.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public ResultData queryUser(PageBean pa) {
        pa.compute();
        List<User> li=userDao.queryData(pa);
        Long count=userDao.queryDataCount();
        PageData p=new PageData();
        p.setTotalPage(count);
        p.setData(li);
        return ResultData.success(p);
    }
}
