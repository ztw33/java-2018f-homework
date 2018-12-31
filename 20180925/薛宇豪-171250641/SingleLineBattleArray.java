public class SingleLineBattleArray extends Formation {
    public SingleLineBattleArray(int row, int column) {
        super(row,column);
    }
    public char[][] embattle(Role[] roles){
        int numOfPeople=roles.length;
        int aimedColumn=column/2;
        if(numOfPeople>row){
            System.out.println("所排人数超过了当前阵列的范围！");
            return null;
        }else {
            int vacancy=(row-numOfPeople)/2;
            for(int i=0;i<numOfPeople;i++){
                queue[vacancy+i][aimedColumn]=roles[i].getSymbol();
            }
        }
        return queue;
   }
}
