package Formations;

import Source.Global;

public class QueueSeven extends Formation {

    //MARK:Initialize
    public QueueSeven(boolean isBro){

        if(isBro == true){

            /*calabash queue7*/

            map.clearCalabash();

            map.setPosition(8,4, Global.calabashBrother.getCalabash(1));
            map.setPosition(7,5, Global.calabashBrother.getCalabash(2));
            map.setPosition(8,6, Global.calabashBrother.getCalabash(3));
            map.setPosition(6,4, Global.calabashBrother.getCalabash(4));
            map.setPosition(6,6, Global.calabashBrother.getCalabash(5));
            map.setPosition(5,3, Global.calabashBrother.getCalabash(6));
            map.setPosition(5,7, Global.calabashBrother.getCalabash(7));

            map.setPosition(3,5,Global.grandFather);

        }
        else{

            /*monster queue7*/

            map.clearMonster();

            map.setPosition(11,4,Global.monsters.getMonster(1));
            map.setPosition(11,6,Global.monsters.getMonster(2));
            map.setPosition(12,5,Global.monsters.getMonster(3));
            map.setPosition(13,4,Global.monsters.getMonster(4));
            map.setPosition(13,6,Global.monsters.getMonster(5));
            map.setPosition(14,3,Global.monsters.getMonster(6));
            map.setPosition(14,7,Global.monsters.getMonster(7));

            map.setPosition(16,4,Global.snake);
            map.setPosition(16,6,Global.scorpion);

        }
    }

}
