package com.horse;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-config.xml" })
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager")
public abstract class AbstractBaseSpringTest extends AbstractTransactionalJUnit4SpringContextTests {

	
}
