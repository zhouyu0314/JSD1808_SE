package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
	public static final int GJ = 3;
	public static final int MJ = 5;
	public static final int XJ = 1;
	public static final int MONEY = 100;

	private void cal() {
		int times = 0;
		List<String> list = new ArrayList<String>();
		Random rand = new Random();

		/*
		 * 公鸡数量 x; 母鸡数量 y; 小鸡数量 z
		 * 
		 * x + y + z = 100 3x + 5y + （z/3） = 100
		 */
		do {
			int x = rand.nextInt(34);
			int y = rand.nextInt(21);
			int z = rand.nextInt(301);
			if (!list.contains(x + "" + y + z)) {
				if ((x + y + z) == 100 && (x * 3 + y * 5 + z / 3) == 100 && z % 3 == 0) {
					times++;
					list.add(x + "" + y + z);
					System.out.println("有" + times + "种买法x=" + x + " " + "y=" + y + " " + "z=" + z);
				}
			}
		} while (true);

	}

	public static void main(String[] args) {
		Test t = new Test();
		t.cal();
	}
}
