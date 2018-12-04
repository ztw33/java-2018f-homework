package creature;

public class CalabashBrother extends Creature{
	public int index; // 0,1,2...,6
	private String color;
	private String nickname;
	
	public CalabashBrother() {
		this.setName("CalabashBrother");
		this.index = -1;
		this.color = "无颜色";
		this.nickname = "无娃";
		this.name = this.nickname;
	}
	public CalabashBrother(CalabashBrotherMask calabro) {
		this.setName("CalabashBrother");
		setIndex(calabro.index);
		this.color = calabro.color;
		this.nickname = calabro.nickname;
		this.name = this.nickname;
	}
}
