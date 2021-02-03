package com.fh.controller;

import com.fh.model.po.Role;
import com.fh.service.RoleService;
import com.fh.utils.PageBean;
import com.fh.utils.ResultData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("api/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @DeleteMapping("delRole")
    public ResultData delRole(Integer id){
        return roleService.delRole(id);
    }
    @PostMapping("saveRoleData")
    public ResultData saveRoleData(Role role){
        return roleService.saveRoleData(role);
    }

    @PostMapping("queryData")
    public ResultData queryData(PageBean pa){
        return roleService.queryData(pa);
    }

}
