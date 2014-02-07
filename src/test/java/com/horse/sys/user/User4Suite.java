package com.horse.sys.user;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.horse.sys.user.dao.UserDaoTest;

@RunWith(Suite.class)
@SuiteClasses(value = { UserDaoTest.class})
public class User4Suite {

}
