package CalabashBrothers;

/*
This class is sort for CalabashBrothers, include two kinds of sort
 */

class CalabashBrothersSort{
	public static void BubbleSort(CalabashBrother[] AllBrothers) {
		for(int i = 0; i < AllBrothers.length; i++) {
			for(int j = 0; j < AllBrothers.length - 1; j++) {
				if(AllBrothers[j + 1].number < AllBrothers[j].number) {
					System.out.println(AllBrothers[j].rank + ":" + j + "->" + (j + 1));
					CalabashBrother temp = AllBrothers[j];
					AllBrothers[j] = AllBrothers[j + 1];
					AllBrothers[j + 1] = temp;
				}
			}
		}
	}
	
	public static void BinaryInsertSort(CalabashBrother[] AllBrothers) {
		for(int i = 1; i < AllBrothers.length; i++) {
			int left = 0;
			int right = i - 1;
			int mid;
			while(left <= right) {
				mid = (left + right) / 2;
				if(AllBrothers[mid].number < AllBrothers[i].number)
					left = mid + 1;
				else
					right = mid - 1;
			}
			CalabashBrother temp = AllBrothers[i];
			for(int j = i; j > left; j--)
				AllBrothers[j] = AllBrothers[j - 1];
			AllBrothers[left] = temp;
			System.out.println(temp.rank + ":" + i + "->" + left);
		}
	}
}

/*
This is the definition of CalabashBrother and the entrance to main function
 */

public enum CalabashBrother {
	First("老大","红色",1),
	Second("老二","橙色",2),
	Third("老三","黄色",3),
	Fourth("老四","绿色",4),
	Fifth("老五","青色",5),
	Sixth("老六","蓝色",6),
	Seventh("老七","紫色",7);
	final String rank;
	final String color;
	final int number;
	private CalabashBrother(String rank,String color,int number) {
		this.rank = rank;
		this.color = color;
		this.number = number;
	}
	public static void main(String[] args) {
		CalabashBrother[] brothers1= {Second, Seventh, Fourth, First, Fifth, Sixth, Third};
		System.out.println("Original arrangement:");
		for(int i = 0; i < brothers1.length; i++)
			System.out.println(brothers1[i].rank);
		System.out.println("\n");
		
		System.out.println("After BubbleSort, arrangement:");
		CalabashBrothersSort.BubbleSort(brothers1);
		for(int i = 0; i < brothers1.length; i++)
			System.out.println(brothers1[i].rank);
		System.out.println("\n");
		
		CalabashBrother[] brothers2= {Second, Seventh, Fourth, First, Fifth, Sixth, Third};
		System.out.println("Original arrangement:");
		for(int i = 0; i < brothers2.length; i++)
			System.out.println(brothers2[i].rank);
		System.out.println("\n");
		
		System.out.println("After BinaryInsertSort, arrangement:");
		CalabashBrothersSort.BinaryInsertSort(brothers2);
		for(int i = 0;i < brothers2.length; i++)
			System.out.println(brothers2[i].color);
		System.out.println("\n");
	}
}
