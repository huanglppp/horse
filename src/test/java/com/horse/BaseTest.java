package com.horse; 
import static org.junit.Assert.assertThat;

public abstract class BaseTest {
	protected  void equalTo(String reason,Object actual, Object matcher){
		assertThat(reason,actual, org.hamcrest.Matchers.equalTo(matcher));
	}
	
	protected void not(String reason,Object actual, Object matcher){
		assertThat(reason, actual, org.hamcrest.Matchers.not(matcher));
	}
	
	protected void notNullValue(String reason,Object actual){
		assertThat(reason,actual, org.hamcrest.Matchers.notNullValue());
	}
	protected void nullValue(String reason,Object actual){
		assertThat(reason,actual, org.hamcrest.Matchers.nullValue());
	}
	protected void greaterThanOrEqualTo(String reason,int actual,int matcher){
		assertThat(reason,actual, org.hamcrest.Matchers.greaterThanOrEqualTo(matcher));
	}
	
	protected void sameInstance(String reason,Object actual,Object matcher){
		assertThat("单例模式两实例相同",actual,org.hamcrest.Matchers.sameInstance(matcher));
	}
	  
	
}
