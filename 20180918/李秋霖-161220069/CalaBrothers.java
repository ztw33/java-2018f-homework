package CalabashBrothers;

import java.util.Random;

public class CalaBrothers {

	private Calabash[] brothers = new Calabash[7];

	public CalaBrothers() {
		super();
		for (COLOR c : COLOR.values()) {
			brothers[c.ordinal()] = new Calabash(c);
		}
	}

	public void makeRandom() {
		Random ran = new Random();
		int tmpidx;
		Calabash tmp;
		for (int i = 0; i < 7; i++) {
			tmpidx = ran.nextInt(7);
			tmp = brothers[tmpidx];
			brothers[tmpidx] = brothers[i];
			brothers[i] = tmp;
		}
		// showBrothers();
	}

	public void showBrothers() {
		for (Calabash bro : brothers) {
			bro.printSign();
			System.out.print(" ");
		}
		System.out.println("");
	}

	public void exchangePos(int i, int j) {
		Calabash tmp;
		tmp = brothers[i];
		brothers[i] = brothers[j];
		brothers[j] = tmp;
		brothers[i].printName();
		System.out.println(":" + i + "->" + j);
		brothers[j].printName();
		System.out.println("£º" + j + "->" + i);
	}

	public void bubbleSort() {
		for (int i = 5; i > 0; i--) {
			for (int j = 0; j <= i; j++) {
				if (brothers[j].getValue() > brothers[j + 1].getValue()) {
					exchangePos(j, j + 1);
				}
			}
		}
		System.out.println("The result of Bubble Sort:");
		showBrothers();
	}

	public void binaryInsert(int i, int j, int pos) {
		if (i == j) {
			for (int m = pos - 1; m >= i; m--) {
				exchangePos(m, m + 1);
			}
			return;
		}
		if (brothers[(i + j) / 2].getValue() > brothers[pos].getValue()) {
			binaryInsert(i, (i + j) / 2, pos);
		} else
			binaryInsert((i + j) / 2 + 1, j, pos);
	}

	public void binarySort() {
		for (int i = 1; i < 7; i++) {
			binaryInsert(0, i, i);
		}
		System.out.println("The result of Binary Sort:");
		showBrothers();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalaBrothers cala = new CalaBrothers();
		cala.makeRandom();
		cala.bubbleSort();
		cala.makeRandom();
		cala.binarySort();
	}

}
