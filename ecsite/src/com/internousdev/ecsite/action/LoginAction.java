package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	public Map<String,Object>session;
	private LoginDAO loginDAO=new LoginDAO();
	private LoginDTO loginDTO=new LoginDTO();
	private BuyItemDAO buyItemDAO=new BuyItemDAO();

	public String execute(){
		String result=ERROR;
		loginDTO=loginDAO.getLoginUserInfo(loginUserId,loginPassword);
		session.put("loginUser",loginDTO);
		/* loginDAOのメソッドを呼び出してその結果をloginDTO代入して、sessionでkeyを"loginUser" valueをloginDTOとして記憶する。*/

		boolean loginFlg=((LoginDTO)session.get("loginUser")).getLoginFlg();
		String adminFlg = ((LoginDTO)session.get("loginUser")).getAdminFlg();
		/* 先ほど上記の文で記憶したsessionからkeyの"loginUser"に格納されているgetLoginFlgとgetAdminFlgを呼び出す。
		 * sessionから値を取り出すとObjectクラスになるためLoginDTOクラスに変換しその結果をloginFlgとadminFlgに代入する。*/

		if(loginFlg){
			if(adminFlg != null && adminFlg.equals("1")){
				result="admin";
			} else {
				result=SUCCESS;
				BuyItemDTO buyItemDTO=buyItemDAO.getBuyItemInfo();

				session.put("login_user_id",loginDTO.getLoginId());
				session.put("id",buyItemDTO.getId());
				session.put("buyItem_name",buyItemDTO.getItemName());
				session.put("buyItem_price",buyItemDTO.getItemPrice());
			}
			return result;
		}
		/* if文でloginFlgがtrueであれば処理に進み、adminFlgが空っぽでなければかつ、adminFlgの値が1であればadmin.jsp(管理者画面)に進む。
		 * それ以外であればitem.jsp(商品情報画面)に進む。次の画面で商品情報が必要なためsession.putで商品情報を記憶しておく。*/



		return result;
	}
	/* 結果をresultに返す、呼び出されたstrutsで結果に応じたページへと遷移する。 */

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


	public void setSession(Map<String,Object>session){
		this.session=session;
	}
	/* このメソッドはオーバーライドされていること */



}
