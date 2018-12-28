package CalabashBrothers;

import java.util.Scanner;

public class Battle {
	final static int FieldSize = 15;
	public static char [][]Field = new char[FieldSize][FieldSize];	//战场
	public static Calabashbrother[] AllBrothers = new Calabashbrother[7];	//葫芦兄弟对象
	public static Grandpa grandpa;	//爷爷对象
	public static Minions[] minions;//小兵对象
	public static SnakeQueen snake;	//蛇精对象
	public static Scorpion scorpion;//蝎子精对象
	public static Scanner in;		//选择阵法
	
	public static void FieldInit() {	//战场初始化
		for(int i = 0; i < FieldSize; i++)
			for(int j = 0; j < FieldSize; j++)
				Field[i][j] = '*';
	}
	public static void CalabashLineup() {	//葫芦兄弟列阵
		Rank[] OriginQueue = {Rank.Fifth, Rank.First, Rank.Fourth, Rank.Second, Rank.Seventh, Rank.Sixth, Rank.Third};
		for(int i = 0; i < 7; i++)
			AllBrothers[i] = new Calabashbrother(OriginQueue[i], i + 2, 2);
		CalabashBrothersSort.BubbleSort(AllBrothers);//排序
		for(int i = 0; i < 7; i++)
			Field[i + 2][2] = AllBrothers[i].CreatureType;
	}
	
	public static void GrandpaJoin() {	//爷爷加入
		grandpa = new Grandpa(9,1);
		Field[9][1] = grandpa.CreatureType;
		System.out.println("爷爷：孩儿们加油，打倒他们！\n");
	}
	
	public static void MinionsSpawn() {	//小兵和蝎子精列阵
		Lineup MinionsLineup = new Lineup();
		in = new Scanner(System.in);
		MinionsLineup.LineupType = in.nextInt();
		MinionsLineup.LineupAccordingToType();
		int count = MinionsLineup.MinionsNumber;
		minions = new Minions[count];
		for(int i = 0; i < count; i++) {
			minions[i] = new Minions(MinionsLineup.MinionsRow[i], MinionsLineup.MinionsCol[i]);
			Field[MinionsLineup.MinionsRow[i]][MinionsLineup.MinionsCol[i]] = minions[i].CreatureType;
		}
		scorpion = new Scorpion(MinionsLineup.ScorpionRow, MinionsLineup.ScorpionCol);
		Field[MinionsLineup.ScorpionRow][MinionsLineup.ScorpionCol] = scorpion.CreatureType;
	}
	
	public static void SnakeQueenJoin() {	//蛇精加入
		snake = new SnakeQueen(1,14);
		Field[1][14] = snake.CreatureType;
		System.out.println("蛇精：蝎子大王，拿下他们！\n");
	}
	
	public static void PrintAllCreature() {	//显示对峙局面
		for(int i = 0; i < FieldSize; i++) {
			for(int j = 0; j < FieldSize; j++)
				System.out.print(Field[i][j] + " ");
			System.out.println("\t");
		}
	}

	public static void main(String[] argvs) {//主函数入口
		for(int i = 0; i <= 1; i++) { //两次列阵
			FieldInit();
			CalabashLineup();
			System.out.println("输入1-8选择一种小兵阵法\n");
			MinionsSpawn();
			GrandpaJoin();
			SnakeQueenJoin();
			PrintAllCreature();
		}
	}
}