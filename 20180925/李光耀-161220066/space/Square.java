package space;


//一个小方块 可以用Square做成一个N*N空间
public class Square {
	private int x;
	private int y;
	private Object being;
	//private Image image; 
	
	public Square(int x,int y,Object creature) {
		this.x=x;
		this.y=y;
		this.being=creature;
		
	}
	
	public Square(){
		this.x=0;
		this.y=0;
		being=null;
		//image=null;
	}
	public int getX(){
		return x;
	}
	
	public int getY() {
		return y;
	}
	public Object getBeing(){
		return being;
	}
	public void setBeing(Object result){
		being=result;
	}
	
}
