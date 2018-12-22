package huluwa;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

enum MonsterClass {Snake,Scorpions,Other}

public class mst extends lives{
	private int no;
	private String name;
	
	public mst()
	{
		this.name="小喽啰";
		this.InitThing(null);
		ImageIcon ic=new ImageIcon("src/icon/low.png");
		ic.setImage(ic.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		JLabel tl=new JLabel(ic);
		tl.setSize(ic.getIconWidth(), ic.getIconHeight());
		this.InitThing(tl);
	}
	
	
	public int getNo()
	{return this.no;}
	
	@Override
	public void tell()
	{
		System.out.println(this.name()+" in "+this.getX()+ ","+this.getY());
		
	}
	
	@Override
	public String name()
	{
		return this.name;
	}
	@Override
	public void print()
	{
		System.out.print("怪");
	}
}
