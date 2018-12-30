package creature;

import javax.swing.ImageIcon;

public class Creature {
	protected String name;
	protected ImageIcon figure;
	public int x;
	public int y;
	Creature(){
		x = -1;
		y = -1;
	}
	public String tellName() {
		return this.name;
	}
	public void setPos(int x ,int y) {
		this.x = x;
		this.y = y;
	}
	public ImageIcon tellFigure() {
    	return this.figure;
    }
}
