package Formations;

import Attributes.Position;

public class YanXing implements  FormationProvider{
    public Position[] provideFormation() {
        Position[] positions = {new Position(2,9),new Position(3,8), new Position(4,7), new Position(5,6),
                        new Position(6,5),new Position(7,4),new Position(8,3),new Position(9,2)};
        return positions;
    }
}
