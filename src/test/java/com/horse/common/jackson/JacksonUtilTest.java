package com.horse.common.jackson;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.junit.Test;

import com.horse.sys.user.model.User;

public class JacksonUtilTest {

	@Test
	public void testReadObjectFromFile() {
		File jsonFile = new File("user.json");
		User user = JacksonUtil.readObjectFromFile(jsonFile, User.class);
		assertThat("默认缓存名称为是" + user.getUserCode(), equalTo("MALE"));
	}
}
