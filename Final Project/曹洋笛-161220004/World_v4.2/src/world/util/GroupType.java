package world.util;

/**	
 *	阵营类型（即共同移动的基本单位）
 * 
 *	@author Mirror
 */
public enum GroupType {

	Bro("葫芦娃"),
	Mon("妖怪");

	public String label;
	private GroupType(String lab) { // 构造方法
		this.label = lab;
	}
}
