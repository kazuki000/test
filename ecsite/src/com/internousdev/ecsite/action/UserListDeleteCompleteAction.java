package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport{

	UserListDeleteCompleteDAO userListDeleteCompleteDAO=new UserListDeleteCompleteDAO();

	public String execute()throws SQLException{

		String result=ERROR;

		int res=userListDeleteCompleteDAO.delete();

		if(res>0){
			result=SUCCESS;
		}else if(res==0){
			result=ERROR;
		}
		/* 削除情報の有無の確認 */
		return result;
	}

}
