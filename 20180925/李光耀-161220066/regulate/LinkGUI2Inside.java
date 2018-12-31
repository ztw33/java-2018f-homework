package regulate;

import space.Board;

/**
* @ClassName: LinkGUI2Inside
* @Description: 定义了UI和内部事务相互通信的基本规约
* @author 13745
* @date 2018年11月4日
*
*/
public interface LinkGUI2Inside {
	public void getputNextMonsterFormation();
	public void getputHuLuFormation();
	public void putGrandPa();
	public void putSnake();
	public void moveRightManual(Class<?> c);
	public void moveLeftManual(Class<?> c);
	public void moveUpManual(Class<?> c);
	public void moveDownManual(Class<?> c);
	public Board getBoard(); 
	public void clearHuLuWas();
	public void clearMonsters();
}
