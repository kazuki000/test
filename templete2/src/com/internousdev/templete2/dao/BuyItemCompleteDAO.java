package com.internousdev.templete2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.templete2.util.DBConnector;
import com.internousdev.templete2.util.DateUtil;

public class BuyItemCompleteDAO {

	private DateUtil dateUtil=new DateUtil();

	private String sql="INSERT INTO user_buy_item_transaction(item_transaction_id, user_master_id, total_price, total_count, String pay) throws SQLException";

	public void buyItemInfo(String item_transaction_id, String user_master_id, String total_price, String total_count, String pay)throws SQLException{

		DBConnector dbconnector=new DBConnector();
		Connection connection=dbconnector.getConnection();

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, item_transaction_id);
			preparedStatement.setString(2, user_master_id);
			preparedStatement.setString(3, total_price);
			preparedStatement.setString(4, total_count);
			preparedStatement.setString(5, pay);
			preparedStatement.setString(6, dateUtil.getDate());

			preparedStatement.execute();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
		connection.close();
	}

}
}