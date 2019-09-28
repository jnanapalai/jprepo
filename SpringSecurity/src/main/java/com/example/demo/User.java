package com.example.demo;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")

public class User {
	@Id
	private int userid;
	@Column(name="username")
	private String username;
	@Column(name="userpassword")
	private String password;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns=@JoinColumn(name="user_id",referencedColumnName = "userid"),inverseJoinColumns=@JoinColumn(name="role_id",referencedColumnName = "roleid"))
	private Set<Role> roles;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	

}
