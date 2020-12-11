package string;
/**
 * StringBuilder修改字符串内容的性能
 * @author ta
 *
 */
public class StringBuilderDemo2 {
	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder("a");
		for(int i=0;i<10000000;i++) {
			builder.append("a");
		}
		System.out.println("执行完毕!");
	}
}
