package com.horse.common.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.horse.common.basedao.BaseImplDao;
import com.horse.common.jackson.JacksonUtil;
import com.horse.common.service.BaseService;
@Transactional
public abstract class BaseServiceImpl<M extends Serializable> implements
		BaseService<M> {

	@Autowired
	protected BaseImplDao<M> baseImplDao;

	@Override
	public int save(M model) {
		return baseImplDao.save(model);
	}

	@Override
	public List<M> getAll() {
		return baseImplDao.getAll();
	}

	@Override
	public M getByCode(String code){
		return baseImplDao.getByCode(code);
	}
	 
	
	@Override 
	public String queryForPage(Map<String, Object> parameterMap,int pageSize, int currentPage) {
		//获取总数
		int count = baseImplDao.queryForCount(parameterMap);
		
		//共多少页
		int pageCount = getPageCount(pageSize, count);
		
		//获取开始页
		int offset = getStartRow(pageSize, currentPage);
		
		List<M> listUser = baseImplDao.queryForPage(parameterMap, offset, pageSize);
		
		return getPageJsonString(currentPage, count,pageCount, listUser);
	}

	private String getPageJsonString(int currentPage, int count,
			int pageCount, List<M> listUser) {
		Map<String,Object> pageMap = new HashMap<String,Object>();
		pageMap.put("count", count);
		pageMap.put("pageCount", pageCount);
		pageMap.put("currentPage", currentPage);
		pageMap.put("items", listUser);
		return JacksonUtil.writeObjectToJsonString(pageMap);
	}

	private int getStartRow(int pageSize, int currentPage) {
		return ((currentPage - 1) < 0) ? 0 : (currentPage - 1) * pageSize;
	}

	private int getPageCount(int pageSize, int count) {
		int pageCount  = 0;
		if(count % pageSize ==0 ){
			pageCount = count / pageSize;
		}else{
			pageCount = count / pageSize + 1;
		}
		return pageCount;
	}
}
