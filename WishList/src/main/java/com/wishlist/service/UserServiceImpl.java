package com.wishlist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wishlist.entity.User;
import com.wishlist.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	private User user;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		this.user = findByUsername(username);
		if( this.user == null ){
			throw new UsernameNotFoundException(username);
		}
		return new UserDetailsImpl(this.user);
	}
	
	public User findByUsername(String username) {
		this.user = userRepository.findByUsername(username);
		return user;
	}

	public String getUsername() {
		return this.user.getUser_username();
	}
	
	public String getRole() {
		return this.user.getRole();
	}
}
