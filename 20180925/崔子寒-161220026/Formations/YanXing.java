package Formations;

import Attributes.Position;

public class YanXing implements  FormationProvider{
    public Position[] provideFormation() {
        Position[] positions = {new Position(2,7),new Position(3,6), new Position(4,5), new Position(5,4),
                        new Position(6,3),new Position(7,2),new Position(8,1),new Position(9,0)};
        return positions;
    }
    public String getName() {
        return "雁行阵";
    }
}
