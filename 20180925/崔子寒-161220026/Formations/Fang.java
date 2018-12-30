package Formations;

import Attributes.Position;

public class Fang implements FormationProvider {
    public Position[] provideFormation() {
        Position[] positions = {new Position(3,4),new Position(4,3),new Position(4,5), new Position(5,2),
                new Position(5,6),new Position(6,3),new Position(6,5),new Position(7,4)};
        return positions;
    }

    public String getName() {
        return "方块阵";
    }
}
