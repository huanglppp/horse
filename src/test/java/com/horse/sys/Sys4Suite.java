package com.horse.sys;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.horse.sys.role.Role4Suite;
import com.horse.sys.user.User4Suite;


@RunWith(Suite.class)
@SuiteClasses(value = { Role4Suite.class,
		User4Suite.class})
public class Sys4Suite {

}
