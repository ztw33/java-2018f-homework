package characters;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import ui.Administrator;
import shapes.Location;

public class Snake extends Creature{

	private static Image img = new ImageIcon("resources/characters/snake/snake2.png").getImage();
	private int snakeSizex = 100, snakeSizey = 100;
	
	public Snake(Location l,Administrator ad) {
		this.loc = l;
		this.admin = ad;
		this.sizex = snakeSizex;
		this.sizey = snakeSizey;
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
