package thirdHomework;

public enum Species {
	/*
	 * 出现的物种：葫芦娃、老爷爷、蛇精、蝎子精、小喽啰
	 */
	CALABASH("葫芦娃"), GRANDPA("老爷爷"), SNAKE("蛇精"), SCORPION("蝎子精"), MINION("小喽啰");
	private String name;

	private Species(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
