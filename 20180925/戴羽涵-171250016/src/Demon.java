/**
 * 初始化设定为demon共有8个，1个蛇精，1个蝎子精，6个小喽啰
 */
public enum Demon implements Creature<Demon> {
	SNAKE("蛇精", 1,"蛇"),  // 蛇精
	SCORPION("蝎子精", 2,"蝎"),  // 蝎子精
	FOLLOWING("小喽啰", 3,"喽")  // 小喽啰
	;

	// TODO: 2018/9/25 若干个小喽啰是否需要用标记来区分他们呢？
	String name;
	int rank;
	String symbol;

	Demon(String name, int rank,String symbol) {
		this.name = name;
		this.rank = rank;
		this.symbol=symbol;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getSymbol() {
		return this.symbol;
	}

	@Override
	public int getRank() {
		return this.rank;
	}

	@Override
	public boolean less(Demon demon) {
		return this.rank<demon.rank;
	}
}
