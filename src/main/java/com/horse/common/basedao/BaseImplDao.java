/**
 * 
 */
package com.horse.common.basedao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.core.ResolvableType;

import com.horse.common.dao.mybatis.BaseMyBatisDao;

 
/**
 * 基础父类实现。
 * 
 * @author longhuang
 * 
 * @param <M>
 *            泛型持久化对象
 * @param <PK>
 *            持久化对象标识
 */
public class BaseImplDao<M extends Serializable> {
	private final static String SAVE = ".save";
	private final static String UPDATE = ".update";
	private final static String DELETE = ".delete";
	private final static String GET_BY = ".getBy";
	private final static String ID = "ID";
	private final static String CODE = "Code";
	
    /**
     * mybatis查询实现类。
     */
    @Resource
    private BaseMyBatisDao baseMyBatisDao;

    /**
     * 持久对象包名 
     */
    private String persistentName;
    
    private String persistentSimpleName;
    
    /**
     * 构造方法持久化对象。
     * 
     * @param persistentClass
     *            持久化对象
     */
    @SuppressWarnings("unchecked")
	public BaseImplDao() {
    	//spring4提供的更好的泛型操作
    	ResolvableType resolvableType =ResolvableType.forClass(getClass());
    	Class<M> clazz = ((Class<M>) resolvableType.as(BaseImplDao.class).getGeneric(0).resolve());
    	this.persistentName = clazz.getName();
    	this.persistentSimpleName = clazz.getSimpleName();
    	//原生态api:this.persistentClass = (Class<M>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private String getOperationSQLName(String operation){
    	StringBuilder builder = new StringBuilder();
    	builder.append(persistentName);
    	builder.append(operation);
    	builder.append(persistentSimpleName);
    	return builder.toString();
    }
    
    private String getOperationSQLName(String operationGetByName,String operationSecondName){
    	StringBuilder builder = new StringBuilder();
    	builder.append(persistentName);
    	builder.append(operationGetByName);
    	builder.append(persistentSimpleName);
    	builder.append(operationSecondName);
    	return builder.toString();
    }
    /**
     * 保存对象
     * @param model
     * @return
     */
    public int save(M model){
    	return baseMyBatisDao.save(getOperationSQLName(SAVE), model);
    }
    
    /**
     * 更新对象
     * @param model
     * @return
     */
    public int update(M model){
    	return baseMyBatisDao.update(getOperationSQLName(UPDATE), model);
    }
    
    /**
     * 删除对象
     * @param id
     * @return
     */
    public int delete(Object id){
    	return baseMyBatisDao.delete(getOperationSQLName(DELETE), id);
    }
    
    /**
     * 根据ID获取对象
     * @param id
     * @return
     */
    public M getByID(Object id){
    	Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("id", id);
    	return baseMyBatisDao.get(getOperationSQLName(GET_BY,ID), parameterMap);
    }
    
    /**
     * 根据编码获取对象
     * @param code
     * @return
     */
    public M getByCode(String code){
    	Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("code", code);
    	return baseMyBatisDao.get(getOperationSQLName(GET_BY,CODE), parameterMap);
    }
    
    /**
     * 根据statement查询。
     * 
     * @param statement
     *            MyBatis查询语句
     * @return 返回持久化对象集合
     */
    public List<M> query(final String statement) {
        return baseMyBatisDao.query(statement);
    }

    /**
     * 根据statement查询条件过滤持久化集合。
     * 
     * @param statement
     *            mybatis查询语句
     * @param parameter
     *            过滤条件
     * @return 返回持久化对象集合
     */
    public List<M> query(final String statement, final Map<String,Object> parameter) {
        return baseMyBatisDao.query(statement, parameter);
    }

    /**
     * 根据statement查询条件过滤并分页持久化集合。
     * 例如：offset=0，limit=5 从第1行开始，取5条数据。
     *       offset=5，limit=3 从第6行开始，取3条数据。
     * @param statement
     *            mybatis查询语句
     * @param parameter
     *            过滤条件
     * @param offset
     *            分页开始处
     * @param limit
     *            要获取的集合数大小
     * @return 返回持久化对象集合
     */
    public List<M> queryForPage(final String statement, final Map<String,Object> parameter, final int offset,final int limit) {
        return baseMyBatisDao.queryForPage(statement, parameter, offset,limit);
    }

    /**
     * 查询持久化对象集合总数。
     * 
     * @param statement
     *            mybatis查询语句
     * @return 返回持久化对象总数
     */
    public Long queryForCount(final String statement) {
        return queryForCount(statement);
    }
    
    /**
     * 查询持久化对象集合总数。
     * 
     * @param statement
     *            mybatis查询语句
     * @param parameter
     *            过滤条件
     * @return 返回持久化对象总数
     */
    public Long queryForCount(final String statement, final Map<String,Object> parameter) {
        return baseMyBatisDao.queryForCount(statement, parameter);
    }
    
}