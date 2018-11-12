package huluwa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jfshow {
    private JFrame jf;
    public Jfshow()
    {
        jf = new JFrame("葫芦娃大战妖精");
        jf.setSize(1000, 600);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void showJf()
    {
        //jf.pack();
        //jf.setLocationRelativeTo(null);
        ImageIcon blank = new ImageIcon("E:\\pro_java\\homework3_huluwa\\src\\huluwa\\pic\\blank.jpg");
        blank.setImage(blank.getImage().getScaledInstance(50, 50,  0));
        JLabel temp = new JLabel(blank);
        temp.setSize(50,50);
        temp.setLocation(19*50,9*50);
        jf.add(temp);
        jf.setVisible(true);
        jf = new JFrame("葫芦娃大战妖精");
        jf.setSize(1000, 600);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void jfadd(Creature creature,int i,int j)
    {
        if(creature !=null)
        {
            JLabel temp = creature.getLabel();
            temp.setLocation(creature.getJ()*50,creature.getI()*50);
            jf.add(temp);
        }
        else
        {
            ImageIcon blank = new ImageIcon("E:\\pro_java\\homework3_huluwa\\src\\huluwa\\pic\\blank.jpg");
            blank.setImage(blank.getImage().getScaledInstance(50, 50,  0));
            JLabel temp = new JLabel(blank);
            temp.setSize(50,50);
            temp.setLocation(j*50,i*50);
            jf.add(temp);
        }
    }
}
