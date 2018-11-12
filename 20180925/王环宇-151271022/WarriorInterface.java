/*
 * 构造一个Warriors的接口，用于规范Warrior类的内容
 * 接口中的内容皆为抽象
 * */
package javahw3;

public interface WarriorInterface {	
	/*
	 * Methods: getName(), getFunction(), getPosition(), changePosition();
	 * */
	abstract public String getName();
	abstract public String getFunction();
	abstract public int[] getPosition();
	abstract public void changePosition(int m, int n);
}
