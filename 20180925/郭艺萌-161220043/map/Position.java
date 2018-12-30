package map;

import creature.*;

public class Position {

	private int x, y;
	private Creature creature;
	
	public Position(int x, int y) {
		this.x = x;
		this.y =y;
		this.creature = null; 
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public Creature getCreature() {
		if (this.creature != null) {
			return this.creature;
		} else {
			return null;
		}
	}
	public boolean getIsSet() {
		return (this.creature != null);
	}
	public void setCreature(Creature creature) {
		if (this.creature != null) {
		//	System.out.println("~~ÒÆ×ßÀ²");
			this.creature = null;
		}
		this.creature = creature;
	}
	public void removeCrearure() {
		this.creature = null; 
	}
}
