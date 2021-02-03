package com.fh.service.impl;

import com.fh.dao.RoleDao;
import com.fh.model.po.Role;
import com.fh.model.vo.PageData;
import com.fh.service.RoleService;
import com.fh.utils.PageBean;
import com.fh.utils.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;

    @Override
    public ResultData queryData(PageBean pa) {
        pa.compute();
        List<Role> li=roleDao.queryData(pa);
        Long count= roleDao.queryDataCount();
        PageData p=new PageData();
        p.setData(li);
        p.setTotalPage(count);
        return ResultData.success(p);
    }
}
