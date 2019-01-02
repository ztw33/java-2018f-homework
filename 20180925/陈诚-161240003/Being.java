package njucs.java2018;

public class Being {
    private String name;
    private Position position;

    Being() {
    }
    Being(String name) {
        this.name = name;
    }
    Being(String name, Position position) {
        this.name = name;
        this.position = position;
    }
    public String getName() {
        return name;
    }
    public void setName (String name) {
        this.name = name;
    }
    public Position getPosition () {
        return this.position;
    }
    public void setPosition (Position position) {
        this.position = position;
    }
}

class Position {
    private int x;
    private int y;

    Position() {
        x = -1;
        y = -1;
    }
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}

enum COLOR {
    RED("红色"), ORA("橙色"), YEL("黄色"), GRE("绿色"), CYA("青色"), BLU("蓝色"), PUR("紫色");
    String color;
    COLOR(String color) {
        this.color = color;
    }
}

class Calabash extends Being{
    private int rank;
    private COLOR color;
    Calabash(int rank) {
        this.rank = rank;
        switch(rank) {
            case 1: color = COLOR.RED; this.setName("老大"); break;
            case 2: color = COLOR.ORA; this.setName("老二"); break;
            case 3: color = COLOR.YEL; this.setName("老三"); break;
            case 4: color = COLOR.GRE; this.setName("老四"); break;
            case 5: color = COLOR.CYA; this.setName("老五"); break;
            case 6: color = COLOR.BLU; this.setName("老六"); break;
            case 7: color = COLOR.PUR; this.setName("老七"); break;
            default: System.out.println("WRONG RANK"); break;
        }
    }

    public COLOR getColor() {
        return color;
    }
    public int getRank() {
        return rank;
    }
}

class Grandpa extends Being {
    Grandpa(Position position) {
        super("爷爷", position);
    }
}

class Snake extends Being {
    Snake(Position position) {
        super("蛇精", position);
    }
}

class Scorpion extends Being {
    private Formation formation;
    Scorpion() {
        super("蝎子");
    }
    public void setFormation(String name) {
        formation = new Formation(name);
    }
    public Formation getFormation() {
        return this.formation;
    }
}

class Soldiers extends Being {
    Soldiers() {
        super("喽啰");
    }
}