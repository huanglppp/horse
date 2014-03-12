package com.horse.sys.user.service.impl;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
 
import com.horse.common.service.impl.BaseServiceImpl;
import com.horse.sys.user.dao.UserDao;
import com.horse.sys.user.model.User;
import com.horse.sys.user.service.UserService;

/**
 * 用户服务类
 * 
 * @author longhuang
 * @version 1.0,2013-07-12
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Resource
	private UserDao userDao;

	public void saveUser(User user){
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("保存用户开始");
		}
		userDao.saveUser(user);
	}
	
	public User getUserByCode(String userCode){
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("保存用户开始");
		}
		return userDao.getUserByCode(userCode);
	}
}
