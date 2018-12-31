
public class Position {
	private int x;
	private int y;
	private boolean isEmpty;
	private Object obj; //位置上放置的物体
	
	Position(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	void showObjShape()
	{
		if(isEmpty)
			System.out.print("   ");
		else
			System.out.print(obj.toString());	//多态
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


	public boolean isEmpty() {
		return isEmpty;
	}


	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	
	public Object getObj() {
		return obj;
	}
	

	public void setObj(Object obj) {
		this.obj = obj;
		isEmpty=false;
	}
	
	public void popObj() {
		obj=null;
		isEmpty=true;
	}
	
}
