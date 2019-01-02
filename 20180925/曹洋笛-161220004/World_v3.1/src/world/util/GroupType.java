package world.util;

/**	
 *	阵营类型（即共同移动的基本单位）
 * 
 *	@author Mirror
 */
public enum GroupType {

	Bro("葫芦娃"),
	Mon("妖怪"),
	Eld("老爷爷"),
	Snk("蛇精");

	public String name;
	private GroupType(String name) { // 构造方法
		this.name = name;
	}
}
