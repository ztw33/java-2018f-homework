package World;

import Creature.Creature;

public class Contain {
    protected  boolean exist;//是否有人
    protected Creature character;
    Contain(){
        this.exist=false;
    }
    public Creature getCharacter() {
        return character;
    }

    public void setCharacter(Creature character) {
        this.character = character;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }
}
