package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO {

	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();

	public ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id, String user_master_id)throws SQLException{
		ArrayList<MyPageDTO> myPageDTO=new ArrayList<MyPageDTO>();
		String sql="SELECT ubit.id, iit.item_name, ubit.total_price, ubit.total_count, ubit.pay, ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id = iit.id WHERE ubit.item_transaction_id = ? AND ubit.user_master_id = ? ORDER BY insert_date DESC";
		/* 2つのテーブルを結合させることによって、ユーザー情報と履歴情報を紐づけて情報を一括習得出来るようにする。
		 * ubit,iitと名前を付けて情報ごとの紐づけ、条件はubim.item_transaction_idとiit.idが等しい情報
		 * LEFT JOINで外部接続を行い、ubit.item_transaction_idとubit.user_master_idを呼び出す。
		 * その後データを昇降順に並べる。*/


		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,item_transaction_id);
			preparedStatement.setString(2,user_master_id);
			/*  Actionクラスのsessionで習得した値を因数として送られてきた値を入力する。*/

			ResultSet resultSet=preparedStatement.executeQuery();

			while(resultSet.next()){
				MyPageDTO dto=new MyPageDTO();
				dto.setId(resultSet.getString("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setTotalPrice(resultSet.getString("total_price"));
				dto.setTotalCount(resultSet.getString("total_count"));
				dto.setPayment(resultSet.getString("pay"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				myPageDTO.add(dto);
			}
			/* while文で繰り返しDBから習得した情報をdtoクラスに格納し、格納した情報をmyPageDTO.addメソッドで順番に記憶していく。 */

			}catch(Exception e){
				e.printStackTrace();
			}finally{
				connection.close();
			}
			return myPageDTO;
			/* 結果を呼び出し元のActionクラスに返す。 */


		}

		public int buyItemHistoryDelete(String item_transaction_id, String user_master_id)throws SQLException{

			String sql="DELETE FROM user_buy_item_transaction WHERE item_transaction_id=? AND user_master_id=?";
			/* 削除文 */

			PreparedStatement preparedStatement;
			int result=0;
			/* 変数resultをint型で宣言 */
			try{
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setString(1,item_transaction_id);
				preparedStatement.setString(2,user_master_id);
				result=preparedStatement.executeUpdate();
				/* 結果をint型の変数resultへ代入 */

			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				connection.close();
			}
			/* DBとの接続を切る */
			return result;
			/* Actionクラスに削除した件数を返します。 */

		}

	}


