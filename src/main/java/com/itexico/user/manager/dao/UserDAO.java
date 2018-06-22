package com.itexico.user.manager.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itexico.user.manager.entity.User;

@Transactional
@Repository
public class UserDAO implements IUserDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User getUserById(int id) {
		String sql = "SELECT name, password, curp FROM user WHERE id=?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);		
		User user= jdbcTemplate.queryForObject(sql, rowMapper, id);
		return user;	
	}	
	
	@Override
	public List<User> getAllUser() {
		String sql = "SELECT name, password, curp FROM user";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);		
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	@Override
	public User addUser(User user) {
		String sql = "INSERT INTO user(id, name, password, curp) values (?, ?, ?, ?)";
		jdbcTemplate.update(sql, user.getId(), user.getName(), user.getPassword(), user.getCurp());
		sql = "SELECT id FROM user WHERE name= ? and password=?";
	    int userId = jdbcTemplate.queryForObject(sql, Integer.class, user.getName(), user.getPassword());
	    user.setId(userId);
		return user;
	}
	
	@Override
	public User updateUser(User user) {
		String sql = "UPDATE user SET name=?, password=?, curp=? WHERE id=?";
		jdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getCurp(), user.getId());
		return user;
		}
	public Integer deleteUser(int id) {
		String sql = "DELETE FROM user WHERE id=?";
		jdbcTemplate.update(sql, id);
		return id;
	}
	@Override
	public boolean userExists(String user, String password) {
		String sql = "SELECT count(*) FROM user WHERE name= ? and password=?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, user, password);
		if(count == 0) {
    		return false;
		} else {
			return true;
		}
	}
	
}
