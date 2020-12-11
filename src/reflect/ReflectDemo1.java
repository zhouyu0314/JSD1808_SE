package reflect;
/**
 * java的反射机制
 * 
 * 反射允许我们在实例化一个类，操作其属性和方法从编码器决定
 * 转为在运行期决定。
 * 这样做可以提高代码的灵活度。适度使用。过度使用会降低代码的
 * 运行效率，增加资源开销。
 * @author zy
 *
 */
public class ReflectDemo1 {
	public static void main(String[] args) {
		/*
		 * Class类
		 * Class类的每个实例用于表示JVM加载的一个类。并且
		 * 在JVM内部每个被加载的类有且只有一个Class的实例
		 * 与之对应。
		 * 
		 * 获取一个类的类对象有一下几种方式：
		 * 1：直接调用该类的静态属性class。
		 * 例如：
		 * Class cls = String.class;
		 * 但是这样做是在编码期间确定后去某个类的类对象
		 * 相对不灵活。
		 * 2：调用Class的静态方法forName
		 * 例如：
		 * Class cls = Class.forName("java.lang.String");
		 * 
		 * 3：通过类加载器ClassLoader
		 */
		/*
		 * 加载Person类
		 * Class.forName中指定的参数为要加载的类的完全限定名
		 * 即：
		 * 包名.类名
		 */
		try {
			/*
			 * 若指定的类完全限定名有误，会抛出异常：
			 * ClassNotFoundException
			 */
			Class cls = Class.forName("reflect.Person");
			System.out.println(cls.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
