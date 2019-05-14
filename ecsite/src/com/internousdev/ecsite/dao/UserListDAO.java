package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {

	DBConnector dbconnector=new DBConnector();
	Connection connection=dbconnector.getConnection();
	ArrayList<UserInfoDTO> userInfoDTO=new ArrayList<UserInfoDTO>();

	public ArrayList<UserInfoDTO> getUserInfo()throws SQLException{

		String sql="select * from login_user_transaction";

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();

			while(resultSet.next()){
				UserInfoDTO dto=new UserInfoDTO();
				dto.setLoginId(resultSet.getString("login_id"));
				dto.setLoginPass(resultSet.getString("login_pass"));
				dto.setUserName(resultSet.getString("user_name"));
				userInfoDTO.add(dto);
			}
			/* カーソルが次の行に項目があればwhile文の処理に進む。DBから習得した情報をdtoに格納した後、ArrayListに格納している。while文のためこの処理を繰り返す。 */

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return userInfoDTO;
	}

}
