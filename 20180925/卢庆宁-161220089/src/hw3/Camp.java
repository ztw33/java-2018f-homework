package hw3;

class Camp {						//阵营类，包含一个boss和若干小兵
	public Creature boss;
	public Creatures soldiers;
}
class Good extends Camp				//好人阵营，包含老爷爷和七个葫芦娃
{
	Good(int x_boss,int y_boss)
	{
		boss=new GrandFather(x_boss, y_boss);
		soldiers=new CalabashBrothers(7);
	}
}
class Bad extends Camp				//坏人阵营，包含蛇精和若干妖怪
{
	Bad(int x_boss,int y_boss,int number)
	{
		boss=new SnakeMonster(x_boss,y_boss);
		soldiers=new Monsters(number);
	}
}
