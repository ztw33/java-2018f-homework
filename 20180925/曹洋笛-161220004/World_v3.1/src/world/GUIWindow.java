package world;


import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import world.creatures.Creature;
import world.formations.*;
import world.util.*;

/**
 *	表世界，世界的衍生. <br>
 *	完全基于里世界{@code CharWindow}，以保证同步 <br>
 *	用于GUI显示整个世界
 *
 *	@author Mirror
 *	
 *	@see CharWindow
 *	@see #cWin
 *	@see #menuBar
 *	@see #ground
 *	@see #cell
 *	@see #removeAtFirst()
 *	@see #showAtLast()
 */
public class GUIWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	/**	窗口位置 {@value} */
	private static final int winLocationXY = 10;
	
	/**	窗口长 {@value} */
	private static final int winWidth = 814;
	
	/**	窗口宽 {@value} */
	private static final int winHeight = 822;
	
	/**	图片长 {@value} */
	private static final int groundWidth = 800;
	
	/**	图片宽 {@value} */
	private static final int groundHeight = 760;	
	
	/**	图片边距（宽） {@value} */
	private static final int marginWidth = 40;	
	
	/**	图片边距（高） {@value} */
	private static final int marginHeight = 40 + 25;	
	
	/**	网格宽度 {@value} */
	private static final int span = 40;
	
	/**	定义菜单栏 */
	private JMenuBar menuBar;
	
	/**	定义“开始”菜单，菜单项为“重置” */
	private JMenu menuStart; 
	/**	“开始”菜单项：“重置” */
	private JMenuItem menuItReset;
	
	/**	定义“阵型”菜单，菜单项为妖怪的阵型 */
	private JMenu menuFormation;
	/**	“阵型”菜单项：妖怪的阵型 */
	private JMenuItem menuItHY, menuItYX, menuItCE, 
						menuItYL, menuItFY, menuItYY, menuItFS;
	
	/**	菜单事件监听 */
	private MenuMonitor menuMonitor;
	
	/**	下一个阵型，仅用于打断初始的自动模式之后 */
	private FormationType nextForm;
	
	/**	键盘事件监听 */
	private KeyMonitor keyMonitor;
	
	/**	定义背景图片所在标签 */
	private JLabel ground;

	/**	定义一群空标签以放置人物 */
	private JLabel[][] cell;
	
	/**	是否停止自动模式 */
	private boolean isAuto;
	
	/**	GUI世界的原型 —— char世界 */
	private CharWindow cWin;
	
	/**	构造函数，以char世界为基础，产生GUI世界窗口 */
	public GUIWindow(CharWindow w) {
		super("葫芦娃大战妖怪"); // 设置标题
		// 设置菜单栏
		menuBar = new JMenuBar();
		menuStart = new JMenu("开始");
		menuItReset = new JMenuItem("重置");
		menuFormation = new JMenu("阵型");
		menuItHY = new JMenuItem("鹤翼阵");
		menuItYX = new JMenuItem("雁行阵");
		menuItCE = new JMenuItem("冲轭阵");
		menuItYL = new JMenuItem("鱼鳞阵");
		menuItFY = new JMenuItem("方円阵");
		menuItYY = new JMenuItem("偃月阵");
		menuItFS = new JMenuItem("锋矢阵");
		menuStart.add(menuItReset);
		menuFormation.add(menuItHY);
		menuFormation.add(menuItYX);
		menuFormation.add(menuItCE);
		menuFormation.add(menuItYL);
		menuFormation.add(menuItFY);
		menuFormation.add(menuItYY);
		menuFormation.add(menuItFS);
		menuBar.add(menuStart);
		menuBar.add(menuFormation);
		this.add(menuBar, BorderLayout.NORTH); // 添加菜单栏
		this.setSize(winWidth, winHeight);
		this.setLocation(winLocationXY, winLocationXY); // 窗口位置
		this.setResizable(false); // 窗口大小不可更改
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 初始化所有标签
		ground = null;
		cell = new JLabel[Range.rowNum][Range.colNum];
		for (int i = 0; i < Range.rowNum; i++) {
			for (int j = 0; j < Range.colNum; j++)
				cell[i][j] = null; 
		}
		// 设置键盘项监听
		keyMonitor = new KeyMonitor();
		this.addKeyListener(keyMonitor);
		// 设置菜单项监听
		menuMonitor = new MenuMonitor();
		menuItReset.addActionListener(menuMonitor);
		menuItHY.addActionListener(menuMonitor);
		menuItYX.addActionListener(menuMonitor);
		menuItCE.addActionListener(menuMonitor);
		menuItYL.addActionListener(menuMonitor);
		menuItFY.addActionListener(menuMonitor);
		menuItYY.addActionListener(menuMonitor);
		menuItFS.addActionListener(menuMonitor);
		// 基于 char 世界，开始构建
		cWin = w; 
		nextForm = FormationType.HY;
		autoWorld();
	}
	
	/**	在窗口上添加地图 */
	private void setGround() {
		ImageIcon groundIcon = new ImageIcon("img\\BackGround.png");
		groundIcon.setImage(groundIcon.getImage().getScaledInstance(groundWidth, groundHeight,Image.SCALE_DEFAULT));
		ground = new JLabel(groundIcon, JLabel.CENTER);
		this.add(ground);
	}

	/**	从窗口上移走地图 */
	private void removeGround() {
		if (ground != null)
			this.getContentPane().remove(ground);
	}

	/**	在窗口上放人物 */
	private void setCreature(int r, int c, CreatureType t) {
		ImageIcon creatureIcon = new ImageIcon("img\\" + t.imgName + ".png");
		creatureIcon.setImage(creatureIcon.getImage().getScaledInstance(span, span,Image.SCALE_DEFAULT));
		cell[r][c] = new JLabel(creatureIcon, JLabel.CENTER);
		cell[r][c].setSize(span, span);
		cell[r][c].setLocation(marginWidth + c * span, marginHeight + r * span);
		this.add(cell[r][c]);
	}

	/**	从窗口上移走人物 */
	private void removeCreature(int r, int c) {
		if (cell[r][c] != null)
			this.getContentPane().remove(cell[r][c]);
	}
	
	/**	在窗口上放阵型.
	 *	阵型类型为form，中心行列为(r, c) */
	private <T extends Creature> void setFormation(int r, int c, Formation<T> form) {
		// 遍历阵型内所有(坐标, 实体)对
		for (Point p : form.formMap.keySet())
			setCreature(p.row() + r - form.getFormCen().row(),
					p.col() + c - form.getFormCen().col(), form.getCreature(p).getType());
		
	}

	/**	从窗口上移走阵型.
	 *	阵型类型为form，中心行列为(r, c) */
	private <T extends Creature> void removeFormation(int r, int c, Formation<T> form) {
		// 遍历阵型内所有(坐标, 实体)对
		for (Point p : form.formMap.keySet())
			removeCreature(p.row() + r - form.getFormCen().row(),
					p.col() + c - form.getFormCen().col());
		
	}

	/**	清空GUI世界 */
	public void removeAtFirst() {
		removeGround();
		removeFormation(cWin.getBroCen().row(), cWin.getBroCen().col(), cWin.broForm);
		removeFormation(cWin.getMonCen().row(), cWin.getMonCen().col(), cWin.monForm);
		removeCreature(cWin.getEldPos().row(), cWin.getEldPos().col());
		removeCreature(cWin.getSnkPos().row(), cWin.getSnkPos().col());
	}

	/**	依照char世界的样子画出GUI世界 */
	public void showAtLast() {
		setFormation(cWin.getBroCen().row(), cWin.getBroCen().col(), cWin.broForm);
		setFormation(cWin.getMonCen().row(), cWin.getMonCen().col(), cWin.monForm);
		setCreature(cWin.getEldPos().row(), cWin.getEldPos().col(), cWin.elder.getType());
		setCreature(cWin.getSnkPos().row(), cWin.getSnkPos().col(), cWin.snake.getType());
		setGround();
		this.setVisible(true);
	}
	
	/**	监听键盘项 */
	class KeyMonitor implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
		}
		@Override
		public void keyPressed(KeyEvent e) {
		}
		@Override
		public void keyReleased(KeyEvent e) {
			if (isAuto) return; // 自动模式不支持使用键盘
			removeAtFirst();
			switch (e.getKeyCode()) {
			// 移动葫芦娃：WDSA
			case KeyEvent.VK_W: cWin.movGroup(GroupType.Bro, new Point(-1, 0)); break;
			case KeyEvent.VK_D: cWin.movGroup(GroupType.Bro, new Point(0, 1)); break;
			case KeyEvent.VK_S: cWin.movGroup(GroupType.Bro, new Point(1, 0)); break;
			case KeyEvent.VK_A: cWin.movGroup(GroupType.Bro, new Point(0, -1)); break;
			// 移动妖怪：UP/RIGHT/DOWN/LEFT
			case KeyEvent.VK_UP: cWin.movGroup(GroupType.Mon, new Point(-1, 0)); break;
			case KeyEvent.VK_RIGHT: cWin.movGroup(GroupType.Mon, new Point(0, 1)); break;
			case KeyEvent.VK_DOWN: cWin.movGroup(GroupType.Mon, new Point(1, 0)); break;
			case KeyEvent.VK_LEFT: cWin.movGroup(GroupType.Mon, new Point(0, -1)); break;
			// 移动老爷爷：THGF
			case KeyEvent.VK_T: cWin.movGroup(GroupType.Eld, new Point(-1, 0)); break;
			case KeyEvent.VK_H: cWin.movGroup(GroupType.Eld, new Point(0, 1)); break;
			case KeyEvent.VK_G: cWin.movGroup(GroupType.Eld, new Point(1, 0)); break;
			case KeyEvent.VK_F: cWin.movGroup(GroupType.Eld, new Point(0, -1)); break;
			// 移动蛇精：ILKJ
			case KeyEvent.VK_I: cWin.movGroup(GroupType.Snk, new Point(-1, 0)); break;
			case KeyEvent.VK_L: cWin.movGroup(GroupType.Snk, new Point(0, 1)); break;
			case KeyEvent.VK_K: cWin.movGroup(GroupType.Snk, new Point(1, 0)); break;
			case KeyEvent.VK_J: cWin.movGroup(GroupType.Snk, new Point(0, -1)); break;
			}
			cWin.showWorld();
			showAtLast();
		}
	}
	
	/**	监听菜单项 */
	class MenuMonitor implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == menuItReset)
				handleReset();
			else if (e.getSource() == menuItHY)
				handleMon(FormationType.HY);
			else if (e.getSource() == menuItYX)
				handleMon(FormationType.YX);
			else if (e.getSource() == menuItCE)
				handleMon(FormationType.CE);
			else if (e.getSource() == menuItYL)
				handleMon(FormationType.YL);
			else if (e.getSource() == menuItFY)
				handleMon(FormationType.FY);
			else if (e.getSource() == menuItYY)
				handleMon(FormationType.YY);
			else if (e.getSource() == menuItFS)
				handleMon(FormationType.FS);
		}
	}
	
	/**	菜单栏“开始”->“重置” */
	public void handleReset() {
		isAuto = false;
		removeAtFirst();
		cWin.initAll();
		cWin.showWorld();
		showAtLast();
	}
	
	/**	菜单栏“开始”->“阵型” */
	public void handleMon(FormationType type) {
		isAuto = false;
		nextForm = type;
		removeAtFirst();
		cWin.changeFormation(type);
		cWin.showWorld();
		showAtLast();
	}

	/**	自动模式 */
	public void autoWorld() {
		isAuto = true;
		while (isAuto) {
			// 1回合，妖怪摆鹤翼阵
			removeAtFirst();
			cWin.initAll();
			cWin.showWorld();
			showAtLast();
			if (!isAuto) break;
			// 2回合，妖怪摆雁行阵
			WorldSleep.worldSleep(500);
			removeAtFirst();
			cWin.changeFormation(FormationType.YX);
			cWin.movGroup(GroupType.Bro, new Point(0, 1));
			cWin.movGroup(GroupType.Eld, new Point(0, -2));
			cWin.movGroup(GroupType.Snk, new Point(0, 2));
			cWin.showWorld();
			showAtLast();
			if (!isAuto) break;
			// 3回合，妖怪摆冲轭阵
			WorldSleep.worldSleep(500);
			removeAtFirst();
			cWin.changeFormation(FormationType.CE);
			cWin.movGroup(GroupType.Bro, new Point(1, 0));
			cWin.movGroup(GroupType.Eld, new Point(-2, 1));
			cWin.movGroup(GroupType.Snk, new Point(2, -1));
			cWin.showWorld();
			showAtLast();
			if (!isAuto) break;
			// 4回合，妖怪摆鱼鳞阵
			WorldSleep.worldSleep(500);
			removeAtFirst();
			cWin.changeFormation(FormationType.YL);
			cWin.movGroup(GroupType.Bro, new Point(0, -1));
			cWin.movGroup(GroupType.Eld, new Point(2, 1));
			cWin.movGroup(GroupType.Snk, new Point(-2, -1));
			cWin.showWorld();
			showAtLast();
			if (!isAuto) break;
			// 5回合，妖怪摆方円阵
			WorldSleep.worldSleep(500);
			removeAtFirst();
			cWin.changeFormation(FormationType.FY);
			cWin.movGroup(GroupType.Bro, new Point(-1, 0));
			cWin.movGroup(GroupType.Eld, new Point(0, -2));
			cWin.movGroup(GroupType.Snk, new Point(0, 2));
			cWin.showWorld();
			showAtLast();
			if (!isAuto) break;
			// 6回合，妖怪摆偃月阵
			WorldSleep.worldSleep(500);
			removeAtFirst();
			cWin.changeFormation(FormationType.YY);
			cWin.movGroup(GroupType.Bro, new Point(0, 2));
			cWin.movGroup(GroupType.Eld, new Point(-2, 1));
			cWin.movGroup(GroupType.Snk, new Point(2, -1));
			cWin.showWorld();
			showAtLast();
			if (!isAuto) break;
			// 7回合，妖怪摆锋矢阵
			WorldSleep.worldSleep(500);
			removeAtFirst();
			cWin.changeFormation(FormationType.FS);
			cWin.movGroup(GroupType.Bro, new Point(0, -2));
			cWin.movGroup(GroupType.Eld, new Point(2, 1));
			cWin.movGroup(GroupType.Snk, new Point(-2, -1));
			cWin.showWorld();
			showAtLast();
			WorldSleep.worldSleep(500);
		}
		removeAtFirst();
		cWin.initAll();
		cWin.changeFormation(nextForm);
		cWin.showWorld();
		showAtLast();
	}
}
