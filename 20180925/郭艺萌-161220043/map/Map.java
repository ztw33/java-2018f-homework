package map;

import creature.*;
import formation.*;

public class Map {
	
	private int row, col;               //大小
	private Position[][] pos;           //位置
	private CalabashBrother brothers;   //葫芦兄弟
	private GrandFather grandpa;        //爷爷
	private Minion[] minions;           //若干小喽啰
	private SnakeMonster snake;         //蛇精
	private ScorpionMonster scorpion;   //蝎子精
	
	//初始化地图   建造整个地图的位置信息以及必须有的生物
	public Map(int row, int col) {
		this.row = row;
		this.col = col;
		//位置
		pos = new Position[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				pos[i][j] = new Position(i, j);
			}
		}
		
		//生物
		brothers = new CalabashBrother();
		
		grandpa = new GrandFather();
		
		minions = new Minion[19];
		for (int i = 0; i < minions.length; i++) {
			minions[i] = new Minion(i+1);
		}
		
		snake = new SnakeMonster();
		
		scorpion = new ScorpionMonster();
	}

	//获取信息
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	public Position[][] getPos() {
		return pos;
	}
	public CalabashBrother getBrother() {
		return brothers;
	}
	public GrandFather getGrandpa() {
		return grandpa;
	}
	public Minion[] getMinions() {
		return minions;
	}
	public SnakeMonster getSnake() {
		return snake;
	}
	public ScorpionMonster getScorpion() {
		return scorpion;
	}
	
	public boolean canStand(int x, int y) {
		if (x < 0 || x >= row) {
			return false;
		}
		if (y < 0 || y >= col) {
			return false;
		}
		if (pos[x][y].getIsSet()) { //检查不越界后再检查是否能站队
			return false;
		}		
		return true;
	}
	public boolean canRemove(int x, int y) {
		if (x < 0 || x >= row) {
			return false;
		}
		if (y < 0 || y >= col) {
			return false;
		}
		if (!pos[x][y].getIsSet()) { 
			return false;
		}		
		return true;
	}
	
	//输出位置上的生物
	public void printMap() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				Creature curCre = pos[i][j].getCreature();
				if (curCre instanceof CalabashBody) {
					System.out.print('&');
				} else if (curCre instanceof GrandFather) {
					System.out.print('#');
				} else if (curCre instanceof ScorpionMonster) {
					System.out.print('$');
				} else if (curCre instanceof Minion) {
					System.out.print('*');
				} else if (curCre instanceof SnakeMonster) {
					System.out.print('@');
				} else {
					System.out.print('-');
				}
			}
			System.out.println();
		}	
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		Map map = new Map(10, 20);
		//葫芦娃排成长蛇阵
		SingleLine changSheZhen = new SingleLine();
		map.getBrother().bubbleSort();  //乱序葫芦娃排序
		changSheZhen.form(map, map.getBrother().getOrder(), 0, 2);
		
		//放置爷爷
		map.getGrandpa().cheer(map, 3, 4);
		
		//放置蝎子精
		map.getScorpion().lead(map, 0, 18);
		
		//小喽啰排成雁行阵
		EnEchelon yanXingZhen = new EnEchelon();
		yanXingZhen.form(map, map.getMinions(), 1, 17);
		
		//放置蛇精
		map.getSnake().cheer(map, 4, 16);
		
		map.printMap();
		
		//小喽啰解散雁行阵
		yanXingZhen.loose(map, map.getMinions(), 1, 17);
		
		//小喽啰再次排成衡轭阵
		Yoke hengEZhen = new Yoke();
		hengEZhen.form(map, map.getMinions(), 1, 19);
		
		map.printMap();
	}

}
