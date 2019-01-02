package project3;

public class Formation {
	public static void showformation1()
	{
		Main.space.init();
		showformation4();
		
		Main.space.scorpion.move(15, 7);	
		
		for(int i = 0;i<3;++i)
		{
			Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
			Main.space.soldier.get(i).move(12+i, 4+i);
		}
		
		for(int i = 3;i<6;++i)
		{
			Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
			Main.space.soldier.get(i).move(13+i, 9-i);
		}
		
		Main.space.show();
	}
	
	public static void showformation2()
	{
		Main.space.init();
		showformation4();
		
		Main.space.scorpion.move(15, 5);
		
		for(int i = 0;i<3;++i)
		{
			Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
			Main.space.soldier.get(i).move(12+i, 8-i);
		}
		for(int i = 3;i<6;++i)
		{
			Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
			Main.space.soldier.get(i).move(13+i, 7-i);
		}
		
		Main.space.show();
	}
	
	public static void showformation3()
	{
		Main.space.init();
		showformation4();
		
		Main.space.scorpion.move(15, 5);
		
		Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
		Main.space.soldier.get(0).move(15, 3);
		
		Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
		Main.space.soldier.get(1).move(15, 7);
		
		for(int i = 2;i<5;++i)
		{
			Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
			Main.space.soldier.get(i).move(16, 2+2*(i-2));
		}
		
		Main.space.show();
	}
	
	static void showformation4()
	{
		for(int i = 0;i<7;++i)
		{
			Main.space.huluwa.get(i).move(Main.Constant.Osupportplacex,2+i);
		}
		
		showoldguy();
		showsnake();
	}
	
	static void showoldguy()
	{
		Main.space.oldguy.show();
	}
	
	static void showsnake()
	{
		Main.space.snake.show();
	}
	
	public static void showformation5()
	{
		Main.space.init();
		showformation4();
		
		Main.space.scorpion.move(15, 5);
		
		for(int i = 0;i<3;++i)
		{
			Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
			Main.space.soldier.get(i).move(15+i, 3+i);
		}
		
		for(int i = 3;i<7;++i)
		{
			Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
			Main.space.soldier.get(i).move(12+(i-3)*2, 6);
		}
		
		Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
		Main.space.soldier.get(7).move(13, 5);
		Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
		Main.space.soldier.get(8).move(15, 7);
		
		Main.space.show();
	}
	
	public static void showformation6()
	{
		Main.space.init();
		showformation4();
		
		Main.space.scorpion.move(13, 5);
		
		for(int i = 0;i<4;++i)
		{
			Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
			Main.space.soldier.get(i).move(14+i/2, 4-i/2);
			
			Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
			Main.space.soldier.get(i+1).move(14+i/2, 6+i/2);
			++i;
		}
		
		Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
		Main.space.soldier.get(4).move(16,4);
		
		Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
		Main.space.soldier.get(5).move(16,6);
		
		Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
		Main.space.soldier.get(6).move(17,5);
		
		Main.space.show();
	}
	
	public static void showformation7()
	{
		Main.space.init();
		showformation4();
		
		Main.space.scorpion.move(14, 5);
		
		for(int i = 0;i<4;++i)
		{
			Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
			Main.space.soldier.get(i).move(15+i, 4-i);
		}
		
		for(int i = 0;i<4;++i)
		{
			Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
			Main.space.soldier.get(i+4).move(15+i, 6+i);
		}
		
		for(int i = 0;i<3;++i)
		{
			Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
			Main.space.soldier.get(8+i).move(14+i, 4-i);
		}
		
		for(int i = 0;i<3;++i)
		{
			Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
			Main.space.soldier.get(i+11).move(14+i, 6+i);
		}
		
		for(int i = 0;i<3;++i)
		{
			Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
			Main.space.soldier.get(i+14).move(13, 4+i);
		}
		
		Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
		Main.space.soldier.get(17).move(15, 5);
		
		Main.space.show();
	}
	
	public static void showformation8()
	{
		Main.space.init();
		showformation4();
		
		Main.space.scorpion.move(14, 2);
		
		for(int i = 0;i<5;++i)
		{
			Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
			Main.space.soldier.get(i).move(14, 3+i);
		}
		
		for(int i = 0;i<3;++i)
		{
			Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
			Main.space.soldier.get(i+5).move(13-i, 3+i);
		}
		
		for(int i = 0;i<3;++i)
		{
			Main.space.soldier.add(new Creature<NormalCreature>("*",Main.Constant.spacesize-1,Main.Constant.spacesize-1,NormalCreature.class));
			Main.space.soldier.get(i+8).move(15+i, 3+i);
		}
		
		
		
		Main.space.show();
	}
}
