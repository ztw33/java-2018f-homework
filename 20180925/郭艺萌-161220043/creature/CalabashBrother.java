package creature;

import java.util.Random;

public class CalabashBrother {
	private CalabashBody[] order;
	
	public CalabashBrother() {
		order = new CalabashBody[7];
		for (int i = 0; i < 7; i++) {
			order[i] = new CalabashBody(i);
		}
		randomOrder();
	}
	public CalabashBody[] getOrder() {
		return order;
	}
	
	public void swap(int p, int q, boolean isSort) {
		CalabashBody temp = order[p];
		order[p] = order[q];
		order[q] = temp;
	}
	
	public  void randomOrder() {
		Random count = new Random();
		for (int i = 0; i < count.nextInt(10)+3; i++) {
			Random p = new Random();
			Random q = new Random();
			swap(p.nextInt(7), q.nextInt(7), false);
		}
	}
	
	public void bubbleSort() {
		for (int i = 0; i < 7; i++) {
			for (int j = 1; j < 7-i; j++) {
				if (order[j-1].getNo() > order[j].getNo()) 
					swap(j-1, j, true);
			}
		}
	}
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
}