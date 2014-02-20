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

import static com.horse.common.constant.ConstantsTest.USER_CODE;
import static com.horse.common.constant.ConstantsTest.USER_NAME;
import static com.horse.common.constant.ConstantsTest.USER_PASSWORD;
import static com.horse.common.constant.ConstantsTest.IS_VALID;
import static com.horse.common.constant.ConstantsTest.USER_TYPE;

public class JacksonUtilTest {
	private static final String USER_MODIFY_FILE = "jackson/user-modify.json";
	@Test
	public void testReadObjectFromFile() throws IOException {
		File jsonFile = FileUtil.getClassPathFile("jackson/user.json");
		User user = JacksonUtil.readObjectFromFile(jsonFile, User.class);
		assertThat("用户对象存在" , user.getUserCode(), equalTo("MALE"));
	}
	
	@Test
	public void testReadObjectFromJsonString() throws IOException {
		StringBuilder jsonString = new StringBuilder();
		jsonString.append("{");
		jsonString.append("	\"userID\":2,");
		jsonString.append("	\"userCode\":\"MALE\",");
		jsonString.append("	\"userName\":\"test\",");
		jsonString.append("	\"userPassword\":\"Rm9vYmFyIQ==\",");
		jsonString.append("	\"userType\":\"1\",");
		jsonString.append("	\"isValid\":\"0\"");
		jsonString.append("}");
		User user = JacksonUtil.readObjectFromJsonString(jsonString.toString(), User.class);
		assertThat("用户对象存在" , user.getUserCode(), equalTo("MALE"));
	}
	
	@Test
	@Ignore
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
