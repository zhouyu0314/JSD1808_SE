package thread;



public class SyncDemo6 {
	public static void main(String[] args) {
		R1 r1 = new R1();
		R1 r2 = new R1();
		Thread t1 = new Thread(r1);
		t1.start();
		
		while(true){
			//int i = r1.get();
			int i = r2.get();
			if(i%2 == 1){
				System.out.println(i);
				System.exit(0);
			}
		}
	}
}
 class R1 implements Runnable{
	 static int i;
	 /**
	  * public synchronized void add()抢当前实例的锁(this)
	  * 
	  * public static synchronized void add() 抢的是类对象的锁
	  * 
	  */
	 public static synchronized void add(){
		 i++;
		 i++;
	 }
	 
	 public static synchronized int get(){
		 return i;
	 }
	@Override
	public void run() {
		while (true) {
			add();
			
		}
		
	}
	
}

