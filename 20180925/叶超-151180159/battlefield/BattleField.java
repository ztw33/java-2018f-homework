package battlefield;
import creature.*;
public class BattleField {
	int row;
	int col;
	Position[][] field;
	public BattleField(int row, int col){
		this.row = row;
		this.col = col;
		field = new Position[row][col];
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				field[i][j] = new Position();
			}
		}
	}
	public void setCreature(int x, int y, Creature c){
		field[x][y].setCreature(c);
	}
	public void clearCreature(int x, int y){
        field[x][y].clearCreature();
	}
	public void display(){
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(field[i][j].isEmpty()){
					System.out.print("-");
				} else {
					System.out.print(field[i][j].getCreature().getSymbol());
				}
				System.out.print("\t");
			}
			System.out.println();
		}
	}
}
