import java.awt.*;
/*
* 任务类型
* */
class CucurbitBoy extends Charactor
{
    static protected int nextid=0;     //每个葫芦娃都是唯一的，nextid用来记录下一个未出生的葫芦娃排行
    public CucurbitBoyProp prop;
    public CucurbitBoy(int sx, int sy, int nx, int ny) throws Exception
    {
        super(sx, sy, nx, ny);
        if(nextid>=7)
            throw new Exception("葫芦娃只能有七个！");
        prop=CucurbitBoyProp.values()[CucurbitBoy.nextid];
        this.name=prop.name;
        this.basename=prop.basename;
        nextid++;
    }
}

class Grandpa extends Charactor
{
    public Grandpa(int sx, int sy, int nx, int ny)
    {
        super(sx, sy, nx, ny);
        basename="grandpa";
        name="老爷爷";
    }
}

class Snake extends Charactor
{
    public Snake(int sx, int sy, int nx, int ny)
    {
        super(sx, sy, nx, ny);
        basename="snake";
        name="蛇精";
    }
}

class Roro extends Charactor
{
    public Roro(int sx, int sy, int nx, int ny)
    {
        super(sx, sy, nx, ny);
        basename="roro";
        name="小喽啰";
    }
}

class Scorpion extends Charactor
{
    public int curFMT=-1;
    private formations[] learnedFormations=new formations[]{new Fengshi(), new Yanyue(), new Yulin()};       //蝎子精学过的阵型
    public Roro[] troops=new Roro[13];                  //每个蝎子精带有13个小喽啰
    public Scorpion(int sx, int sy, int nx, int ny)
    {
        super(sx, sy, nx, ny);
        name="蝎子精";
        basename="scorpion";
        for(int i=0;i<troops.length;i++)
            troops[i]=new Roro(sx, sy, nx, ny);
    }
    public void changeFMT(int index)                             //蝎子精改变阵型，并且要求喽罗们按照新阵型站队
    {
        if(!alive)        //如果蝎子精战死则所有喽啰群龙无首，不再移动
            return;
        curFMT=index%learnedFormations.length;
        int vx=virtualField.width-learnedFormations[curFMT].rightDistance-2;
        int vy=(virtualField.height-1)/2;
        Point realPst=virtualField.vpTorp(vx,vy);
        moveto(realPst.x, realPst.y);
        for(int i=0;i<troops.length;i++) {
            int Rorovx=vx+learnedFormations[curFMT].RelativePosition[i][0];
            int Rorovy=vy+learnedFormations[curFMT].RelativePosition[i][1];
            if(troops[i].alive)
            {
                troops[i].moveto(virtualField.vpTorp(Rorovx, Rorovy));
            }
        }
    }
}