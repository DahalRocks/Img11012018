package com.dhruba.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

	private NamedParameterJdbcTemplate param;
	
	@Autowired
	public void setParam(BasicDataSource param){
		this.param=new NamedParameterJdbcTemplate(param);
	}
	
	public int saveUser(User user){
		
		String sql="Insert into user (user_name, user_password, user_fullname, user_email, user_awareof) values(:userName,:userPassword,:userfullname,:userEmail,:userAwareof)";
		MapSqlParameterSource source=new MapSqlParameterSource();
		source.addValue("userName", user.getUsername());
		source.addValue("userPassword", user.getPassword());
		source.addValue("userfullname", user.getFullname());
		source.addValue("userEmail", user.getEmail());
		source.addValue("userAwareof",user.getAwareof());
		return param.update(sql, source);
				
	}

	public  boolean exists(User user) {
		boolean result=false;
		try {
			result= param.queryForObject("Select count(*) from user where user_name=:username", new MapSqlParameterSource("username", user.getUsername()), Integer.class)>0;
		} catch (DataAccessException e) {
			
			
		}
		return result;
	}
	
	public User getUserDetailByName(User user){
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("username", user.getUsername());
		return (User) param.queryForObject("Select * from user where user_name=:username", source,
				new RowMapper<User>() {
					@Override
					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
						User user = new User();
						user.setUserid(rs.getInt("user_id"));
						user.setUsername(rs.getString("user_name"));
						user.setPassword(rs.getString("user_password"));
						user.setReminded(rs.getBoolean("user_isReminded"));
						return user;
					}
				});
		}
	
	public boolean login(User user){
		MapSqlParameterSource source=new MapSqlParameterSource();
		source.addValue("username", user.getUsername());
		source.addValue("userpassword", user.getPassword());
		return param.queryForObject("Select count(*) from user where user_name=:username AND user_password=:userpassword", source, Integer.class)>0;
	}
	
	public List<User> getUserList(){
		
		return param.query("Select * from user", new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user=new User();
				user.setUserid(rs.getInt("user_id"));
				user.setUsername(rs.getString("user_name"));
				user.setPassword(rs.getString("user_password"));
				user.setReminded(rs.getBoolean("user_isReminded"));
				user.setFullname(rs.getString("user_fullname"));
				user.setEmail(rs.getString("user_email"));
				user.setAwareof(rs.getBoolean("user_awareof"));
				return user;
				
			}
		});
	}
	
	public int updateUserReminder(User user){
		MapSqlParameterSource source=new MapSqlParameterSource();
		source.addValue("userid", user.getUserid());
		source.addValue("userisreminded", user.getReminded());
		return param.update("Update user set user_isReminded=:userisreminded where user_id=:userid",source);
	}

}
