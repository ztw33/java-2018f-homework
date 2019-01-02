package calabashBrothers;

/**
 * @ Author     ：Young
 * @ Description：葫芦娃
 */

enum Color {
    RED("红色"), ORANGE("橙色"), YELLOW("黄色"), GREEN("绿色"), VERDANT("青色"), BLUE("蓝色"), PURPLE("紫色"); // 红橙黄绿蓝靛紫

    private String colorName;
    private final int colorNumber = 7;

    Color(String colorName) {
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }

    public  int getColorNumber(){
        return colorNumber;
    }
}

enum CalabashBrothers {

    RED_BOY("老大", Color.RED, 0),
    ORANGE_BOY("老二", Color.ORANGE, 1),
    YELLOW_BOY("老三", Color.YELLOW, 2),
    GREEN_BOY("老四", Color.GREEN, 3),
    VERDANT_BOY("老五", Color.VERDANT, 4),
    BLUE_BOY("老六", Color.BLUE, 5),
    PURPLE_BOY("老七", Color.PURPLE, 6);

    private String name;
    private Color color;
    private int rank;
    private int number;

    CalabashBrothers(String name, Color color, int rank) {
        this.name = name;
        this.color = color;
        this.rank = rank;
        this.number = 7;
    }

    public String getName() {
        return name;
    }
    public String getColor() {
        return color.getColorName();
    }
    public int getRank() {
        return this.rank;
    }

}

class CalabashBoys extends Creature{
    private CalabashBrothers[] boys;
    private final int boysNumber = 7;

    public CalabashBoys() {
        super("葫芦兄弟", CreatureType.CALABASH_BOY);
        this.boys = new CalabashBrothers[this.boysNumber];
        for (int i = 0; i < boys.length; i++) {
            boys[i] = CalabashBrothers.values()[i];
        }
    }

    public int getBoysNumber() {
        return boysNumber;
    }

    public int getSomeoneRank(int i){
        return boys[i].getRank();
    }


    public void swap(int i, int j) {
        CalabashBrothers tmp = boys[i];
        boys[i] = boys[j];
        boys[j] = tmp;
    }

    public void swapWithReport(int i, int j) {
        System.out.println(boys[i].getName() + ":" + i + "->" + j);
        System.out.println(boys[j].getName() + ":" + j + "->" + i);
        CalabashBrothers tmp = boys[i];
        boys[i] = boys[j];
        boys[j] = tmp;
    }

    public boolean compareSmaller(int i, int j){
        return boys[i].getRank()<boys[j].getRank();
    }

    public void boysReportDetails() {
        for (int i = 0; i < boysNumber; i++) {
            System.out.println("我是" + i + "号,我的名字叫" + boys[i].getName() + ",我的颜色是" + boys[i].getColor());
        }
    }

    public void boysReportNames() {
        for (CalabashBrothers b : boys) {
            System.out.print(b.getName() + ",");
        }
        System.out.println();
    }

    public void boysReportColors() {
        for (CalabashBrothers b : boys) {
            System.out.print(b.getColor() + ",");
        }
        System.out.println();
    }


}



