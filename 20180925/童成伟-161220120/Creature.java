package home3;

enum CalaName {红娃,橙娃,黄娃,绿娃,青娃,蓝娃,紫娃}

public class Creature {
	protected String name;
	protected int x, y;//战场中坐标
	
	public Creature() {
		name = null;
		x = y = -1;
	}
	
	public String getname() {
		return name;
	}
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
	public int setx(int x) {
		this.x = x;
		return this.x;
	}
	public int sety(int y) {
		this.y = y;
		return this.y;
	}
	
	public void GoBattle(Space space) {
		//if(space.isEmpty()) {
			space.setCreature(this);
		//}
	}
	
	public void LeaveBattle(Space space) {
		if(! space.isEmpty()) {
			space.removeCreature();
		}
	}
	
}

class Snake extends Creature{
	public Snake(){
		name = "蛇精";
		x = y = -1;
	}
	
	public Snake(int x, int y) {
		name = "蛇精";
		this.x=x;
		this.y=y;
	}
}

class Scorpion extends Creature{
	public Scorpion(){
		name = "蝎子精";
		x = y = -1;
	}
	public Scorpion(int x, int y) {
		name = "蝎子精";
		this.x=x;
		this.y=y;
	}
}

class Minion extends Creature{
	public Minion(){
		name = "喽啰";
		x = y = -1;
	}
	public Minion(int x, int y) {
		name = "喽啰";
		this.x=x;
		this.y=y;
	}
}

class Grandpa extends Creature{
	public Grandpa(){
		name = "爷爷";
		x = y = -1;
	}
	public Grandpa(int x, int y) {
		name = "爷爷";
		this.x=x;
		this.y=y;
	}
}

class Calabash extends Creature{//葫芦娃类
	
	private int rank;//排名
	
	public Calabash(CalaName name) {
		this.name = name.toString();
		this.rank = name.ordinal();
		x = y = -1;
	}
	
	public int getrank() {
		return rank;
	}
}
