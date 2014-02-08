package com.horse.sys.user.service;

import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import com.horse.AbstractBaseSpringTest;
import com.horse.sys.user.model.User;

public class UserServiceTest extends AbstractBaseSpringTest {
	private static final String USER_TYPE = "1";
	private static final String IS_VALID = "1";
	private static final String USER_PASSWORD = "111111";
	private static final String USER_CODE = "longhuangaa";
	private static final String USER_NAME = "黄龙";
	
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
	public void testSaveUser(){
		int i = userService.saveUser(user);
		assertThat("", i, not(0));
		assertThat("", i, not(-1));
	}
}
