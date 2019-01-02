package Formations;

import Attributes.Position;

public class ChangShe implements FormationProvider{
    public Position[] provideFormation() {
        Position[] positions ={new Position(1,5),new Position(2,5),new Position(3,5), new Position(4,5),
                new Position(5,5),new Position(6,5),new Position(7,5),new Position(8,5)};
        return positions;
    }

    public String getName() {
        return "长蛇阵";
    }
}
