package com.horse.sys.user.dao;

import com.horse.sys.user.model.User;

 

/**
 * 用户dao接口。 提供了保存用户，查询所有用户和根据用户ID获取用户功能。
 * 
 * @author xbdeng
 * 
 */
public interface UserDao {
    /**
     * 保存用户。
     * 
     * @param user
     *            用户对象
     * @return 返回保存后的用户对象唯一标识符
     */
    public int saveUser(User user);
    
    /**
     * 更新用户。
     * 
     * @param user
     *            用户对象
     * @return 返回保存后的用户对象唯一标识符
     */
    public int updateUser(User user);
    
    /**
     * 更新用户。
     * 
     * @param id
     *            用户ID
     * @return 返回保存后的用户对象唯一标识符
     */
    public int deleteUser(Integer id);
    
    /**
     * 根据ID获取用户信息。
     * 
     * @param id
     *            用户ID
     * @return 返回保存后的用户对象唯一标识符
     */
    public User getUserByCode(String code);
    
    /**
     * 根据ID获取用户信息。
     * 
     * @param id
     *            用户ID
     * @return 返回保存后的用户对象唯一标识符
     */
    public User getUserByID(Integer id);
}
