package homework3;

//public class Calabrothers extends Creature{
//	private Calabash[] brothers = new Calabash[7];
//	public Calabrothers() 
//	{
//		for (COLOR c : COLOR.values()) {
//			brothers[c.ordinal()] = new Calabash(c);
//		}
//	}
//}

enum COLOR {
	RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE;
}

public class Calabash extends Creature {
	private COLOR color;

	public Calabash(COLOR color) {
		this.color = color;
	}

	public void printCreature() {
		if (alive == false) {
			System.out.print(" ");
			return;
		}
		System.out.print(color.ordinal());
	}
}