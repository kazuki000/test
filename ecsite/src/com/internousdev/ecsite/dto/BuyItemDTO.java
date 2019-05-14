package com.internousdev.ecsite.dto;

public class BuyItemDTO {

	public int id;
	public String itemName;
	public String itemPrice;
	/* テーブルから習得するデータに対応したフィールド変数を宣言します。*/
	

	public String getItemName(){
		return itemName;
	}
	/* Actionクラスから呼び出されてフィールドの値をActionクラスに渡す。 */

	public void setItemName(String itemName){
		this.itemName=itemName;
	}
	/* DAOクラスから呼び出されてフィールドの値を引数として受け取ったテーブルの値を自信の値の格納します。 */

	public String getItemPrice(){
		return itemPrice;
	}

	public void setItemPrice(String itemPrice){
		this.itemPrice=itemPrice;
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id=id;
	}

}
