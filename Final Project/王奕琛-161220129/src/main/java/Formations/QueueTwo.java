package Formations;

import Source.Global;

public class QueueTwo extends Formation {

    //MARK:Initialize;
    public QueueTwo(boolean isBro){

        if(isBro == true){

            /*Calabash Queue2*/

            map.clearCalabash();

            map.setPosition(3,8,Global.calabashBrother.getCalabash(1));
            map.setPosition(4,7,Global.calabashBrother.getCalabash(2));
            map.setPosition(5,6,Global.calabashBrother.getCalabash(3));
            map.setPosition(6,5,Global.calabashBrother.getCalabash(4));
            map.setPosition(7,4,Global.calabashBrother.getCalabash(5));
            map.setPosition(8,3,Global.calabashBrother.getCalabash(6));
            map.setPosition(9,2,Global.calabashBrother.getCalabash(7));

            map.setPosition(2,5,Global.grandFather);

        }
        else{

            /*Monster Queue2*/

            map.clearMonster();

            map.setPosition(12,8,Global.monsters.getMonster(1));
            map.setPosition(13,7,Global.monsters.getMonster(2));
            map.setPosition(14,6,Global.monsters.getMonster(3));
            map.setPosition(15,5,Global.monsters.getMonster(4));
            map.setPosition(16,4,Global.monsters.getMonster(5));
            map.setPosition(17,3,Global.monsters.getMonster(6));
            map.setPosition(18,2,Global.monsters.getMonster(7));

            map.setPosition(19,6,Global.snake);
            map.setPosition(19,4,Global.scorpion);

        }
    }
}
