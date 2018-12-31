public class CraneWingArray extends Formation {
    public CraneWingArray(int row, int column) {
        super(row,column);
    }
    public char[][] embattle(Role[] roles){
        int numOfPeople=roles.length;
        int allRow=(numOfPeople+1)/2;
        int allColumn=numOfPeople;
        if(allRow>row || allColumn>column){
            System.out.println("所排人数超过了当前阵列的范围！");
            return null;
        }else {
            int vacancyRow = (row - allRow) / 2;
            int vacancyColumn = (column - allColumn) / 2;
            for (int i = 0; i < allRow; i++) {
                if(numOfPeople==1){
                    queue[vacancyRow + i][vacancyColumn + i] = roles[numOfPeople-1].getSymbol();
                    queue[vacancyRow + i][vacancyColumn + allColumn - 1 - i] = roles[numOfPeople-1].getSymbol();
                }else {
                    queue[vacancyRow + i][vacancyColumn + i] = roles[numOfPeople - 1].getSymbol();
                    queue[vacancyRow + i][vacancyColumn + allColumn - 1 - i] = roles[numOfPeople - 2].getSymbol();
                }
                numOfPeople = numOfPeople - 2;
            }
        }
        return queue;
    }
}
