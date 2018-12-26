package field;

import creature.Creature;
import sample.Controller;

public class BattleField {
    private int row;
    private int column;
    public Cell<Creature>[][] battlefield;
    public BattleField(int row, int column){
        this.row=row;
        this.column=column;
        battlefield=new Cell[row][column];
        for(int i=0;i<row;i++){
            for (int j=0;j<column;j++){
                battlefield[i][j]=new Cell<Creature>(new Position(i,j));
            }
        }
    }

   public void print(Controller controller){
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(!(battlefield[i][j].getIfEmpty())){
                    controller.setCreature(i,j,battlefield[i][j].getCreature());
                };
            }
        }
    }


}
