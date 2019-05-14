package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;

	public String execute(){
		String result="login";
		if(session.containsKey("login_user_id")){
			BuyItemDAO buyItemDAO=new BuyItemDAO();
			BuyItemDTO buyItemDTO=buyItemDAO.getBuyItemInfo();
			session.put("id",buyItemDTO.getId());
			session.put("buyItem_name",buyItemDTO.getItemName());
			session.put("buyItem_price",buyItemDTO.getItemPrice());

			result=SUCCESS;
			/* ログイン済み判定を行い、一度ログインしている場合はログイン認証画面に遷移させずに、商品画面に進む
			 * 商品画面に進んだときは次のページで商品情報も必要なためsessionで値を記憶しておく。*/
		}
		return result;
		/* 結果をresultへ。 */
	}

	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;

	}
	/* オーバーライドしているメソッドということを示す。 */

	public Map<String,Object>getSession(){
		return this.session;
	}

}
