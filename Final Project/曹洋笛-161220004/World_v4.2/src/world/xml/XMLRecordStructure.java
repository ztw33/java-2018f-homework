package world.xml;

import world.*;
import world.util.*;

/**
 *	用于缓存xml结构的文件内容.<br>
 *	结构形如：<br>
 *	<records>
 *		<entity1000 ctype="Bro" r="10" c="4" />
 *			<round1 state="LIVE" posr="12" posc="3" dr="0" dc="1" enemy="null" win="false" />
 *			<round2 ... />
 *			<round3 ... />
 *		<entity1017 ... />
 *		<entity1034 ... />
 *	</records>
 *
 *	@author Mirror
 */
public class XMLRecordStructure {

	// 以下为各节点名String
	protected static final String records = "records"; // 根
	protected static final String entity = "entity"; // 第一层子节点
	protected static final String ctype = "ctype"; // Entity -> creature -> type
	protected static final String r = "r"; // Entity初始位置
	protected static final String c = "c"; // Entity初始位置
	protected static final String round = "round"; // 第二层子节点
	protected static final String state = "state"; // Entity -> state
	protected static final String posr = "posr"; // Entity -> position -> row
	protected static final String posc = "posc"; // Entity -> position -> col
	protected static final String dr = "dr"; // Entity -> direction -> row
	protected static final String dc = "dc"; // Entity -> direction -> col
	protected static final String enemy = "enemy"; // Entity -> enemy
	protected static final String win = "win"; // Entity -> hasWined
	
	/**	@return 对应的标签字符串 */
	protected static String toBooleanLabel(boolean bool) {
		return ((bool) ? ("true") : ("false"));
	}

	/**	@return 对应的boolean值 */
	protected static boolean toBoolean(String label) {
		return ((label == "true") ? (true) : (false));
	}

	/**	@return 对应的人物类型 */
	protected static CreatureType toCreatureType(String label) {
		switch (label) {
		case "Bro1": return CreatureType.Bro1;
		case "Bro2": return CreatureType.Bro2;
		case "Bro3": return CreatureType.Bro3;
		case "Bro4": return CreatureType.Bro4;
		case "Bro5": return CreatureType.Bro5;
		case "Bro6": return CreatureType.Bro6;
		case "Bro7": return CreatureType.Bro7;
		case "Scorp": return CreatureType.Scorp;
		case "Mons": return CreatureType.Mons;
		case "Snk": return CreatureType.Snk;
		case "Eld": return CreatureType.Eld;
		default: return null;
		}
	}

	/**	@return 对应的状态值 */
	protected static EntityState toEntityState(String label) {
		switch (label) {
		case "LIVE": return EntityState.LIVE;
		case "DEAD": return EntityState.DEAD;
		default: return EntityState.OUT;
		}
	}
	
	/**	@return 对应的敌方实体对象指针	*/
	protected static Entity toEnemy(String label) {
		if (label.equals("null")) 
			return null;
		else // label为entities集合的id号
			return CoreWorld.entities.get(Integer.parseInt(label));
	}

	/**	@return 对应的敌方对象字符串 */
	protected static String toEntityLabel(Entity ene) {
		if (ene == null)
			return "null";
		else
			return String.valueOf(ene.id);
	}

}
