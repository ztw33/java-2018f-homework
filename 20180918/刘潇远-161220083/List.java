import java.io.*;
enum CalabashBrother{//�㶮��
	RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE;
	String[] NAME = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
	String[] COLOR = {"赤", "橙", "黄", "绿", "青", "蓝", "紫"};
	String getName() {//返回枚举变量的NAME
		return this.NAME[ordinal()];
	}
	String getColor() {//返回枚举变量的COLOR
		return this.COLOR[ordinal()];
	}
}

class CalabashBrothers{//
	CalabashBrother[] calabashbrothers;
	CalabashBrothers(){
		calabashbrothers = new CalabashBrother[7];
		Disorder();//无序初始化葫芦兄弟
/*
		boolean[] existence= {false, false, false, false, false, false, false};
		for(int i = 0; i < 7; i++) {
			int tmp;
			do {
				tmp = (int)(Math.random()*7);
			}while(existence[tmp]);
			calabashbrothers[i]=CalabashBrother.values()[tmp];
			existence[tmp]=true;
		}
*/
	}
	void SwapBrother(int index1, int index2) {//两兄弟交换位置
		System.out.println(calabashbrothers[index1].getName()+":"+ index1 + "->" + index2);
		System.out.println(calabashbrothers[index2].getName()+":" + index2 + "->" + index1);
		CalabashBrother swaper = calabashbrothers[index1];
		calabashbrothers[index1] = calabashbrothers[index2];
		calabashbrothers[index2] = swaper;
	}
	CalabashBrother getBrother(int index) {//返回index位置的葫芦娃
		return calabashbrothers[index];
	}
	String getName(int index) {//返回index位置的葫芦娃名字
		//System.out.print(calabashbrothers[index].getName());
		return calabashbrothers[index].getName();
	}
	String getColor(int index) {//返回index位置的葫芦娃颜色
		//System.out.print(calabashbrothers[index].getColor());
		return calabashbrothers[index].getColor();
	}
	public void QueueNameStatus() {//按名报数
		for(int i = 0;i<7;i++) {
			System.out.print(calabashbrothers[i].getName() + " ");
		}
		System.out.println("");
	}
	public void QueueColorStatus() {//按颜色报数
		for(int i = 0;i<7;i++) {
			System.out.print(calabashbrothers[i].getColor() + " ");
		}
		System.out.println("");
	}
	public void Disorder() {//无序化
		boolean[] existence= {false, false, false, false, false, false, false};
		for(int i = 0; i < 7; i++) {
			int tmp;
			do {
				tmp = (int)(Math.random()*7);
			}while(existence[tmp]);
			calabashbrothers[i]=CalabashBrother.values()[tmp];
			existence[tmp]=true;
		}
	}
}

class Director{
	/*
	private CalabashBrothers calabashbrothers = new CalabashBrothers();
	
	public void QueueNameStatus() {//����������е�ǰ��
		for(int i = 0;i<7;i++) {
			System.out.print(calabashbrothers.getName(i) + " ");
		}
	}
	public void QueueColorStatus() {//����ɫ������е�ǰ��
		for(int i = 0;i<7;i++) {
			System.out.print(calabashbrothers.getColor(i) + " ");
		}
	}
	*/
	public void QueueNameStatus(CalabashBrothers calabashbrothers) {//使按名报数
		calabashbrothers.QueueNameStatus();
	}
	public void QueueColorStatus(CalabashBrothers calabashbrothers) {//使按颜色报数
		calabashbrothers.QueueColorStatus();
	}
	public void BubbleSort(CalabashBrothers calabashbrothers) {//以冒泡法指挥排序
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 6 - i; j++) {
				if(calabashbrothers.getBrother(j).compareTo(calabashbrothers.getBrother(j + 1))>0) {
					
					calabashbrothers.SwapBrother(j, j + 1);
					
				}
			}
		}
	}
	private int Partition(CalabashBrothers calabashbrothers, int p, int r){
		CalabashBrother pivot= calabashbrothers.getBrother(r);
		int i = p - 1;
		for(int j = p; j < r;j++){
			if(calabashbrothers.getBrother(j).compareTo(pivot) < 0){
				i++;
				calabashbrothers.SwapBrother(i, j);
			}
		}
		calabashbrothers.SwapBrother(r, i + 1);
		//elements[r] = elements[i + 1]
		//elements[i + 1] = pivot;
		return i + 1;
	}
	public void QuickSort(CalabashBrothers calabashbrothers, int p, int r) {//以快排法指挥排序
		if(p < r) {
			int q = Partition(calabashbrothers, p, r);
			QuickSort(calabashbrothers, p, q - 1);
			QuickSort(calabashbrothers, q + 1, r);
		}
	}
}

public class List {
	
	public static void main(String args[]) {
	Director director = new Director();
	
	CalabashBrothers calabashbrothers = new CalabashBrothers();
	calabashbrothers.QueueNameStatus();
	calabashbrothers.QueueColorStatus();
	
	director.BubbleSort(calabashbrothers);
	calabashbrothers.QueueNameStatus();
	calabashbrothers.QueueColorStatus();
	
	calabashbrothers.Disorder();
	calabashbrothers.QueueNameStatus();
	calabashbrothers.QueueColorStatus();
	
	director.QuickSort(calabashbrothers, 0, 6);
	calabashbrothers.QueueNameStatus();
	calabashbrothers.QueueColorStatus();
	}
}
