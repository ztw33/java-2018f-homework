package Formations;
import Attributes.Position;

public class HeYi implements FormationProvider{
    private  static Position[] positions = {new Position(2,2),new Position(3,3),new Position(4,4), new Position(5,5),
            new Position(5,6),new Position(4,7),new Position(3,8),new Position(2,9)};
    public Position[] provideFormation() {
        return positions;
    }
}
