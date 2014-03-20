package com.horse.sys.role.dao;
 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.horse.AbstractBaseSpringTest;
import com.horse.sys.role.model.Role;

public class RoleDaoTest extends AbstractBaseSpringTest {
	private Role role =  null;
	@Resource
	private RoleDao roleDao;
	
	@Before
	public void init(){
		role = new Role();
		role.setRoleCode("admin15");
		role.setRoleName("天天");
		role.setParentRoleID(null);
		role.setRemark("测试一把");
	}
	
	@Test
	public void testSaveUser() {
		int i = saveUser();
		not("", i, 0);
		not("", i, -1);
	}
 
	@Test
	public void testQueryUserForPage(){
		//saveUser();
		Map<String,Object> parameter = new HashMap<String,Object>();
		parameter.put("roleName", "管理%");
		parameter.put("offset", 5);
		parameter.put("limit", 5);
		List<Role> listRole = roleDao.queryRoleForPage(parameter);
		greaterThanOrEqualTo("",listRole.size(), 1);
	}
	
	private int saveUser() {
		return roleDao.saveRole(role);
	} 
	@After
	public void destory(){
		role = null;
	}
}
