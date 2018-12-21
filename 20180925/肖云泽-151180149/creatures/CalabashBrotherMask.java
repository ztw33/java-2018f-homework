package creatures;

public enum CalabashBrotherMask{
	RED(0,"红娃","老大"), 
	ORANGE(1,"橙娃","老二"), 
	YELLOW(2,"黄娃","老三"), 
	GREEN(3,"绿娃","老四"), 
	CYAN(4,"青娃","老五"), 
	BLUE(5,"蓝娃","老六"), 
	PURPLE(6,"紫娃","老七");
	protected final int index;
	protected final String color;
	protected final String nickname;
	CalabashBrotherMask(int index, String color, String nickname) {
		this.index = index;
		this.color = color;
		this.nickname = nickname;
	}
}
