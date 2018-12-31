package Battle;

class createException extends Exception{};

interface Cheerable{
    void cheerUp();
}

public class Creatures {
    public String name;                //生物体名字
    /*
    血量、法力值、攻击力、技能冷却时间等游戏属性
     */
    public int px,py;                  //在二维空间中的位置

    Creatures(){
        px=py=-1;                      //新诞生的生物体尚未放置在战场上
    }

    public void moveto(int x,int y){
        if(px>=0&&py>=0&&BattleField.field[px][py].getBody()==this){
            BattleField.field[px][py].setBody(null);
        }
        px=x;
        py=y;
        BattleField.field[x][y].setBody(this);
    }
}

//葫芦娃的枚举类
enum CalabashBrothers{
    RED("红色", "大娃", 1), ORANGE("橙色", "二娃", 2), YELLOW("黄色", "三娃", 3),GREEN("绿色", "四娃", 4),
        CYAN("青色", "五娃", 5), BLUE("蓝色", "六娃", 6), PURPLE("紫色", "七娃", 7);
    public String color;   //颜色
    public String rank;    //排行
    public int index;      //用于排序

    private CalabashBrothers(String str1, String str2, int r) {
        this.color = str1;
        this.rank = str2;
        this.index = r;
    }
}

//葫芦娃类
class CbBrother extends Creatures{
    private static int birth=0;
    CalabashBrothers me;

    //private构造函数禁止new创建对象，按大娃到七娃的顺序产生葫芦娃
    CbBrother() throws createException{
        if(birth>=7){
            throw new createException();
        }
        me=CalabashBrothers.values()[birth++];
        name=me.rank;
    }

    public void queueMove(CbBrother[] queue,int target){
        queue[target]=this;
    }
}

//蝎子精类
class Scorpion extends Creatures{
    private static boolean isBirth=false;

    Scorpion() throws createException{
        if(isBirth){
            throw new createException();
        }
        name="蝎子";
        isBirth=true;
    }
}

//小喽啰类
class Soldier extends Creatures{
    private static int birth=0;
    public static final int max=12;            //暂定为12个小喽啰

    Soldier() throws createException{
        if(birth>=max){
            throw new createException();
        }
        name="喽啰";
    }
}

//老爷爷类
class GrandPa extends Creatures implements Cheerable{
    private static boolean isBirth=false;

    GrandPa() throws createException{
        if(isBirth){
            throw new createException();
        }
        name="爷爷";
        isBirth=true;
    }

    public void cheerUp(){

    }
}

class Snake extends Creatures implements Cheerable{
    private static boolean isBirth=false;

    Snake() throws createException{
        if(isBirth){
            throw new createException();
        }
        name="蛇精";
        isBirth=true;
    }

    public void cheerUp(){

    }
}