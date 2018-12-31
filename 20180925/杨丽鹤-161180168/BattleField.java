class BattleField {
	private int length, width;

	public BattleField(int length, int width) {
		this.width = width;
		this.length = length;
	}

	public void displayField(Creature[] creature) {
		int breakSign = 0;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; ) {
				breakSign = 0;
				for (int t = 0; t < creature.length; t++) {
					if (i == creature[t].getY() && j == creature[t].getX()) {
						System.out.print(creature[t].getName());
						j += creature[t].getName().getBytes().length - creature[t].getName().length();
						breakSign = 1;
						break;	
					}
				}
				if (breakSign == 0) {
					System.out.print("*");
					j++;
				}
			}
			System.out.println();
		}
	}
}