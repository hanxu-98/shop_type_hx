package com.fh.service;

import com.fh.model.po.Role;
import com.fh.utils.PageBean;
import com.fh.utils.ResultData;

import java.util.Map;

public interface RoleService {
    ResultData queryData(PageBean pa);

    ResultData saveRoleData(Role role);

    ResultData delRole(Integer id);

    ResultData saveRoleMenu(Integer rid,String mids);

    ResultData echoRoleMenu(Integer rid);

    ResultData queryRoleAll();
}
