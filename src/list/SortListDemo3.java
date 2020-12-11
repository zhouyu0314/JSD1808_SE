package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListDemo3 {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("医生");
		l.add("消防员");
		l.add("数学老师");
		l.add("体育老师和数学老师");
		Collections.sort(l);
		System.out.println(l);
		sortString(l);
		System.out.println(l);
		
		List<Point> l2 = new ArrayList<Point>();
		l2.add(new Point(2,3));
		l2.add(new Point(3,3));
		l2.add(new Point(5,6));
		l2.add(new Point(1,2));
		System.out.println(l2);
		sortPoint(l2);
		System.out.println(l2);
		/*
		 * 编译不通过。因为Collections的这个sort方法
		 * 要求集合元素必须实现Comparable接口。java提供
		 * 的常用数据类型，比如包装类，字符串等都实现了这个接口
		 * 并定义了比较规则，所以可以使用。但是我们定义的类Point
		 * 并没有实现该接口。
		 * 
		 * 
		 * 当我们定义的类，如：Point，它并没有实现Comparable
		 * 接口，若我们想使用该sort方法排序，就需要实现这个几口，
		 * 并重写其中的比较方法。但是这样做是不推荐的。因为这样做具有侵入性，
		 * 写程序时应当尽量避免侵入性这样利于程序的扩展和重构。
		 * 
		 * 所谓侵入性指的是：
		 * 当我们使用某个功能方法时，除了调用该功能方法的语句之外，
		 * 该功能方法要求我们为其额外的添加其他的代码比如这里要求Point类
		 * 实现接口并重写方法，那么这时该功能就对我们的程序具有侵入性。
		 */
//		Collections.sort(l2);
		

	}
	/**
	 * Collectins的重载sort方法，由于可以传入一个额外的比较规则，
	 * 所以这个sort方法不强制要求元素必须实现Comparable接口。
	 */
	public static void sortPoint(List<Point> l){
		Collections.sort(l,new Comparator<Point>(){

			public int compare(Point o1, Point o2) {
				
				return (o1.getX()*o1.getX()+o1.getY()*o1.getY())
						-(o2.getX()*o2.getX()+o2.getY()*o2.getY());
			}
		});
		
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * 利用Collections重载的sort方法，额外的传入一个比较规则
	 * （comparator比较器实现类）来对已经实现了Comparable
	 * 接口并定义了比较规则的元素按照我们定义的比较规则重新排序。
	 */
	public static void sortString(List<String> l){
		/*
		 * 定义额外比较规则
		 * 为字符串提供一种比较规则：字符少的小，字符多的大
		 */
		Collections.sort(l, new Comparator<String>(){
			/**
			 * 该方法时用来定义o1与o2比较大小的规则。
			 * 而返回值时一个int值，该值不关注具体值，值关注取值范围：
			 * 
			 * 当返回值>0时，表示o1大于o2
			 * 当返回值<0时，表示o1小于o2
			 * 当返回值=0时，两个对象相等
			 */
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
		});
		
	}

}
