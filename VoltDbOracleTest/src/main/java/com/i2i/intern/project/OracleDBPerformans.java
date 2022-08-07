package com.i2i.intern.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class OracleDBPerformans {
	private Random rand = new Random();

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

	public void createSubscribersTable(Connection conn) throws SQLException {

		String SQL = "CREATE TABLE Subscribers "
				+ "(telNo varchar(15), packageName varchar(35), usage int, remainingUsage int)";
		Connection connection = conn;
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(SQL);
			statement.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public long insertSubscribersTime(Connection conn, String[] numbers, String[] packets) throws SQLException {

		String SQL = "INSERT INTO SUBSCRIBERS(telNo,packageName,usage,remainingUsage)" + "VALUES(?,?,?,?)";
		Connection connection = conn;
		PreparedStatement statement;

		long startTime = System.currentTimeMillis();

		try {
			statement = connection.prepareStatement(SQL);

			for (int i = 0; i < 20000; i++) {
				int usage = rand.nextInt(1000);
				int remainingUsage = 1200 - usage;

				statement.setString(1, numbers[rand.nextInt(20000)]);
				statement.setString(2, packets[rand.nextInt(6)]);
				statement.setInt(3, usage);
				statement.setInt(4, remainingUsage);

				statement.executeUpdate();

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		long endTime = System.currentTimeMillis();

		return endTime - startTime;

	}

	public long getSubscribersTime(Connection conn) throws SQLException {

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from SUBSCRIBERS");

		long startTime = System.currentTimeMillis();

		while (rs.next()) {
			rs.getString(1);
		}

		long endTime = System.currentTimeMillis();

		return endTime - startTime;
	}

	public String truncateSubscribersTable(Connection conn) {

		String SQL = "truncate table SUBSCRIBERS";
		Connection connection = conn;
		PreparedStatement statement;

		try {
			statement = connection.prepareStatement(SQL);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "Subscribers Table Truncated";

	}

	public String dropSubscribersTable(Connection conn) throws SQLException {

		String SQL = "Drop Table SUBSCRIBERS";
		Connection connection = conn;
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(SQL);
			statement.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return "Subscribers Table Dropped";

	}

	public void closeConnection(Connection conn) throws SQLException {
		conn.close();

	}
}
