package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
    private String userName;
    public Map<String,Object>session;
    private String errorMessage;

    public String execute(){

    	String result=SUCCESS;

    	if(!(loginUserId.equals(""))
    		&& !(loginPassword.equals(""))
    		&& !(userName.equals(""))){
    		   session.put("loginUserId",loginUserId);
    		   session.put("loginPassword",loginPassword);
    		   session.put("userName",userName);
    	}else{
    		setErrorMessage("未入力の項目があります。");
    		result=ERROR;
    	}
    	/* 未入力項目が有無の確認をしています
    	 * 未入力項目があればelse処理に進みエラーメッセージを表示させる。
    	 * sessionで入力情報を記憶させる。 */

    	return result;
    }

    public String getLoginUserId(){
    	return loginUserId;
    }

    public void setLoginUserId(String loginUserId){
    	this.loginUserId=loginUserId;
    }

    public String getLoginPassword(){
    	return loginPassword;
    }

    public void setLoginPassword(String loginPassword){
    	this.loginPassword=loginPassword;
    }

    public String getUserName(){
    	return userName;
    }

    public void setUserName(String userName){
    	this.userName=userName;
    }

    @Override
    public void setSession(Map<String,Object>session){
    	this.session=session;
    }

    public String getErrorMessage(){
    	return errorMessage;
    }

    public void setErrorMessage(String errorMessage){
    	this.errorMessage=errorMessage;






    }
}