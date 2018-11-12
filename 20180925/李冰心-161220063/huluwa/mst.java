package huluwa;

enum MonsterClass {Snake,Scorpions,Other}

public class mst extends lives{
	private int no;
	private where pos;
	private String name;
	
	public mst()
	{
		this.name="小喽啰";
		this.pos=null;
	}
	
	
	public int getNo()
	{return this.no;}
	
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
		System.out.print("怪");
	}
}
