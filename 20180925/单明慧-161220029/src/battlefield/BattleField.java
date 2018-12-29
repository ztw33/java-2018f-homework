package battlefield;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import battlefield.Tile;
import creature.*;

public class BattleField {
	Tile<Creature>[][] field = new Tile[15][15];
	JFrame battleFieldGui;
	JTextArea text;
	public BattleField() {
		battleFieldGui = new JFrame("battlefield");
		battleFieldGui.setSize(1000, 780);
		battleFieldGui.setLocation(500, 200);
		battleFieldGui.setLayout(null);
		battleFieldGui.setResizable(false);
		
        text = new JTextArea();
        text.setEditable(false);
        text.setSize(250,780);
        text.setLineWrap(true);//自动换行
        battleFieldGui.add(text);
        text.setBounds(750, 0, 250, 780);
        text.setText("info:\n");
        
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				field[i][j] = new Tile<Creature>();
				
				JLabel l = field[i][j].tellSituation();
	            l.setBounds(j * 50, i * 50, 50, 50);
	            battleFieldGui.add(l);
			}
		}
	}
	public void show() {
		battleFieldGui.setVisible(true);
	}
	public void standOn(Creature onePerson) {
		field[onePerson.x][onePerson.y].stood(onePerson);
	}
	public void cleanRight() {
		for(int i = 0; i < 15; i++) {
			for(int j = 6; j < 15; j++) {
				field[i][j] = new Tile<Creature>();
			}
		}
	}//由于蝎子精变换阵型，故需要清屏右边
	public void appendInfo(String newInfo) {
		text.append(newInfo);
	}
	public JTextArea tellText() {
		return this.text;
	}
}
