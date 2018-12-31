package Ground;
import CommonMethods.PointNode;
import Creature.*;
/**
 * 二维空间构造器
 * 用于产生和刷新原始战场
 * 该构造器继承了单个坐标的抽象类
 * 仅仅产生一个新的战斗场景，不提供生物排列
 */
public class GroundCreater extends Point{
    private static int maxSize = 15;
    private static Point[][] ground = new Point[maxSize][maxSize];
    public PointNode[] calabashpos= new PointNode[7];
    public PointNode[] monsterpos = new PointNode[7];
    private CalabashBoy.boy[] calabashBoys;
    public CreatureCreater goodGuys;
    public CreatureCreater monsters;

    public GroundCreater(){
        for(int i = 0; i < maxSize; i++){
            for(int j =0 ; j < maxSize; j++){
                ground[i][j] = new Point();
                ground[i][j].setCreature(false);
            }
        }
        goodGuys = new CreatureCreater();
        goodGuys.initCalabashBoy();
        this.calabashBoys = goodGuys.getCalabashBoys();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public Point[][] getGround() {
        return this.ground;
    }

    public void setGround(Point[][] ground) {
        this.ground = ground;
    }

    public void initMonsters(){
        monsters = new CreatureCreater();
        monsters.initScorpion();
        monsters.initFlunky();
        monsterpos = monsters.initMonsterpos();
    }

    public void initGround(){
        goodGuys.initCalabash();
        calabashpos = goodGuys.getCalabashpos();
        for(int i = 0; i < 7; i++){
            ground[calabashpos[i].yPoint][calabashpos[i].xPoint].setCreature(true);
            ground[calabashpos[i].yPoint][calabashpos[i].xPoint].setName(calabashBoys[i].getName());
        }
    }

    public void refreshGround(){
        for(int i = 0; i < this.ground.length; i++){
            for(int j = 0; j < this.ground[0].length; j++){
                if(this.ground[i][j].isCreature())
                    this.ground[i][j].setCreature(false);
            }
        }

        //刷新葫芦娃位置
        for(int i = 0; i < 7; i++){
            ground[this.calabashpos[i].yPoint][this.calabashpos[i].xPoint].setCreature(true);
            ground[this.calabashpos[i].yPoint][this.calabashpos[i].xPoint].setName(this.calabashBoys[i].getName());
        }

        //刷新爷爷位置
        ground[goodGuys.grandfather.getyPoint()][goodGuys.grandfather.getxPoint()].setCreature(true);
        ground[goodGuys.grandfather.getyPoint()][goodGuys.grandfather.getxPoint()].setName(goodGuys.grandfather.getName());

        //刷新蛇精位置
        if(monsters != null) {
            ground[monsters.snake.getyPoint()][monsters.snake.getxPoint()].setCreature(true);
            ground[monsters.snake.getyPoint()][monsters.snake.getxPoint()].setName(monsters.snake.getName());
        }

        //刷新蝎子精位置
        if(monsters != null) {
            monsters.scorpion.setxPoint(this.monsterpos[3].xPoint);
            monsters.scorpion.setyPoint(this.monsterpos[3].yPoint);
            ground[monsters.scorpion.getyPoint()][monsters.scorpion.getxPoint()].setCreature(true);
            ground[monsters.scorpion.getyPoint()][monsters.scorpion.getxPoint()].setName(monsters.scorpion.getName());
        }

        //刷新小喽啰位置
        if(monsters != null) {

            for (int i = 0; i < 7; i++) {
                if(i != 3)
                    ground[this.monsterpos[i].yPoint][this.monsterpos[i].xPoint].setCreature(true);
            }
            for(int i = 0; i < 6; i++) {
                if(i >= 3)
                    ground[this.monsterpos[i + 1].yPoint][this.monsterpos[i + 1].xPoint].setName(this.monsters.flunkies[i].getName());
                else
                    ground[this.monsterpos[i].yPoint][this.monsterpos[i].xPoint].setName(this.monsters.flunkies[i].getName());
            }
        }

    }

    public void showGround(){
        for(int i = 0; i < this.ground.length; i++){
            for(int j = 0; j < this.ground[0].length; j++) {
                if(this.ground[i][j].isCreature()) {
                    System.out.print(ground[i][j].getName() + " ");
                }
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
}
