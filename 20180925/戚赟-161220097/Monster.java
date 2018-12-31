package huluwa;
import javax.swing.*;
import java.awt.*;

public class Monster extends Creature{
    Monster()
    {
        super(-1,-1);
        nature = false;
    }
}

class Snake extends Monster
{
    public Snake()
    {
        super();
        this.name = "蛇精";
        ownimage = new ImageIcon("E:\\pro_java\\homework3_huluwa\\src\\huluwa\\pic\\"+this.name+".jpg");
        ownimage.setImage(ownimage.getImage().getScaledInstance(50, 50,  Image.SCALE_DEFAULT));
        label = new JLabel(ownimage);
        label.setSize(50,50);
    }
}

class Scorpion extends Monster
{
    public Scorpion()
    {
        super();
        this.name = "蝎子精";
        ownimage = new ImageIcon("E:\\pro_java\\homework3_huluwa\\src\\huluwa\\pic\\"+this.name+".jpg");
        ownimage.setImage(ownimage.getImage().getScaledInstance(50, 50,  Image.SCALE_DEFAULT));
        label = new JLabel(ownimage);
        label.setSize(50,50);
    }
}

class Follower extends Monster
{
    public Follower()
    {
        super();
        this.name = "小怪";
        ownimage = new ImageIcon("E:\\pro_java\\homework3_huluwa\\src\\huluwa\\pic\\"+this.name+".jpg");
        ownimage.setImage(ownimage.getImage().getScaledInstance(50, 50,  Image.SCALE_DEFAULT));
        label = new JLabel(ownimage);
        label.setSize(50,50);
    }
}