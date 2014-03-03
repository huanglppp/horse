package com.horse.common.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public interface BaseService<M extends Serializable> {
	
	public int save(M model);
 
	public List<M> getAll();
	
	public List<M> queryForPage(final Map<String,Object> parameter, final int offset,final int limit);
	
	public Long queryForCount(final Map<String,Object> parameter);
}
