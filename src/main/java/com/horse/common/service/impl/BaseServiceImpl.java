package com.horse.common.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.horse.common.basedao.BaseImplDao;
import com.horse.common.service.BaseService;

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
	public List<M> queryForPage(final Map<String, Object> parameter,
			final int offset, final int limit){
		return baseImplDao.queryForPage(parameter, offset, limit);
	}

	@Override
	public Long queryForCount(final Map<String, Object> parameter){
		return baseImplDao.queryForCount(parameter);
	}
}
