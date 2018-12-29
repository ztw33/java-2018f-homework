package Formations;

import Attributes.Position;

public class YanYue implements FormationProvider {
    @Override
    public Position[] provideFormation() {
        Position[] positions = {new Position(2,5),new Position(3,4),new Position(4,3), new Position(4,4),
                new Position(5,3),new Position(5,4),new Position(6,4),new Position(7,5)};
        return positions;
    }
    public String getName() {
        return "偃月阵";
    }
}
