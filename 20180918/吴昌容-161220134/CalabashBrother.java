package wcr;

enum Color {
    RED("红色"),
    ORANGE("橙色"),
    YELLOW("黄色"),
    GREEN("绿色"),
    CYAN("青色"),
    BLUE("蓝色"),
    PURPLE("紫色");

    private String str;

    Color(String colStr) {
        str = colStr;
    }

    public String getStr() {
        return str;
    }
}

enum Age {
    ONE("老大"),
    TWO("老二"),
    THREE("老三"),
    FOUR("老四"),
    FIVE("老五"),
    SIX("老六"),
    SEVEN("老七");

    private String str;

    Age(String ageStr) {
        str = ageStr;
    }

    public String getStr() {
        return str;
    }
}

public class CalabashBrother {
    Age rank;
    Color colorAttr;

    public CalabashBrother (int n) {
        rank = Age.values()[n];
        colorAttr = Color.values()[n];
    }

    public int compareAge(CalabashBrother right) {
        return rank.compareTo(right.rank);
    }
    public int compareCol(CalabashBrother right) {
        return colorAttr.compareTo(right.colorAttr);
    }

    public void displayMov(int src, int dst) { System.out.println(rank.getStr() + ": "+ src + "->" + dst); }
    public void moveTo(CalabashBrother[] sequence, int index) {
        sequence[index] = this;
    }

    public void printAge() { System.out.printf("%s ", rank.getStr()); }
    public void printCol() {
        System.out.printf("%s ", colorAttr.getStr());
    }
}
