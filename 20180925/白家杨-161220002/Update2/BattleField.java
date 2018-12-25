package Update2;

import Update2.Creature.Creature;
import Update2.Creature.Evil;
import Update2.Creature.God;
import Update2.Strategy.*;

public class BattleField {
    private Creature[][] map;
    final int row = 15;
    final int col = 20;

    //展示战场上的信息
    public void display() {
        System.out.println("/-------------------------------------------------/");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j].Show();
            }
            System.out.println(" ");
        }
        System.out.println("/-------------------------------------------------/");
    }

    //初始化战场，战场上长满草
    public BattleField() {
        map = new Creature[row][col];
        clear();
    }

    //清扫战场
    public void clear() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = new Creature();
            }
        }
    }
    public void ClearEvil(){
        for (int i = 0; i < row; i++) {
            for (int j = 10; j < col; j++) {
                map[i][j] = new Creature();
            }
        }
    }
    //得到地图
    public Creature[][] getMap() {
        return map;
    }

    //安排生物到地图上
    public void SetCreature(int x, int y, Creature a) {
        map[x][y] = a;
    }

    /*public void hello(String[] args) {
        BattleField ground = new BattleField();
        ground.display();
        ground.clear();
        System.out.println("/*******************************");*/
/*        God god = new God();
        //这里可以扩展通过输入来选择阵法
        god.UseStrategy(new Changshe(), ground);

        Evil demon = new Evil();
        demon.UseStrategy(new Changshe(),ground);
        System.out.println("长蛇阵");
        ground.display();
        ground.ClearEvil();
        demon.UseStrategy(new Yanxing(),ground);
        System.out.println("雁行阵");
        ground.display();
        ground.ClearEvil();
        demon.UseStrategy(new Fangyuan(),ground);
        System.out.println("方圆阵");
        ground.display();
        ground.ClearEvil();
        demon.UseStrategy(new Henggui(),ground);
        System.out.println("衡轭阵");
        ground.display();
        ground.ClearEvil();
        demon.UseStrategy(new Heyi(),ground);
        System.out.println("鹤翼阵");
        ground.display();
        ground.ClearEvil();
        demon.UseStrategy(new Yuling(),ground);
        ground.display();
        ground.ClearEvil();
        demon.UseStrategy(new Yanyue(),ground);
        System.out.println("偃月阵");
        ground.display();
        ground.ClearEvil();
        demon.UseStrategy(new Fengshi(),ground);
        System.out.println("锋矢阵");
        ground.display();
    }
*/
}
