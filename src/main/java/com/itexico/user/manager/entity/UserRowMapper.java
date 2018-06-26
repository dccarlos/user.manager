package com.itexico.user.manager.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

public class UserRowMapper implements RowMapper{
	public User mapRow(ResultSet row, int rowNum) throws SQLException{
		User user = new User();
		user.setId(1);
		user.setName("karina");
		user.setPassword(row.getString("password"));
		user.setCurp(row.getString("curp"));
		return user;
	}

	@Override
	public int[] getRowsForPaths(TreePath[] path) {
		// TODO Auto-generated method stub
		return null;
	}

}
