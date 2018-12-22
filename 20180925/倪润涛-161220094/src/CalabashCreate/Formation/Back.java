package CalabashCreate.Formation;

import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class Back extends JPanel{
    private ImageIcon img = null;
    public Back()
    {
        this.img = new ImageIcon("./img/beijing.jpg");
    }
    @Override
    protected void paintComponent(Graphics g)
    {
        g.drawImage(this.img.getImage(),0,0,this.getWidth(),this.getHeight(),this);
    }
}
