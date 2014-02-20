package com.horse.common.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.horse.common.basedao.BaseImplDao;
import com.horse.common.service.BaseService;

public abstract class BaseServiceImpl <M extends Serializable> implements BaseService<M>   {

	@Autowired
	protected BaseImplDao<M> baseImplDao;
	
	@Override
	public int save(M model){
		return baseImplDao.save(model);
	}
	
	@Override
	public List<M> getAll(){
		return baseImplDao.getAll();
	}
}
