package formation;

import java.util.*;

import beings.*;
import cells.*;

public abstract class Formation {
	public final static int ROWS=15;
	public final static int COLS=15;
	public Cell[][] cells;
	
	public String name;
	
	public Formation(){
		name="";
		cells=new Cell[ROWS][COLS];
		int i,j;
		for(i=0;i<ROWS;i++) {
			cells[i]=new Cell[COLS];
			for(j=0;j<COLS;j++) {
				cells[i][j]=null;
			}
		}
	}
	
	public boolean placeallowed(Being being, int row, int col) {
		if(row<0||row>=ROWS||col<0||col>=COLS||cells[row][col]==null)
			return false;
		if(!cells[row][col].placeallowed(being))
			return false;
		else
			return true;
	}
	
	public void setbeing(Being being, int row, int col) {
		cells[row][col].setbeing(being);
	}
	
	public void setbeings(ArrayList<Being> beings) {
		int len=beings.size(),i,j,k;
		A:
		for(i=0;i<len;i++) {
			Being tmpbeing=beings.get(i);
			for(j=0;j<ROWS;j++) {
				for(k=0;k<COLS;k++) {
					if(placeallowed(tmpbeing, j, k)) {
						setbeing(tmpbeing, j, k);
						continue A;
					}
				}
			}
		}
	}
	
	public void clearbeing(int row, int col) {
		if(row<0||row>=ROWS||col<0||col>=COLS) {
			throw new ArrayIndexOutOfBoundsException();
		}
		else if(cells[row][col]==null)
			throw new NullPointerException();
		cells[row][col].clearbeing();
	}
	
	public void clearbeings() {
		int i,j;
		for(i=0;i<ROWS;i++) {
			for(j=0;j<COLS;j++) {
				if(cells[i][j]!=null)
					cells[i][j].clearbeing();
			}
		}
	}
}
