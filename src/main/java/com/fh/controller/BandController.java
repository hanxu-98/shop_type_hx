package com.fh.controller;

import com.fh.model.po.Band;
import com.fh.model.vo.BandPageBean;
import com.fh.service.BandService;
import com.fh.utils.Upload_OSS;
import com.fh.utils.ResultData;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/band")
public class BandController {

    @Resource
    private BandService bandService;
    @Resource
    private HttpServletResponse response;
    @Resource
    private HttpServletRequest request;
    /*http://localhost:8080/api/band/queryBand?currentPage=1&pageSize=2*/
    @PostMapping("queryBand")
    public ResultData queryBand(BandPageBean bpage){
            return bandService.queryBand(bpage);
    }
    @PostMapping("saveBand")
    public ResultData saveBand(Band band){
        return bandService.saveBand(band);
    }
    @DeleteMapping("delBand")
    public ResultData delBand(Integer id){
        return bandService.delBand(id);

    }
    @PostMapping("upload")
    public Map upload(MultipartFile image) throws IOException {
        //Map<String, Object> map = UpLoadDown.upload(image, request, "images");

        Map<String, Object> map = Upload_OSS.uploadFile(image, "images");

        return map;
    }


}
