package com.horse.sys.user.dao;

import static com.horse.common.constant.ConstantsTest.IS_VALID;
import static com.horse.common.constant.ConstantsTest.USER_CODE;
import static com.horse.common.constant.ConstantsTest.USER_NAME;
import static com.horse.common.constant.ConstantsTest.USER_PASSWORD;
import static com.horse.common.constant.ConstantsTest.USER_TYPE;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.horse.AbstractBaseSpringTest;
import com.horse.sys.user.model.User;

public class UserDaoTest extends AbstractBaseSpringTest {
	
	
	private static final String USER_CODE_UPDATE = "ding";

	private User user =  null;
	@Resource
	private UserDao userDao;
	
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
	
	public void testSaveUser() {
		int i = saveUser();
		not("", i,0);
		not("", i,1);
	}

	@Test
	
	public void testUpdateUser() {
		//保存
		saveUser();
		//根据code获取
		User userTemp =  userDao.getUserByCode(USER_CODE);
		
		//更改code
		userTemp.setUserCode(USER_CODE_UPDATE);
		userDao.updateUser(userTemp);
		
		User userTemp1 =  userDao.getUserByCode(USER_CODE_UPDATE);
		
		equalTo("",userTemp1.getUserCode(), USER_CODE_UPDATE);
		equalTo("",userTemp1.getUserID(),userTemp.getUserID());
	} 
	
	@Test
	
	public void testDeleteUser() {
		//保存
		saveUser();
		//根据code获取
		User userTemp =  userDao.getUserByCode(USER_CODE);
		
		//删除
		int i =  userDao.deleteUser(userTemp.getUserID());
		not("",i, 0);
	} 
  
	@Test
	
	public void testGetUserByCode() {
		saveUser();
		User userTemp =  userDao.getUserByCode(USER_CODE);
		equalTo("",userTemp.getUserID(), user.getUserID());
	}
	
	@Test
	 
	public void testGetUserById() {
		saveUser();
		User userTemp =  userDao.getUserByCode(USER_CODE);
		
		User userTemp1 = userDao.getUserByID(user.getUserID());
		equalTo("",userTemp1.getUserID(), userTemp.getUserID());
	}
	
	@Test
	
	public void testGetAllUser() {
		saveUser();
		List<User> listUser =  userDao.getAllUser();
		notNullValue("",listUser);
		greaterThanOrEqualTo("",listUser.size(),1);
	}
	
	@Test
	
	public void testQueryUserForPage(){
		//saveUser();
		Map<String,Object> parameter = new HashMap<String,Object>();
		parameter.put("userCode", "a");
		parameter.put("userName", "a%");
		parameter.put("offset", 0);
		parameter.put("limit", 5);
		List<User> listUser = userDao.queryUserForPage(parameter);
		greaterThanOrEqualTo("",listUser.size(), 1);
	}
	
	@Test
	
	public void testQueryUserForCount(){
		saveUser();
		Map<String,Object> parameter = new HashMap<String,Object>();
		parameter.put("userCode", "a");
		parameter.put("userName", "a");
		int count = userDao.queryUserForCount(parameter);
		equalTo("",count, 1);
	}
	
	private int saveUser() {
		return userDao.saveUser(user);
	} 
	@After
	public void destory(){
		user = null;
	}
}
