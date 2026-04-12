package com.Service.User.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	private String username;
	private String email;
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public UserEntity(Long id, String username, String email, String password) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + "]";
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
