package com.fh.controller;

import com.fh.model.po.TypeData;
import com.fh.service.TypeDataService;
import com.fh.utils.ResultData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("api/type")
public class TypeController {

        @Resource
        private TypeDataService typeDataService;


        /*http://localhost:8080/api/type/getData*/
        @GetMapping("getData")
        public ResultData getData(Integer pid){
                return typeDataService.getData(pid);
        }


        @PostMapping("add")
        public ResultData addTypeData(TypeData tdata){
                return typeDataService.addTypeData(tdata);
        }

        @PostMapping("update")
        public ResultData updateTypeData(TypeData tdata){
                return  typeDataService.updateTypeData(tdata);
        }


}
