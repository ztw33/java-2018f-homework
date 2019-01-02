package battlefield;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import formation.*;
import beings.*;

@SuppressWarnings("serial")
public class BattleField extends JPanel {
	
	//界面中间的主面板
	final static int ROWS=Formation.ROWS;
	final static int COLS=Formation.COLS;
	
	public Formation form;
	
	public BattleField(Formation form,ArrayList<Being> beings){
		this.form=form;
		clearbeings();
		this.setLayout(new GridLayout(ROWS,COLS));
		int i,j;
		for(i=0;i<ROWS;i++) {
			for(j=0;j<COLS;j++)
				this.add(form.cells[i][j]);
		}
		this.form.setbeings(beings);
	}

	public void setform(Formation form) {
		this.removeAll();
		this.form=form;
		clearbeings();
		int i,j;
		for(i=0;i<ROWS;i++) {
			for(j=0;j<COLS;j++)
				this.add(form.cells[i][j]);
		}
		this.repaint();
	}

	public void setbeings(ArrayList<Being> beings) {
		if(form==null)
			throw new NullPointerException();
		else {
			form.setbeings(beings);
			this.repaint();
		}
	}
	
	public void clearbeing(int row, int col) {
		form.clearbeing(row, col);
	}
	
	public void clearbeings() {
		form.clearbeings();
	}
}
