import java.util.Random;

enum Calabash {
	FIRST(1,"老大","红色"),
	SECOND(2,"老二","橙色"),
	THIRD(3,"老三","黄色"),
	FOURTH(4,"老四","绿色"),
	FIFTH(5,"老五","青色"),
	SIXTH(6,"老六","蓝色"),
	SEVENTH(7,"老七","紫色");
	public final int rank;
	private final String rankName;
	private final String color;
	Calabash(int rank,String rankName,String color) {
		this.rank=rank;
		this.rankName = rankName;
		this.color=color;
	}
	public void reportRank() {
		System.out.println(rankName);
	}
	public void reportColor() {
		System.out.println(color);
	}
	public void reportPositionChange(int pos1, int pos2) {
		System.out.println(rankName+"："+pos1+"->"+pos2);
	}
}

public class CalabashBrothers {
	public Calabash[] brothers=Calabash.values();
	public void randomArrange() {
		Random random=new Random();
		for(int i=0;i<7;i++) {
			swap(random.nextInt(brothers.length), random.nextInt(brothers.length),false);
		}
	}
	public void bubbleSort() {
		System.out.println("Bubble Sort:");
		for(int i=0;i<brothers.length-1;i++) {
			for(int j=0;j<brothers.length-1-i;j++) {
				if(brothers[j].rank>brothers[j+1].rank) {
					swap(j, j+1, true);
				}
			}
		}
	}
	public void binarySort() {
		System.out.println("Binary Sort:");
		for(int i=1;i<brothers.length;i++) {
			int left=0,right=i-1;
			Calabash tmp=brothers[i];
			while(left<=right) {
				int mid=(left+right)/2;
				if(brothers[mid].rank>tmp.rank)
					right=mid-1;
				else
					left=mid+1;
			}
			for(int j=i-1;j>right;j--)
				swap(j, j+1, true);
		}
	}
	public void reportRanks() {
		System.out.println();
		for(Calabash x:brothers)
			x.reportRank();
		System.out.println();
	}
	public void reportColors() {
		System.out.println();
		for(Calabash x:brothers)
			x.reportColor();
		System.out.println();
	}
	private void swap(int pos1, int pos2, boolean report) {
		if(report) {
			brothers[pos1].reportPositionChange(pos1, pos2);
			brothers[pos2].reportPositionChange(pos2, pos1);
		}
		Calabash tmp=brothers[pos1];
		brothers[pos1]=brothers[pos2];
		brothers[pos2]=tmp;
	}
	public static void main(String[] args) {
		CalabashBrothers cBrothers=new CalabashBrothers();
		cBrothers.randomArrange();
		cBrothers.bubbleSort();
		cBrothers.reportRanks();
		cBrothers.randomArrange();
		cBrothers.binarySort();
		cBrothers.reportColors();
	}
}
