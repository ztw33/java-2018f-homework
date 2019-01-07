package project3;

public class Formation {
	public static void showformation1()
	{
		Main.space.init();
		showformation4();
		
		Main.space.scorpion.move(15, 7);
		Main.space.soldier = new NormalCreature[6];
		for(int i = 0;i<3;++i)
		{
			Main.space.soldier[i] = new NormalCreature("*",0,0);
			Main.space.soldier[i].move(12+i, 4+i);
		}
		for(int i = 3;i<6;++i)
		{
			Main.space.soldier[i] = new NormalCreature("*",0,0);
			Main.space.soldier[i].move(13+i, 9-i);
		}
		
		Main.space.show();
	}
	
	public static void showformation2()
	{
		Main.space.init();
		showformation4();
		
		Main.space.scorpion.move(15, 5);
		Main.space.soldier = new NormalCreature[6];
		for(int i = 0;i<3;++i)
		{
			Main.space.soldier[i] = new NormalCreature("*",0,0);
			Main.space.soldier[i].move(12+i, 8-i);
		}
		for(int i = 3;i<6;++i)
		{
			Main.space.soldier[i] = new NormalCreature("*",0,0);
			Main.space.soldier[i].move(13+i, 7-i);
		}
		
		Main.space.show();
	}
	
	public static void showformation3()
	{
		Main.space.init();
		showformation4();
		
		Main.space.scorpion.move(15, 5);
		Main.space.soldier = new NormalCreature[5];
		
		Main.space.soldier[0] = new NormalCreature("*",0,0);
		Main.space.soldier[0].move(15, 3);
		
		Main.space.soldier[1] = new NormalCreature("*",0,0);
		Main.space.soldier[1].move(15, 7);
		
		for(int i = 2;i<5;++i)
		{
			Main.space.soldier[i] = new NormalCreature("*",0,0);
			Main.space.soldier[i].move(16, 2+2*(i-2));
		}
		
		Main.space.show();
	}
	
	static void showformation4()
	{
		for(int i = 0;i<7;++i)
		{
			Main.space.huluwa[i].move(Main.Constant.Osupportplacex,2+i);
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
		Main.space.soldier = new NormalCreature[9];
		
		for(int i = 0;i<3;++i)
		{
			Main.space.soldier[i] = new NormalCreature("*",0,0);
			Main.space.soldier[i].move(15+i, 3+i);
		}
		
		for(int i = 3;i<7;++i)
		{
			Main.space.soldier[i] = new NormalCreature("*",0,0);
			Main.space.soldier[i].move(12+(i-3)*2, 6);
		}
		
		Main.space.soldier[7] = new NormalCreature("*",0,0);
		Main.space.soldier[7].move(13, 5);
		Main.space.soldier[8] = new NormalCreature("*",0,0);
		Main.space.soldier[8].move(15, 7);
		
		Main.space.show();
	}
	
	public static void showformation6()
	{
		Main.space.init();
		showformation4();
		
		Main.space.scorpion.move(13, 5);
		Main.space.soldier = new NormalCreature[7];
		
		for(int i = 0;i<4;++i)
		{
			Main.space.soldier[i] = new NormalCreature("*",0,0);
			Main.space.soldier[i].move(14+i/2, 4-i/2);
			
			Main.space.soldier[i+1] = new NormalCreature("*",0,0);
			Main.space.soldier[i+1].move(14+i/2, 6+i/2);
			++i;
		}
		
		Main.space.soldier[4] = new NormalCreature("*",0,0);
		Main.space.soldier[4].move(16,4);
		
		Main.space.soldier[5] = new NormalCreature("*",0,0);
		Main.space.soldier[5].move(16,6);
		
		Main.space.soldier[6] = new NormalCreature("*",0,0);
		Main.space.soldier[6].move(17,5);
		
		Main.space.show();
	}
	
	public static void showformation7()
	{
		Main.space.init();
		showformation4();
		
		Main.space.scorpion.move(14, 5);
		Main.space.soldier = new NormalCreature[18];
		
		for(int i = 0;i<4;++i)
		{
			Main.space.soldier[i] = new NormalCreature("*",0,0);
			Main.space.soldier[i].move(15+i, 4-i);
		}
		
		for(int i = 0;i<4;++i)
		{
			Main.space.soldier[i+4] = new NormalCreature("*",0,0);
			Main.space.soldier[i+4].move(15+i, 6+i);
		}
		
		for(int i = 0;i<3;++i)
		{
			Main.space.soldier[i+8] = new NormalCreature("*",0,0);
			Main.space.soldier[i+8].move(14+i, 4-i);
		}
		
		for(int i = 0;i<3;++i)
		{
			Main.space.soldier[i+11] = new NormalCreature("*",0,0);
			Main.space.soldier[i+11].move(14+i, 6+i);
		}
		
		for(int i = 0;i<3;++i)
		{
			Main.space.soldier[i+14] = new NormalCreature("*",0,0);
			Main.space.soldier[i+14].move(13, 4+i);
		}
		
		Main.space.soldier[17] = new NormalCreature("*",0,0);
		Main.space.soldier[17].move(15, 5);
		
		Main.space.show();
	}
	
	public static void showformation8()
	{
		Main.space.init();
		showformation4();
		
		Main.space.scorpion.move(14, 2);
		Main.space.soldier = new NormalCreature[11];
		
		for(int i = 0;i<5;++i)
		{
			Main.space.soldier[i] = new NormalCreature("*",0,0);
			Main.space.soldier[i].move(14, 3+i);
		}
		
		for(int i = 0;i<3;++i)
		{
			Main.space.soldier[i+5] = new NormalCreature("*",0,0);
			Main.space.soldier[i+5].move(13-i, 3+i);
		}
		
		for(int i = 0;i<3;++i)
		{
			Main.space.soldier[i+8] = new NormalCreature("*",0,0);
			Main.space.soldier[i+8].move(15+i, 3+i);
		}
		
		
		
		Main.space.show();
	}
}
