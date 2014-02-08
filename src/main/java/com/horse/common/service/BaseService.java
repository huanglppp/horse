package com.horse.common.service;

import java.io.Serializable;


public interface BaseService<M extends Serializable> {
	
	public int save(M model);
 

}
