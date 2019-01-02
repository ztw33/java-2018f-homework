package creature;

import space.BatterGround;

public interface Creature {
    char getSymbol();
    void moveTo(BatterGround ground, int x, int y);
    void leaveFrom(BatterGround ground, int x, int y);
}
