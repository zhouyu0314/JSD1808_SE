package integer;
/*
 * JDK1.5推出时，推出了一个新的特性:自动拆装箱。
 * 该特性是编译器认可，而非虚拟机。编译器在编译源代码时
 * 发现基本类型和引用类型相互赋值时，会自动添加代码补全
 * 它们之间的转换操作。
 */
public class IntegerDemo2 {
	public static void main(String[] args) {

		/*
		 * 这里触发了编译器自动装箱特性:
		 * 编译器会补全代码，将基本类型转换为包装类，下面
		 * 的代码在编译后的class文件中为:
		 * Integer in = Integer.valueOf(d);
		 */
		Integer in = 213;
		/*
		 * 触发自动拆箱特性，编译器会改为:
		 * d = in.intValue();
		 */
		int d = in;
		System.out.println(in+1);
		System.out.println(d+1);
		
	}
}



