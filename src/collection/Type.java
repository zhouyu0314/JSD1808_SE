package collection;
/**
 * 泛型
 * 泛型是JDK5推出的一个特性，又称为参数化类型。允许使用
 * 者在使用一个类的时候指定其定义的属性，方法的参数以及
 * 返回值的类型。这样可以使得程序使用更灵活。
 * @author ta
 *
 */
public class Type<T> {
	/*
	 * 实际上编译后，Type类型名后面没有<T>.
	 * 而:
	 * private T x;
	 * 会被改为
	 * private Object x;
	 */
	private T x;
	private T y;
	/*
	 * 参数也会改为:
	 * public Type(Object x, Object y) {
	 * 
	 * 下面的方法同理，返回值若是T，也会被改为Object。
	 */
	public Type(T x, T y) {
		super();
		this.x = x;
		this.y = y;
	}
	public T getX() {
		return x;
	}
	public void setX(T x) {
		this.x = x;
	}
	public T getY() {
		return y;
	}
	public void setY(T y) {
		this.y = y;
	}	
	public String toString() {
		return "("+x+","+y+")";
	}
	
	
}

