package com.horse;

import static org.junit.Assert.assertThat;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-config.xml" })
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager")
public abstract class AbstractBaseSpringTest extends AbstractTransactionalJUnit4SpringContextTests {
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
