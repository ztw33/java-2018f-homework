package ui;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import characters.*;
import shapes.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Administrator extends Frame{
	
	// ----------------------Properties--------------------------------
	//主窗口尺寸
	public static int mainwindow_sizex = 1600;
	public static int mainwindow_sizey = 900;

	//-------------------------Variables----------------------------------------
	private static final long serialVersionUID = 1L;
	//获取屏幕尺寸
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static Dimension screen = tk.getScreenSize();
	//背景图地址
	private static String bkpAddr = "http://i1.073img.com/130109/3848468_100453_1.jpg";
	//背景图	
	private static Image bkp;
	

	//葫芦娃信息和形象的映射表
	public static Map <CalabashInfo, Image> boysImg = new HashMap <CalabashInfo, Image>();
	private static Image[] CalabashBoysImgs = null;
	static {
		CalabashBoysImgs = new Image[] {
			new ImageIcon("resources/characters/calabash/red.PNG").getImage(),
			new ImageIcon("resources/characters/calabash/orange.PNG").getImage(),
			new ImageIcon("resources/characters/calabash/yellow.PNG").getImage(),
			new ImageIcon("resources/characters/calabash/green.PNG").getImage(),
			new ImageIcon("resources/characters/calabash/cyan.PNG").getImage(),
			new ImageIcon("resources/characters/calabash/blue.PNG").getImage(),
			new ImageIcon("resources/characters/calabash/purple.PNG").getImage()
		};
		boysImg.put(CalabashInfo.Red, CalabashBoysImgs[0]);
		boysImg.put(CalabashInfo.Orange, CalabashBoysImgs[1]);
		boysImg.put(CalabashInfo.Yellow, CalabashBoysImgs[2]);
		boysImg.put(CalabashInfo.Green, CalabashBoysImgs[3]);
		boysImg.put(CalabashInfo.Cyan, CalabashBoysImgs[4]);
		boysImg.put(CalabashInfo.Blue, CalabashBoysImgs[5]);
		boysImg.put(CalabashInfo.Purple, CalabashBoysImgs[6]);
	}
	//随机数产生器
	public static Random r = new Random();
	//存放各种人物
	public Snake snake;	
	public GrandFather grandfather;
	//存放葫芦娃
	public List <CalabashBoy> calabashes = new ArrayList <CalabashBoy>();
	//蝎子精和喽啰
	public List <Creature> monsters = new ArrayList <Creature>();
	//阵型信息的数组
	public static ShapeInfo[] spInfo_array = ShapeInfo.values();	
	//葫芦娃信息的数组
	public static CalabashInfo[] cbInfo_array = CalabashInfo.values();	
	//绘图缓冲
	Image OffScreenImage = null;
	//葫芦娃阵型和妖怪阵型,初始化为长蛇
	public static ShapeInfo calabash_shape = ShapeInfo.changshe;
	public static ShapeInfo monster_shape = ShapeInfo.changshe;
	//控制葫芦娃阵型的左右移动
	private int xMove = 0;
	//重写container的update方法,将内容画到缓冲,再一次性画到原图上
	@Override
	public void update(Graphics g) {
		if(OffScreenImage == null) {
			OffScreenImage = this.createImage(mainwindow_sizex,mainwindow_sizey);
		}
		Graphics gOffScreen = OffScreenImage.getGraphics();
		paint(gOffScreen);
		g.drawImage(OffScreenImage, 0, 0, null);
	}
	//重写window的paint方法
	@Override
	public void paint(Graphics g) {
		//画背景图
		//Image bkp = bkps[bkpNum];
		g.drawImage(bkp, 0, 0, this.getWidth(), this.getHeight(), 0, 0, bkp.getWidth(null), bkp.getHeight(null), null);
		
		//画出所有葫芦娃
		for(int i=0;i<calabashes.size();i++) {
			calabashes.get(i).draw(g);
		}
		//画出蝎子精和小喽啰
		for(int i=0;i<monsters.size();i++) {
			monsters.get(i).draw(g);
		}
		//画出蛇精和老爷爷
		snake.draw(g);
		grandfather.draw(g);
	}	
	//设置阵型
	private void set_shape() {
		
		//葫芦娃布阵
		switch (calabash_shape) {
		case heyi:		break;
		case yanxing:	break;
		case henggui:	break;
		case changshe:
			this.calabashes.get(0).setLoc(new Location(200+xMove,100));
			this.calabashes.get(1).setLoc(new Location(200+xMove,200));
			this.calabashes.get(2).setLoc(new Location(200+xMove,300));
			this.calabashes.get(3).setLoc(new Location(200+xMove,400));
			this.calabashes.get(4).setLoc(new Location(200+xMove,500));
			this.calabashes.get(5).setLoc(new Location(200+xMove,600));
			this.calabashes.get(6).setLoc(new Location(200+xMove,700));
			break;
		case yuling:	break;
		case fangmen:	break;
		case yanyue:	break;
		case fengshi:	break;
			default: break;
		}
		
		monsters.clear();	//删除所有元素
		monsters.add(new Crab(new Location(0,0),this));	//添加蝎子精
		//妖精布阵
		switch (monster_shape) {
		case heyi:{
			//添加小喽啰
			for(int i=0;i<6;i++) {
				this.monsters.add(new Gangster(new Location(0,0),this));
			}
			this.monsters.get(0).setLoc(new Location(900,400));
			this.monsters.get(1).setLoc(new Location(1000,500));
			this.monsters.get(2).setLoc(new Location(1000,300));
			this.monsters.get(3).setLoc(new Location(1100,600));
			this.monsters.get(4).setLoc(new Location(1100,200));
			this.monsters.get(5).setLoc(new Location(1200,700));
			this.monsters.get(6).setLoc(new Location(1200,100));
			break;			
		}

		case yanxing:{
			for(int i=0;i<5;i++) {
				this.monsters.add(new Gangster(new Location(0,0),this));
			}
			this.monsters.get(0).setLoc(new Location(1300,150));
			this.monsters.get(1).setLoc(new Location(1220,250));
			this.monsters.get(2).setLoc(new Location(1140,350));
			this.monsters.get(3).setLoc(new Location(1060,450));
			this.monsters.get(4).setLoc(new Location(980,550));
			this.monsters.get(5).setLoc(new Location(900,650));
			break;
		}
		case henggui:{
			for(int i=0;i<5;i++) {
				this.monsters.add(new Gangster(new Location(0,0),this));
			}
			this.monsters.get(0).setLoc(new Location(1300,150));
			this.monsters.get(1).setLoc(new Location(1200,250));
			this.monsters.get(2).setLoc(new Location(1300,350));
			this.monsters.get(3).setLoc(new Location(1200,450));
			this.monsters.get(4).setLoc(new Location(1300,550));
			this.monsters.get(5).setLoc(new Location(1200,650));
			break;
		}
		case changshe:{
			for(int i=0;i<5;i++) {
				this.monsters.add(new Gangster(new Location(0,0),this));
			}
			this.monsters.get(0).setLoc(new Location(1280,170));
			this.monsters.get(1).setLoc(new Location(1300,300));
			this.monsters.get(2).setLoc(new Location(1300,400));
			this.monsters.get(3).setLoc(new Location(1300,500));
			this.monsters.get(4).setLoc(new Location(1300,600));
			this.monsters.get(5).setLoc(new Location(1300,700));
			break;
		}

		case yuling:{
			for(int i=0;i<9;i++) {
				this.monsters.add(new Gangster(new Location(0,0),this));
			}
			this.monsters.get(0).setLoc(new Location(1200,250));
			this.monsters.get(1).setLoc(new Location(1260,350));
			this.monsters.get(2).setLoc(new Location(1320,450));
			this.monsters.get(3).setLoc(new Location(1200,450));
			this.monsters.get(4).setLoc(new Location(1080,450));
			this.monsters.get(5).setLoc(new Location(1380,550));
			this.monsters.get(6).setLoc(new Location(1260,550));
			this.monsters.get(7).setLoc(new Location(1140,550));
			this.monsters.get(8).setLoc(new Location(1020,550));
			this.monsters.get(9).setLoc(new Location(1200,650));
			break;
		}
		case fangmen:{
			for(int i=0;i<7;i++) {
				this.monsters.add(new Gangster(new Location(0,0),this));
			}
			this.monsters.get(0).setLoc(new Location(1000,450));
			this.monsters.get(1).setLoc(new Location(1100,350));
			this.monsters.get(2).setLoc(new Location(1100,550));
			this.monsters.get(3).setLoc(new Location(1200,250));
			this.monsters.get(4).setLoc(new Location(1200,650));
			this.monsters.get(5).setLoc(new Location(1300,350));
			this.monsters.get(6).setLoc(new Location(1300,550));
			this.monsters.get(7).setLoc(new Location(1400,450));
			break;
		}
		case yanyue:{
			for(int i=0;i<18;i++) {
				this.monsters.add(new Gangster(new Location(0,0),this));
			}
			this.monsters.get(0).setLoc(new Location(980,440));
			this.monsters.get(1).setLoc(new Location(1000,530));
			this.monsters.get(2).setLoc(new Location(1000,370));
			this.monsters.get(3).setLoc(new Location(1100,450));
			this.monsters.get(4).setLoc(new Location(1100,530));
			this.monsters.get(5).setLoc(new Location(1100,370));
			this.monsters.get(6).setLoc(new Location(1140,290));
			this.monsters.get(7).setLoc(new Location(1140,610));
			this.monsters.get(8).setLoc(new Location(1180,210));
			this.monsters.get(9).setLoc(new Location(1180,690));
			this.monsters.get(10).setLoc(new Location(1200,450));
			this.monsters.get(11).setLoc(new Location(1200,530));
			this.monsters.get(12).setLoc(new Location(1200,370));
			this.monsters.get(13).setLoc(new Location(1240,290));
			this.monsters.get(14).setLoc(new Location(1240,610));
			this.monsters.get(15).setLoc(new Location(1280,210));
			this.monsters.get(16).setLoc(new Location(1280,690));
			this.monsters.get(17).setLoc(new Location(1320,130));
			this.monsters.get(18).setLoc(new Location(1320,770));
			break;
		}
		case fengshi:{
			for(int i=0;i<11;i++) {
				this.monsters.add(new Gangster(new Location(0,0),this));
			}
			this.monsters.get(0).setLoc(new Location(900,450));
			this.monsters.get(1).setLoc(new Location(980,350));
			this.monsters.get(2).setLoc(new Location(980,550));
			this.monsters.get(3).setLoc(new Location(1060,250));
			this.monsters.get(4).setLoc(new Location(1060,650));
			this.monsters.get(5).setLoc(new Location(1140,150));
			this.monsters.get(6).setLoc(new Location(1140,750));
			this.monsters.get(7).setLoc(new Location(1000,450));
			this.monsters.get(8).setLoc(new Location(1100,450));
			this.monsters.get(9).setLoc(new Location(1200,450));
			this.monsters.get(10).setLoc(new Location(1300,450));
			this.monsters.get(11).setLoc(new Location(1400,450));
			break;
		}
		default: break;
		}
	}
	
	//改变阵型
	public void change_shape() {
		int n = r.nextInt(spInfo_array.length);
		monster_shape = spInfo_array[n];
		xMove = r.nextInt(400)-200;			//葫芦娃阵型横向移动
		//bkpNum = r.nextInt(bkps.length);	//改变背景图
		set_shape();
		setLocGrandfatherSnake();
	}
	//改变老爷爷和蛇精的位置
	public void setLocGrandfatherSnake() {
		do {
			int fatherX = r.nextInt(mainwindow_sizex/3)+grandfather.getSizex();
			int fatherY = r.nextInt(mainwindow_sizey-2*grandfather.getSizey())+grandfather.getSizey();
			grandfather.setLoc(new Location(fatherX,fatherY));			
		}while(grandfather.hitCalaBash(calabashes) || grandfather.hitOthers(monsters)
				|| grandfather.hitAnother(snake));
		do {
			int snakeX = r.nextInt(mainwindow_sizex/2-snake.getSizex())+mainwindow_sizex/2;
			int snakeY = r.nextInt(mainwindow_sizey-2*snake.getSizey())+snake.getSizey();
			snake.setLoc(new Location(snakeX,snakeY));
		}while(snake.hitCalaBash(this.calabashes) || snake.hitOthers(monsters));
	}
	
	//添加键盘事件监听,继承KeyAdapter类
	private class KeyMonitor extends KeyAdapter{

		//重写按下键盘事件的处理
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			//按下空格键时改变阵型
			case KeyEvent.VK_SPACE: 
				change_shape();
				break;
			default:break;
			}
		}
		//重写释放键盘事件的处理
		@Override
		public void keyReleased(KeyEvent e) {
			
		}		
	}
	
	//窗口重画线程
	private class PaintThread implements Runnable{	
		@Override
		public void run() {
			while(true) {
				repaint();	//repaint()首先调用update(),再调用paint()
				try {
					Thread.sleep(50);	//暂停一段时间
				} catch (InterruptedException e) {
					e.printStackTrace();
				}					
			}
		}
	}

	
	private void run() {
		//从网页加载背景图
		try {
			URL bkpURL = new URL(bkpAddr);
			bkp = tk.getImage(bkpURL);
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}

		//添加葫芦娃
		for(int i=0;i<cbInfo_array.length;i++) {
			calabashes.add(new CalabashBoy(new Location(0,0),i,this));
		}
		//添加蛇精
		this.snake = new Snake(new Location(0,0),this);
		//添加老爷爷
		this.grandfather = new GrandFather(new Location(0,0),this);
		this.set_shape();
		this.setLocGrandfatherSnake();
		//设置标题、窗口大小、关闭事件
		this.setTitle("java葫芦娃");
		this.setSize(mainwindow_sizex, mainwindow_sizey);
		this.addWindowListener(new WindowAdapter() {	//定义窗口关闭事件
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);		//表示正常退出
			}
		});
		//设置位置居中
		int locx = (screen.width - this.getWidth())/2;
		int locy = (screen.height - this.getHeight())/2;
		this.setLocation(locx, locy);
		//添加键盘事件监听器
		this.addKeyListener(new KeyMonitor());
		//setVisible(true)最好放在最后,以防出现空指针
		this.setVisible(true);	
		this.setResizable(false);
		//创建重画线程并启动
		new Thread(new PaintThread()).start();
	}
	
	
	public static void main(String[] args) {
		Administrator admin = new Administrator();
		admin.run();
	}

}
