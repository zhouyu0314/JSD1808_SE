package exception;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 子类在重写超类含有throws声明异常抛出的方法时的一些重写规则
 * @author zy
 *
 */

public class ThrowsDemo {

	public void dosome()throws IOException,AWTException{
		
	}

}

class Son extends ThrowsDemo{
	//public void dosome()throws IOException,AWTException{
	//	
	//}
	//允许仅抛出部分异常
	//public void dosome()throws IOException{
	//	
	//}
	//允许抛出父类方法抛出异常的子类型异常
	//public void dosome()throws FileNotFoundException{
	//	
	//}
	//不允许抛出额外异常
	//public void dosome()throws SQLException{
	//	
	//}
	//不允许抛出父类抛出异常的父类型异常
	//public void dosome()throws Exception{
	//	
	//}
	
}
