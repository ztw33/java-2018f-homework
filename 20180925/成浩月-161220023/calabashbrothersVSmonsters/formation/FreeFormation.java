package formation;

import java.util.*;

import beings.*;
import cells.*;

public class FreeFormation extends Formation {
	public FreeFormation(){
		super();
		name=new String("втсиуС");
		int i,j;
		for(i=0;i<ROWS;i++) {
			cells[i]=new BeingCell[COLS];
			for(j=0;j<COLS;j++)
				cells[i][j]=new BeingCell();
		}
	}
	
	@Override
	public void setbeings(ArrayList<Being> beings) {
		Random r=new Random();
		int len=beings.size();
		int i,j,k;
		for(i=0;i<len;i++) {
			Being tmpbeing=beings.get(i);
			j=r.nextInt(ROWS);
			k=r.nextInt(COLS);
			while(!placeallowed(tmpbeing,j,k)) {
				j=r.nextInt(ROWS);
				k=r.nextInt(COLS);
			}
			cells[j][k].setbeing(tmpbeing);
		}
	}
}
