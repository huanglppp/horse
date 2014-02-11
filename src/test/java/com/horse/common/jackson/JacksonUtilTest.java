package com.horse.common.jackson;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.horse.common.exception.BaseException;
import com.horse.common.util.FileUtil;
import com.horse.sys.user.model.User;

public class JacksonUtilTest {
	private static final String USER_TYPE = "1";
	private static final String IS_VALID = "1";
	private static final String USER_PASSWORD = "111111";
	private static final String USER_CODE = "longhuangaa";
	private static final String USER_NAME = "黄龙";
	
	
	private static final String USER_MODIFY_FILE = "jackson/user-modify.json";
	@Test
	@Ignore
	public void testReadObjectFromFile() throws IOException {
		File jsonFile = FileUtil.getClassPathFile("jackson/user.json");
		User user = JacksonUtil.readObjectFromFile(jsonFile, User.class);
		assertThat("用户对象存在" , user.getUserCode(), equalTo("MALE"));
	}
	
	@Test
	public void testWriteObjectToFile() throws IOException, BaseException {
		User user = new User();
		user.setUserID(1);
		user.setUserCode(USER_CODE);
		user.setUserName(USER_NAME);
		user.setUserPassword(USER_PASSWORD);
		user.setIsValid(IS_VALID);
		user.setUserType(USER_TYPE);
		
		File toFile =  FileUtil.createClassPathFile(USER_MODIFY_FILE);
		JacksonUtil.writeObjectToFile(toFile, user);
		
		Resource resource = new ClassPathResource(USER_MODIFY_FILE);
		File jsonFile = resource.getFile();
		User user1 = JacksonUtil.readObjectFromFile(jsonFile, User.class);
		assertThat("默认缓存名称为是" , user1.getUserCode(), equalTo(USER_CODE));
	}
}
