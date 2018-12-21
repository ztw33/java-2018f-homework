package hw.cb.sort;

import java.util.Random;


enum CalabashBrother {
    RED(1, "老大", "红色"),        ORANGE(2, "老二", "橙色"), 
    YELLOW(3, "老三", "黄色"),     GREEN(4, "老四", "绿色"), 
    CYAN(5, "老五", "青色"),       BLUE(6, "老六", "蓝色"), 
    PURPLE(7, "老七", "紫色");
 
	private int no;
    private String name;
    private String color;
    private CalabashBrother(int no, String name, String color) {
    	this.no = no;
        this.name = name;
        this.color = color;
    }
    public int getNo() {
    	return no;
    }
    public String getName() {
        return name;
    }
    public String getColor() {
    	return color;
    }
}

public class CalabashFamily {
	private CalabashBrother[] order = CalabashBrother.values();
	
	public void printInfo(boolean isColor) {
		for (int i = 0; i < 7; i++) {
			if (isColor) {
				System.out.printf(order[i].getColor() + " ");
			} else {
				System.out.printf(order[i].getName() + " ");				
			}


		}			
		System.out.println();
	}
	
	public void swap(int p, int q, boolean isSort) {
		CalabashBrother temp = order[p];
		order[p] = order[q];
		order[q] = temp;
		
		if (isSort) {
			System.out.println(order[p].getName() + ":" + (q+1) + "->" + (p+1));
			System.out.println(order[q].getName() + ":" + (p+1) + "->" + (q+1));
		}
	}
	
	public  void randomOrder() {
		System.out.println();
		System.out.println("Random:");
		Random count = new Random();
		for (int i = 0; i < count.nextInt(10)+3; i++) {
			Random p = new Random();
			Random q = new Random();
			swap(p.nextInt(7), q.nextInt(7), false);
		}
	}
	
	public void bubbleSort() {
		System.out.println();
		System.out.println("Bubble Sort:");
		for (int i = 0; i < 7; i++) {
			for (int j = i+1; j < 7; j++) {
				if (order[j-1].getNo() > order[j].getNo()) 
					swap(j-1, j, true);
			}
		}
	}

	public void binarySort() {
		System.out.println();
		System.out.println("Binary Sort:");
		for (int i = 0; i < 7; i++) {
			int left = 0, right = i-1;
			int mid = (left + right) / 2;
			while (left <= right) {
				if (order[i].getNo() < order[mid].getNo()) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
				mid = (left + right ) /2;
				for (int j = i-1; j >right; j--) {
					swap(j, j+1, true);
				}
			}
		}
		
	}
}
