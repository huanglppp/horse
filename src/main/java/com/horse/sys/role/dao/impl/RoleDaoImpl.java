package com.horse.sys.role.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.horse.common.basedao.BaseImplDao;
import com.horse.sys.role.dao.RoleDao;
import com.horse.sys.role.model.Role;

@Repository("roleDao")
public class RoleDaoImpl extends  BaseImplDao<Role> implements RoleDao {

	@Override
	public int saveRole(Role role) {
		 return this.save(role);
	}

	public List<Role> queryRoleForPage(Map<String,Object> parameter,int offset, int limit){
		return this.queryForPage(parameter, offset, limit);
	}
}
