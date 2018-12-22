/*
 * 在Warriors接口的要求下，构造一个Warrior类，在这个世界中存活的所有生物
 * 都是Warrior，但却又有不同的功能
 * */

public class Warrior implements WarriorInterface{
	/*
	 * Variables: name, function, position, team;
	 * Methods: getName(), getFunction(), getPosition(), changePosition(), toString(), showMe();
	 * */
	private String name;
	private String function;
	private int[] position;
	private String team;
	
	public Warrior(String name, String function, String team) {
		this.name = name;
		this.function = function;
		this.team = team;
		position = new int[2];
	}
	
	
	public String getName() {
		return name;
	}
	public String getFunction() {
		return function;
	}
	public void changeFunction(String function) {
		this.function = function;
	}
	public int[] getPosition() {
		return position;
	}
	public void changePosition(int m, int n) {
		position[0] = m;
		position[1] = n;
	}
	public String getTeam() {
		return team;
	}
	public void changeTeam(String team) {
		this.team = team;
	}

	//重载自带的toString函数，用于System.out的调用
	public String toString() {
		return name;
	}
	//自定义显示函数，打印出对象的所有关键信息
	public void showMe() {
		System.out.println(name+" team:"+team+" "+function+" ["+position[0]+","+position[1]+"]");
	}
	
}
