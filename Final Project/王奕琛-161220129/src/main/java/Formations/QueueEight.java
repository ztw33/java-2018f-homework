package Formations;

import Source.Global;

public class QueueEight extends Formation{

    //MARK:Initialize
    public QueueEight(boolean isBro){

        if(isBro == true){

            /*calabash queue8*/

            map.clearCalabash();

            map.setPosition(8,4, Global.calabashBrother.getCalabash(1));
            map.setPosition(7,3, Global.calabashBrother.getCalabash(2));
            map.setPosition(7,5, Global.calabashBrother.getCalabash(3));
            map.setPosition(6,2, Global.calabashBrother.getCalabash(4));
            map.setPosition(6,6, Global.calabashBrother.getCalabash(5));
            map.setPosition(5,4, Global.calabashBrother.getCalabash(6));
            map.setPosition(5,4, Global.calabashBrother.getCalabash(7));

            map.setPosition(3,4,Global.grandFather);

        }
        else{

            /*monster queue8*/

            map.clearMonster();

            map.setPosition(12,4,Global.monsters.getMonster(1));
            map.setPosition(13,3,Global.monsters.getMonster(2));
            map.setPosition(13,5,Global.monsters.getMonster(3));
            map.setPosition(14,2,Global.monsters.getMonster(4));
            map.setPosition(14,6,Global.monsters.getMonster(5));
            map.setPosition(15,4,Global.monsters.getMonster(6));
            map.setPosition(16,4,Global.monsters.getMonster(7));

            map.setPosition(18,3,Global.snake);
            map.setPosition(18,5,Global.scorpion);

        }
    }

}
