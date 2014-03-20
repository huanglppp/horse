package com.horse.common.jackson;

import org.junit.Test;

import com.horse.BaseTest;

public class JacksonSingltonTest extends BaseTest{
	
	
	@Test
	public void testGetInstance() {
		JacksonSinglton JacksonSinglton1 = JacksonSinglton.getInstance();
		JacksonSinglton JacksonSinglton2 = JacksonSinglton.getInstance();
		notNullValue("不为空", JacksonSinglton1);
		sameInstance("单例模式两实例相同", JacksonSinglton1,JacksonSinglton2);
		sameInstance("单例模式两实例相同", JacksonSinglton1.getObjectMapper(),JacksonSinglton2.getObjectMapper());
	}
}
