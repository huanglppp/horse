package com.horse.sys.user.service;


 
import java.util.Map;

import com.horse.common.service.BaseService;
import com.horse.sys.user.model.User;

 

/**
 * 用户服务类接口
 * @author longhuang
 *
 */
public interface UserService extends BaseService<User> {
	public int saveUser(User user);

	public String getUserForPage(Map<String,Object> parameterMap,int pageSize,int pageNum);
}
