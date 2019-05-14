package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	private BuyItemDTO buyItemDTO=new BuyItemDTO();

	public BuyItemDTO getBuyItemInfo(){
		String sql="SELECT id, item_name, item_price FROM item_info_transaction";
		/* item_info_transactionテーブルから商品情報を全て習得。 */

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			/* sql文の実行 */

		   if(resultSet.next()){
			   buyItemDTO.setId(resultSet.getInt("id"));
			   buyItemDTO.setItemName(resultSet.getString("item_name"));
			   buyItemDTO.setItemPrice(resultSet.getString("item_price"));
		   }
		   /* DBから習得した情報をIntとString型に変換して、その値をDTOクラスにセットする。 */

		}catch(Exception e){
			e.printStackTrace();
		   }/* 処理中にエラーが発生した際に実行する処理です。 */

		return buyItemDTO;
		}
		/* Actionクラスに結果を返す。 */

	public BuyItemDTO getBuyItemDTO(){
		return buyItemDTO;
	}

}
