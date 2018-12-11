package creature;

import space.BatterGround;

public class Snake extends Monster implements Cheerable {
    @Override
    public char getSymbol() {
        return 'S';
    }

    @Override
    public void cheer(BatterGround batterGround, int x, int y) {
        batterGround.placeCreature(x, y, this);
    }
}
