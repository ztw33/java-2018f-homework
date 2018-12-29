public class Position {
    public int x;
    public int y;
    public Creature creature;

    public Position(int x, int y, Creature creature){
        this.x = x;
        this.y = y;
        this.creature = creature;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setCreature(Creature creature){this.creature = creature; }

}
