package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class UserListAction extends ActionSupport{

	ArrayList<UserInfoDTO> userInfoDTO=new ArrayList<UserInfoDTO>();

	public String execute()throws SQLException{

		String result=ERROR;

		UserListDAO userListDAO=new UserListDAO();

		userInfoDTO=userListDAO.getUserInfo();

		if(userInfoDTO.size()>0){
			result=SUCCESS;
		}else{
			result=ERROR;
		}
		/* ユーザー情報の有無の確認 */
		return result;
	}

	public ArrayList<UserInfoDTO> getUserInfoDTO(){
		return userInfoDTO;
	}

	public void setUserInfoDTO(ArrayList<UserInfoDTO>userInfoDTO){
		this.userInfoDTO=userInfoDTO;
	}


}
