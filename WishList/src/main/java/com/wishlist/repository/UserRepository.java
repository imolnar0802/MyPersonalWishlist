package com.wishlist.repository;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.wishlist.entity.Friends;
import com.wishlist.entity.User;

@Repository
public class UserRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
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
			log.error("Hibás felhasználónév és/vagy jelszó! - " + e);
		}
			
		return null;
	}
	

	public void insertNewUser(User user) {
		
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SET_USER");
		
		SqlParameterSource paramMap = new MapSqlParameterSource()
				.addValue("in_username", user.getUser_username())
				.addValue("in_name", user.getName())
				.addValue("in_email", user.getEmail())
				.addValue("in_password", user.getPass());
		
		try {
			out = call.execute(paramMap);
			log.info("Sikeres felhasználó regisztráció");
		}catch(Exception e){
			log.error("Sikertelen felhasználó regisztráció - " + e);
		}
	}
	
	public List<Friends> getAllFriends(String username){
		
		 String sql = "call GET_ALL_FRIENDS('"+username+"')";
		 try {
	        return jdbcTemplate.query(
	                sql,
	                (rs, rowNum) ->
	                        new Friends(
	                                rs.getString("name"),
	                                rs.getString("username"),
	                                rs.getString("email")
	                        )
	        );
		 }catch(Exception e) {
			 log.error("Sikertelen a barátok lekérdezése - " + e);
		 }
		 return null;
	}
}
