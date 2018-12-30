package Beings;
enum NameAndColor {//
	RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE;
	String[] NAME = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
	String[] COLOR = {"赤", "橙", "黄", "绿", "青", "蓝", "紫"};
	String getName() {
		return this.NAME[ordinal()];
	}
	String getColor() {
		return this.COLOR[ordinal()];
	}
}
public class CalabashBrother extends People{
	//private int x, y;
	private NameAndColor nc;
	CalabashBrother(){
		x = -1;
		y = -1;
		nc = null;
	}
	CalabashBrother(NameAndColor NC){
		x = -1;
		y = -1;
		nc = NC;
	}
	CalabashBrother(int x, int y){
		this.x = x;
		this.y = y;
		nc = null;
	}
	CalabashBrother(int x, int y, NameAndColor NC){
		this.x = x;
		this.y = y;
		nc = NC;
	}
	public String getName() {
		return nc.getName();
	}
	public String getColor() {
		return nc.getColor();
	}

	public void setNameAndColor(int index) {
		nc = NameAndColor.values()[index];
	}
	public int compareTo(CalabashBrother brother) {
		// TODO Auto-generated method stub
		return this.nc.compareTo(brother.nc);
	}
}

