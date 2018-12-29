package calabashBrothers;

public enum CalabashBrothers{
	RED("大娃", "红", 1), ORANGE("二娃", "橙", 2), YELLOW("三娃", "黄", 3), GREEN("四娃", "绿", 4), CYAN("五娃", "青", 5), BLUE("六娃", "蓝", 6), PURPLE("七娃", "紫", 7);
	private String name, color;
	private int order;
	
	private CalabashBrothers(String name, String color, int order) {
		this.name = name;
		this.color = color;
		this.order = order;
	}
	
	public void reportName() {
		System.out.print(this.name);
		System.out.print("\t");
	}
	
	public void reportColor() {
		System.out.print(this.color);
		System.out.print("\t");
	}
	
	public int getOrder() {
		return this.order;
	}
	
	public void report(int i, int j) {
		System.out.println(this.name + ":" + j + "->" + i);
	}
}
