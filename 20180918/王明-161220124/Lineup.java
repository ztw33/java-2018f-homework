package calabash;

public class Lineup {
	private CalabashBro[] line;
	
	public void RandomLineup() {
		line = new CalabashBro[7];
		line[0] = CalabashBro.BLUE;line[0].setPos(0);
		line[1] = CalabashBro.CYAN;line[1].setPos(1);
		line[2] = CalabashBro.RED;line[2].setPos(2);
		line[3] = CalabashBro.PURPLE;line[3].setPos(3);
		line[4] = CalabashBro.YELLOW;line[4].setPos(4);
		line[5] = CalabashBro.GREEN;line[5].setPos(5);
		line[6] = CalabashBro.ORANGE;line[6].setPos(6);
	}
	
	public void Bubblesort() {
		for(int i = 0; i < 7; i++)
		{
			for(int j = 0; j < 6 - i; j++)
			{
				if(line[j].getRank() > line[j + 1].getRank())
				{
					System.out.println(line[j].getCodename() + ':' + line[j].getPos() + "->" + line[j + 1].getPos());
					System.out.println(line[j + 1].getCodename() + ':' + line[j + 1].getPos() + "->" + line[j].getPos());
					CalabashBro replace = line[j];
					line[j] = line[j + 1];
					line[j + 1] = replace;
					line[j].setPos(j);
					line[j + 1].setPos(j + 1);
				}
			}
		}
	}
	
	public void Insertsort() {
		CalabashBro store;
		int left, right, mid;
		for(int i = 1; i < 7; i++) {
			store = line[i];
			left = 0;
			right = i - 1;
			mid = 0;
			while(left <= right) {
				mid = (left + right) / 2;
				if(line[mid].getRank() > store.getRank()) {
					right = mid - 1;
				}else {
					left = mid + 1;
				}
			}
			for(int j = i - 1; j >= left; j--) {
				System.out.println(line[j].getCodename() + ':' + line[j].getPos() + "->" + line[j + 1].getPos());
				line[j + 1] = line[j];
				line[j + 1].setPos(j + 1);
			}
			System.out.println(store.getCodename() + ':' + store.getPos() + "->" + left);
			line[left] = store;
			line[left].setPos(left);
		}
	}
	
	public void ReportCodename() {
		for(int i = 0; i < 7; i++)
			System.out.println(line[i].getCodename());
	}
	
	public void ReportColor() {
		for(int i = 0; i < 7; i++)
			System.out.println(line[i].getColor());
	}
	
	public static void main(String[] args) {
		Lineup brothers = new Lineup();
		
		brothers.RandomLineup();
		System.out.println("初始序列：");
		brothers.ReportCodename();
		System.out.println("冒泡排序过程：");
		brothers.Bubblesort();
		System.out.println("排队报数：");
		brothers.ReportCodename();
		
		brothers.RandomLineup();
		System.out.println("初始序列：");
		brothers.ReportColor();
		System.out.println("颜色二分排序过程：");
		brothers.Insertsort();
		System.out.println("排队报数：");
		brothers.ReportColor();
	}
}
