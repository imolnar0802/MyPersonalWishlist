package com.wishlist.entity;

public class User {
	
	private String user_username;
	private String name;
	private String email;
	private String pass;
	private String role;
	private Friends friends;
	
	public User() {}
	
	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Friends getFriends() {
		return friends;
	}

	public void setFriends(Friends friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "User [user_username=" + user_username + ", name=" + name + ", email=" + email + ", pass=" + pass
				+ ", role=" + role + "]";
	}
}
