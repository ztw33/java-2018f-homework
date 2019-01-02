package work3_huluwa;

public class Grandpa implements Creature{
	private Point position;
	String name = "үү";
	@Override
	public Point getplace() {
	return position;
	}
	
	@Override
	public void setplace(Point position) {
       this.position = position;
	   position.set_placeholder(this);
	}
	
	@Override
	public void report() {
		System.out.print("үү");
	}
	

}
