package formation;

import cells.*;

public class SquareCircle extends Formation {
	
	/*0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
	  0,0,0,0,7,0,0,0,0,0,0,0,0,0,0
	  0,0,0,0,6,0,0,0,0,a,0,0,0,0,0
	  0,0,0,0,5,0,0,0,a,0,a,0,0,0,0
	  0,0,0,8,1,0,0,y,0,s,0,a,0,0,0
	  0,0,0,0,2,0,0,0,a,0,a,0,0,0,0
	  0,0,0,0,3,0,0,0,0,a,0,0,0,0,0
	  0,0,0,0,4,0,0,0,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0*/
	
	public SquareCircle(){
		super();
		name="·½Ô²Õó";
		int i,j;
		
		//ºùÂ«ÍÞ
		for(i=4;i<=10;i++)
			cells[i][4]=new CalabashBrotherCell();
		
		//Ð¡à¶†ª
		for(i=5;i<=7;i++)
			cells[i][i+4]=new FollowerCell();
		for(i=6;i<=8;i+=2)
			cells[i][i+2]=new FollowerCell();
		for(i=8;i<=9;i++)
			cells[i][i]=new FollowerCell();
		
		//ÀÏÒ¯Ò¯,Éß¾«,Ð«×Ó¾«
		cells[7][3]=new GrandpaCell();
		cells[7][9]=new SerpentCell();
		cells[7][7]=new ScorpionCell();
		
		for(i=0;i<ROWS;i++) {
			for(j=0;j<COLS;j++) {
				if(cells[i][j]==null)
					cells[i][j]=new Cell();
			}
		}
	}
}
