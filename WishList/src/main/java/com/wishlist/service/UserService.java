package com.wishlist.service;

import com.wishlist.entity.User;

public interface UserService {
	
	public User findByUsername(String username);
	
	public String getUsername();
	
	public String getRole();
	
	public void regNewUser(User user);

}
