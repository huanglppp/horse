package com.horse.common.jackson;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value = { JacksonSingltonTest.class,JacksonUtilTest.class })
public class Jackson4Suite {

}
