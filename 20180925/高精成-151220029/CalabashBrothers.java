public class CalabashBrothers {
    private Calabash []calabashes;

    public Calabash[] getCalabashes() {
        return calabashes;
    }
    CalabashBrothers () {
        calabashes = new Calabash[7];
        for(int i=0;i<calabashes.length;i++){
            //初始化葫芦娃排队顺序为老五、老六、老七、老大、老二、老三、老四
            calabashes[i] = new Calabash((i+4)%7+1);
        }
    }
    void reportTheSortOfCalabashBrothers () { //报告葫芦娃排队情况
        for(int i=0;i<calabashes.length;i++) {
            System.out.print(calabashes[i].getName()+"\t");
        }
        System.out.println();
    }
}
