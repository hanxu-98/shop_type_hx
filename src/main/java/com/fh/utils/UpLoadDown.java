package com.fh.utils;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UpLoadDown {
	
	
	/**
	 * 下载
	 * @throws IOException 
	 */
	public static void downLoad(String filePath,String fileName,HttpServletRequest request,HttpServletResponse response) throws IOException{
		if(!StringUtils.isEmpty(filePath)){
			String realPath = request.getSession().getServletContext().getRealPath("/");
			File f= new File(realPath+filePath);
			//判断图片是否存在
			if(f.exists()){
				//设置MIME类型
				//使客户端浏览器，区分不同种类的数据，并根据不同的MIME调用浏览器内不同的程序嵌入模块来处理相应的数据
				//application/octet-stream以流的形式下载 下载任意格式
				response.setContentType("application/octet-stream");			
				//或者为response.setContentType("application/x-msdownload");
				
				//设置头信息,设置文件下载时的默认文件名，同时解决中文名乱码问题
				response.addHeader("Content-disposition", "attachment;filename="+new String(fileName.getBytes(), "ISO-8859-1"));
				
				InputStream inputStream=new FileInputStream(f);
				ServletOutputStream outputStream=response.getOutputStream();
				byte[] bs=new byte[1024];
				while((inputStream.read(bs)>0)){
					outputStream.write(bs);
				}
				outputStream.close();
				inputStream.close();	
			}
			
		}
	}

	public static Map<String, Object> upload(MultipartFile image, HttpServletRequest request, String folderName) {
		Map<String, Object> map = new HashMap<>();
		//新增的时候不上传图片
		//新增的时候上传图片
		//修改的时候没有图片上传新的图片
		//修改的时候有图片 上传新的图片
			
			/*if(!StringUtils.isEmpty(car.getFilePath())){
				String path = request.getServletContext().getRealPath("");
				File f =  new File(path+"/"+car.getFilePath());
				if(f.exists()){
					f.delete();
				}
			}*/
			//1.获取上传的路径
			String path = request.getSession().getServletContext().getRealPath(folderName);
			//2判断文件路径是否存在 如果不存在则创建一个 存在的则不进if
			File f = new File(path);
			if(!f.exists()){
				//创建文件夹
				f.mkdir();
			}
			//3拼接新的文件名称
			//image.getOriginalFilename()获取真实名称
			String realFileName = image.getOriginalFilename();
			//截取到最后一个点的位置
			int lastIndexOf = realFileName.lastIndexOf(".");
			//获取后缀名称
			String hz = realFileName.substring(lastIndexOf);
			//拼接虚拟名称
			//UUID.randomUUID().toString() 获取一个随机的32位的串
			String falseName = UUID.randomUUID().toString()+hz;
			//把路径和虚拟名称拼接
			File file = new File(path+"/"+falseName);
			try {
				//transferTo上传图片
				image.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				map.put("filePath", folderName+"/"+falseName);
				map.put("fileName", realFileName);
				map.put("fileSize", calculateFileSize(image.getSize()));
		return map;
	}
	
	public static void deleteFile(String fileName, HttpServletRequest req, String folderName) {
		String realPath = req.getSession().getServletContext().getRealPath(folderName);
		if(!StringUtils.isEmpty(fileName)){
			File file = new File(realPath+"/"+fileName);
			file.delete();
		}
		
	}
	
	public static String calculateFileSize(long size) {
		DecimalFormat df = new DecimalFormat("0.00");
		if (size < 1024) {
			return size+"B";
		} else if (size < 1024 * 1024) {
			return df.format((double)size / 1024)+"KB";
		} else if (size < 1024 * 1024 * 1024) {
			return df.format((double)size / (1024 * 1024))+"MB";
		} else {
			return df.format((double)size / (1024 * 1024 * 1024))+"GB";
		}
	}

}
