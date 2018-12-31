package thirdHomework;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.*;

public class ShowFormation extends JFrame implements Constants {
	private JPanel frame;
	private JButton btnCrane, btnGoose, btnYoke, btnFish, btnSquare, btnMoon, btnFront;
	private JLabel[][] label = new JLabel[Constants.NUM][Constants.NUM];
	Creature[][] dimension = new Creature[Constants.NUM][Constants.NUM];
	private final ImageIcon background = new ImageIcon("image\\background.jpg");
	EvilSide evilSide;
	GoodSide goodSide;

	// 主方法：在面板中打印对峙阵型
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShowFormation sFormation = new ShowFormation();
	}

	public ShowFormation() {
		initDimension();
		initFrame();
		initButton();
	}

	// 初始化生物二维数组
	private void initDimension() {
		for (int i = 0; i < Constants.NUM; i++) {
			for (int j = 0; j < Constants.NUM; j++) {
				dimension[i][j] = null;
			}
		}
		int[] order = { 2, 6, 3, 5, 1, 4, 0 };
		goodSide = new GoodSide(order);
		evilSide = new EvilSide();
		goodSide.formate(dimension);
		background.setImage(background.getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_DEFAULT));
	}

	// 初始化父窗体
	private void initFrame() {
		frame = new JPanel();
		getContentPane().add(frame);
		frame.setLayout(null);
		frame.setSize(Constants.TOTAL_WIDTH, Constants.TOTAL_HEIGHT);
		getContentPane().add(frame);
		this.setSize(Constants.TOTAL_WIDTH, Constants.TOTAL_HEIGHT);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("葫芦娃大战蝎子精和他的小弟们");
	}

	// 初始化按钮
	private void initButton() {
		initLabel();
		initCraneButton();
		initGooseButton();
		initYokeButton();
		initFishButton();
		initSquareButton();
		initMoonButton();
		initFrontButton();
	}

	// 初始化每个标签
	private void initLabel() {
		for (int i = 0; i < Constants.NUM; i++) {
			for (int j = 0; j < Constants.NUM; j++) {
				label[i][j] = new JLabel();
				frame.add(label[i][j]);
			}
		}
	}

	// 设置按钮鹤翼
	private void initCraneButton() {
		btnCrane = new JButton();
		frame.add(btnCrane);
		btnCrane.setText("鹤翼");
		btnCrane.setBounds(TOTAL_WIDTH - 2 * IMAGE_WIDTH, IMAGE_HEIGHT / 2, IMAGE_WIDTH, IMAGE_HEIGHT / 2);
		btnCrane.addMouseListener(new MouseAdapter() {// 给按钮加上监听事件
			public void mouseClicked(MouseEvent e1) {
				System.out.println("鹤翼");
				initDimension();
				evilSide.formate(dimension, Formation.CRANE);
				setDimension();
			}

		});
	}

	// 设置按钮雁行
	private void initGooseButton() {
		btnGoose = new JButton();
		frame.add(btnGoose);
		btnGoose.setText("雁行");
		btnGoose.setBounds(TOTAL_WIDTH - 2 * IMAGE_WIDTH, IMAGE_HEIGHT * 3 / 2, IMAGE_WIDTH, IMAGE_HEIGHT / 2);
		btnGoose.addMouseListener(new MouseAdapter() {// 给按钮加上监听事件
			public void mouseClicked(MouseEvent e1) {
				System.out.println("雁行");
				initDimension();
				evilSide.formate(dimension, Formation.GOOSE);
				setDimension();
			}
		});
	}

	// 设置按钮冲轭
	private void initYokeButton() {
		btnYoke = new JButton();
		frame.add(btnYoke);
		btnYoke.setText("冲轭");
		btnYoke.setBounds(TOTAL_WIDTH - 2 * IMAGE_WIDTH, IMAGE_HEIGHT * 5 / 2, IMAGE_WIDTH, IMAGE_HEIGHT / 2);
		btnYoke.addMouseListener(new MouseAdapter() {// 给按钮加上监听事件
			public void mouseClicked(MouseEvent e1) {
				System.out.println("冲轭");
				initDimension();
				evilSide.formate(dimension, Formation.YOKE);
				setDimension();
			}
		});
	}

	// 设置按钮鱼鳞
	private void initFishButton() {
		btnFish = new JButton();
		frame.add(btnFish);
		btnFish.setText("鱼鳞");
		btnFish.setBounds(TOTAL_WIDTH - 2 * IMAGE_WIDTH, IMAGE_HEIGHT * 7 / 2, IMAGE_WIDTH, IMAGE_HEIGHT / 2);
		btnFish.addMouseListener(new MouseAdapter() {// 给按钮加上监听事件
			public void mouseClicked(MouseEvent e1) {
				System.out.println("鱼鳞");
				initDimension();
				evilSide.formate(dimension, Formation.FISH);
				setDimension();
			}
		});
	}

	// 设置按钮方円
	private void initSquareButton() {
		btnSquare = new JButton();
		frame.add(btnSquare);
		btnSquare.setText("方円");
		btnSquare.setBounds(TOTAL_WIDTH - 2 * IMAGE_WIDTH, IMAGE_HEIGHT * 9 / 2, IMAGE_WIDTH, IMAGE_HEIGHT / 2);
		btnSquare.addMouseListener(new MouseAdapter() {// 给按钮加上监听事件
			public void mouseClicked(MouseEvent e1) {
				System.out.println("方円");
				initDimension();
				evilSide.formate(dimension, Formation.SQAURE);
				setDimension();
			}
		});
	}

	// 设置按钮偃月
	private void initMoonButton() {
		btnMoon = new JButton();
		frame.add(btnMoon);
		btnMoon.setText("偃月");
		btnMoon.setBounds(TOTAL_WIDTH - 2 * IMAGE_WIDTH, IMAGE_HEIGHT * 11 / 2, IMAGE_WIDTH, IMAGE_HEIGHT / 2);
		btnMoon.addMouseListener(new MouseAdapter() {// 给按钮加上监听事件
			public void mouseClicked(MouseEvent e1) {
				System.out.println("偃月");
				initDimension();
				evilSide.formate(dimension, Formation.MOON);
				setDimension();
			}
		});
	}

	// 设置按钮锋失
	private void initFrontButton() {
		btnFront = new JButton();
		frame.add(btnFront);
		btnFront.setText("锋失");
		btnFront.setBounds(TOTAL_WIDTH - 2 * IMAGE_WIDTH, IMAGE_HEIGHT * 13 / 2, IMAGE_WIDTH, IMAGE_HEIGHT / 2);
		btnFront.addMouseListener(new MouseAdapter() {// 给按钮加上监听事件
			public void mouseClicked(MouseEvent e1) {
				System.out.println("锋失");
				initDimension();
				evilSide.formate(dimension, Formation.FRONT);
				setDimension();
			}
		});

	}

	// 在面板中显示图片
	private void setDimension() {
		for (int i = 1; i < Constants.NUM; i++) {
			for (int j = 0; j < Constants.NUM; j++) {
				label[i][j].setBounds(j * IMAGE_WIDTH, (i - 1) * IMAGE_HEIGHT, IMAGE_WIDTH, IMAGE_HEIGHT);
				if (dimension[i][j] != null) {
					label[i][j].setIcon(dimension[i][j].icon);
					System.out.print(dimension[i][j].name + "\t");
				} else {
					System.out.print("\t");
					label[i][j].setIcon(background);
				}
			}
			System.out.println();
		}
	}
}
