package space;

import creature.Being;

//一个小方块 可以用Square做成一个N*N空间
/**
* @ClassName: Square
* @Description: 描述组成棋盘的一个基本单元
* @author 13745
* @date 2018年11月4日
*
*/
public class Square<T extends Being> {
	private int x;
	private int y;
	private T being;
	
	public Square(int x,int y,T being) {
		this.x=x;
		this.y=y;
		this.being=being;
		
	}
	
	public Square(){
		this.x=0;
		this.y=0;
		being=null;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY() {
		return y;
	}
	public T getBeing(){
		return being;
	}
	public void setBeing(T result){
		being=result;
	}
	
}
