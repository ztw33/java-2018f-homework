package Formations;

import Source.Global;

public class QueueSix extends Formation{

    //MARK:Initialize
    public QueueSix(boolean isBro){

        if(isBro == true){

            /*calabash queue6*/

            map.clearCalabash();

            map.setPosition(4,1, Global.calabashBrother.getCalabash(1));
            map.setPosition(3,3, Global.calabashBrother.getCalabash(2));
            map.setPosition(5,3, Global.calabashBrother.getCalabash(3));
            map.setPosition(2,5, Global.calabashBrother.getCalabash(4));
            map.setPosition(6,5, Global.calabashBrother.getCalabash(5));
            map.setPosition(3,7, Global.calabashBrother.getCalabash(6));
            map.setPosition(5,7, Global.calabashBrother.getCalabash(7));

            map.setPosition(0,4,Global.grandFather);

        }
        else{

            /*monster queue6*/

            map.clearMonster();

            map.setPosition(14,1,Global.monsters.getMonster(1));
            map.setPosition(13,3,Global.monsters.getMonster(2));
            map.setPosition(15,3,Global.monsters.getMonster(3));
            map.setPosition(12,5,Global.monsters.getMonster(4));
            map.setPosition(16,5,Global.monsters.getMonster(5));
            map.setPosition(13,7,Global.monsters.getMonster(6));
            map.setPosition(15,7,Global.monsters.getMonster(7));

            map.setPosition(18,3,Global.snake);
            map.setPosition(18,5,Global.scorpion);

        }
    }
}
