package com.horse;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.horse.common.Common4Suite;
import com.horse.sys.user.User4Suite;

@RunWith(Suite.class)
@SuiteClasses(value = { Common4Suite.class,
		User4Suite.class})
public class Horse4Suite {

}
