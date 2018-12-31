/*
 * 在Warriors接口的要求下，构造一个Warrior类，用于对双方战士的描述
 * @see class Warrior
 * @author why
 * @Time 2018-9-27
 * @version 1.0
 * 
 * */
package javahw3;

public class Warrior implements Warriors {
	/*
	 * Variables: name, function, position, team;
	 * Methods: getName(), getFunction(), getPosition(), changePosition(), toString(), showMe();
	 * */
	private String name;
	private String function;
	private int[] position;
	private String team;
	
	public Warrior(String name, String function, int team) {
		this.name = name;
		this.function = function;
		if(team==1)
			this.team = "GoodMan";
		else
			this.team = "BadMan";
		position = new int[2];
	}
	
	public String getName() {
		return name;
	}

	public String getFunction() {
		return function;
	}

	public int[] getPosition() {
		return position;
	}

	public void changePosition(int m, int n) {
		position[0] = m;
		position[1] = n;
	}
	//重载自带的toString函数，用于System.out的调用
	public String toString() {
		return name;
	}
	//自定义显示函数，打印出对象的所有关键信息
	public void showMe() {
		System.out.println(name+" team:"+team+" ["+position[0]+","+position[1]+"]");
	}
	
}
