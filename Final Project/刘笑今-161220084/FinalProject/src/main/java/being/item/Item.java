package being.item;

import being.Being;
import position.Position;

public class Item extends Being {
    private String whichvalue;
    private int value;

    public Item(Position position, String name, char identifier, boolean faction, int value, String whichvalue){
        super(position, name, identifier, faction);
        this.value=value;
        this.whichvalue=whichvalue;
    }

    public int getValue() {
        return value;
    }

    public String getWhichvalue() {
        return whichvalue;
    }

}
