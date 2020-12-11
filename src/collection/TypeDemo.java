package collection;

public class TypeDemo {
	public static void main(String[] args) {
		/*
		 * 使用时指定泛型的实际类型，需要注意，泛型的实际类型
		 * 必须是引用类型，不可以用基本类型。
		 * 
		 * 泛型是编译器认可，而不是虚拟机认可。泛型的原型就是Object。
		 * 也就是说，在编译Type这个类时，x,y的类型就是Object，
		 * 所有泛型参数和返回值都会被改回Object
		 * 
		 * 
		 * 那么这里使用时，编译器也会将泛型删除，下面实例化Type的过程
		 * 会被编译器改为：
		 * Type t1 = new Type(1,2);
		 * 但是由于Type的构造方法要求参数符合泛型要求所以编译器会在编译时
		 * 检查实际参数是否符合要求
		 * 不符合时编译不通过。
		 * 由于构造方法中的实参1，2都是整数，符合这里t1指定的泛型Integer
		 * 那么编译通过。
		 */
		Type<Integer> t1 = new Type<Integer>(1,2);
		//编译不通过，实参不符合泛型要求。
//		Type<Integer> t1 = new Type<Integer>("1","2");
		
		/*
		 * 当获取以泛型定义的返回值类型数据时，编译器会自动补充造型代码，
		 * 将返回值造型为泛型所指定的实际类型。
		 * 下面的代码会被编译器改为：
		 * int x1 = (Integer)t1.getX();
		 * 当然这里还会触发自动拆箱，改为：
		 * int x1 = ((Integer)t1.getX()).intValue();
		 */
		int x1 = t1.getX();
		System.out.println("x1:"+x1);
		System.out.println("t1:"+t1);
		
		Type<Double> t2 = new Type<Double>(1.1,2.2);
		double x2 = t2.getX();
		System.out.println("x2:"+x2);
		System.out.println("t2:"+t2);
		
		Type<String> t3 = new Type<String>("一","二");
		String str = t3.getX();
		System.out.println("x3:"+str);
		System.out.println("t3:"+t3);
	}

}
