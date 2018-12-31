package huluwa;

public class where {
	
	private int x,y;
	private lives on;
	
	public where(int x,int y)
	{
		this.x=x;
		this.y=y;
		this.on=null;
		
	}
	
	public int getX() {return this.x;}
	public int getY() {return this.y;}
	public lives getLives() {return this.on;}
	
	public void newX(int x) {this.x=x;}
	public void newY(int y) {this.y=y;}
	
	public void set(lives one)
	{
		if(this.on!=null)
		{
			this.on.cleanPos();
		}
		this.on=one;
	}
	
	public void cleanOn()
	{
		if(this.on!=null)
			this.on.cleanPos();
		this.on=null;
	}
	
	
	public boolean isEmpty() {return this.on==null;}
	

}
