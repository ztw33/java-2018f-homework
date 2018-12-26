package confront;

import java.util.Random;

public class Lineup {
	private CalabashBro[] line;            //葫芦娃队列

	public Lineup() {
		line = new CalabashBro[7];
		for(int i = 0; i < 7; i++)
			line[i] = new CalabashBro(i + 1);
	}
	
	public void Randomsort() {                    //随机排序
		Random ran = new Random();
		for(int i = 0; i < 7; i++) {
			int getran = ran.nextInt(7);
			if(i != getran) {
				CalabashBro temp = line[getran];
				line[getran] = line[i];
				line[i] = temp;
			}
		}
	}
	
	public void Bubblesort() {                   //冒泡排序
		for(int i = 0; i < 7; i++)
		{
			for(int j = 0; j < 6 - i; j++)
			{
				if(line[j].getRank() > line[j + 1].getRank())
				{
					CalabashBro replace = line[j];
					line[j] = line[j + 1];
					line[j + 1] = replace;
				}
			}
		}
	}
	
	public void Insertsort() {                   //二分插入排序
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
				line[j + 1] = line[j];
			}
			line[left] = store;
		}
	}
	
	public CalabashBro[] getLine() {
		return line;
	}
}
