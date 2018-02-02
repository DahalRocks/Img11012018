package com.dhruba.user;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class User {
	
	private String fullname;
	@NotEmpty(message="Username can not be empty!!")
	private String username;
	@NotEmpty(message="Password can not be empty!!")
	private String password;
	private int userid;
	private Boolean reminded;
	private Boolean awareof;
	private String email;
	
	
	
	
	public Boolean getAwareof() {
		return awareof;
	}

	public void setAwareof(Boolean awareof) {
		this.awareof = awareof;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Boolean getReminded() {
		return reminded;
	}

	public void setReminded(Boolean reminded) {
		this.reminded = reminded;
	}

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

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User(int userid){
		this.userid=userid;
	}
	
	public User(){
		
	}

}
