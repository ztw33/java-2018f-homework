package formation;

import cells.*;

public class FishScale extends Formation {

	/*0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,8,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,6,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,5,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,4,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,3,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,2,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,1,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,7,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,y,0,0,0,0,0,0,0
	  0,0,0,0,0,0,a,s,a,0,0,0,0,0,0
	  0,0,0,0,0,a,0,a,0,a,0,0,0,0,0
	  0,0,0,0,a,0,a,0,a,0,a,0,0,0,0
	  0,0,0,0,0,0,0,a,0,0,0,0,0,0,0
	  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0*/
	
	public FishScale(){
		super();
		name="”„¡€’Û";
		int i,j;
		
		//∫˘¬´Õﬁ
		for(i=2;i<=8;i++)
			cells[i][7]=new CalabashBrotherCell();
		
		//–°‡∂Ü™
		for(i=10;i<=12;i++) {
			cells[i][16-i]=new FollowerCell();
			cells[i][18-i]=new FollowerCell();
		}
		for(i=11;i<=13;i++)
			cells[i][20-i]=new FollowerCell();
		cells[12][10]=new FollowerCell();
		
		//¿œ“Ø“Ø,…ﬂæ´,–´◊”æ´
		cells[1][7]=new GrandpaCell();
		cells[10][7]=new SerpentCell();
		cells[9][7]=new ScorpionCell();
		
		for(i=0;i<ROWS;i++) {
			for(j=0;j<COLS;j++) {
				if(cells[i][j]==null)
					cells[i][j]=new Cell();
			}
		}
	}
}
