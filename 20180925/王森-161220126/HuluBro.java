public class HuluBro {
    private HuluWa Members[];
    public HuluBro() {
        Members = new HuluWa[7];
        String name[] = {"红娃","橙娃","黄娃","绿娃","青娃","蓝娃","紫娃"};
        for(int i = 0; i < Members.length; i++)
            Members[i] = new HuluWa();
        Members[0].setRank(HuluWa.Rank.老三);
        Members[1].setRank(HuluWa.Rank.老大);
        Members[2].setRank(HuluWa.Rank.老五);
        Members[3].setRank(HuluWa.Rank.老七);
        Members[4].setRank(HuluWa.Rank.老四);
        Members[5].setRank(HuluWa.Rank.老二);
        Members[6].setRank(HuluWa.Rank.老六);
    }
    public HuluWa getMember(int i) {
        return Members[i];
    }
    public HuluWa[] getMembers() {
        return Members;
    }
    public void myBubbleSort() {
        for(int i = 0; i < Members.length-1; i++) {
            for(int j = 0; j < Members.length-1-i; j++) {
                if(Members[j].getRank().ordinal() > Members[j+1].getRank().ordinal()) {
                    Members[j].reportTheChange(j, j+1);
                    HuluWa temp = Members[j];
                    Members[j] = Members[j+1];
                    Members[j+1] = temp;
                }
            }
        }
        System.out.println();
    }
}
