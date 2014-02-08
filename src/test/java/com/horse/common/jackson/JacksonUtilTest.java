package com.horse.common.jackson;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.horse.sys.user.model.User;

public class JacksonUtilTest {

	@Test
	public void testReadObjectFromFile() throws IOException {
		Resource resource = new ClassPathResource("jackson/user.json");
		File jsonFile = resource.getFile();
		User user = JacksonUtil.readObjectFromFile(jsonFile, User.class);
		assertThat("默认缓存名称为是" , user.getUserCode(), equalTo("MALE"));
	}
}
