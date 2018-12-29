package confrontation;

public class Position {
	private Organisms creature;
	private int x;
	private int y;
	Position(){
		this.creature=null;
		x=-1;
		y=-1;
	}
	public void setXY(Organisms creature,int x,int y) {
		if(isNull()==true) {
			this.creature=creature;
			this.x=x;
			this.y=y;
		}
		else {
			System.out.println("该位置已被占用");	
		}
	}
	public Organisms getCreature() {
		return creature;
	}
	public boolean isNull() {
		if(this.creature!=null)
			return false;
		return true;
	}
}
