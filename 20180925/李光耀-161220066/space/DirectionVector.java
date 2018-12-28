package space;

/**
* @ClassName: DirectionVector
* @Description: 描述方向向量 用于定义上下左右
* @author 13745
* @date 2018年11月4日
*
*/
public class DirectionVector {
	private int x;
	private int y;
	public DirectionVector(int t1,int t2){
		x=t1;
		y=t2;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}
