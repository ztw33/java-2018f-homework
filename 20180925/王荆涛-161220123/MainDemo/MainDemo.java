package MainDemo;

import Ground.*;

public class MainDemo {
    public static void main(String[] args){
        //创建战场实例,初始化为空
        GroundCreater battleGround = new GroundCreater();
        //紧接着打印战场
        battleGround.initGround();
        battleGround.showGround();

        battleGround.goodGuys.initGrandfather();
        battleGround.goodGuys.grandfather.addToBattle();
        battleGround.goodGuys.grandfather.changeFormation("长蛇", battleGround.calabashpos);
        battleGround.refreshGround();
        battleGround.showGround();
        System.out.println();

        battleGround.initMonsters();
        battleGround.monsters.initSnake();
        battleGround.monsters.snake.addToBattle();
        battleGround.monsters.snake.changeFormation("雁行", battleGround.monsterpos);
        battleGround.refreshGround();
        battleGround.showGround();
        System.out.println();

        battleGround.monsters.snake.changeFormation("鱼鳞", battleGround.monsterpos);
        battleGround.refreshGround();
        battleGround.showGround();
        System.out.println();

        battleGround.monsters.snake.changeFormation("偃月", battleGround.monsterpos);
        battleGround.refreshGround();
        battleGround.showGround();
        System.out.println();
    }
}
