package com.fh.service;

import com.fh.model.po.Role;
import com.fh.utils.PageBean;
import com.fh.utils.ResultData;

public interface RoleService {
    ResultData queryData(PageBean pa);

    ResultData saveRoleData(Role role);

    ResultData delRole(Integer id);
}
