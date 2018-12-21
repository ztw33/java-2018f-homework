package world.util;

import world.creatures.*;

/**	
 *	生物的最细类别划分. <br>
 *	只要存在不同即为不同的种类，具有不同的enum
 *
 *	@author Mirror
 */
public enum CreatureType {
	Bro1("Bro1", "老大", "bro1"),
	Bro2("Bro2", "老二", "bro2"),
	Bro3("Bro3", "老三", "bro3"),
	Bro4("Bro4", "老四", "bro4"),
	Bro5("Bro5", "老五", "bro5"),
	Bro6("Bro6", "老六", "bro6"),
	Bro7("Bro7", "老七", "bro7"),
	Scorp("Scorp", "蝎子精", "scorp"),
	Mons("Mons", "小喽啰", "mons"),
	Snk("Snk", "蛇精", "snk"),
	Eld("Eld", "老爷爷", "eld");
	
	public String label; // xml标签
	public String detail; // 细致类别名
	public String imgName; // 对应图片名
	
	/**	enum 的构造函数
	 *	@param rou 粗略类别名
	 *	@param det 细致类别名
	 *	@param nam 对应图片名 */
	private CreatureType(String lab, String det, String nam) {
		this.label = lab;
		this.detail = det;
		this.imgName = nam;
	}
	
	/**	@return 对应的阵营 */
	public GroupType group() {
		switch (this) {
		case Mons: case Scorp: case Snk: return GroupType.Mon;
		default: return GroupType.Bro;
		}
	}
	
	/**	@return 对应的人物对象 */
	public Creature getCreature() {
		switch (this) {
		case Bro1: return new Brothers(0);
		case Bro2: return new Brothers(1);
		case Bro3: return new Brothers(2);
		case Bro4: return new Brothers(3);
		case Bro5: return new Brothers(4);
		case Bro6: return new Brothers(5);
		case Bro7: return new Brothers(6);
		case Scorp: return new Scorpion();
		case Mons: return new Monsters();
		case Snk: return new Snake();
		case Eld: return new Elder();
		default: return null;
		}
	}
}
