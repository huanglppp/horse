package com.horse.sys.role.service;

import com.horse.common.service.BaseService;
import com.horse.sys.role.model.Role;

public interface RoleService extends BaseService<Role> {
	public int saveRole(Role role);
}
