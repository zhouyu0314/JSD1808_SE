package collection;
/**
 * 作为集合元素测试集合相关方法
 */

public class Point {
	private int x;
	private int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}



	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public String toString(){
		return "("+x+","+y+")";
	}
	public boolean equals(Object obj){
		if(obj==null){
			return false;
		}
		if(obj==this){
			return true;
		}
		if(obj instanceof Point){
			Point p = (Point)obj;
			return  p.x==this.x&&p.y==this.y;
		}
		return false;
	}
	
	
	
	



	public static void main(String[] args) {

	}

}
