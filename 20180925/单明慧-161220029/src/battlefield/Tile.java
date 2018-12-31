package battlefield;
import creature.*;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Tile<T extends Creature> {
	private JLabel situation;
	Tile() {
		situation = new JLabel();
		ImageIcon icon = new ImageIcon("pics/1.png");
        situation.setIcon(icon);
	}
	void stood(T onePerson) {
		situation.setIcon(onePerson.tellFigure());
	}
	JLabel tellSituation() {
		return situation;
	}
}
