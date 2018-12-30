package formation;

import cells.*;

public class CrossBar extends Formation {
	
	/*0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
	  0,0,0,0,7,0,0,0,0,a,0,0,0,0,0
	  0,0,0,0,6,0,0,0,a,0,0,0,0,0,0
	  0,0,0,0,5,0,0,0,0,a,0,0,0,0,0
	  0,0,0,8,1,0,0,0,y,s,0,0,0,0,0
	  0,0,0,0,2,0,0,0,0,a,0,0,0,0,0
	  0,0,0,0,3,0,0,0,a,0,0,0,0,0,0
	  0,0,0,0,4,0,0,0,0,a,0,0,0,0,0
	  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0*/
	
	public CrossBar(){
		super();
		name="ºâéîÕó";
		int i,j;
		
		//ºùÂ«ÍÞ
		for(i=4;i<=10;i++)
			cells[i][4]=new CalabashBrotherCell();
		
		//Ð¡à¶†ª
		for(i=4;i<=10;i+=2)
			cells[i][9]=new FollowerCell();
		cells[5][8]=new FollowerCell();
		cells[9][8]=new FollowerCell();
		
		//ÀÏÒ¯Ò¯,Éß¾«,Ð«×Ó¾«
		cells[7][3]=new GrandpaCell();
		cells[7][9]=new SerpentCell();
		cells[7][8]=new ScorpionCell();
		
		for(i=0;i<ROWS;i++) {
			for(j=0;j<COLS;j++) {
				if(cells[i][j]==null)
					cells[i][j]=new Cell();
			}
		}
	}
}
