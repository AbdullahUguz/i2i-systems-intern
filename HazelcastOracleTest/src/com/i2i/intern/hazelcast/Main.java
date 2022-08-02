package com.i2i.intern.hazelcast;

import java.sql.Connection;
import java.sql.SQLException;


public class Main {
	public static void main(String[] args) throws SQLException {

		HazelcastTimePerformans hazelcastTimePerformans = new HazelcastTimePerformans();
		hazelcastTimePerformans.hazelcastOperation();
		
		
		System.out.println("------------------------------------------------");
		
		OracleTimePerformans oracleTimePerformans =new OracleTimePerformans();
		
		Connection conn = oracleTimePerformans.connection("system","oracle");
		
		System.out.println("Oracle create 20000 users time : "+oracleTimePerformans.createUsers(conn)+" ms"); //oracleTimePerformans.createUsers(conn);
		System.out.println("Oracle get 20000 users time : "+oracleTimePerformans.getUsers(conn)+" ms");        //oracleTimePerformans.getUsers(conn);
		
		
//		String message = oracleTimePerformans.truncateUsersTable(conn);
//		System.out.println(message);
		
		oracleTimePerformans.closeConnection(conn);
		

	}
}
