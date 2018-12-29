package cells;

import java.awt.*;
import javax.swing.*;

import beings.*;

@SuppressWarnings("serial")
public class Cell extends JButton {
	
	//不能放任何东西
	public Being being=null;
	
	int width;
	int height;
	
	public Cell(){
		width=50;
		height=40;
		this.setPreferredSize(new Dimension(width,height));
	}
	
	public void setbeing(Being being) {}
	
	public boolean placeallowed(Being being) {return false;}
	
	public void clearbeing() {
		this.setIcon(null);
		this.being=null;
	}
}
