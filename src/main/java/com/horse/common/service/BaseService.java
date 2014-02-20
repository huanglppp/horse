package com.horse.common.service;

import java.io.Serializable;
import java.util.List;


public interface BaseService<M extends Serializable> {
	
	public int save(M model);
 
	public List<M> getAll();
}
