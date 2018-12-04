package huluwa;

public class boss extends lives{

	private where pos;
	private String name;
	
	public boss()
	{
		this.name="蝎子精";
		this.pos=null;
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
		System.out.print("蝎");
	}
}
