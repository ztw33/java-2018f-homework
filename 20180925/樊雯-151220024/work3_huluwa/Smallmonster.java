package work3_huluwa;

public class Smallmonster implements Creature{
	private Point position;
	@Override
	public Point getplace() {
	return position;
	}
	
	@Override
	public void setplace(Point position) {
       this.position = position;
       if(this.position != null)
	   position.set_placeholder(this);
	}
	
	@Override
	public void report() {
		//System.out.print("ะกัýนึ ->" + this.position.get_x() + "," + this.position.get_y() + ";");
		System.out.print("ะกัýนึ");
	}
}
