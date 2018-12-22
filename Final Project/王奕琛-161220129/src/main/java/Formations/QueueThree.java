package Formations;

import Source.Global;

public class QueueThree extends Formation{

    //MARK:Initialize
    public QueueThree(boolean isBro){

        if(isBro == true){

            /*calabash queue3*/

            map.clearCalabash();

            map.setPosition(5,1,Global.calabashBrother.getCalabash(1));
            map.setPosition(6,2,Global.calabashBrother.getCalabash(2));
            map.setPosition(5,3,Global.calabashBrother.getCalabash(3));
            map.setPosition(6,4,Global.calabashBrother.getCalabash(4));
            map.setPosition(5,5,Global.calabashBrother.getCalabash(5));
            map.setPosition(6,6,Global.calabashBrother.getCalabash(6));
            map.setPosition(5,7,Global.calabashBrother.getCalabash(7));

            map.setPosition(3,4,Global.grandFather);

        }
        else{

            /*monster queue3*/

            map.clearMonster();

            map.setPosition(13,1,Global.monsters.getMonster(1));
            map.setPosition(14,2,Global.monsters.getMonster(2));
            map.setPosition(13,3,Global.monsters.getMonster(3));
            map.setPosition(14,4,Global.monsters.getMonster(4));
            map.setPosition(13,5,Global.monsters.getMonster(5));
            map.setPosition(14,6,Global.monsters.getMonster(6));
            map.setPosition(13,7,Global.monsters.getMonster(7));

            map.setPosition(16,3,Global.snake);
            map.setPosition(16,5,Global.scorpion);

        }
    }
}
