package lambda;
/**
 * lambda表达式
 * lanbda是JDK8之后推出的一个特性，让我们可以以函数式编程
 * 
 * lambda可以更简单的完成匿名内部类创建
 * 
 * 语法规则
 * ([参数列表])->{
 * 方法体
 * }
 * 
 * 使用lambda创建的匿名内部类所属接口必须只能有一个抽象方法。
 * 否则无法使用。
 * @author zy
 *
 */
public class LambdaDemo1 {
	/*
	 * Runnable的创建
	 */
	Runnable r1 = new Runnable(){
		public void run(){
			System.out.println("Hello!");
		}
	};
	//lambda表达式
	Runnable r2 = ()->{
		System.out.println("Hello!");
	};
	/*
	 * 如果方法中只有一句代码，那么lambda中的"{}"可以省略
	 */
	Runnable r3 = ()-> System.out.println("Hello!");
}
