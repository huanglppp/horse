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
	private final static String GET_ALL = ".getAll";
	
	//getByID,getByCode
	private final static String GET_BY = ".getBy";
	private final static String ID = "ID";
	private final static String CODE = "Code";
	
	//
	private final static String QUERY = ".query";
	private final static String FOR_PAGE = "ForPage";
	private final static String FOR_COUNT = "ForCount";
	
    /**
     * mybatis查询实现类。
     */
    @Resource
    protected BaseMyBatisDao baseMyBatisDao;

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
    
    /**
     * 获取保存，更新，删除，查询所有 的 mybatis sql id
     * @param operation
     * @return
     */
    private String getOperationSQLName(String operation){
    	StringBuilder builder = new StringBuilder();
    	builder.append(persistentName);
    	builder.append(operation);
    	builder.append(persistentSimpleName);
    	return builder.toString();
    }
    
    /**
     * 获取 根据ID和code 的 mybatis sql id
     * @param operationGetByName
     * @param operationSecondName
     * @return
     */
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
    public int delete(final Object id){
    	return baseMyBatisDao.delete(getOperationSQLName(DELETE), id);
    }
    
    /**
     * 根据ID获取对象
     * @param id
     * @return
     */
    public M getByID(final Object id){
    	Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("id", id);
    	return baseMyBatisDao.get(getOperationSQLName(GET_BY,ID), parameterMap);
    }
    
    /**
     * 根据编码获取对象
     * @param code
     * @return
     */
    public M getByCode(final String code){
    	Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("code", code);
    	return baseMyBatisDao.get(getOperationSQLName(GET_BY,CODE), parameterMap);
    }
    
    /**
     * 获取所有数据表
     * @return
     */
    public List<M> getAll() {
    	return baseMyBatisDao.query(getOperationSQLName(GET_ALL));
	}
    
    
    public List<M> queryForPage(final int offset,final int limit) {
        return queryForPage(null,offset,limit);
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
    public List<M> queryForPage(final Map<String,Object> parameter, final int offset,final int limit) {
        return baseMyBatisDao.queryForPage(getOperationSQLName(QUERY,FOR_PAGE), parameter, offset,limit);
    }

    /**
     * 查询持久化对象集合总数。
     * 
     * @param statement
     *            mybatis查询语句
     * @return 返回持久化对象总数
     */
    public Long queryForCount() {
        return queryForCount(null);
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
    public Long queryForCount(final Map<String,Object> parameter) {
        return baseMyBatisDao.queryForCount(getOperationSQLName(QUERY,FOR_COUNT), parameter);
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
    
}
