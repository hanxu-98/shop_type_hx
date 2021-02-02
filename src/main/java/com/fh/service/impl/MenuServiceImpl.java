package com.fh.service.impl;

import com.fh.dao.MenuDao;
import com.fh.model.po.Menu;
import com.fh.service.MenuService;
import com.fh.utils.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuDao menuDao;

    @Override
    public ResultData queryData(Integer pid) {

        List<Menu> list=menuDao.queryData(pid);
        return ResultData.success(list);
    }

    @Override
    public ResultData updateData(Menu menu) {
        if (menu.getId()!=null){
           menuDao.updateData(menu);
        }else {
            menu.setCreateDate(new Date());
            menu.setIsDel(0);
            menuDao.saveData(menu);
            return  ResultData.success(menu.getId());
        }


         return ResultData.success(null);
    }
}
