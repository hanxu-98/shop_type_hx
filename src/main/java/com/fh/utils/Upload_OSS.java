package com.fh.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Upload_OSS {
    // Endpoint以北京为例，其它Region请按实际情况填写。
    private static String endpoint = "oss-cn-beijing.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
    private static   String accessKeyId = "LTAI4GCgGNihZqtXUt2NqNRe";
    private static  String accessKeySecret = "30Y16cs3RGWnlfKmvHdeZuNjT7VtZZ";
    private static String bucket="oss-bucket-hx";


    /*
    * is  输入流
    *
    * fileName  保存的名字  //可以包含路径
    *
    */

    public static Map<String, Object> uploadFile(MultipartFile image, String folderName) throws IOException {
        Map<String,Object> map=new HashMap<String,Object>();
        String originalFilename = image.getOriginalFilename();
        //拼接新的文件名称
        //image.getOriginalFilename()获取真实名称
        String realFileName = image.getOriginalFilename();
        //截取到最后一个点的位置
        int lastIndexOf = realFileName.lastIndexOf(".");
        //获取后缀名称
        String hz = realFileName.substring(lastIndexOf);
        //拼接虚拟名称
        String newName = folderName+"/"+UUID.randomUUID().toString() + hz;
        // 创建OSSClient实例。
        OSS ossClient=new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        //调用上传方法
        PutObjectResult putObjectResult = ossClient.putObject(bucket,newName,image.getInputStream());
        //判断是否上传成功
        //释放资源
        ossClient.shutdown();
        map.put("filePath","https://"+bucket+"."+endpoint+"/"+newName);
        map.put("fileName",realFileName);
        return map;
    }








}
