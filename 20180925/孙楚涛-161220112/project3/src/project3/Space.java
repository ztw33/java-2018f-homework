package project3;

public class Space {
	public ObjPlace [][]space;
	public SupportCreature oldguy = new SupportCreature("O",Main.Constant.Osupportplacex,Main.Constant.Osupportplacey);
	public SupportCreature snake = new SupportCreature("S",Main.Constant.Ssupportplacex,Main.Constant.Ssupportplacey);
		
	public SpecialCreature scorpion = new SpecialCreature("J",0,0);
	public SpecialCreature []huluwa = new SpecialCreature[7];
	
	public NormalCreature []soldier;
	
	Space(){
		space = new ObjPlace[Main.Constant.spacesize][Main.Constant.spacesize];
		init();
		inithuluwa();
	}
	
	void init()
	{
		for(int i = 0;i<Main.Constant.spacesize;++i)
			for(int j = 0;j<Main.Constant.spacesize;++j)
				space[i][j] = null;
	}
	
	void inithuluwa()
	{
		for(int i = 0;i<7;++i)
		{
			huluwa[i] = new SpecialCreature(String.valueOf(i+1),0,0);
		}
	}
	
	void show()
	{
		for(int j = 0;j<Main.Constant.spacesize;++j)
		{
			for(int i = 0;i<Main.Constant.spacesize;++i)
			{
					if(space[i][j] != null&&space[i][j].alive == 1)
					{
						System.out.print(space[i][j].name);
					}
					else
						System.out.print(" ");
			}
			System.out.println();
		}	
	}
	
}
