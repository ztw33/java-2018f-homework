package work3_huluwa;

public class Scorpion implements Creature {
	private Point position;
	private String name ="Ы�Ӿ�";
	@Override
	public Point getplace() {
	return position;
	}
	
	@Override
	public void setplace(Point position) {
       this.position = position;
       if(this.position != null)
	   this.position.set_placeholder(this);
	}
	
	@Override
	public void report() {
	//	System.out.print("Ы�Ӿ� ->" + this.position.get_x() + "," + this.position.get_y() + ";/n");
		System.out.print(this.name);
	}
	
}
