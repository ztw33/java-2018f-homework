package Formations;

import Source.Global;

public class QueueFour extends Formation{

    //MARK:Initialize;
    public QueueFour(boolean isBro){

        if(isBro == true){

            /*calabash queue4*/

            map.clearCalabash();

            map.setPosition(3,1, Global.calabashBrother.getCalabash(1));
            map.setPosition(3,2,Global.calabashBrother.getCalabash(2));
            map.setPosition(3,3,Global.calabashBrother.getCalabash(3));
            map.setPosition(3,4,Global.calabashBrother.getCalabash(4));
            map.setPosition(3,5,Global.calabashBrother.getCalabash(5));
            map.setPosition(3,6,Global.calabashBrother.getCalabash(6));
            map.setPosition(3,7,Global.calabashBrother.getCalabash(7));

            map.setPosition(1,4,Global.grandFather);

        }
        else{

            /*monsters queue4*/

            map.clearMonster();

            map.setPosition(17,1,Global.monsters.getMonster(1));
            map.setPosition(17,2,Global.monsters.getMonster(2));
            map.setPosition(17,3,Global.monsters.getMonster(3));
            map.setPosition(17,4,Global.monsters.getMonster(4));
            map.setPosition(17,5,Global.monsters.getMonster(5));
            map.setPosition(17,6,Global.monsters.getMonster(6));
            map.setPosition(17,7,Global.monsters.getMonster(7));

            map.setPosition(19,3,Global.snake);
            map.setPosition(19,5,Global.scorpion);

        }
    }
}
