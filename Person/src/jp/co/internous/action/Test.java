package jp.co.internous.action;

public class Test {

	public static void main(String[]args){

	Person taro=new Person();

	taro.name="武田一輝";

	taro.age=25;

	taro.phoneNumber="090-1201-5523";

	taro.addless="tktk-0923@ezweb.ne.jp";


	Robot aibo=new Robot();

	aibo.name="田中";

	Robot asimo=new Robot();

	asimo.name="山田";

	Robot pepper=new Robot();

	pepper.name="高橋";



	System.out.println(taro.name);
	System.out.println(taro.age);
	System.out.println(taro.phoneNumber);
	System.out.println(taro.addless);

	taro.talk();
	taro.walk();

	aibo.talk();
	asimo.walk();
	pepper.run();


	}




}
