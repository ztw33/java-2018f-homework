/*
 * 构造一个Warriors的接口，用于规范Warrior类的内容
 * 接口中的内容皆为抽象
 * */

public interface WarriorInterface {	
	/*
	 * Methods: getName(), getFunction(), getPosition(), changePosition();
	 * */
	abstract public String toString();
	abstract public void showMe();
	
	abstract public String getName();
	
	abstract public String getFunction();
	abstract public void changeFunction(String function);
	
	abstract public int[] getPosition();
	abstract public void changePosition(int m, int n);
	
	abstract public String getTeam();
	abstract public void changeTeam(String team);
}
