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
 
		
		oracleTimePerformans.createUsersTable(conn);

		
		
		System.out.println("Oracle create 20000 users time : "+oracleTimePerformans.insertTimePerformans(conn)+" ms");
		System.out.println("Oracle get 20000 users time : "+oracleTimePerformans.getUsersTimePerformans(conn)+" ms");

      
//		System.out.println(oracleTimePerformans.dropUsersTable(conn));
        
//		System.out.println(oracleTimePerformans.truncateUsersTable(conn));
		
		oracleTimePerformans.closeConnection(conn);
		

	}
}
