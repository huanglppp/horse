package com.horse.sys.role.dao;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

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
		assertThat("", i, not(0));
		assertThat("", i, not(-1));
	}
 
	@Test
	public void testQueryUserForPage(){
		//saveUser();
		Map<String,Object> parameter = new HashMap<String,Object>();
		parameter.put("roleName", "管理%");
		List<Role> listRole = roleDao.queryRoleForPage(parameter, 0, 5);
		assertThat("",listRole.size(), greaterThanOrEqualTo(1));
	}
	
	private int saveUser() {
		return roleDao.saveRole(role);
	} 
	@After
	public void destory(){
		role = null;
	}
}
