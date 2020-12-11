package collection;
/**
 * 泛型常见面试题
 * @author zy
 *
 */

public class TypeDemo2 {
	public static void main(String[] args) {
		Type<Integer> t1 = new Type<Integer>(1,2);
		t1.setX(2);
		int x = t1.getX();
		System.out.println("x:"+x);
		
		//不指定则默认为原型Object
		Type t2 = t1;
		t2.setX("一");
		/*
		 * 这里会出现类造型异常
		 */
		x = t1.getX();
		System.out.println("x:"+x);
	}
}
