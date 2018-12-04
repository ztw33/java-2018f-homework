package creature;

public enum CalabashBrotherMask{
	RED(0,"红娃","老大"), 
	ORANGE(1,"橙娃","老二"), 
	YELLOW(2,"黄娃","老三"), 
	GREEN(3,"绿娃","老四"), 
	CYAN(4,"青娃","老五"), 
	BLUE(5,"蓝娃","老六"), 
	PURPLE(6,"紫娃","老七");
	public final int index;
	public final String color;
	public final String nickname;
	//initialize
	CalabashBrotherMask(int index, String color, String nickname) {
		this.index = index;
		this.color = color;
		this.nickname = nickname;
	}
}
