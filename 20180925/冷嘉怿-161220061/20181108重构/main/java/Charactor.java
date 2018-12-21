import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/*
* 所有人物类型的基类
* */
public class Charactor implements Runnable{
    public AtomicInteger PositionX=new AtomicInteger(0), PositionY=new AtomicInteger(0);
    //角色在真实画布上的位置
    public AtomicBoolean avaliable=new AtomicBoolean(true);
    //当前是否正在执行操作
    public AtomicInteger cmd=new AtomicInteger(0);
    //用于接收命令
    public AtomicBoolean mov1=new AtomicBoolean(false);
    //是否使用移动中贴图

    protected int DstX, DstY;             //角色移动的目的地
    protected int speed=3;                //角色移动速度
    public String basename;               //角色名称(用于获取资源)
    public String name;                    //角色名称(用于输出)
    public boolean alive=true;           //角色是否存活


    public Charactor(int sx, int sy, int nx, int ny)
    {
        Point s=virtualField.vpTorp(sx,sy);
        Point t=virtualField.vpTorp(nx,ny);
        PositionX.set(s.x);
        PositionY.set(s.y);
        DstX=t.x;
        DstY=t.y;
    }
    public void moveto(Point dst) { moveto(dst.x, dst.y); }
    public void moveto(int x,int y)      //移动到新位置
    {
        //TODO 添加移动到新位置的线程算法
        DstX=x;
        DstY=y;
    }

    @Override
    public void run()
    {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
            cmdHandler();       //命令处理函数
        }
    }

    protected void cmdHandler()          //用来处理命令
    {
        switch (cmd.get())
        {
            case 0: break;                  //当前无任务
            case 1: WalkToDst(); cmd.set(0);break;       //1 号命令为移动到目的地
            default: break;
        }
    }

    protected void WalkToDst()           //移动到指定位置的逐帧动画
    {
        avaliable.set(false);
        double dx,dy;
        double realspeed=(double)speed/36;
        dx=(DstX-PositionX.get());
        dy=(DstY-PositionY.get());
        double distance=Math.sqrt(dx*dx+dy*dy);
        int TimeConsume=(int)distance/speed;    //移动动画所需时间=距离/速度
        dx/=TimeConsume;
        dy/=TimeConsume;
        double curx=PositionX.get();
        double cury=PositionY.get();
        for(int i=0;i<TimeConsume;i++) {
            curx+=dx;
            cury+=dy;
            PositionX.set((int)curx);
            PositionY.set((int)cury);
            try {
                Thread.sleep(1000 / 36);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(i%5==0)
                mov1.set(!mov1.get());
        }
        mov1.set(false);
        avaliable.set(true);
    }
}

enum CucurbitBoyProp{
    RedBro("老大","brother1","红色",0), OrangeBro("老二","brother2","橙色",1), YellowBro("老三","brother3","黄色",2),
    GreenBro("老四","brother4","绿色",3), BlueBro("老五","brother5","青色",4), IndigoBro("老六","brother6","蓝色",5),
    VioletBro("老七","brother7","紫色",6);
    public String name;
    public String basename;
    public String colorname;
    public int seniority;
    private CucurbitBoyProp(String name, String basename, String colorname, int seniority)
    {
        this.name=name;
        this.basename=basename;
        this.colorname=colorname;
        this.seniority=seniority;
    }
}