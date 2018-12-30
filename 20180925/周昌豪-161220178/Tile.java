package Battle;

public class Tile 
{
	private Creature standon;
	private boolean isempty;

	public Tile()
	{
		standon = null;
		isempty = true;
	}
	
	public boolean IsEmpty()
	{
		return isempty;
	}
	
	public boolean Set(Creature src)
	{
		if(true == isempty)
		{
			standon = src;
			isempty = false;
			return true;
		}
		else
			return false;
		
	}
	
	public boolean Clear()
	{
		standon = null;
		isempty = true;
		return true;
	}
	
	public void Print()
	{
		if(true == isempty)
			System.out.print(" _ ");
		else
		{
			System.out.print(" " + standon.OutPutInfo().substring(0, 1) + " ");
			//System.out.print(" " + standon.OutPutInfo() + " ");
		}
	}
}
