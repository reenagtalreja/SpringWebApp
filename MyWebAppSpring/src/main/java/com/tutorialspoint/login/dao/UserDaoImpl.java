package com.tutorialspoint.login.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tutorialspoint.login.beans.Login;
import com.tutorialspoint.login.beans.User;
@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	  DataSource datasource;

	  @Autowired
	  JdbcTemplate jdbcTemplate;
	@Override
	public void register(User user) {
		String sql = "insert into users values(?,?,?,?,?,?,?)";

	    jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
	        user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone() });
		
	}

	@Override
	public User validateUser(Login login) {
		String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
        + "'";
    //Check for ColumnMapRowMapper implementation 
    List<User> users = jdbcTemplate.query(sql, new UserMapper());

    return users.size() > 0 ? users.get(0) : null;
	}

}
