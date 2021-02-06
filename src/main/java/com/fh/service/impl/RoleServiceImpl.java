package com.fh.service.impl;

import com.fh.dao.RoleDao;
import com.fh.model.po.Role;
import com.fh.model.vo.PageData;
import com.fh.service.RoleService;
import com.fh.utils.PageBean;
import com.fh.utils.ResultData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

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

    @Override
    public ResultData saveRoleData(Role role) {
        if (role.getId()!=null){
            roleDao.updateRole(role);
        }else {
            role.setCreateDate(new Date());
            roleDao.saveRole(role);
        }

        return ResultData.success(null);
    }

    @Override
    public ResultData delRole(Integer id) {
        roleDao.delRole(id);
        return ResultData.success(null);
    }

    @Override
    @Transactional
    public ResultData saveRoleMenu(Integer rid,String mids) {
        List rmli=new ArrayList();
        String[] midarr = mids.split(",");
        List<Integer> midarray=new ArrayList<>();
        for (int i = 0; i < midarr.length; i++) {
            midarray.add(Integer.parseInt(midarr[i]));
        }
        for (int i = 0; i < midarray.size(); i++) {
            Map m=new HashMap<>();
            m.put("rid",rid);
            m.put("mid",midarray.get(i));

            rmli.add(m);
        }
        roleDao.delRoleMenu(rid);
        roleDao.saveRoleMenu(rmli);

        return ResultData.success(null);
    }

    @Override
    public ResultData echoRoleMenu(Integer rid) {
        List<Integer> li=roleDao.echoRoleMenu(rid);
        return ResultData.success(li);
    }

    @Override
    public ResultData queryRoleAll() {
        List<Role> li=roleDao.queryRoleAll();

        return ResultData.success(li);
    }
}
