package com.horse.common.util;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.horse.common.exception.BaseException;

public class FileUtil {

	/**
	 * 获取class目录下的文件对象
	 * @param fileRelativePath 目录相对路径
	 * @return 返回文件对象
	 * @throws IOException
	 */
	public static File getClassPathFile(String fileRelativePath) throws IOException{
		if(StringUtil.isNullOrBlank(fileRelativePath)){
			return null;
		}
		Resource resource = new ClassPathResource(fileRelativePath);
		return resource.getFile();
	}
	
	/**
	 * 
	 * @param fileRelativePath
	 * @return
	 * @throws Exception 
	 */
	public static File createClassPathFile(String fileRelativePath) throws BaseException,IOException{
		if(StringUtil.isNullOrBlank(fileRelativePath)){
			return null;
		}
		
		if(!fileRelativePath.contains(".")){
			throw new BaseException("必须包括文件后续名");
		}
		
		String classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		StringBuilder realPath = new StringBuilder();
		realPath.append(classPath);
		realPath.append(fileRelativePath);
		File file = new File(realPath.toString());
		
		//检查父目录是否存在，如果不存在，则创建
		if(!file.getParentFile().exists()){
			file.getParentFile().mkdirs();
		}
		//创建文件
		if(!file.exists()){
			file.createNewFile();
		}
		return file;
	}
}
