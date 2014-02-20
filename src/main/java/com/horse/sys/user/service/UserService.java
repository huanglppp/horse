package com.horse.sys.user.service;


import java.util.List;

import com.horse.sys.user.model.User;

 

/**
 * 用户服务类接口
 * @author longhuang
 *
 */
public interface UserService {
	public int saveUser(User user);

	public List<User> getUserForPage();
}
