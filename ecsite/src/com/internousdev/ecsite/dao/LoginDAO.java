package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class LoginDAO {
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	private LoginDTO loginDTO=new LoginDTO();

	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){

		String sql="SELECT * FROM login_user_transaction WHERE login_id=? AND login_pass=?";
		/* login_user_transactionテーブルの全データからlogin_idとlogin_passを呼び出す*/

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,loginUserId);
			preparedStatement.setString(2,loginPassword);
			ResultSet resultSet=preparedStatement.executeQuery();
			/* sql文の？にLoginActionから送られてきた値をセットする。*/

			if(resultSet.next()){
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));
				loginDTO.setAdminFlg(resultSet.getString("admin_flg"));
				/* DBから習得した情報をString型に変換してLoginDTOに格納する。 */




				if(!(resultSet.getString("login_id").equals(null))){
					loginDTO.setLoginFlg(true);
				}
				/* DBから習得した情報で"login_id"の値が空っぽじゃなければ処理に進む。
				 * loginDTOに格納されているloginFlgの値をfalseからtrueに変更。*/

			}
			}catch(Exception e){
				e.printStackTrace();
			}
			return loginDTO;
		}
		/* 結果をActionクラスに返す。 */

		public LoginDTO getLoginDTO(){
			return loginDTO;
		}
	}


