public enum Color {
    RED("红色", 1), ORANGE("橙色", 2), YELLOW("黄色", 3), GREEN("绿色", 4),
    CYAN("青色", 5), BLUE("蓝色", 6), PURPLE("紫色", 7);

    private String name;
    private int index;

    Color(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public static Color getColorAccordingToIndex(int index){
        for(Color c: Color.values()){
            if(c.index == index)
                return c;
        }
        return Color.RED;
    }
}
