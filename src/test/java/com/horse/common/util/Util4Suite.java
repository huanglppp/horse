package com.horse.common.util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value = { 
			DateUtilTest.class, 
			FileUtilTest.class,
			StringUtilTest.class })
public class Util4Suite {

}
