public class EnEchelonArray extends Formation {
    public EnEchelonArray(int row, int column) {
        super(row,column);
    }
    public char[][] embattle(Role[] roles){
        int numOfPeople=roles.length;
        int allRow=numOfPeople;
        int allColumn=numOfPeople;
        if(allRow>row || allColumn>column){
            System.out.println("所排人数超过了当前阵列的范围！");
            return null;
        }else {
            int vacancyRow = (row - allRow) / 2;
            int vacancyColumn = (column - allColumn) / 2;
            for (int i = 0; i < allRow; i++) {
                queue[vacancyRow+allRow-1-i][vacancyColumn+i]=roles[i].getSymbol();
            }
        }
        return queue;
    }
}
