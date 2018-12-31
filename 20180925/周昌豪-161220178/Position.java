package Battle;

public class Position
{
	private int x;
	private int y;
	public Position(int y, int x) 
	{
		this.x = x;
		this.y = y;
	}
	public Position() 
	{
		x = -1;
		y = -1;
	}
	
	public void SetPos(int y, int x)
	{
		this.y = y;
		this.x = x;
	}
	
	public int x()
	{
		return x;
	}
	
	public int y()
	{
		return y;
	}
}