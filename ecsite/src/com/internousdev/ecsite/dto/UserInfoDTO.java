package com.internousdev.ecsite.dto;

public class UserInfoDTO {

	private String loginId;
	private String loginPass;
	private String userName;

	public String getLoginId(){
		return loginId;
	}

	public void setLoginId(String loginId){
		this.loginId=loginId;
	}

	public String getLoginPass(){
		return loginPass;
	}

	public void setLoginPass(String loginPass){
		this.loginPass=loginPass;
	}

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName=userName;
	}
}
