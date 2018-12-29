//package project2;

import java.util.Random;

enum COLOR{RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE};

public class Calabash {	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		CalabashWorld world = new CalabashWorld();
		world.shuffle();
		world.bubbleSort();
		world.shuffle();
		world.halfSort();
	}
	
}

class CalabashBrother {
	
	int rank;
	String name;
	COLOR color;
	
	CalabashBrother(int r, String n, COLOR c) {
		// TODO Auto-generated constructor stub
		rank = r;
		name = n;
		color = c;
	}
	
}

class CalabashWorld {
	
	CalabashBrother[] brothers;
	
	CalabashWorld() {
		// TODO Auto-generated constructor stub
		CalabashBrother theOldest = new CalabashBrother(1, "老大", COLOR.RED);
		CalabashBrother theSecond = new CalabashBrother(2, "老二", COLOR.ORANGE);
		CalabashBrother theThird = new CalabashBrother(3, "老三", COLOR.YELLOW);
		CalabashBrother theForth = new CalabashBrother(4, "老四", COLOR.GREEN);
		CalabashBrother theFifth = new CalabashBrother(5, "老五", COLOR.CYAN);
		CalabashBrother theSixth = new CalabashBrother(6, "老六", COLOR.BLUE);
		CalabashBrother theYoungest = new CalabashBrother(7, "老七", COLOR.PURPLE);		
		
		brothers = new CalabashBrother[]{theOldest, theSecond, theThird, theForth, theFifth, theSixth, theYoungest};
		
	}

	
	void shuffle() {
		// 葫芦娃随机站队
		int length = brothers.length;
        for ( int i = length; i > 0; i-- ) {
        	Random random = new Random();
            int randInd = random.nextInt(i);
            swap(brothers, randInd, i - 1);
        }
	}
	
	
	public static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }	
	
	void bubbleSort() {
		// 冒泡排序
		for (int i = brothers.length; i > 0 ; i--) {
			for (int j = 0; j < i-1; j++) {
				if (brothers[j].rank > brothers[j+1].rank) {
					System.out.println(brothers[j].name+":"+j+"->"+(j+1)+";"+brothers[j+1].name+":"+(j+1)+"->"+j);
					swap(brothers, j, j + 1);				
				}
			}
		}
		for (CalabashBrother k : brothers) {
			System.out.print(k.name + " ");
		}
		System.out.println();
		
	}
	
	
	void halfSort() {
		//二分排序
		int start;
	    int end;
	    CalabashBrother target;
	    int mid;
	        
		for (int i = 1; i < brothers.length; i++) {
			start = 0;
			end = i - 1;
			target = brothers[i];
			 
			while (start <= end) {
				mid = (start+end)/2;
				if (target.color.ordinal() < brothers[mid].color.ordinal()) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
			 
			int j = 0;
			for (j = i; j > start; j--) {
				brothers[j] = brothers[j-1];
			}
			brothers[j] = target;
			System.out.println(target.name + ":" + (i+1) + "->" + (j+1));
		}
		for (CalabashBrother k : brothers) {
			System.out.print(k.color + " ");
		}
		System.out.println();
		
	}
	
	/*
	void display() {
	
		for (CalabashBrother k : brothers) {
			System.out.print(k.rank + ":" + k.color);
			System.out.println();
		}
		
	}*/
	
}