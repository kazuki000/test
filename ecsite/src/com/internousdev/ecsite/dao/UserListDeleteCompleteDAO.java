package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserListDeleteCompleteDAO {

	DBConnector dbconnector=new DBConnector();
	Connection connection=dbconnector.getConnection();

	public int delete()throws SQLException{


		int result=0;
		String sql="DELETE FROM login_user_transaction ";

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
