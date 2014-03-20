package com.horse.sys.user.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.horse.common.basedao.BaseImplDao;
import com.horse.sys.user.dao.UserDao;
import com.horse.sys.user.model.User;


/**
 * 用户dao接口实现类。
 * 
 * @author longhuang
 * @version 1.0,2013-07-08
 * 
 */
@Repository("userDao")
public class UserDaoImpl extends  BaseImplDao<User> implements UserDao {
	 
	@Override
	public int saveUser(User user) {
		 return this.save(user);
	}
	
	@Override
    public int updateUser(User user){
    	return this.update(user);
    }
    
	@Override
    public int deleteUser(Integer id){
    	return this.delete(id);
    }
	
	public User getUserByCode(String code){
		return this.getByCode(code);
	}
	
	@Override
	public User getUserByID(Integer id) {
		return this.getByID(id);
	}
 
	@Override
	public List<User> getAllUser(){
		return this.getAll();
	}
	
	@Override
	public List<User> queryUserForPage(Map<String,Object> parameter){
		return this.queryForPage(parameter);
	}
	
	@Override
	public int queryUserForCount(Map<String,Object> parameter){
		return this.queryForCount(parameter);
	}
	 
}
