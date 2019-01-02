package creature;

public class Creature {
    protected int coorX;
    protected int coorY;
    protected String name;

    /**
     * 用来标示生物属性，true为好，false为坏
     */
    protected boolean kind;
    /**
     * 用来在控制台等地表示属性，也可以用来做标示
     */
    protected char symbolForCrea;

    public boolean isKind() {
        return kind;
    }

    public int getCoorX() {
        return coorX;
    }

    public int getCoorY() {
        return coorY;
    }

    public char getSymbolForCrea() {
        return symbolForCrea;
    }

    public String getName() {
        return name;
    }

    /**
     * 设置坐标函数
     */
    public void moveToGoal(int coorX, int coorY) {
        this.coorX = coorX;
        this.coorY = coorY;
        System.out.println(name + "says: " + name + "move to Goal (" + coorX + "," + coorY + ")");
    }
}