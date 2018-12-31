package creature;

import space.BatterGround;

public class Monster implements Creature {
    @Override
    public char getSymbol() {
        return '*';
    }

    @Override
    public void moveTo(BatterGround ground, int x, int y) {
        ground.placeCreature(x, y, this);
    }

    @Override
    public void leaveFrom(BatterGround ground, int x, int y) {
        ground.clearCreature(x, y);
    }
}
