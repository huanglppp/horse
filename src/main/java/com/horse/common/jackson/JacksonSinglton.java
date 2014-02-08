package com.horse.common.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonSinglton {
	
	private static volatile JacksonSinglton jacksonSinglton = null;

	private ObjectMapper mapper;

	private JacksonSinglton() {
		mapper = new ObjectMapper();
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
