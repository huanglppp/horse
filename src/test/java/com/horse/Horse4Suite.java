package com.horse;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.horse.common.Common4Suite;
import com.horse.sys.Sys4Suite;

@RunWith(Suite.class)
@SuiteClasses(value = { Common4Suite.class,
		Sys4Suite.class})
public class Horse4Suite {

}
