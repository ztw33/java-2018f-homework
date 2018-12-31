package world.creatures;

/* 人物抽象类 */

public abstract class Creature {

    protected String name; // 人物名称

    protected char symbol; // 显示符号

    protected Creature() {}
    
    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
}
