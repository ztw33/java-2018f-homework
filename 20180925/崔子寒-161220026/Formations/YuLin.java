package Formations;

import Attributes.Position;
import javafx.geometry.Pos;

public class YuLin implements FormationProvider{
    public Position[] provideFormation() {
        Position[] positions = {new Position(3,4),new Position(4,4),new Position(4,5), new Position(5,3),
                new Position(5,4),new Position(5,5),new Position(5,6),new Position(6,4)};
        return positions;
    }

    public String getName() {
        return "鱼鳞阵";
    }
}
