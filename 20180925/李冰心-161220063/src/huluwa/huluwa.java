package huluwa;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

enum Hcolor {RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE}

public class huluwa extends lives{
	private int no;
	//private where pos;
	private String name;
	//public JLabel thing;
	//private Hcolor color;
	
	public huluwa(int x)
	{
		if(x<1 || x>7)
		{	
			System.out.print("this huluwa isn't real");
			return;
		}
		this.no=x;
		where tpos=null;
		this.InitPos(tpos);
		
		String url="";
		switch(this.no)
		{
		case 1:	this.name="老大（红）";url="src/icon/h1.png";break;
		case 2:	this.name="老二（橙）";url="src/icon/h2.png";break;
		case 3:	this.name="老三（黄）";url="src/icon/h3.png";break;	
		case 4:	this.name="老四（绿）";url="src/icon/h4.png";break;
		case 5:	this.name="老五（青）";url="src/icon/h5.png";break;
		case 6:	this.name="老六（蓝）";url="src/icon/h6.png";break;
		case 7:	this.name="老七（紫）";url="src/icon/h7.png";break;
		default:System.out.print("there must have a error!");
		}
		ImageIcon ic=new ImageIcon(url);
		ic.setImage(ic.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		JLabel tl=new JLabel(ic);
		tl.setSize(ic.getIconWidth(), ic.getIconHeight());
		this.InitThing(tl);
		//this.color= Hcolor.values()[x-1];
		
	}
	
	public int getNo()
	{
		return this.no;
	}
	
	/*
	public Hcolor getColor()
	{
		return this.color;
	}
	
	public String makeColor()
	{
		switch(this.color)
		{
		case RED:	return "红";
		case ORANGE:return "橙";
		case YELLOW:return "黄";
		case GREEN:	return "绿";
		case CYAN:	return "青";
		case BLUE:	return "蓝";
		case PURPLE:return "紫";
		default:System.out.print("there must have a error!");return "";
		}
	}
	*/
	
	public void printNo()
	{
		switch(this.no)
		{
		case 1:	System.out.print("老大（红）");break;
		case 2:	System.out.print("老二（橙）");break;
		case 3:	System.out.print("老三（黄）");break;	
		case 4:	System.out.print("老四（绿）");break;
		case 5:	System.out.print("老五（青）");break;
		case 6:	System.out.print("老六（蓝）");break;
		case 7:	System.out.print("老七（紫）");break;
		default:System.out.print("there must have a error!");
		}
	}
	
	
	/*
	public void printColor()
	{
		System.out.print(makeColor());
	}*/
	
	public boolean ifLess(huluwa x)
	{
		if(this.no < x.getNo())
			return true;
		else return false;
	}
	
	@Override
	public void tell()
	{
		System.out.println(this.name+" in "+this.getX()+ ","+this.getY());
		
	}
	
	@Override
	public String name()
	{
		return this.name;
	}
	
	@Override
	public void print()
	{
		System.out.print(this.no);
	}
	
	
}
