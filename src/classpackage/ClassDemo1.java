package classpackage;

public class ClassDemo1 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class cla = Class.forName("classpackage.Person");
		System.out.println(cla);
		//Person p1 = (Person)cla.newInstance();
		/*
		 * boolean isInstance(Object obj)
		 * 判断obj是否时当前类对象所表示的类的子类
		 */
		//System.out.println(cla.isInstance(new Boo()));
		
		/*
		 * boolean isAssignableFrom(Class<?> cls)
		 * 判断此类对象所表示的类是否时cls所表示的类的超类或者超接口
		 */
		//System.out.println(cla.isAssignableFrom(Boo.class));

		System.out.println(cla.getName());
		
		
		
	}
}
