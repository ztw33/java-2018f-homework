package battlefield;
import creature.*;

public class Tile {
	String[][] situation = new String[5][5];
	Tile() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++)
				situation[i][j] = "  ";
		}
		for(int i = 0; i < 5; i++) {
			situation[4][i] = "--";
		}
		for(int i = 1; i < 5;i++) {
			situation[i][4] = "|";
		}
	}
	void stood(Creature onePerson) {
		int strLen = onePerson.tellName().length();
		for(int i = 0; i < strLen; i++) {
			situation[1 + i][1] = onePerson.tellName().substring(i, i + 1);
		}
	}
}
