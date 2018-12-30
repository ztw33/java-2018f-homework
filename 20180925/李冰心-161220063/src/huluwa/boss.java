package huluwa;
import java.awt.*;
import javax.swing.*;

public class boss extends lives{
	private String name;
	
	
	public boss()
	{
		this.name="蝎子精";
		this.InitPos(null);
		ImageIcon ic=new ImageIcon("src/icon/boss.png");
		ic.setImage(ic.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		JLabel tl=new JLabel(ic);
		tl.setSize(ic.getIconWidth(), ic.getIconHeight());
		this.InitThing(tl);
	}
	
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
		System.out.print("蝎");
	}
}
