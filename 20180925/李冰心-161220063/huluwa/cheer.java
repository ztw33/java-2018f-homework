package huluwa;

public class cheer extends lives {
	private int no;
	private where pos;
	private String name;
	
	public cheer(int x)
	{
		this.no=x%2;
		switch(this.no)
		{
		case 0:this.name="爷爷";break;
		case 1:this.name="蛇精";break;
		default:this.name=null;
		}
		this.pos=null;
		
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
		System.out.println(this.name()+" in "+this.pos.getX()+ ","+this.pos.getY());
		
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
