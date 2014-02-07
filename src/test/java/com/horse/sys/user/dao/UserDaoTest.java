package com.horse.sys.user.dao;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.horse.AbstractBaseSpringTest;
import com.horse.sys.user.model.User;

public class UserDaoTest extends AbstractBaseSpringTest {
	private static final String USER_TYPE = "1";
	private static final String IS_VALID = "1";
	private static final String USER_PASSWORD = "111111";
	private static final String USER_CODE = "longhuangaa";
	private static final String USER_NAME = "黄龙";
	
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
		assertThat("", i, not(0));
		assertThat("", i, not(-1));
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
		
		assertThat("",userTemp1.getUserCode(), equalTo(USER_CODE_UPDATE));
		assertThat("",userTemp1.getUserID(), equalTo(userTemp.getUserID()));
	} 
	
	@Test
	public void testDeleteUser() {
		//保存
		saveUser();
		//根据code获取
		User userTemp =  userDao.getUserByCode(USER_CODE);
		
		//删除
		int i =  userDao.deleteUser(userTemp.getUserID());
		assertThat("",i, not(0));
	} 
  
	@Test
	public void testGetUserByCode() {
		saveUser();
		User userTemp =  userDao.getUserByCode(USER_CODE);
		assertThat("",userTemp.getUserID(), equalTo(user.getUserID()));
	}
	
	@Test
	public void testGetUserById() {
		saveUser();
		User userTemp =  userDao.getUserByCode(USER_CODE);
		
		User userTemp1 = userDao.getUserByID(user.getUserID());
		assertThat("",userTemp1.getUserID(), equalTo(userTemp.getUserID()));
	}
	
	private int saveUser() {
		return userDao.saveUser(user);
	} 
	@After
	public void destory(){
		user = null;
	}
}
