package com.horse.sys.user.service.impl;

import javax.annotation.Resource;

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
	@Resource
	private UserDao userDao;

	public int saveUser(User user) {
		//baseservice 实现
		//return save(user);
		//userDao实现
		return userDao.saveUser(user);
	}
	

}
