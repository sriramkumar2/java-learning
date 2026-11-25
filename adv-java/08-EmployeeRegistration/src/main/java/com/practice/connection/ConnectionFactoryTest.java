package com.practice.connection;
import java.io.*;
import java.sql.*;
import java.sql.Connection;
public class ConnectionFactoryTest {
	public static void main(String[] args) throws IOException,SQLException{
		Connection con = ConnectionFactory.getConnection();
		if(con!=null) {
			System.out.println("Connection Established");
		}
		else {
			System.out.println("Connection Failed");
		}
		
	}
}
