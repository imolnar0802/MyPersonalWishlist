package com.wishlist.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.wishlist.entity.User;

@Repository
public class UserRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Map<String, Object> out;
	
	@Autowired
	public UserRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public User findByUsername(String username) {
		
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("GET_USER");
		
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("in_user", username);
		try {
			out = call.execute(paramMap);
			
			if ((String) out.get("out_user_username") != null) {
				User user = new User();
				user.setName((String) out.get("out_user_name"));
				user.setEmail((String) out.get("out_email"));
				user.setUser_username(username);
				user.setPass((String) out.get("out_password"));
				user.setRole((String) out.get("out_role"));
				
				return user;
			}
		} catch (Exception e) {
			System.err.println("Hibás felhasználónév és/vagy jelszó!");
		}
			
		return null;
	}
}
