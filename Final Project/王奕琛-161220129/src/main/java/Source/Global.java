package Source;

import Creatures.*;
import Formations.Map;
import Thread.Game;

public final class Global {

    //MARK:Properties;

    //行数
    public static final int rowCount = 10;
    //列数
    public static final int colCount = 20;
    //单个方块的高
    public static final double height = 50;
    //单个方块的宽
    public static final double width = 50;
    //背景图片;
    public static final String backGroundURL = "/images/backGround.jpg";
    //图片加载失败是加载该图片;
    public static final String defaultImageURL = "/images/defaultPhoto.png";
    //生物死亡图片
    public static final String deadImageURL = "/images/dead.png";
    //主地图
    public static final Map map = new Map();

    //葫芦娃
    public static final Calabashbrother calabashBrother = new Calabashbrother();
    //妖怪
    public static final Monsters monsters = new Monsters();
    //爷爷
    public static final GrandFather grandFather = new GrandFather();
    //蛇精
    public static final Snake snake = new Snake();
    //蝎精
    public static final Scorpion scorpion = new Scorpion();

    //游戏单元
    public static final Game game = new Game();


    //MARK: function
    public static boolean isHuluFailed(){
        if(Global.grandFather.isAlive())
            return false;
        for(int i = 1; i <= 7; i++){
            if(Global.calabashBrother.getCalabash(i).isAlive())
                return false;
        }
        return true;
    }

    public static boolean isMonFailed(){
        if(Global.snake.isAlive())
            return false;
        if(Global.scorpion.isAlive())
            return false;
        for(int i = 1; i <= 7; i++){
            if(Global.monsters.getMonster(i).isAlive())
                return false;
        }
        return true;
    }

    public static void creatureInit(){
        Global.map.clearMap();
        for(int i = 1; i <= 7; i++)
            Global.calabashBrother.getCalabash(i).init();
        Global.grandFather.init();
        for(int i = 1; i <= 7; i++)
            Global.monsters.getMonster(i).init();
        Global.scorpion.init();
        Global.snake.init();
    }

}
