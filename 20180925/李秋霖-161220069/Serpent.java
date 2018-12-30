package homework3;

public class Serpent extends Creature {
	public void printCreature() {
		if (alive == false) {
			System.out.print(" ");
			return;
		}
		System.out.print("S");
	}
}
