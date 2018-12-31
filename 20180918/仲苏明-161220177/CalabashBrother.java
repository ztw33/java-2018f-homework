package CalabashBrother;

public enum CalabashBrother {
	RED("老大","红色",1),ORANGE("老二","橙色",2),YELLOW("老三","黄色",3),GREEN("老四","绿色",4),
	CYAN("老五","青色",5),BLUE("老六","蓝色",6),PURPLE("老七","紫色",7);
	private final String name;
	private final String color;
	private final int rank;
	private CalabashBrother(String name,String color,int rank) {
		this.name=name;
		this.color=color;
		this.rank=rank;
	}
	/*public String getName() {
		return name;
	}
	public String getColor() {
		return color;
	}
	public int getRank() {
		return rank;
	}*/
	/*public static void changePos(CalabashBrother a,CalabashBrother b) {
		//System.out.println(a.name+":"+i+"->"+j+","+b.name+":"+j+"->"+i);
		CalabashBrother temp=a;
		a=b;
		b=temp;
	}*/
	public static void bubbleSort(CalabashBrother[] brothers) {
		int len=brothers.length;
		for(int i=0;i<len;i++) {
			for(int j=0;j<len-1;j++) {
				if(brothers[j].rank>brothers[j+1].rank) {
					int l=j+1;
					int r=j+2;
					System.out.println(brothers[j].name+":"+l+"->"+r);
					CalabashBrother temp=brothers[j];
					brothers[j]=brothers[j+1];
					brothers[j+1]=temp;
					//changePos(brothers[j],brothers[j+1]);
					//System.out.println(brothers[j].name+brothers[j+1].name);
				}
			}
		}
	}
	public static void binaryInsertSort(CalabashBrother[] brothers) {
		int len=brothers.length;
		for(int i=1;i<len;i++) {
			CalabashBrother temp=brothers[i];
			int src=i+1;
			int right=i-1;
			int left=0;
			int mid;
			while(left<=right) {
				mid=(left+right)/2;
				if(brothers[mid].rank>temp.rank) {
					right=mid-1;
				}
				else if(brothers[mid].rank<temp.rank) {
					left=mid+1;
				}
			}
			for(int j=i;j>left;j--) {
				brothers[j]=brothers[j-1];
			}
			brothers[left]=temp;
			left++;
			System.out.println(temp.name+":"+src+"->"+left);
			/*for(int k=0;k<brothers.length;k++) {s
				System.out.print(brothers[k].rank+" ");
			}
			System.out.println();*/
		}
	}
	public static void main(String[] args) {
		CalabashBrother[] brothers= {ORANGE,BLUE,GREEN,PURPLE,RED,CYAN,YELLOW};
		//CalabashBrother.values();	
		System.out.println("冒泡排序：");
		CalabashBrother.bubbleSort(brothers);
		for(int i=0;i<brothers.length;i++) {
			System.out.println(brothers[i].name);
		}
		System.out.println();
		CalabashBrother[] brothers2= {ORANGE,BLUE,GREEN,PURPLE,RED,CYAN,YELLOW};
		System.out.println("二分插入排序：");
		CalabashBrother.binaryInsertSort(brothers2);
		for(int i=0;i<brothers2.length;i++) {
			System.out.println(brothers2[i].color);
		}
	}
}
