package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	private MyPageDAO myPageDAO=new MyPageDAO();
	private ArrayList<MyPageDTO> myPageList=new ArrayList<MyPageDTO>();
	private String deleteFlg;
	private String message;

	public String execute()throws SQLException{
		if(!session.containsKey("login_user_id")){
			return ERROR;
		}
		/* session.contaninskeyで"login_user_id"に値が入っていなければEROORに*/

		if(deleteFlg==null){
			String item_transaction_id=session.get("id").toString();
			String user_master_id=session.get("login_user_id").toString();
			myPageList=myPageDAO.getMyPageUserInfo(item_transaction_id, user_master_id);
			if (myPageList.size() <= 0) {
				myPageList = null;
			}/* 履歴の削除がされているか否か、チェックしています。
				DBから習得した情報をmyPageListに格納しています。
				if文でmypageListでnullを代入してnullを空っぽではなくなるようにする。 */


		}else if(deleteFlg.equals("1")){
			delete();
		}
		/*deleteメソッドを呼び出して、履歴の削除を行う。*/

		String result=SUCCESS;
		return result;
	}

	public void delete()throws SQLException{
		/* 履歴の削除を行うためのメソッド */

		String item_transaction_id=session.get("id").toString();
		String user_master_id=session.get("login_user_id").toString();

		int res=myPageDAO.buyItemHistoryDelete(item_transaction_id, user_master_id);
		/* DBから削除した情報の件数を変数resに格納しています。 */

		if(res>0){
			myPageList=null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res==0){
			setMessage("商品情報の削除に失敗しました。");

		}
		/* 1件以上登録されたか否かで正常に削除されたか判別しています。 */
	}

	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg=deleteFlg;
	}

	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}

	public ArrayList<MyPageDTO>getMyPageList(){
		return this.myPageList;
	}

	public String getMessage(){
		return this.message;
	}

	public void setMessage(String message){
		this.message=message;
	}
}