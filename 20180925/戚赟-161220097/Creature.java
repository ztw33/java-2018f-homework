package huluwa;
import javax.swing.*;
import java.awt.*;

public class Creature {
    int i; //在棋盘里面的位置
    int j;
    String name;
    boolean nature;
    ImageIcon ownimage;
    JLabel label;
    public Creature(int x,int y)
    {
        i = x;
        j = y;
    }
    public Creature()
    {
        i = -1;
        j = -1;
    }
    public void changeTheposition(int i,int j)
    {
        this.i = i;
        this.j = j;
    }
    public void getTheinfo()
    {
        if(name != "蝎子精")
        System.out.print(name+"  ");
        else  System.out.print(name);
        System.out.print(i+"坐标"+j);
    }
    public int getI()
    {
        return i;
    }
    public int getJ()
    {
        return j;
    }
    public JLabel getLabel()
    {
        return label;
    }
}

class Grandfather extends Creature{
    Grandfather()
    {
        name = "爷爷";
        nature = true;
        ownimage = new ImageIcon("E:\\pro_java\\homework3_huluwa\\src\\huluwa\\pic\\"+this.name+".jpg");
        ownimage.setImage(ownimage.getImage().getScaledInstance(50, 50,  Image.SCALE_DEFAULT));
        label = new JLabel(ownimage);
        label.setSize(50,50);
    }
}

