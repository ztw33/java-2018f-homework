package battlefield;
import battlefield.Tile;
import creature.*;

public class BattleField {
	Tile[][] field = new Tile[15][15];
	public BattleField() {
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				field[i][j] = new Tile();
			}
		}
	}
	public void show() {
		for(int i = 0; i < 5 * 15; i++) {
			for (int j = 0; j < 5 * 15; j++) {
				System.out.print(field[i / 5][j / 5].situation[i % 5][j % 5]);
			}
			System.out.print("\n");
		}
	}
	public void standOn(Creature onePerson) {
		field[onePerson.x][onePerson.y].stood(onePerson);
	}
	public void cleanRight() {
		for(int i = 0; i < 15; i++) {
			for(int j = 6; j < 15; j++) {
				field[i][j] = new Tile();
			}
		}
	}//由于蝎子精变换阵型，故需要清屏右边
}
