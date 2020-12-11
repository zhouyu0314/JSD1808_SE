package collection;

import java.util.ArrayList;
import java.util.Collection;

public class Demo {

	public static void main(String[] args) {
		int a = 1;
		String b = "hello";
		Point p = new Point(1,2);
		Collection c = new ArrayList();
		c.add(p);
		test(a,b,p,c);
		System.out.println("a:"+a);
		System.out.println("b:"+b);
		System.out.println("p:"+p);
		System.out.println("c:"+c);
		
	}
	public static void test(int a,String b,Point p,Collection c){
		a = 2;
		b = b+"World!";
		p.setX(a);
		c.clear();
		p = new Point(3,4);
		c.add(p);
		p.setX(5);
		c = new ArrayList();
		p = new Point(6,7);
		c.add(p);
	}

}
