package space;

import java.util.Random;
import creature.*;
import formation.Formation;

public class CalabashWorld {
	
	private static final int BATTLEFIELD_ROW = 15;
	private static final int BATTLEFIELD_COLUMN = 15;
	private static final int MINIONS_NUM = 7;
	
	private BattleField battleField;
	
	private CalabashBrother[] brothers;
	private Grandpa grandpa;
	private Scorpion scorpion;
	private Snake snake;
	private Minion[] minions = new Minion[MINIONS_NUM];
	
	public CalabashWorld() {
		// TODO Auto-generated constructor stub
		
		battleField = new BattleField(BATTLEFIELD_ROW, BATTLEFIELD_COLUMN);
		initBrothers();
		grandpa = new Grandpa();
		scorpion = new Scorpion();
		snake = new Snake();
		for (int i = 0; i < MINIONS_NUM; i++) {
			minions[i] = new Minion();
		}
	}
	
	private void initBrothers() {
		CalabashBrother theOldest = new CalabashBrother(1, "老大", COLOR.RED);
		CalabashBrother theSecond = new CalabashBrother(2, "老二", COLOR.ORANGE);
		CalabashBrother theThird = new CalabashBrother(3, "老三", COLOR.YELLOW);
		CalabashBrother theForth = new CalabashBrother(4, "老四", COLOR.GREEN);
		CalabashBrother theFifth = new CalabashBrother(5, "老五", COLOR.CYAN);
		CalabashBrother theSixth = new CalabashBrother(6, "老六", COLOR.BLUE);
		CalabashBrother theYoungest = new CalabashBrother(7, "老七", COLOR.PURPLE);		
		
		brothers = new CalabashBrother[]{theOldest, theSecond, theThird, theForth, theFifth, theSixth, theYoungest};
	}
	
	public void brothersShuffle() {
		// 葫芦娃乱序
		int length = brothers.length;
        for ( int i = length; i > 0; i-- ) {
        	Random random = new Random();
            int randInd = random.nextInt(i);
            swap(brothers, randInd, i - 1);
        }
        System.out.println("葫芦娃乱序：");
        for(CalabashBrother k : brothers) {
        	System.out.print(k.getName() + " ");
        }
        System.out.println();
	}	
	
	public static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
	
	public void brothersSort() {
		// 冒泡排序
		for (int i = brothers.length; i > 0 ; i--) {
			for (int j = 0; j < i-1; j++) {
				if (brothers[j].getRank() > brothers[j+1].getRank()) {
					swap(brothers, j, j + 1);				
				}
			}
		}
		System.out.println("葫芦娃排序：");
        for(CalabashBrother k : brothers) {
        	System.out.print(k.getName() + " ");
        }
        System.out.println();
	}

	public void displayField() {
		System.out.print(battleField);
	}
	
	public void setBrothers(Formation formation, int startRow, int startColumn) {
		formation.conjure(battleField, brothers, startRow, startColumn);
	}
	
	public void setMonsters(Formation formation, int startRow, int startColumn) {
		Bad[] bads = new Bad[MINIONS_NUM + 1];
		for (int i = 0; i < MINIONS_NUM; i++) {
			bads[i] = minions[i];
		}
		bads[MINIONS_NUM] = scorpion;
		
		formation.conjure(battleField, bads, startRow, startColumn);
	}
	
	public void setCheerleaders() {
		Random random = new Random();
		while(true) {
			int randRow = random.nextInt(BATTLEFIELD_ROW);
	        int randColumn = random.nextInt(BATTLEFIELD_COLUMN / 2);
	        if (battleField.setCreatrue(grandpa, randRow, randColumn)) {
	        	break;
	        }
		}
		while(true) {
			int randRow = random.nextInt(BATTLEFIELD_ROW);
	        int randColumn = random.nextInt((BATTLEFIELD_COLUMN+1)/2) + BATTLEFIELD_COLUMN/2;
	        if (battleField.setCreatrue(snake, randRow, randColumn)) {
	        	break;
	        }
		}
	}

	public void clearBattleField() {
		battleField.clear();
	}
	
}
