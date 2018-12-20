public class Battle {
	public static void main(String args[]) {
		Battle battle = new Battle();
		Manipulator god = new Manipulator();
		
		battle.startRound(1);
		god.placeCreature(1);
		god.displayField(1);

		battle.startRound(2);
		god.placeCreature(2);
		god.displayField(2);

		battle.startRound(3);
		god.placeCreature(3);
		god.displayField(3);

		battle.startRound(4);
		god.placeCreature(4);
		god.displayField(4);

		battle.startRound(5);
		god.placeCreature(5);
		god.displayField(5);


		battle.startRound(6);
		god.placeCreature(6);
		god.displayField(6);
	}

	public void startRound(int round) {
		System.out.println();
		for (int i = 0; i < 36; i++)
			System.out.print("-");
		System.out.print(" Round" + round + " ");
		for (int i = 0; i < 36; i++)
			System.out.print("-");
		System.out.println();
	}
}