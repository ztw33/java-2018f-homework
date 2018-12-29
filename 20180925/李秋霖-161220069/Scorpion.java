package homework3;

public class Scorpion extends Creature {
	boolean littlescrop;

	public Scorpion(boolean b) {
		littlescrop = b;
	}

	public void printCreature() {
		if (alive == false) {
			System.out.print(" ");
			return;
		}
		if (!littlescrop)
			System.out.print("X");
		else
			System.out.print("x");
	}
}
