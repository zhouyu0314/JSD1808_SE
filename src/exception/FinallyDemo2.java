package exception;

import java.io.FileOutputStream;

/**
 * 在IO操作中使用异常处理机制
 * @author zy
 *
 */

public class FinallyDemo2 {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		try{

			fos = new FileOutputStream("fos.dat");
			fos.write(97);
		}catch(Exception e){
			System.out.println("报错了");
		}finally{
			try{
				if(fos != null){
					fos.close();
				}

			}catch(Exception e){
				e.printStackTrace();
			}

		}
		

	}

}
