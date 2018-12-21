package creature;


import space.BatterGround;

public class Scorpion extends Monster implements Leadable {
    @Override
    public char getSymbol() {
        return 'X';
    }

    @Override
    public void lead(BatterGround batterGround, int x, int y) {
        batterGround.placeCreature(x, y, this);
    }
}
