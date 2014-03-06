package com.horse.sys.role.dao;

import java.util.List;
import java.util.Map;

import com.horse.sys.role.model.Role;

public interface RoleDao {
	public int saveRole(Role role);
	public List<Role> queryRoleForPage(Map<String,Object> parameter,int offset, int limit);
}
