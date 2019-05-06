package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;


public class ItemListDeleteCompleteDAO {

	int result=0;
	DBConnector dbconnector=new DBConnector();
	Connection connection=dbconnector.getConnection();

	public int delete()throws SQLException{

	String sql="DELETE FROM item_info_transaction";

	try{
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		result=preparedStatement.executeUpdate();
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		connection.close();
	}
	return result;


	}



}
