package confrontation;

public class Battlefield {
	final int row=20;
	final int col=30;
	Position[][] position;
	Good good;
	Bad bad;
	public void Intialize(){
		position=new Position[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				position[i][j]=new Position();
			}
		}
		good=new Good();
		bad=new Bad();
	}
	public void Start() {
		good.selectFormation(this);
		bad.selectFormation(this);
	}
	public void Print() {
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(position[i][j].getCreature()==null)
					System.out.print("     ");
				else if(position[i][j].getCreature().getType()==1)
					System.out.print("  *  ");
				else if(position[i][j].getCreature().getType()==2)
					System.out.print("  ^  ");
				else if(position[i][j].getCreature().getType()==3)
					System.out.print("  &  ");
				else if(position[i][j].getCreature().getType()==4)
					System.out.print("  %  ");
				else if(position[i][j].getCreature().getType()==5)
					System.out.print("  $  ");
			}
			System.out.println();
		}
	}
}
