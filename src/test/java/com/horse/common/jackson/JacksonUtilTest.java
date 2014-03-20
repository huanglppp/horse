package com.horse.common.jackson;

import static com.horse.common.constant.ConstantsTest.IS_VALID;
import static com.horse.common.constant.ConstantsTest.USER_CODE;
import static com.horse.common.constant.ConstantsTest.USER_NAME;
import static com.horse.common.constant.ConstantsTest.USER_PASSWORD;
import static com.horse.common.constant.ConstantsTest.USER_TYPE;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.horse.BaseTest;
import com.horse.common.exception.BaseException;
import com.horse.common.util.FileUtil;
import com.horse.sys.user.model.User;

public class JacksonUtilTest extends BaseTest {
	private static final String USER_MODIFY_FILE = "jackson/user-modify.json";
	@Test
	public void testReadObjectFromFile() throws IOException {
		File jsonFile = FileUtil.getClassPathFile("jackson/user.json");
		User user = JacksonUtil.readObjectFromFile(jsonFile, User.class);
		equalTo("用户对象存在" , user.getUserCode(), "MALE");
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
		equalTo("用户对象存在" , user.getUserCode(),"MALE");
	}
	
	@Test
	public void testWriteObjectToFile() throws IOException, BaseException {
		User user = createUser();
		
		File toFile =  FileUtil.createClassPathFile(USER_MODIFY_FILE);
		JacksonUtil.writeObjectToFile(toFile, user);
		
		Resource resource = new ClassPathResource(USER_MODIFY_FILE);
		File jsonFile = resource.getFile();
		User user1 = JacksonUtil.readObjectFromFile(jsonFile, User.class);
		equalTo("默认缓存名称为是" , user1.getUserCode(), USER_CODE);
	}
	
	@Test
	public void testWriteObjectToJsonString_List() throws IOException, BaseException {
		List<User> listUser = new ArrayList<User>();
		User user = createUser();
		listUser.add(user);
		 
		String userJsonString = JacksonUtil.writeObjectToJsonString(listUser);
		greaterThanOrEqualTo("默认缓存名称为是" , userJsonString.indexOf(USER_CODE), 1);
	}

	private User createUser() {
		User user = new User();
		user.setUserID(1);
		user.setUserCode(USER_CODE);
		user.setUserName(USER_NAME);
		user.setUserPassword(USER_PASSWORD);
		user.setIsValid(IS_VALID);
		user.setUserType(USER_TYPE);
		return user;
	}
}
