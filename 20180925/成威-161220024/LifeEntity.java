package Battle;

import java.util.Random;

//生命体
class LifeEntity{
    //此后的游戏可添加 生命值等属性
    String label;   //不同生命体打印显示的字符

    int lrow,lcol;  //生命体在二维空间中的当前位置

    LifeEntity(){
        lrow=lcol=-1;   //生命体诞生时不在该二维空间中
    }

    //将生命体移动到二维空间的指定位置，更新位置信息
    public void twomove(LifeEntity[][] ground,int r,int c){
            if (lrow >= 0 && lcol >= 0 && ground[lrow][lcol] == this)
                ground[lrow][lcol] = null;
            lrow = r;
            lcol = c;
            ground[r][c] = this;
    }
}

//葫芦娃的枚举类
enum CalabashBrothers{
    RED("红色", "老大", 1), ORANGE("橙色", "老二", 2), YELLOW("黄色", "老三", 3), GREEN("绿色", "老四", 4), CYAN("青色", "老五", 5), BLUE("蓝色", "老六", 6), PURPLE("紫色", "老七", 7);
    String color;   //颜色
    String rank;    //排行
    int index;      //用于排序

    CalabashBrothers(String str1, String str2, int r) {
        this.color = str1;
        this.rank = str2;
        this.index = r;
    }
}

//继承于LifeEntity的葫芦娃类
class CalabashBrother extends LifeEntity{
    static protected int birth=0;
    CalabashBrothers me;

    //private构造函数，按大娃到七娃的顺序产生葫芦娃
    private CalabashBrother(){
        me=CalabashBrothers.values()[birth++];
        label=me.rank;
    }

    //通过这个函数创建对象，并限定只有大娃到七娃这七个葫芦娃
    public static CalabashBrother cb_birth(){
        if(birth>=7)
            return null;
        else
            return new CalabashBrother();
    }

    //在葫芦娃队列这个一维空间内的移动，用于排序
    public void onemove(CalabashBrother[] cb,int destination){cb[destination]=this;}
}

//老爷爷类
class Grandpa extends LifeEntity {
    static Grandpa one=new Grandpa();

    private Grandpa(){
        label="爷爷";
    }

    public static Grandpa gp_birth(){
        return one;
    }   //限定只能创建一个老爷爷对象，下同

    //葫芦娃队列的随机排序
    public void randomsort(CalabashBrother[] cb) {
        Random random = new Random();
        for (int i = 1; i < 7; i++) {
            int p = random.nextInt(i + 1);
            CalabashBrother temp = cb[i];
            cb[p].onemove(cb, i);
            temp.onemove(cb, p);
        }
    }

    //葫芦娃队列冒泡排序
    public void bubblesort(CalabashBrother[] cb) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7 - i - 1; j++) {
                if (cb[j].me.index > cb[j + 1].me.index) {
                    CalabashBrother temp = cb[j];
                    cb[j + 1].onemove(cb, j);
                    temp.onemove(cb, j + 1);
                }
            }
        }
    }

    //将当前葫芦娃队列在二维空间内摆成长蛇阵
    public void snaketeam(LifeEntity[][] ground,CalabashBrother[] cb){
        for(int i=0;i<7;i++)
            cb[i].twomove(ground,5+i,6);
    }
}

//蛇精类
class Snake extends LifeEntity{
    static Snake one=new Snake();

    private Snake(){
        label="蛇精";
    }

    public static Snake se_birth(){
        return one;
    }

    //鹤翼阵
    public void cranewing(LifeEntity[][] ground,Scorpion sp,Little[] lm){
        sp.twomove(ground,8,16);
        int i=0;
        for(int j=1;j<=6;j++) {
            lm[i++].twomove(ground, 8 - j, 16 - j);
            lm[i++].twomove(ground, 8 + j, 16 - j);
        }
    }

    //锋矢阵
    public void arrow(LifeEntity[][] ground,Scorpion sp,Little[] lm){
        sp.twomove(ground,8,10);
        int i=0;
        for(int j=1;j<=6;j++)
            lm[i++].twomove(ground,8,10+j);
        for(int j=1;j<=3;j++){
            lm[i++].twomove(ground,8-j,10+j);
            lm[i++].twomove(ground,8+j,10+j);
        }
    }
}

//蝎子精类
class Scorpion extends LifeEntity{
    static Scorpion one=new Scorpion();

    private Scorpion(){
        label="蝎子";
    }

    public static Scorpion sp_birth(){
        return one;
    }
}

//小喽啰类
class Little extends LifeEntity{
    Little(){
        label="喽啰";
    }
}
