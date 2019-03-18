package person;

public class Test {

	public static void main(String[]args){

	Person taro=new Person();

	Robot aibo=new Robot();
	Robot asimo=new Robot();
	Robot pepper=new Robot();

	taro.name="鈴木花子";

	taro.age=16;

	aibo.name="鈴木花子";
	asimo.name="鈴木高";
	pepper.name="鈴木";




	System.out.println(taro.name);
	System.out.println(taro.age);

	taro.talk();
	taro.walk();

	aibo.talk();
	asimo.walk();
	pepper.run();

	}
}
