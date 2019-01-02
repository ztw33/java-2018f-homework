package work3_huluwa;

public class Snake implements Creature{
	private Point position;
	private String name ="Éß¾«";
	@Override
	public Point getplace() {
	return position;
	}
	@Override
	public void setplace(Point position) {
       this.position = position;
	   this.position.set_placeholder(this);
	}
	
	@Override
	public void report() {
		//System.out.print("Éß¾« ->" + this.position.get_x() + "," + this.position.get_y() + ";/n");
		System.out.print(this.name);
	}
	
}
