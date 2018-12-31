package huluwa;


enum Hcolor {RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE}

public class huluwa {
	private int no;
	private Hcolor color;
	
	public huluwa(int x)
	{
		if(x<1 || x>7)
		{	
			System.out.print("this huluwa isn't real");
			return;
		}
		this.no=x;
		this.color= Hcolor.values()[x-1];
		
	}
	
	public int getNo()
	{
		return this.no;
	}
	
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
	
	public void printNo()
	{
		switch(this.no)
		{
		case 1:	System.out.print("老大");break;
		case 2:	System.out.print("老二");break;
		case 3:	System.out.print("老三");break;	
		case 4:	System.out.print("老四");break;
		case 5:	System.out.print("老五");break;
		case 6:	System.out.print("老六");break;
		case 7:	System.out.print("老七");break;
		default:System.out.print("there must have a error!");
		}
	}
	
	public void printColor()
	{
		System.out.print(makeColor());
	}
	
	public boolean ifLess(huluwa x)
	{
		if(this.no < x.getNo())
			return true;
		else return false;
	}
	
}
