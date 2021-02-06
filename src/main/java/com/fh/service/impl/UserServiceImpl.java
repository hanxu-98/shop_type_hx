package com.fh.service.impl;

import com.fh.dao.UserDao;
import com.fh.model.po.User;
import com.fh.model.vo.PageData;
import com.fh.service.UserService;
import com.fh.utils.PageBean;
import com.fh.utils.ResultData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public ResultData echoUserRole(Integer uid) {
        List<Integer> li=userDao.echoUserRole(uid);
        return ResultData.success(li);
    }

    @Override
    @Transactional
    public ResultData saveUserRole(Integer uid, String rids) {
        List list= new ArrayList();
        String[] split = rids.split(",");
        List<Integer> ridsList=new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            ridsList.add(Integer.parseInt(split[i]));
        }
        for (int i = 0; i < ridsList.size(); i++) {
            Map m=new HashMap();
            m.put("uid",uid);
            m.put("rid",ridsList.get(i));
            list.add(m);
        }

        userDao.delUserRole(uid);
        userDao.saveUserRole(list);
        return ResultData.success(null);
    }
}
