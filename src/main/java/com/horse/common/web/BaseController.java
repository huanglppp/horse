package com.horse.common.web;

import com.horse.common.jackson.JacksonUtil;

public class BaseController {

	public String toJsonString(Object obj){
		return JacksonUtil.writeObjectToJsonString(obj);
	}
}
