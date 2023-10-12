package com.coderscampus;

public class User {
	String username;
	String password;
	String name;
	
	User (String username, String password, String name){
		this.username = username;
		this.password = password;
		this.name = name;
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
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

