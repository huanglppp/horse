package com.horse.common.jackson;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class JacksonSingltonTest {
	
	
	@Test
	public void testGetInstance() {
		JacksonSinglton JacksonSinglton1 = JacksonSinglton.getInstance();
		JacksonSinglton JacksonSinglton2 = JacksonSinglton.getInstance();
		assertThat("不为空", JacksonSinglton1, notNullValue());
		assertThat("单例模式两实例相同", JacksonSinglton1,sameInstance(JacksonSinglton2));
		assertThat("单例模式两实例相同", JacksonSinglton1.getObjectMapper(),sameInstance(JacksonSinglton2.getObjectMapper()));
	}
}
