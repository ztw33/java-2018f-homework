package Battle;

public class Creature 
{
	protected String name;
	protected Position pos;
	
	public Creature()
	{
		name = null;
		pos = new Position();
	}
	
	String OutPutInfo()
	{
		return "Creature";
	}
	public String GetName()
	{
		return name;
	}
}

abstract class CreatureTeam
{
	protected Creature[] list;
	protected Creature cheerleader;
	
	protected abstract void GetRandomList();
	public abstract void SetRandomFormation(Field field);
}
