package huluwa;

import java.awt.*;
import javax.swing.*;

public abstract class lives {
	
	private where pos;
	private JLabel thing;
	
	//private int no;
	//private String name;
	
	
	public int getX() {return this.pos.getX();}
	public int getY() {return this.pos.getY();}
	public where getPos() {return this.pos;}
	public JLabel getThing() {return this.thing;}
	public void cleanPos() {this.pos=null;changeLoc();}
	public void InitPos(where tpos) {this.pos=tpos;}
	public void InitThing(JLabel tl) {this.thing=tl;}
	
	public void set(where tpos) 
	{
		if(this.pos!=null)
			this.pos.cleanOn();
		
		this.pos=tpos;
		this.pos.set(this);
		changeLoc();
	}
	
	public void changeLoc()
	{
		int ix,iy;
		if(this.pos==null)
		{
			ix=1000;
			iy=1000;
		}else {
			ix=30*this.getX();
			iy=30*this.getY();
		}
		this.thing.setLocation(ix, iy);
	}
	
	
	public abstract void tell();
	public abstract String name();
	public abstract void print();
	
}
