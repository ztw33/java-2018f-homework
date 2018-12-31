package characters;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import ui.Administrator;
import shapes.Location;

public class GrandFather extends Creature{
	private static Image img = new ImageIcon("resources/characters/grandfather/grandfather2.PNG").getImage();
	private int fatherSizex = 100, fatherSizey = 100;
	
	public GrandFather(Location l, Administrator ad) {
		this.loc = l;
		this.admin = ad;
		this.sizex = fatherSizex;
		this.sizey = fatherSizey;
	}
	
	public void draw(Graphics g) {
		g.drawImage(img, loc.locx, loc.locy, loc.locx+sizex, loc.locy+sizey, 0, 0, img.getWidth(null), img.getHeight(null), null);
	}

	public boolean hitCalaBash(List<CalabashBoy> calabashes) {
		for(int i=0;i<calabashes.size();i++) {
			if(this.hitAnother(calabashes.get(i)))
				return true;
		}
		return false;
	}
	
}
