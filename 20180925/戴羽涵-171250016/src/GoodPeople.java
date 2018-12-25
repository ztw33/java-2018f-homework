public enum GoodPeople implements Creature<GoodPeople> {
	// TODO: 2018/9/25 把"爷爷"放在哪里好呢？？？
	GrandPa("爷爷",0,"爷"),
	BrotherOne("红娃", "老大", "红色", 1,"红"),
	BrotherTwo("橙娃", "老二", "橙色", 2,"橙"),
	BrotherThree("黄娃", "老三", "黄色", 3,"黄"),
	BrotherFour("绿娃", "老四", "绿色", 4,"绿"),
	BrotherFive("青娃", "老五", "青色", 5,"青"),
	BrotherSix("蓝娃", "老六", "蓝色", 6,"蓝"),
	BrotherSeven("紫娃", "老七", "紫色", 7,"紫");

	private String name;
	private String smallName;
	private int rank;
	private String color;
	private String symbol;

	GoodPeople(String name,int rank,String symbol) {
		this.name=name;
		this.rank=rank;
		this.symbol=symbol;
	}

	GoodPeople(String name, String smallName, String color, int rank,String symbol) {
		this.name = name;
		this.smallName = smallName;
		this.color = color;
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

	public String getSmallName() {
		return this.smallName;
	}

	@Override
	public int getRank() {
		return this.rank;
	}

	public String getColor() {
		return this.color;
	}

	@Override
	public boolean less(GoodPeople goodPeople) {
		return this.rank < goodPeople.rank;
	}
}
