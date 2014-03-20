package com.horse.sys.role.service;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import com.horse.AbstractBaseSpringTest;
import com.horse.sys.role.model.Role;
import com.horse.sys.role.service.RoleService;

public class RoleServiceTest extends AbstractBaseSpringTest {
	
	@Resource
	private RoleService roleService;
	
	private Role role =  null;
	
	@Before
	public void init(){
		role = new Role();
		role.setRoleCode("admin17");
		role.setRoleName("天天");
		role.setParentRoleID(null);
		role.setRemark("测试一把");
	}
	
	@Test
	public void testSaveUser(){
		int i = roleService.saveRole(role);
		not("", i, 0);
		not("", i, -1);
	}
	 
	@Test
	public void testGetUserForPage(){
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		String jasonString = roleService.queryForPage(parameterMap,5, 1);
		System.out.println(jasonString);
	}
}
