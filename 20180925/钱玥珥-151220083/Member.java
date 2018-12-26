package square;

enum Member {
	EMPTY(" "),
	RED("大娃"),
	ORANGE("二娃"),
	YELLOW("三娃"),
	GREEN("四娃"),
	CYAN("五娃"),
	BLUE("六娃"),
	PURPLE("七娃"),
	GRANDFATHER("爷爷"),
	SCORPION("蜈蚣精"),
	SERPENT("蛇精"),
	UNDERLING("喽啰");
	Member(String name){
		this.name=name;
	}
	String name;
};
enum Forces{
	HULUWA,
	ENEMY;
};