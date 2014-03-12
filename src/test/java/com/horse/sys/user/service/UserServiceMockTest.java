package com.horse.sys.user.service;

import static com.horse.common.constant.ConstantsTest.IS_VALID;
import static com.horse.common.constant.ConstantsTest.USER_CODE;
import static com.horse.common.constant.ConstantsTest.USER_NAME;
import static com.horse.common.constant.ConstantsTest.USER_PASSWORD;
import static com.horse.common.constant.ConstantsTest.USER_TYPE;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
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

    @Mock
    private UserDao userDao;
    
    private User user;
 
    @Before
    public void init(){
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
                allowing(userDao).getUserByCode(with(any(String.class)));will(returnValue(user));
                
            }
        });
        userService = new UserServiceImpl();
        ReflectionTestUtils.setField(userService, "userDao", userDao);  
        //测试保存的思路是：先保存，如果保存成功，则可以查询出来，调用查询方法
        //保存
        userService.saveUser(user);
        
        //查询
        User user2 = userService.getUserByCode(USER_CODE);
        
        assertThat("用户名", user2.getUserCode(), equalTo(user.getUserCode()));
    }

   
}

