package battlefield;

import creature.CalabashBrother;
import creature.Position;
import creature.Scorpion;
import creature.Soldier;

import java.util.List;

public class Battlefield {
    private Unit[][] field;
    private int row;
    private int coloumn;

    public Battlefield(int row,int col){
        this.row =row;
        this.coloumn = col;

        field = new Unit[row][col];
        for(int i = 0; i<row;i++)
            for(int j = 0;j<col;j++)
                field[i][j] = new Unit(new Position(i,j));
    }

    public boolean is_empty(int x,int y){
        return !field[x][y].if_exist_creature();
    }

    public void display(){
        for(int i = 0; i < row; i++){
            for(int j = 0 ;j<coloumn;j++)
                if(is_empty(i,j))
                    System.out.print("Null ");
                else
                    System.out.print(field[i][j].getName() + " ");
            System.out.println();
        }
        System.out.println();
    }

    public void clear(){
        for(int i = 0; i<row;i++)
            for(int j = 0; j<coloumn;j++)
                field[i][j].clear_unit();
    }

    public void setField_calabash(List<CalabashBrother> list){
        for (CalabashBrother i: list
             ) {
            field[i.getPosition().get_x()][i.getPosition().get_y()].setCreature(i);
        }
    }

    public void setField_soldier(List<Soldier> list, Scorpion scorpion){
        for (Soldier i: list
                ) {
            field[i.getPosition().get_x()][i.getPosition().get_y()].setCreature(i);
            field[scorpion.getPosition().get_x()][scorpion.getPosition().get_y()].setCreature(scorpion);
        }
    }
}
