package com.horse.sys.user.service;

import com.horse.common.service.BaseService;
import com.horse.sys.user.model.User;

/**
 * 用户服务类接口
 * @author longhuang
 *
 */
public interface UserService extends BaseService<User> {
	public void saveUser(User user) throws Exception;
}
