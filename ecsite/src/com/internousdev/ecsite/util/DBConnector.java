package com.internousdev.ecsite.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static String driverName="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost/ecsite";
	private static String user="root";
	private static String password="mysql";
	/* MySQLに必要な情報を設定します。*/

	public Connection getConnection(){
		Connection con=null;

	try{
		Class.forName(driverName);
		con=(Connection)DriverManager.getConnection(url,user,password);
		/* 自分の接続情報から自分のパソコンにインストールされているMySQLへの接続準備を整える */

	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}

	return con;
	}

}
