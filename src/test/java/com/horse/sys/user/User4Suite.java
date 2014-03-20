package com.horse.sys.user;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.horse.sys.user.dao.UserDaoTest;
import com.horse.sys.user.service.UserServiceMockTest;
import com.horse.sys.user.service.UserServiceTest;

@RunWith(Suite.class)
@SuiteClasses(value = { UserDaoTest.class,UserServiceMockTest.class,UserServiceTest.class})
public class User4Suite {

}
