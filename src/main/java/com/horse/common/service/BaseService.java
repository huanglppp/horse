package com.horse.common.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public interface BaseService<M extends Serializable> {
	
	public int save(M model);
 
	public List<M> getAll();
	
	public M getByCode(String code);
	 
	public String queryForPage(final Map<String,Object> parameter, final int pageSize,final int currentPage);
	 
}
