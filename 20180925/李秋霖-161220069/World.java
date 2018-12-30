package homework3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class World {
	public final int SIZE = 60;

	private Creature[][] space = new Creature[SIZE][SIZE];
//	public ArrayList<Creature> creature;

	private Oldman oldman = new Oldman();
	private Calabash[] calabrothers = new Calabash[7];
	private Serpent serpent = new Serpent();
	private List<Scorpion> scorpion = new ArrayList<Scorpion>();

	public World() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				space[i][j] = new Creature();
			}
		}
		for (COLOR c : COLOR.values()) {
			calabrothers[c.ordinal()] = new Calabash(c);
		}
		scorpion.add(new Scorpion(false));
		for (int i = 1; i <= 5; i++)
			scorpion.add((Scorpion) new Scorpion(true));
	}

	private void put(int i, int j, Creature x) {
		if (space[i][j].alive == false) {
			space[i][j] = x;
			space[i][j].alive = true;
		} else
			System.out.println("this place is already full");
	}

	public void showTheWorld() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				space[i][j].printCreature();
			}
			System.out.println("");
		}
	}

	public void putCalabrothers() {
		final int STARTX = 15;
		final int STARTY = 27;
		for (int i = 0; i < 7; i++) {
			put(STARTY + i, STARTX, calabrothers[i]);
		}
	}

	public void putOldman() {
		final int STARTX = 5;
		final int STARTY = 30;
		put(STARTY, STARTX, oldman);
	}

	public void putSerpent() {
		final int STARTX = 55;
		final int STARTY = 30;
		put(STARTY, STARTX, serpent);
	}

	private void heFormation() {
		final int STARTX = 45;
		final int STARTY = 30;
		put(STARTY, STARTX, scorpion.get(0));
		for (int i = 1, tmp = 1; i < scorpion.size(); i = i + 2, tmp++) {
			put(STARTY + tmp, STARTX + tmp, scorpion.get(i));
			if (i + 1 == scorpion.size())
				scorpion.add((Scorpion) new Scorpion(true));
			put(STARTY - tmp, STARTX + tmp, scorpion.get(i + 1));
		}
	}

	private void yanFormation() {
		final int STARTX = 45;
		final int STARTY = 30;
		put(STARTY, STARTX, scorpion.get(0));
		for (int i = 1, tmp = 1; i < scorpion.size(); i = i + 2, tmp++) {
			put(STARTY - tmp, STARTX + tmp, scorpion.get(i));
			if (i + 1 == scorpion.size())
				scorpion.add((Scorpion) new Scorpion(true));
			put(STARTY + tmp, STARTX - tmp, scorpion.get(i + 1));
		}
	}

//	private void chongFormation() {
//		
//	}
//	private void changFormation() {
//		
//	}
//	private void yuFormation() {
//		
//	}
//	private void fangFormation() {
//		
//	}
//	private void yueFormation() {
//		
//	}
//	private void fengFormation() {
//		
//	}
	public void putScorpion(int type) {
		switch (type) {
		case 0:
			heFormation();
			break;
		case 1:
			yanFormation();
			break;
		default:
			break;
		}
	}

//	public void 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Please choose the formation of Scorpion(0 for HeYi, 1 for YanXing)");
		int formation = input.nextInt();
		input.close();
		World world = new World();
		world.putOldman();
		world.putCalabrothers();
		world.putSerpent();
		world.putScorpion(formation);
		world.showTheWorld();

	}

}
