package com.fh.service.impl;

import com.fh.dao.TypeDataDao;
import com.fh.model.po.TypeData;
import com.fh.service.TypeDataService;
import com.fh.utils.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class TypeDataServiceImpl implements TypeDataService{

        @Resource
        private TypeDataDao typeDataDao;

        @Override
        public ResultData getData(Integer pid) {

                List<TypeData> list=typeDataDao.getData(pid);

                return ResultData.success(list);
        }

        @Override
        public ResultData addTypeData(TypeData tdata) {
                tdata.setCreateDate(new Date());
                tdata.setUpdateDate(new Date());
                tdata.setIsDel(0);
                typeDataDao.addTypeData(tdata);
                return ResultData.success(tdata.getId());
        }

        @Override
        public ResultData updateTypeData(TypeData tdata) {
                tdata.setUpdateDate(new Date());
                typeDataDao.updateTypeData(tdata);
                return ResultData.success(null);
        }


}
