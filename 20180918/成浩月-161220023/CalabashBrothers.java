package second_homework;


//葫芦娃有且只有7个互不相同的娃，不能单个创造葫芦娃，只能让7个葫芦娃一起产生。将这7个葫芦娃设置为静态，并且将构造函数设置为私有，确保只有7个葫芦娃，通过其他函数返回这7个葫芦娃。
public class CalabashBrothers {
	enum CalabashBrother{
		FIRST("老大","红色"),SECOND("老二","橙色"),THIRD("老三","黄色"),FOURTH("老四","绿色"),FIFTH("老五","青色"),SIXTH("老六","蓝色"),SEVENTH("老七","紫色");
		private String status;
		private String color;
		
		CalabashBrother(String status,String color){
			this.status=status;
			this.color=color;
		}
		
		public void tellstatus() {
			System.out.print(status);
		}
		
		public void tellcolor() {
			System.out.print(color);
		}
	}
	public static final int number=7;
	private static CalabashBrother[] cala=new CalabashBrother[number];
	private static CalabashBrothers c=new CalabashBrothers();
	
	private CalabashBrothers() {
		for(int i=0;i<number;i++)
			cala[i]=CalabashBrother.values()[i];
	}
	
	static CalabashBrothers GetCalabashBrothers() {
		return c;
	}
	
  	void swap(int i,int j) {
		if(i<0||i>=number||j<0||j>=number)
			System.out.println("error!");
		CalabashBrother temp=cala[i];
		cala[i]=cala[j];
		cala[j]=temp;
		tellmove(i,j);
		tellmove(j,i);
	}
		
	boolean larger(int i,int j) {
		return cala[i].ordinal()>cala[j].ordinal();
	}
		
	void countoffbystatus() {
		for(int i=0;i<number;i++)
			cala[i].tellstatus();
		System.out.println();
	}
		
	void countoffbycolor() {
		for(int i=0;i<number;i++)
			cala[i].tellcolor();
		System.out.println();
	}
	
	private void tellmove(int x,int y) {
		if(x<0||x>=number||y<0||y>=number)
			System.out.println("error!");
		cala[y].tellstatus();
		System.out.println(":"+(x+1)+"->"+(y+1));
	}
}