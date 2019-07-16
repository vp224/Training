package com.visa.training.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.DatabaseMetaData;

public class ConnectionTest {
	public static void main(String[] args) throws SQLException {
		Connection c = JdbcUtil.getConnection();
		//get metadata from collection
		
		DatabaseMetaData metaData = c.getMetaData();// either try cath or main throws since compiler harassing
		System.out.println(metaData.getDatabaseProductName());
		System.out.println(metaData.getDatabaseProductVersion());
	}
}
