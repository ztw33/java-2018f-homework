enum CalabashBrother {
    One("红", "大娃", 1), Two("橙","二娃", 2), Three("黄","三娃", 3), Four("绿","四娃", 4), Five("青","五娃", 5), Six("蓝","六娃", 6), Seven("紫","七娃", 7);
    private String color;
    private String myName;
    private int rank;
    CalabashBrother(String color, String myName, int rank) {
        this.color = color;
        this.myName = myName;
        this.rank = rank;
    }
    public void reportColor() {
        System.out.print(color);
    }
    public void reportName() {
        System.out.print(myName);
    }
    public int getRank() {
        return rank;
    }
    public String getMyName() {
        return myName;
    }
    public int compareByRank(int otherRank) {
        if(rank < otherRank)
            return 1;
        else
            return 0;
    }
    public void reportSwap(int oldPlace, int newPlace) {
        System.out.println(myName + ":" + (oldPlace+1) + "->" + (newPlace+1));
    }
}

public class HuluWa extends Creature{
    private CalabashBrother brother;
    public HuluWa(int rank) {
        switch (rank) {
            case 1:brother = CalabashBrother.One; break;
            case 2:brother = CalabashBrother.Two; break;
            case 3:brother = CalabashBrother.Three; break;
            case 4:brother = CalabashBrother.Four; break;
            case 5:brother = CalabashBrother.Five; break;
            case 6:brother = CalabashBrother.Six; break;
            case 7:brother = CalabashBrother.Seven; break;
        }
        name = brother.getMyName();
    }
    public int getRank() {
        return brother.getRank();
    }
    public int compareByRank(int otherRank) {
        return brother.compareByRank(otherRank);
    }
}
