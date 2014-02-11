package com.horse.common;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.horse.common.cache.Cache4Suite;
import com.horse.common.jackson.Jackson4Suite;
import com.horse.common.util.Util4Suite;

@RunWith(Suite.class)
@SuiteClasses(value = {Cache4Suite.class, Jackson4Suite.class,Util4Suite.class})
public class Common4Suite {

}
