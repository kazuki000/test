package jp.co.internous.action;

public class Person {

	public String name=null;

	private int age=0;


	public Person(String name,int age){

		this.name=name;

		this.age=age;

	}

	public int getAge(){

		return this.age;
	}

	public void setAge(int age){

		this.age=age;

	}
}