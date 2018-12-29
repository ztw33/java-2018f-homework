package Battle;

public class Battle 
{
	private static Field field;
	private static CalabashBrotherTeam aCalabashBrotherTeam;
	private static MonsterTeam aMonsterTeam;
	
	public Battle()
	{
		field = new Field();
		aCalabashBrotherTeam = new CalabashBrotherTeam();
		aMonsterTeam = new MonsterTeam();
	}
	
	public void StartBattle()
	{
		aCalabashBrotherTeam.SetRandomFormation(field);
		aMonsterTeam.SetRandomFormation(field);
		field.PrintPlant();
	}
	
	public void ChangeFormation()
	{
		field.AllClear();
		aCalabashBrotherTeam.SetRandomFormation(field);
		aMonsterTeam.SetRandomFormation(field);
		field.PrintPlant();
	}
	
	public static void main(String args[]) throws InterruptedException 
	{
		Battle aBattle = new Battle();
		aBattle.StartBattle();
		Thread.sleep(3000);
		
		while(true)
		{
			aBattle.ChangeFormation();
			Thread.sleep(3000);
		}
	}
}
