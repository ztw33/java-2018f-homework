package confront;

public class Formation {
	private Coordinate leader;        //领导点坐标（决定了阵型在战场中的位置）
	private int number;
	private Coordinate[] layout;      //阵型其他点相对于领导点的坐标
	
	public Formation(int c) {
		leader = null;
		number = c;
		layout = new Coordinate[number];
		for(int i = 0; i < number; i++)
			layout[i] = new Coordinate(-1,-1);
	}
	
	public Coordinate getLeader() {
		return leader;
	}
	
	public void setLeader(Coordinate a) {
		leader = a;
	}
	
	public Coordinate[] getLayout() {
		return layout;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int a) {
		number = a;
	}
	
	public void setLayout(String a) {          //根据不同的口令选取不同的阵型
		switch(a) {
		case "鹤翼":
			Coordinate[] temp0 = {new Coordinate(0,0), new Coordinate(-1,-1), new Coordinate(-2,-2), new Coordinate(-3,-3), new Coordinate(-1,1), new Coordinate(-2,2), new Coordinate(-3,3)};
			for(int i = 0; i < number; i++) layout[i].add(leader, temp0[i]);
			break;
		case "雁行":
			Coordinate[] temp1 = {new Coordinate(0,0), new Coordinate(-1,1), new Coordinate(-2,2), new Coordinate(-3,3), new Coordinate(-4,4), new Coordinate(-5,5), new Coordinate(-6,6)};
			for(int i = 0; i < number; i++) layout[i].add(leader, temp1[i]);
			break;
		case "衡轭":
			Coordinate[] temp2 = {new Coordinate(0,0), new Coordinate(-1,1), new Coordinate(-2,0), new Coordinate(-3,1), new Coordinate(-4,0), new Coordinate(-5,1), new Coordinate(-6,0)};
			for(int i = 0; i < number; i++) layout[i].add(leader, temp2[i]);
			break;
		case "长蛇":
			Coordinate[] temp3 = {new Coordinate(0,0), new Coordinate(-1,0), new Coordinate(-2,0), new Coordinate(-3,0), new Coordinate(-4,0), new Coordinate(-5,0), new Coordinate(-6,0)};
			for(int i = 0; i < number; i++) layout[i].add(leader, temp3[i]);
			break;
		case "鱼鳞":
			Coordinate[] temp4 = {new Coordinate(0,0), new Coordinate(-1,-2), new Coordinate(-1,0), new Coordinate(-1,2), new Coordinate(-2,-1), new Coordinate(-2,1), new Coordinate(-3,0)};
			for(int i = 0; i < number; i++) layout[i].add(leader, temp4[i]);
			break;
		case "方门":
			Coordinate[] temp5 = {new Coordinate(0,0), new Coordinate(-1,-1), new Coordinate(-1,1), new Coordinate(-2,-2), new Coordinate(-2,2), new Coordinate(-3,-1), new Coordinate(-3,1)};
			for(int i = 0; i < number; i++) layout[i].add(leader, temp5[i]);
			break;
		case "偃月":
			Coordinate[] temp6 = {new Coordinate(0,0), new Coordinate(0,1), new Coordinate(1,2), new Coordinate(-1,2), new Coordinate(0,3), new Coordinate(1,4), new Coordinate(-1,4)};
			for(int i = 0; i < number; i++) layout[i].add(leader, temp6[i]);
			break;
		case "锋矢":
			Coordinate[] temp7 = {new Coordinate(0,0), new Coordinate(1,-1), new Coordinate(1,0), new Coordinate(1,1), new Coordinate(2,-2), new Coordinate(2,0), new Coordinate(2,2)};
			for(int i = 0; i < number; i++) layout[i].add(leader, temp7[i]);
			break;
		}
	}
}

class Coordinate {
	private int x;
	private int y;
	
	public Coordinate() {
		x = -1;
		y = -1;
	}
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void add(Coordinate a, Coordinate b){
		x = a.getX() + b.getX();
		y = a.getY() + b.getY();
	}
}
