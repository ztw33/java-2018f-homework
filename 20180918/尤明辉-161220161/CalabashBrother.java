public enum CalabashBrother {
    ONE(1, "老大", "红色"),
    TWO(2, "老二", "橙色"),
    THREE(3, "老三", "黄色"),
    FOUR(4, "老四", "绿色"),
    FIVE(5, "老五", "青色"),
    SIX(6, "老六", "蓝色"),
    SEVEN(7, "老七", "紫色");

    public final int order;
    private final String orderChn;
    private final String color;

    CalabashBrother(int ranking, String rankingChn, String colour) {
        this.order = ranking;
        this.orderChn = rankingChn;
        this.color = colour;
    }

    public void reportOrder() {
        System.out.print(this.orderChn + " ");
    }

    public void reportColor() {
        System.out.print(this.color + " ");
    }

    public void reportChange(int pos1, int pos2) {
        System.out.println(orderChn + "：" + pos1 + " -> " + pos2);
    }
}
