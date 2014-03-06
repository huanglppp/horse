package com.horse.sys.role.model;

public class Role implements java.io.Serializable{
	private static final long serialVersionUID = -8690991983162379496L;
	private Integer roleID;
	private String roleCode;
	private String roleName;
	private Integer parentRoleID;
	private String remark;
	 
	
	public Role() {
	}


	public Integer getRoleID() {
		return roleID;
	}


	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}


	public String getRoleCode() {
		return roleCode;
	}


	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public Integer getParentRoleID() {
		return parentRoleID;
	}


	public void setParentRoleID(Integer parentRoleID) {
		this.parentRoleID = parentRoleID;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}
	  
	
}
