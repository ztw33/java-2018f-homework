package field;

public class BattleField {
    private int row;
    private int column;
    public Cell[][] battlefield;
    public BattleField(int row,int column){
        this.row=row;
        this.column=column;
        battlefield=new Cell[row][column];
        for(int i=0;i<row;i++){
            for (int j=0;j<column;j++){
                battlefield[i][j]=new Cell(new Position(i,j));
            }
        }
    }

    public void print(){
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(battlefield[i][j].getIfEmpty()){
                    System.out.print("-");
                }else {
                    System.out.print(battlefield[i][j].getCreature().getSymbol());
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
