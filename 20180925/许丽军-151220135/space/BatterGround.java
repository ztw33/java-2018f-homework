package space;

import creature.Creature;

public class BatterGround {
	private Position[][] ground ;
	private int row, col;
	
	public BatterGround(int N){
		this(N,N);
	}
	public BatterGround(int row, int col){
		this.row = row;
		this.col = col;
		ground = new Position[row][col];
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				ground[i][j] = new Position();
			}
		}
	}
	
	public void placeCreature(int x, int y, Creature c){
		ground[x][y].setCreature(c);
	}
    public void clearCreature(int x, int y){
        ground[x][y].clearCreature();
    }

//	public Creature getCreature(int x, int y) {	return ground[x][y].getCreature();	}

//	public void setPosition(int x,int y,Position p){
//		ground[x][y] = p;
//	}
	
	
	
	public void display(){
        for (int i = 0; i < col*4; i++) {
            System.out.print("-");
        }
        System.out.println();

		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(ground[i][j].isEmpty()){
					System.out.print("-");
				} else {
					System.out.print(ground[i][j].getCreature().getSymbol());
				}
				System.out.print("\t");
			}
			System.out.println();
		}
        for (int i = 0; i < col*4; i++) {
            System.out.print("-");
        }
        System.out.println();

    }

}
