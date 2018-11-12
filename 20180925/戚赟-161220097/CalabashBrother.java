package huluwa;

import javax.swing.*;
import java.awt.*;

enum Color
{
    Red("大娃"),Orange("二娃"),Yellow("三娃"),Green("四娃"),Cyan("五娃"),Blue("六娃"),Purple("七娃");
    private final String name;
    Color(String name)
    {
        this.name = name;
    }
    //print and get
    public void callName()
    {
        System.out.println(name);
    }
    public String getName() {
        return name;
    }
}

public class CalabashBrother extends Creature{
    private Color theBro; //葫芦娃
    private int pro;
    //创造葫芦兄弟类
    public CalabashBrother(int i,int x,int y)
    {
        super(x,y);
        theBro = Color.values()[i];
        this.name = theBro.getName();
        nature = true;
        pro = i;
        ownimage = new ImageIcon("E:\\pro_java\\homework3_huluwa\\src\\huluwa\\pic\\"+this.name+".jpg");
        ownimage.setImage(ownimage.getImage().getScaledInstance(50, 50,  Image.SCALE_DEFAULT));
        label = new JLabel(ownimage);
        label.setSize(50,50);
    }
    public void callTheposition()
    {
        System.out.println(name+"的位置为:"+this.i+" "+this.j);
    }
    public int getPro()
    {
        return pro;
    }
}