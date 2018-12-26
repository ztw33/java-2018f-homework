package gui;

import java.awt.EventQueue;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import creature.Being;
import creature.StyleImage;
import creature.Human;
import creature.SnakeEssence;
import regulate.Administer;
import space.Square;



/**
* @ClassName: Gui
* @Description: 整个UI界面 以及外部事物的设置
* @author 13745
* @date 2018年11月4日
*
*/
public class Gui {

	private static Image floorImage;
	private static Image HuLu1;
	private static Image HuLu2;
	private static Image HuLu3;
	private static Image HuLu4;
	private static Image HuLu5;
	private static Image HuLu6;
	private static Image HuLu7;
	private static Image grandpa;
	private static Image littlemonster;
	private static Image scorp;
	private static Image snake;
	private static Image buttonImage;
	
	private int putSeq=0;	//用于记录放爷爷和蛇精的次序
	
	public static JTextArea textArea=new JTextArea();	//设置一个输出窗口 用户信息都输出 公有使用
	
	static{
		try {
			buttonImage=ImageIO.read(Gui.class.getResource("/images/button.jpg"));
			buttonImage=buttonImage.getScaledInstance(Gui.squareXLength*Gui.N/3+12, 100,Image.SCALE_DEFAULT );
			
			floorImage=ImageIO.read(Gui.class.getResource("/images/floor_h.jpg"));
			floorImage=floorImage.getScaledInstance(Gui.squareXLength, Gui.squareYLength,Image.SCALE_DEFAULT );
			
			HuLu1=ImageIO.read(Gui.class.getResource("/images/hulu1_h.jpg"));
			HuLu1=HuLu1.getScaledInstance(Gui.squareXLength, Gui.squareYLength,Image.SCALE_DEFAULT );
			
			HuLu2=ImageIO.read(Gui.class.getResource("/images/hulu2_h.jpg"));
			HuLu2=HuLu2.getScaledInstance(Gui.squareXLength, Gui.squareYLength,Image.SCALE_DEFAULT );
			
			HuLu3=ImageIO.read(Gui.class.getResource("/images/hulu3_h.jpg"));
			HuLu3=HuLu3.getScaledInstance(Gui.squareXLength, Gui.squareYLength,Image.SCALE_DEFAULT );
			
			HuLu4=ImageIO.read(Gui.class.getResource("/images/hulu4_h.jpg"));
			HuLu4=HuLu4.getScaledInstance(Gui.squareXLength, Gui.squareYLength,Image.SCALE_DEFAULT );
			
			HuLu5=ImageIO.read(Gui.class.getResource("/images/hulu5_h.jpg"));
			HuLu5=HuLu5.getScaledInstance(Gui.squareXLength, Gui.squareYLength,Image.SCALE_DEFAULT );
			
			HuLu6=ImageIO.read(Gui.class.getResource("/images/hulu6_h.jpg"));
			HuLu6=HuLu6.getScaledInstance(Gui.squareXLength, Gui.squareYLength,Image.SCALE_DEFAULT );
			
			HuLu7=ImageIO.read(Gui.class.getResource("/images/hulu7_h.jpg"));
			HuLu7=HuLu7.getScaledInstance(Gui.squareXLength, Gui.squareYLength,Image.SCALE_DEFAULT );
			
			grandpa=ImageIO.read(Gui.class.getResource("/images/grandpa_h.jpg"));
			grandpa=grandpa.getScaledInstance(Gui.squareXLength, Gui.squareYLength,Image.SCALE_DEFAULT );
			
			littlemonster=ImageIO.read(Gui.class.getResource("/images/monster_h.jpg"));
			littlemonster=littlemonster.getScaledInstance(Gui.squareXLength, Gui.squareYLength,Image.SCALE_DEFAULT );
			
			scorp=ImageIO.read(Gui.class.getResource("/images/scorp_h.jpg"));
			scorp=scorp.getScaledInstance(Gui.squareXLength, Gui.squareYLength,Image.SCALE_DEFAULT );
			
			snake=ImageIO.read(Gui.class.getResource("/images/snake_h.jpg"));
			snake=snake.getScaledInstance(Gui.squareXLength, Gui.squareYLength,Image.SCALE_DEFAULT );
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static final int N=17;	//N*N 原来15
	
	private final int xLength=1500;	
	private final int yLength=830;
	
	public static final int squareXLength=40;	//每一个小方格大小 原来50
	public static final int squareYLength=40;
	
	private Administer administer=new Administer();	
	private JFrame frame;

	//private JLabel[][] background=new JLabel[N][N];
	private ArrayList<ArrayList<JLabel>> background=new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, xLength, yLength);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
		JScrollPane scrollPane=new JScrollPane(textArea);
		scrollPane.setBounds(new Rectangle(400,N*squareYLength+100));
		scrollPane.setLocation(N*squareXLength, 0);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		frame.getContentPane().add(scrollPane);
		
		textArea.append("规则:首先为妖怪挑选合适阵型 然后为老爷爷、蛇精挑选合适位置加油助威(通过上下键移动)\n");
		textArea.append("规则:选择合适位置后按S键固定(先确定老爷爷、再确定蛇精)\n");
		textArea.append("规则:一旦妖怪阵型改变或者葫芦娃阵型改变，老爷爷、蛇精位置都要重新固定\n");
		textArea.append("规则:如果老爷爷、蛇精所在位置导致妖怪阵型无法变化，则妖怪阵型不会发生改变直到老爷爷、蛇精移动位置\n");
		
		ImageIcon buttonIcon=new ImageIcon(buttonImage);
		JButton button=new JButton("妖怪下一个阵型",buttonIcon);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setBounds(squareXLength*N/3*2, N*squareYLength, N*squareXLength/3 , 100);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				administer.clearMonsters(); 
				//administer.getBoard().clearBoardMonster();
				administer.getputNextMonsterFormation();
				putSeq=0;
				mypaint();
				frame.requestFocus();
			}
		});
		
		JButton button1=new JButton("葫芦娃随机变换",buttonIcon);
		button1.setBounds(0, N*squareYLength,N*squareXLength/3 , 100);
		button1.setHorizontalTextPosition(SwingConstants.CENTER);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				administer.clearHuLuWas();
				administer.shuffleGoodHuLus();
				//administer.getBoard().clearBoardHuLuWa();
				//HuLuWaAdminister.shuffleHuLuWas();
				administer.getputHuLuFormation();;
				mypaint();
				frame.requestFocus();
			}
		});
		
		JButton button2=new JButton("葫芦娃排列整齐",buttonIcon);
		button2.setBounds(N*squareXLength/3, N*squareYLength, N*squareXLength/3 , 100);
		button2.setHorizontalTextPosition(SwingConstants.CENTER);
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				administer.clearHuLuWas();
				administer.sortGoodHuLus();
				//administer.getBoard().clearBoardHuLuWa();
				//HuLuWaAdminister.sortHuLuWas();
				administer.getputHuLuFormation();
				mypaint();
				frame.requestFocus();
			}
		});
		
		frame.add(button);
		frame.add(button1);
		frame.add(button2);
		
		
		for(int i=0;i<N;i++){
			ArrayList<JLabel> rowtemp=new ArrayList<>();
			for(int j=0;j<N;j++){
				ImageIcon imageIcon=new ImageIcon(floorImage);
				JLabel temp=new JLabel("");
				temp.setBounds(i*squareXLength, j*squareYLength, squareXLength, squareYLength);
				temp.setIcon(imageIcon);
				rowtemp.add(temp);
				frame.getContentPane().add(temp);
			}
			background.add(rowtemp);
		}
		administer.getputHuLuFormation();
		administer.getputNextMonsterFormation();
		administer.putGrandPa();
		administer.putSnake();
		mypaint();
		
		//添加键盘活动
		KeyAdapter keyAdapter = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				textArea.append("enter keyadapter\n");
				if(putSeq>=2)
					return;
				Class<?> temp=null;
				if(putSeq==0)
					temp=Human.class;
				else if(putSeq==1)
					temp=SnakeEssence.class;
				int key = e.getKeyCode();
				switch(key){
				case KeyEvent.VK_RIGHT: administer.moveRightManual(temp); break;
				case KeyEvent.VK_LEFT: administer.moveLeftManual(temp); break;
				case KeyEvent.VK_DOWN: administer.moveDownManual(temp); break;
				case KeyEvent.VK_UP: administer.moveUpManual(temp); break;
//				case KeyEvent.VK_S:if(putSeq==0) textArea.append("老爷爷放置成功,为葫芦娃加油助威!\n");
//									else if(putSeq==1) textArea.append("蛇精放置成功，为蝎子精加油助威!\n");
//									putSeq++;break;
				case KeyEvent.VK_S:if(putSeq==0) administer.grandpaCheer();
									else if(putSeq==1) administer.snakeCheer();
									putSeq++;break;	
				default:break;
				}
				mypaint();
			}
		};
		 
		frame.addKeyListener(keyAdapter);
		frame.setFocusable(true);
	}
	
	private void mypaint() {
		ArrayList<ArrayList<Square<Being>>> board=administer.getBoard().getBoard();
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(board.get(i).get(j).getBeing()!=null){
					ImageIcon imageIcon=new ImageIcon(getImage((board.get(i).get(j).getBeing()).getImage()));
					background.get(i).get(j).setIcon(imageIcon);	//这里要注意
				}
				else{
					ImageIcon imageIcon=new ImageIcon(floorImage);
					background.get(i).get(j).setIcon(imageIcon);
				}
			}
		}
	}

	
	private Image getImage(StyleImage type){
		switch (type) {
		case HULUWAONE:return HuLu1;
		case HULUWATWO:return HuLu2;
		case HULUWATHREE:return HuLu3;
		case HULUWAFOUR:return HuLu4;
		case HULUWAFIVE:return HuLu5;
		case HULUWASIX:return HuLu6;
		case HULUWASEVEN:return HuLu7;
		case GRANDPA:return grandpa;
		case SCORP:return scorp;
		case SNAKE:return snake;
		case LITTLEMONSTER:return littlemonster;
		default:
			break;
		}
		return null;
	}
	
}
