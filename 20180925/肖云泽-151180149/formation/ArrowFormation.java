package formation;

public class ArrowFormation extends Formation {
	public ArrowFormation(){
		name = "Arrow";
		array = new Position[] {new Position(7,7),
				new Position(8,6),new Position(9,5),new Position(10,4),
				new Position(8,7),new Position(9,7),new Position(10,7),new Position(11,7),new Position(12,7),new Position(13,7),
				new Position(8,8),new Position(9,9),new Position(10,10)};
	}
}
