package Creature;

import java.util.ArrayList;

public class MonsterAdapter {
    public static ArrayList<Monster> mices = new ArrayList<Monster>();

    public static void initMice(){
        for(int i = 0;i < 8;i++){
            mices.add(new Monster("Mouse"+String.valueOf(i+1),"mouse.jpg",9,"REDCIRCLE.png"));
        }
    }
}
