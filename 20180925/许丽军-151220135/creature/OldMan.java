package creature;


import space.BatterGround;

public enum OldMan implements Creature, Cheerable {

    GRANDPA();

    OldMan(){}
    @Override
    public char getSymbol() {
        return 'Y';
    }

    @Override
    public void cheer(BatterGround batterGround, int x, int y) {
        batterGround.placeCreature(x, y, this);
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
