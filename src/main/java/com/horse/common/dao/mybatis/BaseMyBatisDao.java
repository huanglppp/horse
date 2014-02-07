package com.horse.common.dao.mybatis;

import java.util.List;
import java.util.Map;

import com.horse.common.dao.BaseDao;

/**
 * Mybatis 基础dao接口
 * @author huanglong
 * @since 1.0 2013/08/27
 * @version broncho 1.0
 */
public interface BaseMyBatisDao extends BaseDao {
	
	/**
	 * 保存
	 * @param statement
	 * @return
	 */
	public int save(String statement);
	
	/**
	 * 带参数的保存
	 * @param statement
	 * @param parameter
	 * @return
	 */
	public int save(String statement, Object parameter);
	
	
	
	/**
	 * 更新
	 * @param statement
	 * @return
	 */
	public int update(String statement);

	/**
	 * 带参数更新
	 * @param statement
	 * @param parameter
	 * @return
	 */
	public int update(String statement, Object parameter);
	
	
	/**
	 * 删除
	 * @param statement
	 * @return
	 */ 
	public int delete(String statement);

	/**
	 * 带参数删除
	 * @param statement
	 * @return
	 */ 
	public int delete(String statement, Object id);
	
	
	/**
	 * 获取
	 * @param statement
	 * @return
	 */
	public <T> T get(String statement);
	
	/**
	 * 带参数获取
	 * @param statement
	 * @return
	 */
	public <T> T get(String statement,Map<String,Object> paramMap);
	
	/**
     * 查询。
     * 
     * @param statement
     *            mybatis SQL
     * 
     * @return 返回持久化对象集合
     */
    public <T> List<T> query(String statement);

    /**
     * 带参数查询。
     * 
     * @param statement
     *            mybatis SQL
     * @param parameter
     *            查询条件
     * 
     * @return 返回持久化对象集合
     */
    public <T> List<T> query(String statement, Map<String,Object> paramMap);

    /**
     * 分页查询。
     * 
     * @param statement
     *            mybatis sql
     * @param offset
     *            分页开始处
     * @param limit
     *            要返回的集合数大小
     * @return
     */
    public <T> List<T> queryForPage(String statement,int offset, int limit);
    
    /**
     * 带参数分页查询。
     * 
     * @param statement
     *            mybatis sql
     * @param parameter
     *            查询条件
     * @param offset
     *            分页开始处
     * @param limit
     *            要返回的集合数大小
     * @return
     */
    public <T> List<T> queryForPage(String statement, Map<String,Object> paramMap,int offset, int limit);
    
    /**
     * 查询总行数
     * @param statement
     */
    public <T> T queryForCount(String statement);
    
    /**
     * 带参数查询总行数
     * @param statement
     * @param parameter
     */
    public <T> T queryForCount(String statement, Map<String,Object> paramMap);
}
