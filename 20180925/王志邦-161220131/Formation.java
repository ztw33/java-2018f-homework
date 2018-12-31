import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.nio.file.*;
import java.io.IOException;

public class Formation {
    private final Tuple[][] formation = {{new Tuple(9, 4), new Tuple(8, 4), new Tuple(7, 4), new Tuple(6, 4), new Tuple(5, 4), new Tuple(4, 4), new Tuple(3, 4)},
            {new Tuple(11, 4), new Tuple(12, 3), new Tuple(12, 4), new Tuple(12, 5), new Tuple(13, 2), new Tuple(13, 4), new Tuple(13, 6), new Tuple(14, 4), new Tuple(15, 4)},
            {new Tuple(11, 0), new Tuple(12, 1), new Tuple(13, 2), new Tuple(14, 3), new Tuple(15, 4), new Tuple(16, 5), new Tuple(17, 6), new Tuple(18, 7), new Tuple(19, 8)},
            {new Tuple(11, 4), new Tuple(12, 5), new Tuple(13, 4), new Tuple(14, 5), new Tuple(15, 4), new Tuple(16, 5), new Tuple(17, 4), new Tuple(18, 5), new Tuple(19, 4)},
            {new Tuple(15, 4), new Tuple(11, 0), new Tuple(11, 8), new Tuple(12, 1), new Tuple(12, 7), new Tuple(13, 2), new Tuple(13, 6), new Tuple(14, 3), new Tuple(14, 5)},
            {new Tuple(11, 3), new Tuple(12, 4), new Tuple(12, 5), new Tuple(13, 4), new Tuple(13, 5), new Tuple(13, 6), new Tuple(14, 4), new Tuple(14, 5), new Tuple(15, 3)},
    };

    public void printFormation(int formationI){
        for(int i = 0; i < formation[formationI].length; ++i)
            System.out.print(formation[formationI][i].x + "," + formation[formationI][i].y + " ");
        System.out.println();
    }

    public void setPosition(Creature[] creatures, int formationI){
        for(int i = 0; i < creatures.length; ++i)
            creatures[i].setPosition(formation[formationI][i]);
    }
}
