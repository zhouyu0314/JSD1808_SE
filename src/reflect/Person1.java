package reflect;

public class Person1 {
	private String name = "李四";
	private int age = 30;
	public Person1(){
		
	}
	public Person1(String name,int age){
		this.name = name;
		this.age = age;
	}
	public void say(){
		System.out.println("我叫"+name+","+"今年"+age+"岁了");
	}

}
