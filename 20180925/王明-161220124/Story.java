package confront;

public class Story {
	private Lineup lineup;                     //葫芦娃队列
	private Grandpa grandpa;                   //老爷爷
	private DemonSnake demonsnake;             //蛇精
	private DemonScorpion demonscorpion;       //蝎子精
	private Lackey[] lackey;                   //小喽啰队列
	private Battleground battleground;         //战场
	private Formation formation1;              //阵型1（好人使用）
	private Formation formation2;              //阵型2（坏人使用）
	
	public Story() {
		lineup = new Lineup();
		grandpa = new Grandpa();
		demonsnake = new DemonSnake();
		demonscorpion = new DemonScorpion();
		lackey = new Lackey[6];
		for(int i = 0; i < 6; i++)
			lackey[i] = new Lackey();
		battleground = new Battleground(20);
		formation1 = new Formation(7);
		formation2 = new Formation(7);
	}
	
	public void CalabashBroShowup(Coordinate c, String a) {
		lineup.Randomsort();
		lineup.Bubblesort();
		lineup.getLine()[0].SetLeaderground(c, formation1);
		lineup.getLine()[0].GiveOrder(a, formation1);
		for(int i = 0; i < 7; i++)
			lineup.getLine()[i].GotoBattleground(battleground, formation1);
	}
	
	public void GrandpaShowup(Coordinate c) {
		grandpa.Lookatside(battleground, c);
	}
	
	public void LackeyShowup(Coordinate c, String a) {
		demonscorpion.SetLeaderground(c, formation2);
		demonscorpion.GiveOrder(a, formation2);
		demonscorpion.GotoBattleground(battleground, formation2);
		for(int i = 0; i < 6; i++)
			lackey[i].GotoBattleground(battleground, formation2);
	}
	
	public void DemonSnakeShowup(Coordinate c) {
		demonsnake.Lookatside(battleground, c);
	}
	
	public void AllLeaveaway() {
		for(int i = 0; i < 7; i++)
			lineup.getLine()[i].LeaveBattleground(battleground);
		grandpa.LeaveBattleground(battleground);
		demonscorpion.LeaveBattleground(battleground);
		for(int i = 0; i < 6; i++)
			lackey[i].LeaveBattleground(battleground);
		demonsnake.LeaveBattleground(battleground);
	}
	
	public void tell() {
		System.out.println("一天葫芦娃与妖精们在峡谷中遭遇\n");
		System.out.println("双方第一次排兵布阵\n");
		CalabashBroShowup(new Coordinate(12,5), "长蛇");
		LackeyShowup(new Coordinate(7,13), "锋矢");
		GrandpaShowup(new Coordinate(9,1));
		DemonSnakeShowup(new Coordinate(9,18));
		battleground.show();
		AllLeaveaway();
		
		System.out.println("双方第二次排兵布阵\n");
		CalabashBroShowup(new Coordinate(12,2), "雁行");
		LackeyShowup(new Coordinate(12,13), "衡轭");
		GrandpaShowup(new Coordinate(9,1));
		DemonSnakeShowup(new Coordinate(9,18));
		battleground.show();
		AllLeaveaway();
	}
	
	public static void main(String[] args) {
		Story story = new Story();
		story.tell();
	}
}
