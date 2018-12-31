package calabashbrothers;

enum COLOR {
	RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE
}

enum ONECAlABASH {
	FIRST(0, "红色", COLOR.RED, "老大"), SECOND(1, "橙色", COLOR.ORANGE, "老二"), THIRD(2, "黄色", COLOR.YELLOW, "老三"), FOURTH(3, "绿色", COLOR.GREEN, "老四"),
	FIFTH(4, "青色", COLOR.CYAN, "老五"), SIXTH(5, "蓝色", COLOR.BLUE, "老六"), SEVENTH(6, "紫色", COLOR.PURPLE, "老七");
	
	private int number;
	private String colorName;
	private COLOR color;
	private String name;
	
	ONECAlABASH(int no, String colorName, COLOR color, String name){
		this.number = no;
		this.colorName = colorName;
		this.color = color;
		this.name = name;
	}
	int tellNo() {
    	return this.number;
    }
    String tellColorName() {
    	return this.colorName;
    }
    COLOR tellColor() {
    	return this.color;
    }
    String tellName() {
    	return this.name;
    }
	
}

class CalabashBrothers {
	ONECAlABASH[] sevenBrothers = new ONECAlABASH[7];
	CalabashBrothers() {		
		sevenBrothers[0] = ONECAlABASH.FIRST;
		sevenBrothers[1] = ONECAlABASH.SECOND;
		sevenBrothers[2] = ONECAlABASH.THIRD;
		sevenBrothers[3] = ONECAlABASH.FOURTH;
		sevenBrothers[4] = ONECAlABASH.FIFTH;
		sevenBrothers[5] = ONECAlABASH.SIXTH;
		sevenBrothers[6] = ONECAlABASH.SEVENTH;
	}
}
class Sort{
	int[] queue = new int[7];
	ONECAlABASH[] sevenBrothers = new ONECAlABASH[7];
	Sort(ONECAlABASH[] sevenBrothers){
		this.sevenBrothers = sevenBrothers;
	}
	
	private void initQueue() {
		queue[0] = 3;
		queue[1] = 1;
		queue[2] = 6;
		queue[3] = 2;
		queue[4] = 0;
		queue[5] = 4;
		queue[6] = 5;
	}
	void sortByNo() {
		initQueue();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6 - i; j++) {
				if (sevenBrothers[queue[j]].tellNo() > sevenBrothers[queue[j + 1]].tellNo()) {
					int tmp = queue[j];
					queue[j] = queue[j + 1];
					queue[j + 1] = tmp;
					System.out.println(sevenBrothers[queue[j + 1]].tellName() + ": "+ (j + 1) + " -> " + (j + 2));
					System.out.println(sevenBrothers[queue[j]].tellName() + ": "+ (j + 2) + " -> " + (j + 1));
				}
			}
		}
		for (int i = 0; i < 7; i++) {
			System.out.println(sevenBrothers[queue[i]].tellName());
		}
	}
	void sortByColor() {
		initQueue();
		for (int i = 0; i < 7 ;i++ ) {
			int tmp = queue[i];
			int left = 0;
			int right = i - 1;
			int middle = 0;
			while (left <= right) {
				middle = (left + right) / 2;
				if (sevenBrothers[queue[i]].tellColor().compareTo(sevenBrothers[queue[middle]].tellColor()) > 0) {
					left = middle + 1;
				}else {
					right = middle - 1;
				}
			}
			for (int j = i - 1; j >= left; j--) {
				queue[j+1] = queue[j];
				System.out.println(sevenBrothers[queue[j]].tellName() + ": "+ (j + 1) + " -> " + (j + 2));
			}
			if (left != i) {
				queue[left] = tmp;
				System.out.println(sevenBrothers[queue[left]].tellName() + ": "+ (i + 1) + " -> " + (left + 1));
			}
		}
		for (int i = 0; i < 7; i++) {
			System.out.println(sevenBrothers[queue[i]].tellColorName());
		}
	}
}
public class CalabashBrothersQueue {
	public static void main(String[] args) {
		CalabashBrothers ourCalabashBro = new CalabashBrothers();
		Sort sort = new Sort(ourCalabashBro.sevenBrothers);
		sort.sortByNo();
		sort.sortByColor();
		return;
	}
}
