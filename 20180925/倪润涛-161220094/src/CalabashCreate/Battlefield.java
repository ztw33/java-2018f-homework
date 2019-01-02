package CalabashCreate;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.*;

/*public class Battlefield extends JFrame {
    JPanel imgpanel;
    Battlefield()
    {
        setTitle("葫芦娃 VS 妖怪");
        setSize(16*50+30,16*50);
        imgpanel = new Back();
        setContentPane(imgpanel);
    }
    void showBattlefield(char [][]field)
    {
        int count=1;
        for(int i=0;i<15;i++)
        {
            for(int j=0;j<15;j++)
            {
                if(field[i][j]=='G') {
                    ImageIcon img = new ImageIcon("./img/ye.jpg");
                    img.setImage(img.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT ));
                    JLabel label = new JLabel(img);
                    //label.setSize(50, 50);
                    label.setBounds(i*50,j*50,50,50);
                    imgpanel.add(label);
                }
                else if(field[i][j]=='B') {
                    ImageIcon img = new ImageIcon("./img/"+count+".jpg");
                    img.setImage(img.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT ));
                    JLabel label = new JLabel(img);
                    //label.setSize(50, 50);
                    label.setBounds(i*50,j*50,50,50);
                    imgpanel.add(label);
                    count++;
                }
                else if(field[i][j]=='S') {
                    ImageIcon img = new ImageIcon("./img/shejing.jpg");
                    img.setImage(img.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT ));
                    JLabel label = new JLabel(img);
                    //label.setSize(50, 50);
                    imgpanel.add(label);
                    label.setBounds(i*50,j*50,50,50);
                }
                else if(field[i][j]=='X') {
                    ImageIcon img = new ImageIcon("./img/xizijing.jpg");
                    JLabel label = new JLabel(img);
                    //label.setSize(50, 50);
                    imgpanel.add(label);
                    label.setBounds(i*50,j*50,50,50);
                }
                else if(field[i][j]=='M') {
                    ImageIcon img = new ImageIcon("./img/xiaoyaojing.jpg");
                    img.setImage(img.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT ));
                    JLabel label = new JLabel(img);
                    //label.setSize(50, 50);
                    imgpanel.add(label);
                    label.setBounds(i*50,j*50,50,50);
                }
            }
        }
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}*/

public class Battlefield extends JFrame{
    private int row;
    private int col;
    private int size;
    private int width;
    private int height;

    public Battlefield(int size) {
        setTitle("葫芦娃 VS 妖怪");
        this.row = 15;
        this.col = 15;
        this.size = size;
        this.width = (col+1) * size-30;
        this.height = (row+2) * size;

        setSize(width, height);
        Point point = new Point(350, 200);
        setLocation(point);
    }

    void showBattlefield(char [][]field) {
        int count=1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ImageIcon icon = new ImageIcon("");
                if(field[i][j]=='G')
                    icon = new ImageIcon("./img/ye.jpg");
                    //icon = new ImageIcon("/battle/img/ye.jpg");
                else if(field[i][j]=='B') {
                    icon = new ImageIcon("./img/"+count+".jpg");
                    count++;
                }
                else if(field[i][j]=='S')
                    icon = new ImageIcon("./img/shejing.jpg");
                else if(field[i][j]=='X')
                    icon = new ImageIcon("./img/xiezijing.jpg");
                else if(field[i][j]=='M')
                    icon = new ImageIcon("./img/xiaoyaojing.jpg");

                icon.setImage(icon.getImage().getScaledInstance(size, size, 0));
                JLabel l = new JLabel(icon, JLabel.CENTER);
                l.setSize(size, size);
                l.setLocation(j * size, i * size);    //设置标签位置
                l.setBorder(BorderFactory.createLineBorder(Color.black));  //设置边界为黑色
                add(l);            //添加标签
            }
        }
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

/*import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.*;

public class Battlefield extends JFrame {
    JButton bt1, bt2, bt3, bt4, bt5, bt6;

    public Battlefield(char [][]field) {
        bt1 = new JButton("饼干");
        bt2 = new JButton("瓜子");
        bt3 = new JButton("蛋糕");
        bt4 = new JButton("话梅");
        bt5 = new JButton("开心果");
        bt6 = new JButton("年糕");
        this.setLayout(new GridLayout(6, 3));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(16*50-30, 16*50);
        ImageIcon icon = new ImageIcon("");
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(field[i][j]=='G')
                    icon = new ImageIcon("/battle/img/ye.jpg");
                else
                    icon = new ImageIcon("/battle/img/1.jpg");
                this.add(bt1);
            }
        }
        this.add(bt1);
        this.add(bt2);
        this.add(bt3);
        this.add(bt4);
        this.add(bt5);
        this.add(bt6);
    }
}*/
