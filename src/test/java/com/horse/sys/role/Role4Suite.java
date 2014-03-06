package com.horse.sys.role;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.horse.sys.role.dao.RoleDaoTest;
import com.horse.sys.role.service.RoleServiceTest;


@RunWith(Suite.class)
@SuiteClasses(value = { RoleDaoTest.class,
		RoleServiceTest.class})
public class Role4Suite {

}
