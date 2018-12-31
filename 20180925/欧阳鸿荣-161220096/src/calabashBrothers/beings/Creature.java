package calabashBrothers.beings;

import calabashBrothers.beings.enums.CreatureType;

/**
 * @ Author     ：Young
 * @ Description：世界初生，有了生物
 */


public class Creature extends Beings {

    protected CreatureType type;

    public Creature(String name, CreatureType type) {
        super(name);
        this.type = type;
    }

    public void setType(CreatureType type) {
        this.type = type;
    }

    public CreatureType getType() {
        return type;
    }

    public void selfIntroduction() {
        System.out.println("我的种类是" + this.type.toString());
    }
}

