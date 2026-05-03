package com.Service.User.Entity;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	private String username;
	private String email;
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "roleMapping", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "roleid"))
	private Set<RoleTable> roles = new HashSet<RoleTable>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<RoleTable> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleTable> roles) {
		this.roles = roles;
	}

	public UserEntity(Long id, String username, String email, String password, Set<RoleTable> roles) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
