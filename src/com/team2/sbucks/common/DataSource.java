package com.team2.sbucks.common;

import java.sql.Connection;

import java.sql.DriverManager;

public class DataSource {
	/***********************************************/
	private String driverClass = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
	private String user = "J2205JDEVELOPER#TEAM2";
	private String password = "J2205JDEVELOPER#TEAM2";
	/**********************************************/
	
	//Connection 객체를 생성해서 반환하는 메소드 
	public Connection getConnection() throws Exception{
		
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		return con;
	}
	
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
