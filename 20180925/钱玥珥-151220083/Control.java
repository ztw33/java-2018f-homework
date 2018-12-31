package square;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Control {
	HuluwaQueue huluwa;
	EnemyQueue enemy;
	Space square;
	Control(){
		huluwa=new HuluwaQueue();
		enemy=new EnemyQueue();
		square=new Space();
		place();
	}
	private void place() {
		square.enterQueue(huluwa.getQueue(), 7, 1, Forces.HULUWA);
		square.enterQueue(enemy.getQueue(), enemy.getRow(), enemy.getCol(), Forces.ENEMY);
		square.enter(Member.GRANDFATHER, Forces.HULUWA);
		square.enter(Member.SERPENT, Forces.ENEMY);
	}
	private void change() {
		huluwa.requeue();
		enemy.requeue();
		square.clearSpace();
		place();
	}
	void observe() {
		int n = square.N;
		JFrame pf = new JFrame("");
		pf.setSize(n*40+200, n*40);
		pf.setLocation(400, 400);
		pf.setLayout(null);
		pf.setVisible(true);
		pf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton jb = new JButton("改变阵形");
		jb.setBounds(n*40+30,50,100,20);	
		pf.add(jb);
		
		
		JLabel [][]local=new JLabel[n][n];
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				String str=square.locationOf(i, j).name;
				local[i][j]=new JLabel(str);	
				local[i][j].setBounds(40*j,40*i,40,40);
				pf.add(local[i][j]);
			}		
		}
		pf.setTitle("对阵————"+"长蛇阵vs"+enemy.getQueueName());
		pf.repaint();
		
		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent E) {
				change();
				for(int i = 0;i<n;i++) {
					for(int j = 0;j<n;j++) {
						String str=square.locationOf(i, j).name;
						if(!str.equals(" ")) {
							local[i][j].setText(str);				
						}
						else
							local[i][j].setText(" ");
						local[i][j].setBounds(40*j,40*i,40,40);
					}
				}
				pf.setTitle("对阵————"+"长蛇阵vs"+enemy.getQueueName());
//				pf.validate();
				pf.repaint();
			}
		});
		
		


	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Control b=new Control();
		b.observe();
	
	}

}
