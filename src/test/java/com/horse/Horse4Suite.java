package com.horse;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.horse.common.cache.Cache4Suite;
import com.horse.common.util.Util4Suite;
import com.horse.sys.user.User4Suite;

@RunWith(Suite.class)
@SuiteClasses(value = { User4Suite.class,
		Cache4Suite.class,
		Util4Suite.class})
public class Horse4Suite {

}
