package calabash;

public enum CalabashBro {
	RED("老大","红色", 0),ORANGE("老二","橙色", 1),YELLOW("老三","黄色", 2),GREEN("老四","绿色", 3),CYAN("老五","青色", 4),BLUE("老六","蓝色", 5),PURPLE("老七","紫色", 6);
	private String codename;
	private String color;
	private int rank;
	private int pos;
	
	CalabashBro(String codename, String color, int rank)
	{
		this.codename = codename;
		this.color = color;
		this.rank = rank;
		this.pos = 0;
	}
	
	public String getCodename() {
		return this.codename;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public int getRank() {
		return this.rank;
	}
	
	public int getPos() {
		return this.pos;
	}
	 
	public void setPos(int position) {
		this.pos =  position;
	}
}


