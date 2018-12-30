import java.awt.*;
/*
* 提供虚拟位置和真实位置坐标的转换，并规定界面元素大小
* */
public class virtualField {          //战场类
    public static int width=10;     //战场大小
    public static int height=10;
    public static int BlockSize;
    public static int RightMargin;
    static{
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        BlockSize=screenSize.height*3/5/10;
        RightMargin=4*BlockSize;
    }
    public static Point vpTorp(int vx, int vy)      //将虚拟坐标转化为画布上的坐标
    {
        Point rp=new Point(vx*BlockSize, vy*BlockSize);
        return rp;
    }
    public static Point rpTovp(int rx, int ry)      //将画布上的坐标坐标转化为虚拟坐标
    {
        Point vp=new Point(rx/BlockSize, ry/BlockSize);
        return vp;
    }
}
