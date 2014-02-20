package com.horse.common.jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.horse.common.constant.Constants;
import com.horse.common.util.StringUtil;

public class JacksonUtil {

	/**
	 * 读取json文件转化为对象
	 * 
	 * @param file
	 * @param clazz
	 * @return
	 */
	public static <T> T readObjectFromFile(File jsonFile, Class<T> clazz) {
		if(jsonFile==null){
			return null;
		}
		
		try {
			return JacksonSinglton.getInstance().getObjectMapper().readValue(jsonFile, clazz);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 把json字符串转化为对象
	 * @param jsonString
	 * @param clazz
	 * @return
	 */
	public static <T> T readObjectFromJsonString(String jsonString, Class<T> clazz) {
		if(StringUtil.isNullOrBlank(jsonString)){
			return null;
		}
		try {
			return JacksonSinglton.getInstance().getObjectMapper().readValue(jsonString, clazz);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 把对象保存为json格式文件
	 * @param jsonFile
	 * @param object
	 */
	public static void writeObjectToFile(File jsonFile, Object object) {
		if(object == null){
			return;
		}
		
		try {
			JacksonSinglton.getInstance().getObjectMapper().writeValue(jsonFile, object);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 把json字符串转化为对象
	 * @param jsonString
	 * @param clazz
	 * @return
	 */
	public static String writeObjectToJsonString(Object object) {
		if(object == null){
			return Constants.EMPTY_STRING_VALUE;
		}
		 
		try {
			return JacksonSinglton.getInstance().getObjectMapper().writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return Constants.EMPTY_STRING_VALUE;
	}
}
