package com.horse.sys.user.service;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import com.horse.AbstractBaseSpringTest;
import com.horse.sys.user.model.User;

import static com.horse.common.constant.ConstantsTest.USER_CODE;
import static com.horse.common.constant.ConstantsTest.USER_NAME;
import static com.horse.common.constant.ConstantsTest.USER_PASSWORD;
import static com.horse.common.constant.ConstantsTest.IS_VALID;
import static com.horse.common.constant.ConstantsTest.USER_TYPE;

public class UserServiceTest extends AbstractBaseSpringTest {
	
	@Resource
	private UserService userService;
	
	private User user =  null;
	
	
	
	@Before
	public void init(){
		user = new User();
		user.setUserCode(USER_CODE);
		user.setUserName(USER_NAME);
		user.setUserPassword(USER_PASSWORD);
		user.setIsValid(IS_VALID);
		user.setUserType(USER_TYPE);
	}
	
	@Test
	public void testSaveUser() throws Exception{
		userService.saveUser(user);
		
		User user2 = userService.getByCode(USER_CODE);
		assertThat("", user.getUserCode(), equalTo(user2.getUserCode()));
	}
	
//	@Test
//	public void testGetUserForPage(){
//		Map<String,Object> parameterMap = new HashMap<String,Object>();
//		String jasonString = userService.queryForPage(parameterMap,5, 3);
//		System.out.println(jasonString);
//	}
}
