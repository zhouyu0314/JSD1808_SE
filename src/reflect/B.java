package reflect;


public class B {
	@Test("m1")
	public void m1(){
		System.out.println("B's m1()");
	}
	public void m2(){
		System.out.println("B's m2()");
	}
	@Test(value="hello")
	public void hello(){
		System.out.println("B's hello()");
	}
}
