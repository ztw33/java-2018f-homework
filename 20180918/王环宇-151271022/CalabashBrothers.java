package javahw2;

public class CalabashBrothers {

	private String name;
	private String color;
	private int order;
	private int num;
	
	public String getName() {
		return name;
	}
	public String getColor() {
		return color;
	}
	public int getOrder() {
		return order;
	}
	public void changeNum(int num) {
		if(this.num != num) {
			System.out.print(this.name+":"+num+"->"+this.num);
			System.out.print("\t\t");
		}
		this.num = num;
	}
	
	public static CalabashBrothers[] total = new CalabashBrothers[7];
	
	public CalabashBrothers(String name, String color, int order, int num) {
		this.name = name;
		this.color = color;
		this.order = order;
		this.num = num;
	}
	public CalabashBrothers() {
	}
	
	public static void main(String[] args) {
		String name = "大二三四五六七";
		String color = "赤橙黄绿青蓝紫";
		for (int i=0; i<7; i++) {
			total[i] = new CalabashBrothers(name.charAt(i) + "娃", color.charAt(i)+"", i+1, i);
		}
		System.out.println("Initialization!");
		showName();
		//showNum();
		// shuffle the array
		shuffle(total);
		System.out.println("After the shuffle:");
		showName();
		//showNum();

		bubble(total);
		System.out.println("After the bubble sort:");
		showName();
		//showNum();
		
		shuffle(total);
		System.out.println("After the shuffle:");
		showName();
		//showNum();
		
		binarySort(total);
		System.out.println("After the binary sort:");
		showColor();
		//showNum();
	}
	
	public static void bubble(CalabashBrothers[] cb) {
		int len = cb.length;
		for (int i=0; i<len; i++) {
			for (int j=0; j<len-i-1; j++) {
				if (cb[j].getOrder()>cb[j+1].getOrder()) {
					swap(cb, j, j+1);
				}
			}
		}
	}
	public static void binarySort(CalabashBrothers[] cb) {
		for (int i=1; i<cb.length; i++) {
			int position = index(cb, i);
			move(cb, position, i);
		}
	}
	
	public static void shuffle(CalabashBrothers[] cb) {
		for (int i=0; i<20; i++) {
			int rand1 = ((int)(Math.random()*100) % 7);
			int rand2 = ((int)(Math.random()*100) % 7);
			swap(cb, rand1, rand2, 0);
		}
	}
	
	public static void swap(CalabashBrothers[] cb, int m, int n) {
		swap(cb, m, n, 1);
	}
	public static void swap(CalabashBrothers[] cb, int m, int n, int mode) {
		if (m==n) return;
		CalabashBrothers temp;
		temp = cb[m];
		cb[m] = cb[n];
		cb[n] = temp;
		if (mode==1) {
			cb[m].changeNum(m);
			cb[n].changeNum(n);
			System.out.println();
		}
		else {
			cb[m].num = m;
			cb[n].num = n;
		}
	}

	
	public static void showColor() {
		for (CalabashBrothers k : total) {
			System.out.print(k.getColor());
			System.out.print("\t");
		}
		System.out.println("\n");
	}
	public static void showName() {
		for (CalabashBrothers k : total) {
			System.out.print(k.name);
			System.out.print("\t");
		}
		System.out.println("\n");
	}
	public static void showNum() {
		for (CalabashBrothers k : total) {
			System.out.print(k.num);
			System.out.print("\t");
		}
		System.out.println("\n");
		
	}
	
	public static int index(CalabashBrothers[] cb, int x) {
		int position = 0;
		for(int i=0; i<x; i++) {
			if(cb[x].getOrder()>cb[i].getOrder() && cb[i+1].getOrder()>=cb[x].getOrder()) {
				position = i+1;
			}
		}
		return position;
	}
	
	public static void move(CalabashBrothers[] cb, int m, int n) {
		if (m==n) return;
		CalabashBrothers temp = cb[n];
		for (int i=n; i>m; i--) {
			cb[i] = cb[i-1];
			cb[i].changeNum(i);		
		}
		cb[m] = temp;
		cb[m].changeNum(m);
		System.out.println();
	}
}
