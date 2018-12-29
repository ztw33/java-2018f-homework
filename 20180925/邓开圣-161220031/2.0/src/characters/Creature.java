package characters;

import ui.Administrator;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

import shapes.Location;
//基类——生物体
public class Creature {
	protected Location loc;
	public Administrator admin;
	protected int sizex = 80, sizey = 80;	
	
	public int getSizex() {
		return sizex;
	}

	public int getSizey() {
		return sizey;
	}

	public void draw(Graphics g) {
		
	}
	
	public void setLoc(Location l) {
		this.loc = l;
	}
	
	public Rectangle getRect() {
		return new Rectangle(loc.locx,loc.locy,sizex,sizey);
	}
	//检测生物体的碰撞
	public boolean hitAnother(Creature c) {
		return this.getRect().intersects(c.getRect());
	}
	
	public boolean hitOthers(List<Creature> others) {
		for(int i=0;i<others.size();i++) {
			if(this.hitAnother(others.get(i)))
				return true;
		}
		return false;
	}
}
