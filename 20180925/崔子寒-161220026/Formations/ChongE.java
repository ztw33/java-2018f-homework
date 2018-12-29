package Formations;

import Attributes.Position;

public class ChongE implements  FormationProvider {
    public Position[] provideFormation() {
        Position[] positions = {new Position(1,5),new Position(2,4),new Position(3,5), new Position(4,4),
                new Position(5,5),new Position(6,4),new Position(7,5),new Position(8,4)};
        return positions;
    }
    public String getName() {
        return "冲轭阵";
    }
}
