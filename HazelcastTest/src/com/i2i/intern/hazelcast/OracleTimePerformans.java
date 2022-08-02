package com.i2i.intern.hazelcast;

import java.sql.*;

public class OracleTimePerformans {

	public Connection connection(String username, String password) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:xe", username, password);

			return con;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public long createUsers(Connection conn) throws SQLException {

		String SQL = "INSERT INTO users(id,name) " + "VALUES(?,?)";
		Connection connection = conn;
		PreparedStatement statement ;
		
		long startTime = System.currentTimeMillis();
		
		
		try{
			statement = connection.prepareStatement(SQL);

			for (int i = 0; i < 20000; i++) {
				statement.setInt(1, i);
				statement.setString(2, "Veli");

				statement.executeUpdate();
				
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		long endTime = System.currentTimeMillis();

		return endTime - startTime;

	}

	public long getUsers(Connection conn) throws SQLException {


		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from users");

		long startTime = System.currentTimeMillis();

		while (rs.next()) {
			rs.getInt(1);
			rs.getString(2);
		}
		
		long endTime = System.currentTimeMillis();

		return endTime - startTime;
	}
	
	public String truncateUsersTable(Connection conn) {
		
		String SQL = "truncate table users";
		Connection connection = conn; 
		PreparedStatement statement;
		
		try {
			statement = connection.prepareStatement(SQL);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Users table truncated";
		
	}

	public void closeConnection(Connection conn) throws SQLException {
		conn.close();

	}
}
