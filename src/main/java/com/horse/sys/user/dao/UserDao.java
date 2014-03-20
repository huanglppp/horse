package com.horse.sys.user.dao;

import java.util.List;
import java.util.Map;

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
    
    /**
     * 获取所有用户
     * @return
     */
    public List<User> getAllUser();
    
    /**
     * 用户分页查询
     * @param parameter
     * @param offset
     * @param limit
     * @return
     */
    public List<User> queryUserForPage(Map<String,Object> parameter);
    
    /**
     * 查询总数
     * @param parameter
     * @return
     */
    public int queryUserForCount(Map<String,Object> parameter);
}
