package Battle;

public class Field 
{
	private Tile[][] plant;
	
	public static final int PlantSize = 10;
	
	/*Field构造器,对每个位置new一个Tile*/
	public Field()
	{
		plant = new Tile[PlantSize][PlantSize];
		for(int i = 0;i < PlantSize;i++)
			for(int j = 0;j < PlantSize;j++)
				plant[i][j] = new Tile();
	}

	/*在plant[i][j]安放Creature*/
	public boolean Set(Creature creature, int x, int y)
	{
		if(true == plant[x][y].IsEmpty())
		{
			plant[x][y].Set(creature);
			return true;
		}
		else
			return false;
	}
	
	/*清空plant，整个平台*/
	public void AllClear()
	{
		for(int i = 0;i < PlantSize; i++)
			for(int j = 0; j < PlantSize; j++)
				plant[i][j].Clear();
	}
	
	/*打印平台*/
	public void PrintPlant()
	{
		System.out.println("");
		for(int i = 0;i < PlantSize;i++)
		{
			for(int j = 0;j < PlantSize;j++)
			{
				plant[i][j].Print();
			}
			System.out.println();
		}
	}
}
