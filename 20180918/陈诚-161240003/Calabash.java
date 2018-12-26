package njucs.java2018;

enum COLOR {
    RED("红色"), ORA("橙色"), YEL("黄色"), GRE("绿色"), CYA("青色"), BLU("蓝色"), PUR("紫色");
    String color;
    COLOR(String color) {
        this.color = color;
    }
}

public class Calabash {
    private int rank;
    private COLOR color;
    private String name;
    Calabash(int rank) {
        this.rank = rank;
        switch(rank) {
            case 1:
                color = COLOR.RED;
                name = "老大";
                break;
            case 2:
                color = COLOR.ORA;
                name = "老二";
                break;
            case 3:
                color = COLOR.YEL;
                name = "老三";
                break;
            case 4:
                color = COLOR.GRE;
                name = "老四";
                break;
            case 5:
                color = COLOR.CYA;
                name = "老五";
                break;
            case 6:
                color = COLOR.BLU;
                name = "老六";
                break;
            case 7:
                color = COLOR.PUR;
                name = "老七";
                break;
            default:
                System.out.println("WRONG RANK");
                break;
        }
    }

    public COLOR getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }
}