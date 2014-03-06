package com.horse.sys.role.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.horse.common.service.impl.BaseServiceImpl;
import com.horse.sys.role.model.Role;
import com.horse.sys.role.service.RoleService;

@Transactional
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{
	public int saveRole(Role role){
		return this.save(role);
	}
}
