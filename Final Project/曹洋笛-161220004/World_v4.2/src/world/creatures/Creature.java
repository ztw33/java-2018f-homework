package world.creatures;

import world.util.*;

/**	
 *	人物类
 *	
 *	@author Mirror
 *	
 *	@see #type
 *	@see #getGroup()
 */
public class Creature {

	/**	人物类型	*/
	protected CreatureType type;

	/**	人物名称	*/
    protected String name; 

	/**	人物符号	*/
    protected char symbol;

    protected Creature() {}
    private Creature(CreatureType t, String n, char s) {
    	type = t;
    	name = n;
    	symbol = s;
    }

	/**	得到人物类型	*/
    public CreatureType getType() {
    	return type;
    }

	/**	得到人物阵营	*/
    public GroupType getGroup() {
    	return type.group();
    }

	/**	得到人物名称	*/
    public String getName() {
        return name;
    }

	/**	得到人物符号	*/
    public char getSymbol() {
        return symbol;
    }
    
    /**	复制，便于赋值	*/
    public Creature copy() {
    	return new Creature(type, name, symbol);
    }
    
    @Override
    public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof Creature) {
			Creature c = (Creature) obj;
			return (this.type == c.type);
		}
		return false;
    }
}
