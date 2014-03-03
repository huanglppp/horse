package com.horse.sys.user.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Resource
	private UserDao userDao;

	public int saveUser(User user) {
		//baseservice 实现
		//return save(user);
		//userDao实现
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("保存用户开始");
		}
		return userDao.saveUser(user);
	}

	@Override
	public String getUserForPage(Map<String, Object> parameterMap,
			int pageSize, int pageNum) {
		
		return null;
	}
	
	 
	
	 

}
