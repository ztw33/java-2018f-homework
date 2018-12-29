import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/*
* 使用图片形状的按钮，按键按下时会改变成另一幅图片，抬起后恢复
* */
class ActionButton extends JLabel
{
    ImageIcon imgicon1;
    ImageIcon imgicon2;
    public ActionButton(Point loc, int width, int height, String img1name, String img2name)          //构造时需要指定大小，位置和图片文件名称
    {
        this.setBounds(loc.x,loc.y,width,height);
        imgicon1=new ImageIcon(this.getClass().getResource(img1name));
        imgicon2=new ImageIcon(this.getClass().getResource(img2name));
        imgicon1.setImage(imgicon1.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));        //缩放图片到适当大小
        imgicon2.setImage(imgicon2.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
        this.setIcon(imgicon1);
        setOpaque(false);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                setIcon(imgicon2);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                setIcon(imgicon1);
                repaint();
            }
        });
    }
}