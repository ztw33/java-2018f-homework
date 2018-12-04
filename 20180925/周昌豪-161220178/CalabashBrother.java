package Battle;
import java.util.Random;

class GrandFather extends Creature
{
	@Override
	public String OutPutInfo()
	{
		return "CheerLeader";
	}
	
	GrandFather()
	{
		this.name = "GrandFather";
	}
}

enum Color
{
	Red, Orange, Yellow, Green, Cyan, Blue, Purple;
}
enum CalabashBrotherType
{
	HongWa(Color.Red, 1), ChengWa(Color.Orange, 2), HuangWa(Color.Yellow, 3), LvWa(Color.Green, 4),
	QingWa(Color.Cyan, 5), LanWa(Color.Blue, 6), ZiWa(Color.Purple, 7);
	private Color color;
	private int rank;
	private CalabashBrotherType(Color color, int rank)
	{
		this.color = color;
		this.rank = rank;
	}
	
	public Color GetColor()
	{
		return color;
	}
	
	public int GetRank()
	{
		return rank;
	}
}

public class CalabashBrother extends Creature
{
	private Color color;
	private int rank;
	
	
	public CalabashBrother(CalabashBrotherType aCB) {
		this.name = aCB.name();
		this.color = aCB.GetColor();
		this.rank = aCB.GetRank();
	}

	@Override
	public String OutPutInfo()
	{
		//return name;
		String str = "";
		return str + this.rank;
	}
}


class CalabashBrotherTeam extends CreatureTeam
{
	static CalabashBrother[] menu;
	public static final int CalaNumMax = 7;
	
	/*新建随机排列葫芦娃列表：由menu生成新的随机葫芦娃列表*/
	@Override
	protected void GetRandomList()
	{
		list = new CalabashBrother[CalaNumMax];
		for(int i = CalaNumMax - 1; i >= 0; i--)
		{
			//生成0 ~ i随机整数
			int random = (int)(Math.random()* i);
			list[CalaNumMax - 1 - i] = menu[random];
			//调整menu
			CalabashBrother tmp = menu[random];
			menu[random] = menu[i];
			menu[i] = tmp;
		}
	}
	
	/*CalabashBrotherTeam构造器：初始化menu，生成初始list，初始化cheerleader*/
	public CalabashBrotherTeam()
	{
		menu = new CalabashBrother[CalaNumMax];
		for(int i = 0;i < CalaNumMax;i++)
		{
			menu[i] = new CalabashBrother(CalabashBrotherType.values()[i]);
		}
		this.cheerleader = new GrandFather();
		GetRandomList();
	}
	
	/*用于调试时打印葫芦娃的信息*/
	public void Printlist()
	{
		for(Creature i:list)
			System.out.print(i.OutPutInfo());
	}
	
	/*生成范围随机数*/
	private int RandomNumberInRange(int min, int max)
	{
		return new Random().nextInt(max -min) + min;
	}
	
	/*阵型*/
	@Override
	public void SetRandomFormation(Field field)
	{
		/*生成新葫芦娃队列*/
		GetRandomList();
		/* 1 <= y <= 4, 1 <= x <= 2*/
		int rx = RandomNumberInRange(1, 2);
		int ry = RandomNumberInRange(1, 4);
		//System.out.println(ry + " " + rx);
		Position[] pos = Formation.GetRandomFormation();
		
		assert(this.list.length == pos.length);
		for(int i = 0;i < this.list.length; i++)
		{
			list[i].pos.SetPos(ry + pos[i].y(), rx + pos[i].x());
			field.Set(list[i], ry + pos[i].y(), rx + pos[i].x());
		}
		
		int cheerleaderPos = 0;
		do {
			cheerleaderPos = RandomNumberInRange(0, Field.PlantSize - 1);
		}while(false == field.Set(this.cheerleader, cheerleaderPos, 0));
			
	}
}
