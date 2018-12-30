package formation;

import cells.*;

public class CraneWing extends Formation {
	
	//1-7代表葫芦娃,8代表老爷爷,a代表小喽啰,s代表蛇精,y代表蝎子精
	/*0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
	0,0,0,0,0,0,0,8,0,0,0,0,0,0,0
	0,0,0,0,0,0,0,7,0,0,0,0,0,0,0
	0,0,0,0,0,0,0,6,0,0,0,0,0,0,0
	0,0,0,0,0,0,0,5,0,0,0,0,0,0,0
	0,0,0,0,0,0,0,4,0,0,0,0,0,0,0
	0,0,0,0,0,0,0,3,0,0,0,0,0,0,0
	0,0,0,0,0,0,0,2,0,0,0,0,0,0,0
	0,0,a,0,0,0,0,1,0,0,0,0,a,0,0
	0,0,0,a,0,0,0,0,0,0,0,a,0,0,0
	0,0,0,0,a,0,0,0,0,0,a,0,0,0,0
	0,0,0,0,0,a,0,0,0,a,0,0,0,0,0
	0,0,0,0,0,0,a,s,a,0,0,0,0,0,0
	0,0,0,0,0,0,0,y,0,0,0,0,0,0,0
	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0*/
	
	public CraneWing(){
		super();
		name="鹤翼阵";
		int i,j;

		//葫芦娃
		for(i=2;i<=8;i++)
			cells[i][7]=new CalabashBrotherCell();
		
		//小喽啰
		for(i=8;i<=12;i++) {
			cells[i][i-6]=new FollowerCell();
			cells[i][20-i]=new FollowerCell();
		}
		
		//老爷爷,蛇精,蝎子精
		cells[1][7]=new GrandpaCell();
		cells[12][7]=new SerpentCell();
		cells[13][7]=new ScorpionCell();
		
		for(i=0;i<ROWS;i++) {
			for(j=0;j<COLS;j++) {
				if(cells[i][j]==null)
					cells[i][j]=new Cell();
			}
		}
	}
}
