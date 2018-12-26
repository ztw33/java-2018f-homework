package Update2;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import Update2.Creature.*;
public class UI {
    final int row = 15;
    final int col = 20;
    private JFrame frame;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JComboBox<Object> godCombox;
    private JComboBox<Object> evilCombox;
    private JTextArea textArea;
    private JSplitPane splitPane;
    private JButton[][] grids;
    //private JRadioButton radio1,
    private Evil demon;
    private God god;
    private ImageIcon HuluwaIcon;
    private ImageIcon SnakeIcon;
    private ImageIcon GrandpaIcon;
    private ImageIcon BadIcon;
    public void InitCreature(){
        demon = new Evil(this);
        god = new God(this);
        HuluwaIcon = new ImageIcon("src/Picture/huluwa.jpg");
        HuluwaIcon.setImage(HuluwaIcon.getImage().getScaledInstance(50,50,HuluwaIcon.getImage().SCALE_DEFAULT));
        GrandpaIcon = new ImageIcon("src/Picture/grandpa.jpg");
        GrandpaIcon.setImage(GrandpaIcon.getImage().getScaledInstance(50,50,GrandpaIcon.getImage().SCALE_DEFAULT));
        SnakeIcon = new ImageIcon("src/Picture/snake.jpg");
        SnakeIcon.setImage(SnakeIcon.getImage().getScaledInstance(50,50,SnakeIcon.getImage().SCALE_DEFAULT));
        BadIcon = new ImageIcon("src/Picture/bad.jpg");
        BadIcon.setImage(BadIcon.getImage().getScaledInstance(50,50,BadIcon.getImage().SCALE_DEFAULT));
    }
    public void InitUI(){
        frame = new JFrame("BJY's Battle");
        frame.setSize(890, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);

        JPanel leftPanel = new JPanel();
        //LeftPanel.setBounds();
        grids = new JButton[row][col];

        leftPanel.setLayout(new GridLayout(row, col));

        for(int i = 0; i < grids.length; i++) {
            for(int j = 0; j < grids[i].length; j++) {

                grids[i][j] = new JButton();
                grids[i][j].setBackground(Color.ORANGE);
                //grids[i][j].setIcon(icon);
                leftPanel.add(grids[i][j]);
            }
        }


        JPanel rightPanel = new JPanel();
        rightPanel.add(new JLabel("葫芦娃阵型:"));
        godCombox = new JComboBox<>();
        godCombox.addItem("长蛇阵");
        godCombox.addItem("鹤翼阵");
        godCombox.addItem("鱼鳞阵");
        godCombox.addItemListener(god);
        rightPanel.add(godCombox);


        rightPanel.add(new JLabel("妖怪阵型:"));
        evilCombox = new JComboBox<>();
        evilCombox.addItem("长蛇阵");
        evilCombox.addItem("鹤翼阵");
        evilCombox.addItem("方圆阵");
        evilCombox.addItem("衡轭阵");
        evilCombox.addItem("锋矢阵");
        evilCombox.addItem("雁行阵");
        evilCombox.addItem("偃月阵");
        evilCombox.addItemListener(demon);
        rightPanel.add(evilCombox);
        rightPanel.add(new JLabel("文本区"));
        textArea = new JTextArea(50, 13);// 文本区设置行数和列数
        textArea.setLineWrap(true);        //激活自动换行功能
        textArea.setWrapStyleWord(true);
        rightPanel.add(new JScrollPane(textArea));
        // 创建一个水平JSplitPane，左边是p1,右边是p2
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        // 设置分割条的位置
        splitPane.setDividerLocation(700);

        // 把sp当作ContentPane
        frame.setContentPane(splitPane);
        frame.setVisible(true);
    }
    public UI(){
        InitCreature();
        InitUI();
    }

    public void SetCreature(int x_pos, int y_pos, Creature creature){
        String ID = creature.Identity();
        grids[x_pos][y_pos].setIcon(null);
        if(ID.equals("葫芦娃")){
            grids[x_pos][y_pos].setIcon(HuluwaIcon);
            return;
        }
        else if(ID.equals(" 爷爷 ")){
            grids[x_pos][y_pos].setIcon(GrandpaIcon);
            return;
        }
        else if (ID.equals("小喽啰")){
            grids[x_pos][y_pos].setIcon(BadIcon);
            return;
        }
        else if(ID.equals("大蛇精")){
            grids[x_pos][y_pos].setIcon(SnakeIcon);
            return;
        }
        else{
            grids[x_pos][y_pos].setBackground(Color.ORANGE);
            return;
        }
    }
    public void AppendText(String cout){
        textArea.append(cout+"\r\n");
    }
    public static void main(String[] args){
        UI ui = new UI();

    }
}
