package calabashBrothers;

/**
 * @ Author     ：Young
 * @ Description：世界初生，有了生物
 */
enum CreatureType{
    HUMAN_BEING, CALABASH_BOY, MONSTER, MONSTER_LEADER;
}

class Creature extends Beings{
    CreatureType type;

    public Creature(String name, CreatureType type) {
        super(name);
        this.type = type;
    }

    @Override
    public void selfIntroduction() {
        super.selfIntroduction();
        System.out.println("我的种类是"+this.type.toString());
    }
}

