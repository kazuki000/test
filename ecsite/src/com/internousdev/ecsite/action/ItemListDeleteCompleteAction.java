package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport{


	ItemListDeleteCompleteDAO itemListDeleteCompleteDAO=new ItemListDeleteCompleteDAO();
	public String execute()throws SQLException{

		String result=ERROR;

	int res=itemListDeleteCompleteDAO.delete();


	if(res>0){
		result=SUCCESS;
	}else if(res==0){
		result=ERROR;
	}
	/* 削除件数の確認 */

	return result;
	}




}




