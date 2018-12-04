package Formations;

import Attributes.Position;

public class FengShi implements  FormationProvider{
    @Override
    public Position[] provideFormation() {
        Position[] positions = {new Position(4,3),new Position(3,4),new Position(2,5), new Position(3,6),
                new Position(4,7),new Position(3,5),new Position(4,5),new Position(5,5)};
        return positions;
    }

    public String getName() {
        return "锋矢阵";
    }
}
