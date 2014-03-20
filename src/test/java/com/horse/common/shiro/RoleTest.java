package com.horse.common.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RoleTest {
	@Test
	public void testHasRole(){
		Factory<SecurityManager> facotry = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager = facotry.getInstance();
		
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("hanglong","123");
		
		subject.login(token);
		subject.checkRole("role1");
		//subject.checkRoles("role1","role3");
		assertThat("",subject.isPermitted("user:create"),equalTo(true));
		//assertThat("",subject.hasRole("role1"),equalTo(true));
		//assertThat("",subject.hasRole("role2"),equalTo(true));
		//assertThat("",subject.hasRole("role3"),equalTo(false));
	}
}
