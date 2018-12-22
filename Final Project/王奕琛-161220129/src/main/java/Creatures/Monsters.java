package Creatures;

import java.io.FileNotFoundException;

public class Monsters {

    //MARK:Properties;
    Monster[] monsters;

    //MARK:Initialize;
    public Monsters(){
        monsters = new Monster[7];
        for(int i = 0; i < 7; i++) {
                monsters[i] = new Monster();
        }
    }

    //MARK:function
    public Monster getMonster(int i){
        if(i > 7)
            return null;
        return monsters[i-1];
    }

}
