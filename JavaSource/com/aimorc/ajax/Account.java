package com.aimorc.ajax;

import java.util.Date;

public class Account {

	public int user_id;
	public String username;
	public String password;
	public String email;
	public Date created_on;
	public Date last_login;


	public Account(int user_id, String username, String password, String email, Date created_on, Date last_login) {
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.created_on = created_on;
		this.last_login = last_login;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}

	@Override
	public String toString() {
		return "\n Account [user_id=" + user_id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", created_on=" + created_on + ", last_login=" + last_login + "]";
	}



}
