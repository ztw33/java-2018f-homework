package huluwa;

public abstract class lives {
	
	private where pos;
	//private int no;
	//private String name;
	
	public int getX() {return this.pos.getX();}
	public int getY() {return this.pos.getY();}
	public where getPos() {return this.pos;}
	
	public void cleanPos() {this.pos=null;}
	
	public void set(where tpos) 
	{
		if(this.pos!=null)
			this.pos.cleanOn();
		
		this.pos=tpos;
		this.pos.set(this);
	}
	
	public abstract void tell();
	public abstract String name();
	public abstract void print();
	
}
