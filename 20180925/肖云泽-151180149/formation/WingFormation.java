package formation;

public class WingFormation extends Formation {
	public WingFormation(){
		name = "Wing";
		array = new Position[] {new Position(7,7),
				new Position(8,6),new Position(9,5),new Position(10,4),
				new Position(8,8),new Position(9,9),new Position(10,10)};
	}
}
