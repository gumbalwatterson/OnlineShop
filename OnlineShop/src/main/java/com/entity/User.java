package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="name can't be empty")
	@Size(min=3 , max=10)
	private String name;
	
	private int active;
	
	@NotBlank(message="lastname can't be empty")
	@Size(min=2 , message="not acceptable name")
	private String lastname;
	
	@NotBlank(message="password can't be empty")
	private String password;
	
	private String permissions ="";
	private String roles ="";
	
	@NotBlank(message="email can't be empty")
	@Email(message="email can't be empty")
	private String email;

	public User() {
		
	}
	
	public User(String name,
			int active, String lastname,
			String password, String permissions, String roles , String email) {
		super();
		this.name = name;
		this.active = active;
		this.lastname = lastname;
		this.password = password;
		this.permissions = permissions;
		this.roles = roles;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public List<String> getListOfRoles() {
		
		if(getRoles().length()>0) {
	
			return Arrays.asList(getRoles().split(","));
		}
		
		return new ArrayList<>();
	}
	
	public List<String> getAuthorities() {
		
		
		if(getPermissions().length()>0) {
	
			return Arrays.asList(getPermissions().split(","));
		}
		
		return new ArrayList<>();
		}
		
}
