package calabash;

public enum CalabashColor {  //将葫芦娃的颜色定义为枚举类，避免重复生成同一个葫芦娃；
	RED("大娃", 1), 
	ORANGE("二娃", 2), 
	YELLOW("三娃", 3), 
	GREEN("四娃", 4), 
	CYAN("五娃", 5), 
	BLUE("六娃", 6), 
	PURPLE("七娃", 7);
	private String name;
	private int order;  //表示葫芦娃的大小顺序；
	
	CalabashColor(String name, int order){
		this.name = name;
		this.order = order;
	}
	
	public int getOrder() {
		return this.order;
	}
	
	public String getName() {
		return this.name;
	}
}
