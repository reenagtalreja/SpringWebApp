package com.tutorialspoint.login.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tutorialspoint.login.beans.User;

public class GenericMapper<T> implements RowMapper<T> {
	T t;

	GenericMapper(T o) {
		t = o;
	}

	public T mapRow(ResultSet rs, int arg1) throws SQLException {

		return t;
	}
}