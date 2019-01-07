package work3_huluwa;

public class Point {
	private int x;
	private int y;
	private Creature placeholder;
	
	public void set_x(int px)
	{
		this.x = px;
	}
	public void set_y(int py)
	{
		this.y = py;
	}
	
	public Point(int a, int b){
		super();
		this.x = a;
		this.y = b;
	}
	public Point(int a, int b,Creature holder){
		super();
		this.x = a;
		this.y = b;
		this.placeholder = holder;
	}
	public Creature get_placeholder(){
		return  this.placeholder;
	}
	public void set_placeholder( Creature holder){
		this.placeholder = holder;
	}
	public int get_x()
	{
		return x;
	}
	public int get_y()
	{
		return y;
	}


}
