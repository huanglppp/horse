package com.horse.sys.user.service;

import static com.horse.common.constant.ConstantsTest.IS_VALID;
import static com.horse.common.constant.ConstantsTest.USER_CODE;
import static com.horse.common.constant.ConstantsTest.USER_ID;
import static com.horse.common.constant.ConstantsTest.USER_NAME;
import static com.horse.common.constant.ConstantsTest.USER_PASSWORD;
import static com.horse.common.constant.ConstantsTest.USER_TYPE;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.horse.AbstractBaseSpringTest;
import com.horse.sys.user.dao.UserDao;
import com.horse.sys.user.model.User;
import com.horse.sys.user.service.impl.UserServiceImpl;
public class UserServiceMockTest extends AbstractBaseSpringTest{
	 
    private UserServiceImpl userService;

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    private UserDao userDao;
    private User user;
 
    @Before
    public void init(){
    	userDao = context.mock(UserDao.class);
    	user = new User();
    	user.setUserCode(USER_CODE);
		user.setUserName(USER_NAME);
		user.setUserPassword(USER_PASSWORD);
		user.setIsValid(IS_VALID);
		user.setUserType(USER_TYPE);
        
    }


    @Test
    public void testSaveUser() {
        context.checking(new Expectations() {
            {
                allowing(userDao).saveUser(with(any(User.class)));
                will(returnValue(USER_ID));
            }
        });
        userService = new UserServiceImpl();
        ReflectionTestUtils.setField(userService, "userDao", userDao);  
        int pk = userService.saveUser(user);

        assertThat("用户名", pk, equalTo(USER_ID));
    }

    
}
