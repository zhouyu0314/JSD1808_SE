package thread;

public class ThreadLocalDemo {
	static ThreadLocal<Double> local = new ThreadLocal<Double>();

	public static void main(String[] args) {
		
		new Thread() {
			@Override
			public void run() {
				a();
				b();
				c();
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				a();
				b();
				c();
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				a();
				b();
				c();
			}
		}.start();

	}

	static void a() {
		String name = Thread.currentThread().getName();
		System.out.println(name +"  " + getData());
	}

	static void b() {
		String name = Thread.currentThread().getName();
		System.out.println(name +"  " + getData());
	}

	static void c() {
		String name = Thread.currentThread().getName();
		System.out.println(name +"  " + getData());
	}

	static double getData() {
		// 从当前线程获取绑定的数据
		Double d = local.get();
		if (d == null) {
			// 产生一个数据绑定到当前线程
			d = Math.random();
			local.set(d);
		}
		return d;
	}

	static void remove() {
		// 移除当前线程的数据
		local.remove();
	}

}
