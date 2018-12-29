package formation;

import IO.BufferedInputFile;
import creature.CalabashBrother;
import creature.Position;
import creature.Scorpion;
import creature.Soldier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public  class Formation {
    private String name;

    public  void form_C_formation(List<CalabashBrother> a){}
    public  void form_S_formation(List<Soldier> a){}
    public  void form_S_Random_formation(List<Soldier> a, BufferedInputFile input, Scorpion scorpion)throws IOException{
        int k = 0;
        Soldier s;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 21; j++) {
                char ch = input.charFromInput();
                if (ch == '-') {
                    s = a.get(k);
                    Position p = new Position(i, j);
                    s.setPosition(p);
                    a.set(k, s);
                    k++;
                }
                else if(ch == '+')
                    scorpion.setPosition(new Position(i,j));
            }
        }
    }
}
