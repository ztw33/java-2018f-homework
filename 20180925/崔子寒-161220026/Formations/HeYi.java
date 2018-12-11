package Formations;
import Attributes.Position;

public class HeYi implements FormationProvider{
    private  static Position[] positions = {new Position(2,0),new Position(3,1),new Position(4,2), new Position(5,3),
            new Position(5,4),new Position(4,5),new Position(3,6),new Position(2,7)};
    public Position[] provideFormation() {
        return positions;
    }

    public String getName() {
        return "鹤翼阵";
    }
}
