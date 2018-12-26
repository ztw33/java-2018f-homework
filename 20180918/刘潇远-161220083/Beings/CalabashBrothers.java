package Beings;
/*
enum CalabashBrother {//
	RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE;
	String[] NAME = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
	String[] COLOR = {"赤", "橙", "黄", "绿", "青", "蓝", "紫"};
	int x;
	int y;
	CalabashBrother(){
		x=-1;
		y=-1;
	}
	String getName() {
		return this.NAME[ordinal()];
	}
	String getColor() {
		return this.COLOR[ordinal()];
	}
	void MoveToPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
*/
public class CalabashBrothers {
	private CalabashBrother[] calabashbrothers;
	public CalabashBrothers(){
		calabashbrothers = new CalabashBrother[7];
		Disorder();
	}
	
	public void SetCBPostion(int index, int x, int y) {
		calabashbrothers[index].MoveToPos(x, y);
	}
	
	public void SwapBrother(int index1, int index2) {
		System.out.println(calabashbrothers[index1].getName()+":"+ index1 + "->" + index2);
		System.out.println(calabashbrothers[index2].getName()+":" + index2 + "->" + index1);
		CalabashBrother swaper = calabashbrothers[index1];
		calabashbrothers[index1] = calabashbrothers[index2];
		calabashbrothers[index2] = swaper;
	}
	public CalabashBrother getBrother(int index) {
		return calabashbrothers[index];
	}
	public String getName(int index) {

		return calabashbrothers[index].getName();
	}
	public String getColor(int index) {

		return calabashbrothers[index].getColor();
	}
	public void QueueNameStatus() {
		for(int i = 0;i<7;i++) {
			System.out.print(calabashbrothers[i].getName() + " ");
		}
		System.out.println("");
	}
	public void QueueColorStatus() {
		for(int i = 0;i<7;i++) {
			System.out.print(calabashbrothers[i].getColor() + " ");
		}
		System.out.println("");
	}
	public void Disorder() {
		
		boolean[] existence= {false, false, false, false, false, false, false};
		for(int i = 0; i < 7; i++) {
			int tmp;
			do {
				tmp = (int)(Math.random()*7);
			}while(existence[tmp]);
			if(calabashbrothers[i]==null)
				calabashbrothers[i] = new CalabashBrother(NameAndColor.values()[tmp]);
			else
				calabashbrothers[i].setNameAndColor(tmp);

			existence[tmp]=true;
		}
		
	}
}
