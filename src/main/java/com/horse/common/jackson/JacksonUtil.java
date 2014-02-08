package com.horse.common.jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class JacksonUtil {

	/**
	 * 读取json文件转化为对象
	 * @param file
	 * @param clazz
	 * @return
	 */
	public static <T> T readObjectFromFile(File jsonFile,Class<T> clazz){
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
}
