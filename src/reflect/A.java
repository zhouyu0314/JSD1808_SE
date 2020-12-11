package reflect;

public class A {
	public void f1(){
		System.out.println("a's f1()");
	}
	public String f2(){
		System.out.println("a's f2()");
		return "I am f2";
	}
	public String f3(String str,int num){
		System.out.println("A's f3()");
		return str + num;
	}
}
