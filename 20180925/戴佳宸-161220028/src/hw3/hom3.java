package hw3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;
import java.util.*;
import java.util.Timer;

public class hom3 extends JFrame{
	int row=11;
	int col=11;
	static JLabel lab[]=new JLabel[121];
	public hom3() {
		Container container=getContentPane();
		setLayout(new GridLayout(11,11));
		for(int i=0;i<121;i++)
		{
			if(i==7)
			{JButton bianzhen=new JButton("º×ÒíÕó");
			bianzhen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					henge_end();
					yanxing_end();
					fangzhen_end();
					fengshi_end();
					heyi();
				}
			});
			container.add(bianzhen);
			}
			else if(i==8)
			{JButton bianzhen=new JButton("ÑãÐÐÕó");
			bianzhen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					henge_end();
					heyi_end();
					fangzhen_end();
					fengshi_end();
					yanxing();
				}
			});
			container.add(bianzhen);
			}
			else if(i==9)
			{JButton bianzhen=new JButton("ºâéîÕó");
			bianzhen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					heyi_end();
					yanxing_end();
					fangzhen_end();
					fengshi_end();
					henge();
				}
			});
			container.add(bianzhen);
			}
			else if(i==10)
			{JButton bianzhen=new JButton("·½ƒÒÕó");
			bianzhen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					henge_end();
					yanxing_end();
					heyi_end();
					fengshi_end();
					fangzhen();
				}
			});
			container.add(bianzhen);
			}
			else if(i==18)
			{JButton bianzhen=new JButton("·æÊ¸Õó");
			bianzhen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					henge_end();
					yanxing_end();
					fangzhen_end();
					heyi_end();
					fengshi();
				}
			});
			container.add(bianzhen);
			}
			else
			{JLabel jb=new JLabel();
		jb.setBorder(BorderFactory.createLineBorder(Color.red));
		jb.setOpaque(true); 
		jb.setSize(100, 100);
		container.add(jb);
		lab[i]=jb;}
	}
		init();
		setSize(1100, 1100);
		setTitle("ºùÂ«ÍÞ´óÕ½Ð«×Ó¾«");
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}
	public static void main(String[] args) {
		new hom3();
		
	}
	public static void init() {
		
		setwa(lab[22],"/img/1.jpg"); 
		setwa(lab[33],"/img/2.jpg");
		setwa(lab[44],"/img/3.jpg");
		setwa(lab[55],"/img/4.jpg");
		setwa(lab[66],"/img/5.jpg"); 
		setwa(lab[77],"/img/6.jpg"); 
		setwa(lab[88],"/img/7.jpg");
		setwa(lab[114],"/img/yeye.png");
		setwa(lab[6], "/img/shejing.jpg");
	}
	public static void heyi() {

		setwa(lab[54], "/img/xiaobing.png");
		setwa(lab[64], "/img/xiaobing.png");
		setwa(lab[74], "/img/boss.png");
		setwa(lab[62], "/img/xiaobing.png");
		setwa(lab[50], "/img/xiaobing.png");
	}
	public static void heyi_end() {
		lab[54].setIcon(null);
		lab[64].setIcon(null);
		lab[74].setIcon(null);
		lab[62].setIcon(null);
		lab[50].setIcon(null);
	}
	public static void yanxing() {
		setwa(lab[43], "/img/xiaobing.png");
		setwa(lab[53], "/img/xiaobing.png");
		setwa(lab[63], "/img/boss.png");
		setwa(lab[73], "/img/xiaobing.png");
		setwa(lab[83], "/img/xiaobing.png");
	}
	public static void yanxing_end() {
		lab[43].setIcon(null);
		lab[53].setIcon(null);
		lab[63].setIcon(null);
		lab[73].setIcon(null);
		lab[83].setIcon(null);
	}
	public static void fangzhen() {
		setwa(lab[41], "/img/xiaobing.png");
		setwa(lab[51], "/img/xiaobing.png");
		setwa(lab[61], "/img/xiaobing.png");
		setwa(lab[73], "/img/xiaobing.png");
		setwa(lab[65], "/img/boss.png");
		setwa(lab[85], "/img/xiaobing.png");
		setwa(lab[75], "/img/xiaobing.png");
		setwa(lab[53], "/img/xiaobing.png");
	}
	public static void fangzhen_end() {
		lab[41].setIcon(null);
		lab[51].setIcon(null);
		lab[61].setIcon(null);
		lab[73].setIcon(null);
		lab[65].setIcon(null);
		lab[85].setIcon(null);
		lab[75].setIcon(null);
		lab[53].setIcon(null);
	}
	public static void henge() {

		setwa(lab[31], "/img/xiaobing.png");
		setwa(lab[43], "/img/xiaobing.png");
		setwa(lab[53], "/img/xiaobing.png");
		setwa(lab[65], "/img/boss.png");
		setwa(lab[75], "/img/xiaobing.png");
		setwa(lab[87], "/img/xiaobing.png");
		setwa(lab[97], "/img/xiaobing.png");

	}
	public static void henge_end() {
		lab[31].setIcon(null);
		lab[43].setIcon(null);
		lab[53].setIcon(null);
		lab[65].setIcon(null);
		lab[75].setIcon(null);
		lab[87].setIcon(null);
		lab[97].setIcon(null);
	}
	public static void fengshi() {
		setwa(lab[51], "/img/xiaobing.png");
		setwa(lab[41], "/img/xiaobing.png");
		setwa(lab[73], "/img/xiaobing.png");
		setwa(lab[61], "/img/boss.png");
		setwa(lab[85], "/img/xiaobing.png");
		setwa(lab[62], "/img/xiaobing.png");
		setwa(lab[63], "/img/xiaobing.png");
		setwa(lab[64], "/img/xiaobing.png");
		setwa(lab[65], "/img/xiaobing.png");
	}
	public static void fengshi_end() {
		lab[51].setIcon(null);
		lab[41].setIcon(null);
		lab[73].setIcon(null);
		lab[61].setIcon(null);
		lab[85].setIcon(null);
		lab[62].setIcon(null);
		lab[63].setIcon(null);
		lab[64].setIcon(null);
		lab[65].setIcon(null);
	}
	public static void setwa(JLabel jl,String url) {
		java.net.URL imgURL1 = hom3.class.getResource(url);
		ImageIcon image = new ImageIcon(imgURL1);
		image.setImage(image.getImage().getScaledInstance(jl.getWidth(), jl.getHeight(),Image.SCALE_DEFAULT ));
		jl.setIcon(image);
		jl.setHorizontalAlignment(0);  
	}
}
