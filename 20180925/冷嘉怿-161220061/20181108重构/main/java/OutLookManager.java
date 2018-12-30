import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
/*
* 处理所有人物贴图的绘制和动画的执行
* */
public class OutLookManager extends JFrame {
    protected BackGroundPanel background;
    protected ArrayList<Charactor> creatures=new ArrayList<>();     //需要管理的人物
    protected ArrayList<ImageIcon> standimg=new ArrayList<>();      //人物的两种贴图
    protected ArrayList<ImageIcon> movimg=new ArrayList<>();
    protected ArrayList<JLabel> outlooks=new ArrayList<>();         //人物的swing对象
    protected CQueue humanqueue=new CQueue(1,1);
    protected boolean sortorshuffle=false;
    public static void main(String[] args) {
        OutLookManager outlook=new OutLookManager();
        outlook.setVisible(true);
        outlook.start();
    }
    public OutLookManager()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        int width=virtualField.BlockSize*virtualField.width+virtualField.RightMargin;
        int height=virtualField.BlockSize*(virtualField.height+1);
        setBounds(100,100, width, height);
        background=new BackGroundPanel();
        background.setSize(width,height);
        setContentPane(background);
        createComponents();
    }
    protected void addCharactor(Charactor chat)                     //添加一个新角色并为之创建“视”相关对象
    {
        creatures.add(chat);
        int size=virtualField.BlockSize;
        ImageIcon stand=new ImageIcon(this.getClass().getResource(chat.basename+".PNG"));
        stand.setImage(stand.getImage().getScaledInstance(size,size, Image.SCALE_SMOOTH));
        standimg.add(stand);
        ImageIcon mov=new ImageIcon(this.getClass().getResource(chat.basename+"mov1.PNG"));
        mov.setImage(mov.getImage().getScaledInstance(size,size, Image.SCALE_SMOOTH));
        movimg.add(mov);
        JLabel outlook=new JLabel();
        outlook.setSize(size,size);
        outlook.setLocation(chat.PositionX.get(), chat.PositionY.get());
        outlook.setIcon(stand);
        outlook.setOpaque(false);
        outlooks.add(outlook);
        background.add(outlook);
        Thread tmpthread=new Thread(chat);
        tmpthread.start();
        chat.cmd.set(1);
    }
    protected void createComponents()           //添加界面元素
    {
        addCharactor(new Grandpa(0,0, 0,9));
        for(int i=0;i<7;i++) {
            try {
                CucurbitBoy tmpcb=new CucurbitBoy(0,0,1,i+1);
                addCharactor(tmpcb);
                humanqueue.addCharactor(tmpcb);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        addCharactor(new Snake(9,0,9,0));
        Scorpion scorpion=new Scorpion(9,0,9,0);
        scorpion.changeFMT(0);
        addCharactor(scorpion);
        for(Roro x:scorpion.troops)
            addCharactor(x);
        ActionButton humanctl=new ActionButton(virtualField.vpTorp(11,3),virtualField.BlockSize*2,
                virtualField.BlockSize*2,"humanhead.PNG","humanhead2.PNG");
        humanctl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(!sortorshuffle)
                    humanqueue.Randomize();
                else
                    humanqueue.Sort();
                sortorshuffle=!sortorshuffle;
            }
        });
        ActionButton monsterctl=new ActionButton(virtualField.vpTorp(11,5),virtualField.BlockSize*2,
                virtualField.BlockSize*2,"monsterhead.PNG","monsterhead2.PNG");
        monsterctl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(!scorpion.avaliable.get())
                    return;
                scorpion.changeFMT(scorpion.curFMT+1);
                scorpion.cmd.set(1);
                for(Roro x:scorpion.troops)
                    x.cmd.set(1);
            }
        });
        background.add(humanctl);
        background.add(monsterctl);
    }
    public void start()
    {
        while(true)
        {
            try {
                Thread.sleep(1000/36);
            } catch (Exception e) {
                e.printStackTrace();
            }
            for(int i=0;i<creatures.size();i++)
            {
                Charactor x= creatures.get(i);
                JLabel outlook=outlooks.get(i);
                ImageIcon img;
                if(x.mov1.get())
                    img=movimg.get(i);
                else
                    img=standimg.get(i);
                outlook.setIcon(img);
                int tmpx=x.PositionX.get();
                int tmpy=x.PositionY.get();
                outlook.setLocation(tmpx, tmpy);
                outlook.repaint();
            }
        }
    }
}



class BackGroundPanel extends JPanel{                //以特定图片作为背景的Panel
    private Image image=(Image)new ImageIcon(this.getClass().getResource("background.jpg")).getImage();
    public BackGroundPanel(){ setLayout(null); }
    protected void paintComponent(Graphics g)
    {
        g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);
    }
}