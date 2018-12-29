package world.creatures;

import world.util.CreatureType;

/**	
 *	人物抽象类
 *	
 *	@author Mirror
 *	
 *	@see type
 *	@see name
 *	@see symbol
 */
public class Creature {

	/**	人物类型 */
	protected CreatureType type;

	/**	人物名称 */
    protected String name; 

	/**	人物符号 */
    protected char symbol;

    protected Creature() {}
    private Creature(CreatureType t, String n, char s) {
    	type = t;
    	name = n;
    	symbol = s;
    }

	/**	得到人物类型 */
    public CreatureType getType() {
    	return type;
    }

	/**	得到人物名称 */
    public String getName() {
        return name;
    }

	/**	得到人物符号 */
    public char getSymbol() {
        return symbol;
    }
    
    public Creature copy() {
    	return new Creature(type, name, symbol);
    }
}
