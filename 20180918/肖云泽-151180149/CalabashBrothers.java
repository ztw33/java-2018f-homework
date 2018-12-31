
public enum CalabashBrothers {
	//seven brothers with their features
	NO_1(0,"红娃","老大"), 
	NO_2(1,"橙娃","老二"), 
	NO_3(2,"黄娃","老三"), 
	NO_4(3,"绿娃","老四"), 
	NO_5(4,"青娃","老五"), 
	NO_6(5,"蓝娃","老六"), 
	NO_7(6,"紫娃","老七");
	public final int index;
	private final String color;
	private final String nickname;
	//initialize
	CalabashBrothers(int index, String color, String nickname) {
		this.index = index;
		this.color = color;
		this.nickname = nickname;
	}
	
	public void tellColor(){
		System.out.print(this.color);
	}
	
	public void tellNickname() {
		System.out.print(this.nickname);
	}
}

