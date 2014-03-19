package com.horse.common.dao.mybatis.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import com.horse.common.dao.mybatis.BaseMyBatisDao;

@Component(value = "baseMyBatisDao")
public class BaseMyBatisDaoImpl implements BaseMyBatisDao{
	
	@Resource
    private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int save(String statement) {
		return save(statement,null);
	}

	@Override
	public int save(String statement, Object parameter) {
		return sqlSessionTemplate.insert(statement,parameter);
	}
	
	@Override
	public int update(String statement) {
		return update(statement,null);
	}

	@Override
	public int update(String statement, Object parameter) {
		return sqlSessionTemplate.update(statement, parameter);
	}
	
	
	@Override
	public int delete(String statement) {
		return delete(statement,null);
	}

	@Override
	public int delete(String statement, Object id) {
		return sqlSessionTemplate.delete(statement, id);
	}
	
	@Override
	public <T> T get(String statement){
		return get(statement,null);
	}
	
	@Override
	public <T> T get(String statement,Map<String,Object> paramMap){
		return sqlSessionTemplate.selectOne(statement,paramMap);
	}
	
    @Override
    public <T> List<T> query(String statement) {
        return query(statement, null);
    }

    @Override
    public <T> List<T> query(String statement, Map<String,Object> paramMap) {
    	return sqlSessionTemplate.selectList(statement,paramMap);
    }

    @Override
   	public <T> List<T> queryForPage(String statement, int offset, int limit) {
   		return queryForPage(statement, null,offset,limit);
   	}
    
    @Override
    public <T> List<T> queryForPage(String statement, Map<String,Object> paramMap,
            int offset, int limit) {
        return queryForPage(statement, paramMap, new RowBounds(offset, limit));
    }

    
    private <T> List<T> queryForPage(String statement, Map<String,Object> paramMap,
            RowBounds rowBounds) {
        return sqlSessionTemplate.selectList(statement, paramMap, rowBounds);
    }
    
    @Override
	public <T> T queryForCount(String statement) {
		return queryForCount(statement,null);
	}
    
    @Override
    public <T> T queryForCount(String statement, Map<String,Object> paramMap){
    	return sqlSessionTemplate.selectOne(statement,paramMap);
    }

	

	

	
}
