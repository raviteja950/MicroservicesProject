package com.Service.User.Entity;

import org.hibernate.annotations.GeneratedColumn;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rolestable")
public class RoleTable {

	@Id
	private long roleid;
	private String rolename;

	public long getRoleid() {
		return roleid;
	}

	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public RoleTable(long roleid, String rolename) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
	}

	public RoleTable() {
		super();
		// TODO Auto-generated constructor stub
	}

}
