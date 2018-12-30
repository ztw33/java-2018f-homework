import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Objects;

public class BattleField {

    private JPanel battlefield;
    private Font mfont=new Font("华文楷体",Font.BOLD,25);

    AnimationHandler animationHandler;

    private Scorpion scorption;
    private Grandpa grandpa;
    private Snake snake;
    private Brotherhood brotherhood;

    private boolean Bsorted=false;

    public JFrame father;
    private JTextField debug;
    private TransparentPanel hlmask;
    private SelectionBar toolbar;

    MouseListener ms;

    public static int selectionsize=80;

    public int curX=0,curY=0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("BattleField");
        frame.setTitle("葫芦娃兄弟阵法");
        frame.setResizable(false);
        BattleField battle=new BattleField();
        battle.father=frame;
        frame.addMouseListener(battle.ms);
        frame.setContentPane(battle.battlefield);
//        battle.scorption=new Scorpion((BackGroundPanel)battle.battlefield);
        frame.setBounds(130,20,1200,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        battle.getMouseInfo();
    }

    private void createUIComponents() throws Exception {
        // TODO: place custom component creation code here
        battlefield = new BackGroundPanel();
        battlefield.setBounds(0, 0, 1200, 700);
        battlefield.setLayout(null);

        actionButton button1 = new actionButton(1100, 500, 90, 80, "monsterhead.PNG", "monsterhead2.PNG");
        button1.addMouseListener(new MouseListener() {          //负责蝎子精变换阵型的按钮
            @Override
            public void mouseClicked(MouseEvent e) {
                if (animationHandler.avaliable.get() == false)
                    return;
                scorption.changeFMT();
//                scorption.StandStill();
                animationHandler.cmd.set(1);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        battlefield.add(button1);
        actionButton button2 = new actionButton(1000, 500, 90, 80, "humanhead.PNG", "humanhead2.PNG");
        button2.addMouseListener(new MouseListener() {          //负责葫芦娃排队的按钮
            @Override
            public void mouseClicked(MouseEvent e) {
                if (animationHandler.avaliable.get() == false)
                    return;
                if (Bsorted)
                    brotherhood.randomize();
                else
                    brotherhood.BubbleSort();
                Bsorted = !Bsorted;
//                scorption.StandStill();
                animationHandler.cmd.set(1);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        battlefield.add(button2);
        animationHandler = new AnimationHandler();
        /*创建角色*/
        scorption = new Scorpion((BackGroundPanel) battlefield);               //创建人类和妖怪
        animationHandler.addChat(scorption);
        animationHandler.addChat(scorption.troops);

        grandpa = new Grandpa((BackGroundPanel) battlefield);
        animationHandler.addChat(grandpa);
        grandpa.StandStill();

        snake = new Snake((BackGroundPanel) battlefield);
        animationHandler.addChat(snake);
        snake.StandStill();

        brotherhood = new Brotherhood((BackGroundPanel) battlefield);
        animationHandler.addChat(brotherhood.cbs);
//        brotherhood.StandStill();

        /*加入动画处理器*/
        Thread anim = new Thread(animationHandler);
        anim.start();
        animationHandler.cmd.set(1);

        /*加入其他控件*/
        debug = new JTextField("debug");
        debug.setBounds(400, 630, 200, 20);
        battlefield.add(debug);

        hlmask = new TransparentPanel();
        hlmask.setBounds(((BackGroundPanel) battlefield).xstart, ((BackGroundPanel) battlefield).ystart, ((BackGroundPanel) battlefield).deltax, ((BackGroundPanel) battlefield).deltay);
        hlmask.setTransparency(.3f);
        battlefield.add(hlmask);

        toolbar = new SelectionBar(this);
        toolbar.setBounds(-20, 100, 200, 500);
        battlefield.add(toolbar);

        ms=new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toolbar.reloadBars();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
    }

    public void getMouseInfo()
    {
        while (true)
        {
            try{
                Thread.sleep(50);

            }catch(Exception e)
            {
                e.printStackTrace();
            }
            PointerInfo pointerInfo=MouseInfo.getPointerInfo();
            Point p=pointerInfo.getLocation();
            highlight(p.getX(),p.getY());
        }
    }

    private void highlight(double x, double y)          //高亮显示当前鼠标所在区域
    {
        Point tmploc=father.getLocation();
        BackGroundPanel tmp=(BackGroundPanel)battlefield;
        x=x-tmploc.x-tmp.xstart;
        y=y-tmploc.y-tmp.ystart;
        int virtuleX=(int)x/tmp.deltax;
        int virtuleY=(int)y/tmp.deltay-1;
        if(virtuleX<0 || virtuleX>=15 || virtuleY<0 || virtuleY>=15)
            return;
        String name="empty";
        if(virtualField.field[virtuleY][virtuleX]!=null)
            name=virtualField.field[virtuleY][virtuleX].basename;
        debug.setText("("+virtuleX+", "+virtuleY+"):"+name);
        curX=virtuleX;
        curY=virtuleY;
        hlmask.setBounds(tmp.xstart+virtuleX*tmp.deltax, tmp.ystart+virtuleY*tmp.deltay,tmp.deltax,tmp.deltay);
    }
}

class BackGroundPanel extends JPanel{                //以特定图片作为背景的Panel
    private Image image=(Image)new ImageIcon(this.getClass().getResource("background.jpg")).getImage();
    int deltax=50,deltay=40;
    int xstart=220,ystart=20;
    protected void paintComponent(Graphics g)
    {
        g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);
    }
}

class actionButton extends JButton{                 //使用图片形状的按钮，按键按下时会改变成另一幅图片
    private Image img1;
    private Image img2;
    public actionButton(int x, int y, int width, int height, String img1name, String img2name)          //构造时需要指定大小，位置和图片文件名称
    {
        this.setBounds(x,y,width,height);
        ImageIcon imgicon1=new ImageIcon(this.getClass().getResource(img1name));
        ImageIcon imgicon2=new ImageIcon(this.getClass().getResource(img2name));
        imgicon1.setImage(imgicon1.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));        //缩放图片到适当大小
        img1=imgicon1.getImage();
        imgicon2.setImage(imgicon2.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
        img2=imgicon2.getImage();
        this.setBorder(null);
        this.setIcon(imgicon1);
        this.setMargin(new Insets(0,0,0,0));
        this.setContentAreaFilled(false);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                setIcon(imgicon2);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setIcon(imgicon1);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}

class SelectionBar extends JPanel{      //一个选择侧边栏，为以后添加各种角色的技能做准备
    private BattleField father;
    private Image image=(Image)new ImageIcon(this.getClass().getResource("floatbar.PNG")).getImage();
    private Font mfont=new Font("华文楷体",Font.BOLD,30);
    private JLabel Chatname;
    private JLabel regularattack;
    private JLabel AOE;
    private JLabel ZXC;
    public SelectionBar(BattleField battle)
    {
        father=battle;
        this.setLayout(null);
        int size=BattleField.selectionsize;

        Chatname=new JLabel();
        Chatname.setBounds(50,50,size,size/2);
        Chatname.setText("空");
        Chatname.setForeground(new Color(255,215,000));
        Chatname.setFont(mfont);

        regularattack=new JLabel();
        regularattack.setBounds(52,100,size,size);
        regularattack.setOpaque(false);
        regularattack.setBorder(null);

        AOE=new JLabel();
        AOE.setBounds(52,200,size,size);
        AOE.setOpaque(false);
        AOE.setBorder(null);

        ZXC=new JLabel();
        ZXC.setBounds(52,300,size,size);
        ZXC.setOpaque(false);
        ZXC.setBorder(null);

        this.add(regularattack);
        this.add(AOE);
        this.add(ZXC);
        this.add(Chatname);
    }
    protected void paintComponent(Graphics g)
    {
        g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);
    }

    public void reloadBars()
    {
        Charactors tmp=virtualField.field[father.curY][father.curX];
        if(tmp==null || tmp.monster) {
            regularattack.setIcon(null);
            AOE.setIcon(null);
            ZXC.setIcon(null);
            Chatname.setText("空");
            return;
        }
        String name="";
        switch (tmp.basename.charAt(0))
        {
            case 'b': name=((CucurbitBoy)tmp).tellName();break;
            case 'g': name="爷爷";break;
        }
        Chatname.setText(name);
        regularattack.setIcon(tmp.regularattack);
        AOE.setIcon(tmp.AOE);
        ZXC.setIcon(tmp.ZXC);
    }
}

class TransparentPanel extends JPanel{
    protected float transparency;
    public void setTransparency(float trans)
    {
        transparency=trans;
    }
    @Override
    protected void paintComponent(Graphics g)
    {
//        super.paintComponent(g);
        Graphics2D graphics2D=(Graphics2D)g.create();
        graphics2D.setBackground(Color.GRAY);
        graphics2D.setComposite(AlphaComposite.SrcOver.derive(transparency));
        graphics2D.fillRect(0,0,getWidth(),getHeight());
        graphics2D.dispose();
    }
}