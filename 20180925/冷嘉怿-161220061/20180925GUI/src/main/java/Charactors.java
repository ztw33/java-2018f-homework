import javax.swing.*;
import java.awt.*;

public class Charactors {       //角色类
    public String typename;        //每个角色有自己的名字
    public String basename;
    ImageIcon baseimg;
    ImageIcon movingimg;
    ImageIcon regularattack;
    ImageIcon AOE;
    ImageIcon ZXC;

    protected BackGroundPanel world;         //每个角色所在的容器
    protected JLabel testLabel=new JLabel("T");     //每个角色在界面中表现为一个具有特殊图片的JLabel
    public boolean animate=false;


    public int positionX,positionY;         //每个角色有自己的位置坐标
    public int nextX=0, nextY=0;
    public double tmpX=0,tmpY=0;
    public char testview;                    //在命令行中输出代表的字符
    public boolean alive=true;              //角色是否存活
    public boolean monster=true;                 //是否为敌人
    public void load()
    {
        baseimg=new ImageIcon(this.getClass().getResource(basename+".PNG"));
        baseimg.setImage(baseimg.getImage().getScaledInstance(world.deltax, world.deltay, Image.SCALE_SMOOTH));
        movingimg=new ImageIcon(this.getClass().getResource(basename+"mov1.PNG"));
        movingimg.setImage(movingimg.getImage().getScaledInstance(world.deltax, world.deltay, Image.SCALE_SMOOTH));

        int size=BattleField.selectionsize;
        if(monster==false)
        {
            regularattack=new ImageIcon(this.getClass().getResource("tmpskill.PNG"));
            regularattack.setImage(regularattack.getImage().getScaledInstance(size,size, Image.SCALE_SMOOTH));
            AOE=new ImageIcon(this.getClass().getResource("tmpskill.PNG"));
            AOE.setImage(AOE.getImage().getScaledInstance(size,size, Image.SCALE_SMOOTH));
            ZXC=new ImageIcon(this.getClass().getResource("tmpskill.PNG"));
            ZXC.setImage(ZXC.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH));
        }
    }
    public void moveto(int x,int y)          //移动到新位置
    {
        nextX=x;
        nextY=y;
        animate=true;
    }
    public int realX(int x)
    { return world.xstart+x*world.deltax; }
    public int realY(int y)
    { return world.ystart+y*world.deltay; }
    public void StandStill()                 //更新自己在战场上的位置信息
    {
        if(alive) {         //只有活着的角色能够在战场上移动
//            virtualField.field[positionY][positionX] = testview;
            testLabel.setBounds(world.xstart+positionX*world.deltax,world.ystart+positionY*world.deltay,testLabel.getWidth(),testLabel.getHeight());
        }
    }
}
class Rank{         //为所有角色分等级，默认高级角色可以指挥低级角色，并且对立阵营角色在本方心中为等级最低
    static public String[] MonsterClass=new String[]{"小喽啰","蝎子精","蛇精","青蛇精"};       //妖怪阵营等级（由低到高）
    static public String[] HumanClass=new String[]{"百姓","老七","老六","老五","老四","老三","老二","老大","兄弟们","爷爷"};     ////人类阵营等级（由低到高
    static public int find(String str, boolean human)       //查询某一角色的等级，如果非同一阵营则返回最低等级-1
    {
        int index=0;
        if(human) {
            for (; index < HumanClass.length; index++)
                if (str.equals(HumanClass[index]))
                    return index;
            return -1;
        }
        else
        {
            for (; index < MonsterClass.length; index++)
                if (str.equals(MonsterClass[index]))
                    return index;
            return -1;
        }
    }

}

enum CucurbitBoys{          //葫芦娃兄弟们的枚举类型
    RedBro, OrangeBro, YellowBro, GreenBro, BlueBro, IndigoBro, VioletBro;
    static protected String[] names={"老大","老二","老三","老四","老五","老六","老七"};
    static protected String[] colors={"红色","橙色","黄色","绿色","青色","蓝色","紫色"};
    static protected String[] imgname={"brother1.PNG","brother2.PNG","brother3.PNG","brother4.PNG","brother5.PNG","brother6.PNG","brother7.PNG"};
    public String getName(){ return names[ordinal()]; }
    public String getColor(){ return colors[ordinal()]; }
    public String getImg(){ return imgname[ordinal()]; }
}

class Grandpa extends Charactors        //老爷爷
{
    Grandpa(BackGroundPanel father)
    {               //老爷爷初始时在战场左下角观战
        world=father;
        basename="grandpa";
        monster=false;
        load();
        testLabel.setSize(father.deltax,father.deltay);
        testLabel.setIcon(baseimg);
        testLabel.setOpaque(false);
        world.add(testLabel);           //将老爷爷加入战场界面中
        nextX=positionX=0;
        nextY=positionY=virtualField.height-1;
        typename="爷爷";
        testview='Y';
    }
}

class CucurbitBoy extends Charactors        //葫芦娃类
{
    //按照排行顺序存放葫芦娃的姓名和颜色
    static protected int nextid=0;     //每个葫芦娃都是唯一的，nextid用来记录下一个未出生的葫芦娃排行
    private CucurbitBoys id;            //每个葫芦娃拥有自己的id，描述他在兄弟中的排行
    private int innerPosition;        //葫芦娃在队列内部的位置
    CucurbitBoy(BackGroundPanel father) throws Exception {
        world=father;
        this.id=CucurbitBoys.values()[CucurbitBoy.nextid];
        typename=id.getName();
        basename="brother"+(id.ordinal()+1);
        this.monster=false;
        load();
        testLabel.setSize(father.deltax,father.deltay);
        testLabel.setIcon(baseimg);
        testLabel.setOpaque(false);
        world.add(testLabel);           //将葫芦娃加入界面中
        //每个葫芦娃只能出生一次，并且最多有七个
        if(CucurbitBoy.nextid>=7)
        {
            throw new Exception("葫芦娃只有七个！");
        }
        //为葫芦娃分配排行
        testview=(char)('1'+this.getID());

        CucurbitBoy.nextid++;
    }
    //返回自己的名字
    public String tellName(){ return id.getName(); }
    //返回自己的颜色
    public String tellColor(){ return id.getColor(); }
    //返回自己的排行
    public int getID(){ return id.ordinal(); }
    public void setInnerPosition(String type, int newpst)       //设定该葫芦娃在兄弟队伍中的相对位置
    {
        if(Rank.find(typename,true)>Rank.find(type,true))       //如果等级比自己低则无权指挥自己
            return;
        innerPosition=newpst;
    }
    public void resort(String type, int mx, int my)             //按照兄弟们整体的位置重新站队
    {
        if(Rank.find(typename,true)>Rank.find(type,true))
            return;
        moveto(mx, my+innerPosition);
    }

}

class Roro extends Charactors           //小喽啰类
{
    public int number;                  //小喽啰的编号
    private formations curFMT=null;     //小喽啰们当前应该站的阵型
    public Roro(BackGroundPanel father){
        world=father;
        basename="Roro";
        load();
        testLabel.setSize(father.deltax,father.deltay);
        testLabel.setIcon(baseimg);
        testLabel.setOpaque(false);
        world.add(testLabel);           //将小喽啰加入界面中
        typename="小喽啰";
        testview='R';
    }
    public void resort(String type, int mx, int my, formations FMT)         //在高级妖怪要求换阵型时，每个小喽啰重新找到自己应该站的位置
    {
        if(Rank.find(typename,false)>Rank.find(type,false))
            return;
        curFMT=FMT;
//        System.out.println(curFMT.rightDistance);
        int npX=mx+curFMT.RelativePosition[number][0];          //这两项是在当前阵法中这个小喽啰正确的位置坐标
        int npY=my+curFMT.RelativePosition[number][1];
        moveto(npX, npY);
    }
}

class Scorpion extends Charactors                       //蝎子精
{
    private int curFMT=-1;
    private formations[] learnedFormations=new formations[]{new Fengshi(), new Yanyue()};       //蝎子精学过的阵型
    public Roro[] troops=new Roro[18];                  //每个蝎子精带有18个小喽啰
    public Scorpion(BackGroundPanel father)
    {
        world=father;
        basename="scorption";
        load();
        testLabel.setSize(father.deltax,father.deltay);
        testLabel.setIcon(baseimg);
        testLabel.setOpaque(false);
        world.add(testLabel);       //将蝎子精加入战场界面中
        typename="蝎子精";
        testview='X';
        for(int i=0;i<troops.length;i++) {
            troops[i]=new Roro(world);
            troops[i].number = i;                       //蝎子精为小喽啰编号
        }
        changeFMT();                                      //开始列阵
    }

    @Override
    public void StandStill()                            //蝎子精不仅要更新自己的位置，并且要告诉喽罗们更新他们的位置
    {
        super.StandStill();
        if(alive==false)                                //如果蝎子精死了，则喽罗们会一哄而散
            return;
        for(int i=0;i<troops.length;i++)
            troops[i].StandStill();
    }

    public void changeFMT()                             //蝎子精改变阵型，并且要求喽罗们按照新阵型站队
    {
        curFMT=(curFMT+1)%learnedFormations.length;
        moveto(virtualField.width-learnedFormations[curFMT].rightDistance-1,virtualField.height/2);
        for(int i=0;i<troops.length;i++) {
            troops[i].resort(typename,nextX,nextY,learnedFormations[curFMT]);
        }
    }
}

class Snake extends Charactors          //蛇精
{
    public Snake(BackGroundPanel father)
    {                                     //蛇精初始时在战场右上角观战
        world=father;
        basename="snake";
        load();
        testLabel.setSize(father.deltax,father.deltay);
        testLabel.setIcon(baseimg);
        testLabel.setOpaque(false);
        world.add(testLabel);
        nextX=positionX=virtualField.width-1;
        nextY=positionY=0;
        typename="蛇精";
        testview='S';
    }
}