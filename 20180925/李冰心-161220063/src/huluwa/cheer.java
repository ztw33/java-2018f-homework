package huluwa;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class cheer extends lives {
	private int no;
	private String name;
	
	public cheer(int x)
	{
		this.no=x%2;
		String url="";
		switch(this.no)
		{
		case 0:this.name="爷爷";url="src/icon/yeye.png";break;
		case 1:this.name="蛇精";url="src/icon/se.png";break;
		default:this.name=null;
		}
		ImageIcon ic=new ImageIcon(url);
		ic.setImage(ic.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		JLabel tl=new JLabel(ic);
		tl.setSize(ic.getIconWidth(), ic.getIconHeight());
		this.InitThing(tl);
		this.InitPos(null);
		
	}
	
	public void cheers()
	{
		System.out.print(this.name()+":");
		switch(this.no)
		{
		case 0:System.out.println("葫芦娃们加油！");break;
		case 1:System.out.println("蝎子精们加油！");break;
		}
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
		if(this.no==0)
			System.out.print("爷");
		else
			System.out.print("蛇");
	}

}
