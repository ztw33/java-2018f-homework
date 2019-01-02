public class Creature {
    private String name;
    private int type;
    Creature() {
        name = "  ";
        type = 0;
    }

    public void Print() {
        System.out.print(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
