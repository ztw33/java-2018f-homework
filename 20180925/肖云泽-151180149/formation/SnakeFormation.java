package formation;

public class SnakeFormation extends Formation {
	public SnakeFormation(){
		name = "Snake";
		array = new Position[] {new Position(3,4),new Position(3,5),new Position(3,6),
				new Position(3,7),new Position(3,8),new Position(3,9),new Position(3,10)};
	}
}
