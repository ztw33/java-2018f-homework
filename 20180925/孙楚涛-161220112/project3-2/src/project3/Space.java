package project3;

import java.util.ArrayList;
import java.util.List;

public class Space {
	public ObjPlace [][]space;
	
	public Creature<SupportCreature> oldguy = new Creature<SupportCreature>("O",Main.Constant.Osupportplacex,Main.Constant.Osupportplacey,SupportCreature.class);
	public Creature<SupportCreature> snake = new Creature<SupportCreature>("S",Main.Constant.Ssupportplacex,Main.Constant.Ssupportplacey,SupportCreature.class);
		
	public Creature<SpecialCreature> scorpion = new Creature<SpecialCreature>("J",Main.Constant.spacesize-1,Main.Constant.spacesize-1,SpecialCreature.class);
	public List<Creature<SpecialCreature>> huluwa = new ArrayList<Creature<SpecialCreature>>();
	
	public List<Creature<NormalCreature>> soldier = new ArrayList<Creature<NormalCreature>>();
	
	Space(){
		space = new ObjPlace[Main.Constant.spacesize][Main.Constant.spacesize];
		init();
		inithuluwa();
		soldier.clear();
	}
	
	void init()
	{
		for(int i = 0;i<Main.Constant.spacesize;++i)
			for(int j = 0;j<Main.Constant.spacesize;++j)
				space[i][j] = null;
		
		soldier.clear();
	}
	
	void inithuluwa()
	{
		huluwa.clear();
		for(int i = 1;i<=7;++i)
		{
			huluwa.add(new Creature<SpecialCreature>(String.valueOf(i),0,0,SpecialCreature.class));
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
