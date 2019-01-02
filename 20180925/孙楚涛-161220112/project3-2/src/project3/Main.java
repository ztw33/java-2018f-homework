package project3;

public class Main {
	interface Constant{
		int spacesize = 20;
		//int barriernum = 2;
		int Osupportplacex = 5;
		int Osupportplacey = 13;
		int Ssupportplacex = 15;
		int Ssupportplacey = 13;
	}	
	
	static Space space = new Space();
	
	public static void main(String avg[])
	{
		for(int i = 1;i<=7;++i)
		{
			try {
				if(i!=1)
				{
					char c = (char)System.in.read();			//接收回车
				}
			}catch(Exception e)
			{
				
			}
			
			switch(i)
			{
				case 1:Formation.showformation1();break;
				case 2:Formation.showformation2();break;
				case 3:Formation.showformation3();break;
				case 4:Formation.showformation5();break;
				case 5:Formation.showformation6();break;
				case 6:Formation.showformation7();break;
				case 7:Formation.showformation8();break;
			}
			
		}
	}
}
