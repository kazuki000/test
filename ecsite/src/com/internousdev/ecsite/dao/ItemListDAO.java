package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;


public class ItemListDAO {

	ArrayList<ItemInfoDTO> itemInfoDTO=new ArrayList<ItemInfoDTO>();

	DBConnector dbconnector=new DBConnector();
	Connection connection=dbconnector.getConnection();

	public ArrayList<ItemInfoDTO> getItemInfo() throws SQLException{

	String sql="SELECT * FROM item_info_transaction ";

	try{
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		ResultSet resultSet=preparedStatement.executeQuery();

		while(resultSet.next()){
			ItemInfoDTO dto=new ItemInfoDTO();
			dto.setItemName(resultSet.getString("item_name"));
			dto.setItemPrice(resultSet.getString("item_price"));
			dto.setItemStock(resultSet.getString("item_stock"));
			itemInfoDTO.add(dto);
		}
		/* カーソルが次の行に項目があればwhile文の処理に進む。DBから習得した情報をdtoに格納した後、ArrayListに格納している。while文のためこの処理を繰り返す。 */


	}catch(Exception e){
		e.printStackTrace();
	}finally{
		connection.close();
	}
	return itemInfoDTO;


	}
}
