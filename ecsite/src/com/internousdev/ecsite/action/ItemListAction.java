package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport{

	ArrayList<ItemInfoDTO> itemInfoDTO=new ArrayList<ItemInfoDTO>();

	public String execute() throws SQLException{

		String result=ERROR;

		ItemListDAO itemListDAO=new ItemListDAO();

		itemInfoDTO=itemListDAO.getItemInfo();

		if(itemInfoDTO.size()>0){
			result=SUCCESS;
		}else{
			result=ERROR;
		}
		/* アイテム情報が入っているか否かの確認 */

		return result;




	}

	public ArrayList<ItemInfoDTO> getItemInfoDTO(){
		return itemInfoDTO;
	}

	public void setItemInfoDTO(ArrayList<ItemInfoDTO> itemInfoDTO){
		this.itemInfoDTO=itemInfoDTO;
	}

}
