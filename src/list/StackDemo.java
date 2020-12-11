package list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈
 * 栈也可以保存一组元素，存取必须遵循先进后出原则
 * 
 * 使用栈一般是为了实现如"后退"这样的功能
 * @author zy
 *
 */

public class StackDemo {
	public static void main(String[] args) {
		Deque<String> stack = new LinkedList<String>();
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");
		stack.push("five");
		System.out.println(stack);
		//System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack);
	}
}
