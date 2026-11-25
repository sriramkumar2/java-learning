package com.practice.connection;
import java.util.Properties;
import java.io.InputStream;

import javax.sql.DataSource;

import java.io.FileInputStream;
import java.io.File;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.SQLException;
import java.sql.Connection;
import java.io.IOException;
public class ConnectionFactory {
	private static DataSource ds = null;
	public static Connection getConnection() throws SQLException,IOException {
		if(ds==null) {
		
//		FileInputStream fis = new FileInputStream(new File("src/main/resources/db.properties"));
			InputStream fis = ConnectionFactory.class
			        .getClassLoader()
			        .getResourceAsStream("db.properties");
		Properties ps = new Properties();
		ps.load(fis);
		
		HikariConfig hs=new HikariConfig();
		hs.setJdbcUrl(ps.getProperty("db.url"));
		hs.setUsername(ps.getProperty("db.username"));
		hs.setPassword(ps.getProperty("db.password"));
		hs.setDriverClassName(ps.getProperty("db.driver"));
		
		HikariDataSource hd = new HikariDataSource(hs);
		ds = hd;
	}
		return ds.getConnection();
	}
	
}
