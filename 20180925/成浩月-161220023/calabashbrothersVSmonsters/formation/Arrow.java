package formation;

import cells.*;

public class Arrow extends Formation {

	/*0,0,0,0,0,0,0,8,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,7,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,6,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,5,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,4,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,3,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,2,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,1,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,y,0,0,0,0,0,0,0
	  0,0,0,0,0,0,a,a,a,0,0,0,0,0,0
	  0,0,0,0,0,a,0,a,0,a,0,0,0,0,0
	  0,0,0,0,a,0,0,a,0,0,a,0,0,0,0
	  0,0,0,0,0,0,0,a,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,a,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,s,0,0,0,0,0,0,0*/
	
	public Arrow(){
		super();
		name="·æÊ¸Õó";
		int i,j;
		
		//ºùÂ«ÍÞ
		for(i=1;i<=7;i++)
			cells[i][7]=new CalabashBrotherCell();
		
		//Ð¡à¶†ª
		for(i=9;i<=13;i++)
			cells[i][7]=new FollowerCell();
		for(i=9;i<=11;i++) {
			cells[i][15-i]=new FollowerCell();
			cells[i][i-1]=new FollowerCell();
		}
		
		//ÀÏÒ¯Ò¯,Éß¾«,Ð«×Ó¾«
		cells[0][7]=new GrandpaCell();
		cells[14][7]=new SerpentCell();
		cells[8][7]=new ScorpionCell();
		
		for(i=0;i<ROWS;i++) {
			for(j=0;j<COLS;j++) {
				if(cells[i][j]==null)
					cells[i][j]=new Cell();
			}
		}
	}
}
