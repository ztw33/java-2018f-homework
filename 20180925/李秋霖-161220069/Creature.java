package homework3;

public class Creature {

//	protected int x;
//	protected int y;
	protected boolean alive;
//	public final int N = 100;

	public Creature() {
		alive = false;
		System.out.print("*");
	}

//	public void putDown(int i, int j) {
//
//	}

	public void printCreature() {
		if (alive == false) {
			System.out.print(" ");
			return;
		}
		System.out.print("?");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Oldman x = new Oldman();

		// x.putDown(0, 0);
	}

}
