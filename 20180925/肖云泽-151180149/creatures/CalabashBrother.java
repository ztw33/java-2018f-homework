package creatures;

import infos.Infos;

public class CalabashBrother extends Creature {
	protected int index; // 0,1,2...,6
	protected String color;
	//super.name replace nickname
	//protected String nickname;
	
	public CalabashBrother(){
		super("CalaBashBrother", Infos.GOOD_CAMP);
		this.index = -1;
		this.color = "Null";
		//this.nickname = "Null";
	}
	public CalabashBrother(CalabashBrotherMask calabro){
		super("CalaBashBrother", Infos.GOOD_CAMP);
		this.index = calabro.index;
		this.color = calabro.color;
		//this.nickname = calabro.nickname;
		super.name = calabro.nickname;
	}
	public int getIndex() {
		return this.index;
	}
	public String getColor() {
		return this.color;
	}
	/*public String getNickname() {
		return this.nickname;
	}*/
}
