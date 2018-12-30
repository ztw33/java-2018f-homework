package huluwa.pic;

import java.awt.*;
import javax.swing.*;


public class space {
	JFrame UI;
	int max=10;
	
	public space(){
		UI=new JFrame("huluwa VS monster");
		UI.setSize(1024, 580);
		UI.setLayout(null);
		UI.setLocation(200,200);
		
		JLabel board1=new JLabel();
		ImageIcon iboard1=new ImageIcon("src/icon/board.jpg");
		board1.setIcon(iboard1);
		board1.setBounds(0, 0, iboard1.getIconWidth(), iboard1.getIconHeight());;
		
		UI.getLayeredPane().add(board1,new Integer(Integer.MIN_VALUE));
		Container cp=UI.getContentPane();
		cp.setLayout(new BorderLayout());
		((JPanel)cp).setOpaque(false); 
		
		/*
		try {
			Thread.sleep(1000);
		}catch(Exception e)
		{
			System.exit(0);
		}*/
		
		/*JLabel huluwa1=new JLabel();
		ImageIcon ihuluwa1=new ImageIcon("src/icon/h1.png");
		ihuluwa1.setImage(ihuluwa1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		//ihuluwa1=new ImageIcon(ihuluwa1.getImage().getScaledInstance(getWidth(), getHeight()-25, Image.SCALE_DEFAULT));
		huluwa1.setIcon(ihuluwa1);
		huluwa1.setBounds(100, 100, ihuluwa1.getIconWidth(), ihuluwa1.getIconHeight());
		
		
		UI.add(huluwa1);*/
		
		UI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		UI.setVisible(true);
		
		/*try {
			Thread.sleep(3000);
		}catch(Exception e)
		{
			System.exit(0);
		}
		
		huluwa1.setLocation(150, 150);*/
		
	}
	
	public void add(JLabel t)
	{
		UI.add(t);
	}
	
}
