package CalabashBrothers;

enum Color
{
	Red, Orange, Yellow, Green, Cyan, Blue, Purple;
}

public enum CalabashBrother
{	HongWa("Red", 1), ChengWa("Orange", 2), HuangWa("Yellow", 3), LvWa("Green", 4),
	QingWa("Cyan", 5), LanWa("Blue", 6), ZiWa("Purple", 7);
	private Color color;
	private final int rank;
	private CalabashBrother(String color, int rank)
	{
		switch(color)
		{
		case("Red"):   this.color = Color.Red;break;
		case("Orange"):this.color = Color.Orange;break;
		case("Yellow"):this.color = Color.Yellow;break;
		case("Green"): this.color = Color.Green;break;
		case("Cyan"):  this.color = Color.Cyan;break;
		case("Blue"):  this.color = Color.Blue;break;
		case("Purple"):this.color = Color.Purple;break;
		}
		this.rank = rank;
	}
	public int getColorRank()
	{
		return this.color.ordinal();
	}
	public int getRank()
	{
		return this.rank;
	}
	public void PlaceChangeReport(int src, int dst)
	{
		System.out.println(this.name() + ": " + src + " -> " + dst);
	}
	
	public void ColorReport()
	{
		System.out.print(this.color.name() + " ");
	}
	
	public static CalabashBrother[] getRandomList()
	{
		CalabashBrother[] list = new CalabashBrother[7];
		CalabashBrother[] menu = CalabashBrother.values().clone();
		for(int i = 6; i >= 0; i--)
		{
			//生成0 ~ i随机整数
			int random = (int)(Math.random()* i);
			list[6 - i] = menu[random];
			//调整menu
			menu[random] = menu[i];
		}
		return list;
	}                                                 
}

class HuluBrotherSort
{
	static void BinarySort(CalabashBrother[] list) 
	{
		for(int i = 1;i < 7;i++)
		{
			int mid = FindIndexToInsert(list, i);
			CalabashBrother tmp = list[i];
			for(int j = i; j > mid; j--)
				list[j] = list[j - 1];
			list[mid] = tmp;
			//for(HuluBrother it: list)
				//System.out.print(it.name() + "." + it.getrank() + " ");
		}
	}
	
	static int FindIndexToInsert(CalabashBrother[] list, int CIndex)
	{
		if(list[0].getColorRank() > list[CIndex].getColorRank())
			return 0;
		else if(list[CIndex - 1].getColorRank() < list[CIndex].getColorRank())
			return CIndex;
		else
		{
			int low = 0, high = CIndex - 1;
			int mid = (low + high)/2;
			while(!(list[mid- 1].getColorRank() < list[CIndex].getColorRank() && 
					list[CIndex].getColorRank() < list[mid].getColorRank()))
			{
				mid = (low + high)/2 + (low + high)%2;
				if(list[mid - 1].getColorRank() > list[CIndex].getColorRank())
					high = mid - 1;
				else
					low = mid + 1;
			}
			return mid;
		}
	}

    static void BubbleSort(CalabashBrother[] list) {
    	for(int i = 0; i < 7; i++)
    	{
    		for(int j = 0; j < 7; j++)
    			if(list[i].getRank() < list[j].getRank())
    			{
    				//report
    				list[i].PlaceChangeReport(i, j);
    				list[j].PlaceChangeReport(j, i);
    				CalabashBrother tmp = list[i];
    				list[i] = list[j];
    				list[j] = tmp;
    			}
    	}

	}
}