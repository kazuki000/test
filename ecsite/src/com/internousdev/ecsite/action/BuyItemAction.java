package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	private int count;
	private String pay;

	public String execute(){
		String result=SUCCESS;
		session.put("count",count);
		int intCount=Integer.parseInt(session.get("count").toString());
		int intPrice=Integer.parseInt(session.get("buyItem_price").toString());
		session.put("total_price",intCount * intPrice);
		String payment;
		if(pay.equals("1")){
			payment="現金払い";
			session.put("pay",payment);
		}else{
			payment="クレジットカード";
			session.put("pay",payment);
		}
		return result;
	}
	/* sessionでkeyを"count"にvalueをcountで記憶。
	 * sessionから"count"と"buyItem_price"を習得して一度String型に変換してからInt型に変換する。
	 * sessionでkeyを"toal_price",valueをintCount * intPriceで計算式を作る。
	 * if文でjspから送られてきた情報をもとに次のjspのページへと表示させる内容を記憶する。*/



        public void setCount(int count){
	    this.count=count;
       }

         public void setPay(String pay){
	     this.pay=pay;
       }

         @Override
         public void setSession(Map<String,Object>session){
        this.session=session;
      }

}







