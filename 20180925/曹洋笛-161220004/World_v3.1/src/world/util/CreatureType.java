package world.util;

/**	
 *	生物的最细类别划分. <br>
 *	只要存在不同即为不同的种类，具有不同的enum
 *
 *	@author Mirror
 */
public enum CreatureType {
	Bro1("葫芦娃", "老大", "bro1"),
	Bro2("葫芦娃", "老二", "bro2"),
	Bro3("葫芦娃", "老三", "bro3"),
	Bro4("葫芦娃", "老四", "bro4"),
	Bro5("葫芦娃", "老五", "bro5"),
	Bro6("葫芦娃", "老六", "bro6"),
	Bro7("葫芦娃", "老七", "bro7"),
	Scorp("妖怪", "蝎子精", "scorp"),
	Mons("妖怪", "小喽啰", "mons"),
	Snk("啦啦队", "蛇精", "snk"),
	Eld("啦啦队", "老爷爷", "eld");
	
	public String rough; // 粗略类别名
	public String detail; // 细致类别名
	public String imgName; // 对应图片名
	
	/**	enum 的构造函数
	 *	@param rou 粗略类别名
	 *	@param det 细致类别名
	 *	@param nam 对应图片名 */
	private CreatureType(String rou, String det, String nam) {
		this.rough = rou;
		this.detail = det;
		this.imgName = nam;
	}
}
