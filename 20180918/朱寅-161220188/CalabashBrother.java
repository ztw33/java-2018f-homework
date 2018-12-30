public enum CalabashBrother {
    RED(1, Name.老大, Color.红色), ORG(2, Name.老二, Color.橙色),
    YLW(3, Name.老三, Color.黄色), GRN(4, Name.老四, Color.绿色),
    CYN(5, Name.老五, Color.青色), BLU(6, Name.老六, Color.蓝色),
    PPL(7, Name.老七, Color.紫色);

    public int brotherRank;
    public Name brotherName;
    public Color brotherColor;


    public enum Name {
        老大, 老二, 老三, 老四, 老五, 老六, 老七
    }
    public enum Color {
        红色, 橙色, 黄色, 绿色, 青色, 蓝色, 紫色
    }

    private CalabashBrother(int brotherRank, Name brotherName, Color brotherColor) {
        this.brotherRank = brotherRank;
        this.brotherName = brotherName;
        this.brotherColor = brotherColor;
    }

    public void tellMyName() {
        System.out.println(brotherName);
    }

    public void tellMyColor() {
        System.out.println(brotherColor);
    }

    public void reportSwitch(int formerPos, int latterPos) {
        System.out.println(brotherName + ":" + formerPos + "->" + latterPos);
    }
}
