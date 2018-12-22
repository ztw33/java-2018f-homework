package Formations;

import Source.Global;

import java.io.FileNotFoundException;

public class QueueOne extends Formation{

    //MARK:Initialize;
    public QueueOne(boolean isBro){

        if(isBro == true){

            /*Calabash queue1*/

            map.clearCalabash();

            map.setPosition(3,4,Global.calabashBrother.getCalabash(1));
            map.setPosition(4,5,Global.calabashBrother.getCalabash(2));
            map.setPosition(5,6,Global.calabashBrother.getCalabash(3));
            map.setPosition(6,7,Global.calabashBrother.getCalabash(4));
            map.setPosition(7,6,Global.calabashBrother.getCalabash(5));
            map.setPosition(8,5,Global.calabashBrother.getCalabash(6));
            map.setPosition(9,4,Global.calabashBrother.getCalabash(7));

            map.setPosition(6,2,Global.grandFather);
        }
        else {

            /*Monster Queue1*/

            map.clearMonster();

            map.setPosition(12,4,Global.monsters.getMonster(1));
            map.setPosition(13,5,Global.monsters.getMonster(2));
            map.setPosition(14,6,Global.monsters.getMonster(3));
            map.setPosition(15,7,Global.monsters.getMonster(4));
            map.setPosition(16,6,Global.monsters.getMonster(5));
            map.setPosition(17,5,Global.monsters.getMonster(6));
            map.setPosition(18,4,Global.monsters.getMonster(7));

            map.setPosition(14,2,Global.scorpion);
            map.setPosition(16,2,Global.snake);
        }

    }
}