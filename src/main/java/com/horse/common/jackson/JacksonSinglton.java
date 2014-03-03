package com.horse.common.jackson;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.horse.common.util.DateUtil;

public class JacksonSinglton {
	
	private static volatile JacksonSinglton jacksonSinglton = null;

	private ObjectMapper mapper;

	private JacksonSinglton(){
		mapper = new ObjectMapper();
		
		//设置时间
		mapper.setDateFormat(new  SimpleDateFormat(DateUtil.DATETIME_FORMAT));
		 //提供其它默认设置
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
		mapper.setFilters(new SimpleFilterProvider().setFailOnUnknownId(false));
	}
	
	public static JacksonSinglton getInstance() {
        if (jacksonSinglton != null) {
            return jacksonSinglton;
        }
        synchronized (JacksonSinglton.class) {
            if (jacksonSinglton == null) {
            	jacksonSinglton = new JacksonSinglton();
            }
            return jacksonSinglton;
        }
    }
	
	public ObjectMapper getObjectMapper(){
		return mapper;
	}
}
