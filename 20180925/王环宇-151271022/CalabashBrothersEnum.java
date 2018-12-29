// this enum file is prepared for better manage CalabashBrothers
// but not used now, it can be used in the future version
public enum CalabashBrothersEnum {
	大娃("红",1), 二娃("橙",2), 三娃("黄",3), 四娃("绿",4), 五娃("青",5), 六娃("蓝",6), 七娃("紫",7);
	private final String name;
	private final int order;
	public int[] destination;
	private CalabashBrothersEnum(String name, int order){
		this.name = name;
		this.order = order;
		destination = new int[2];
	}
	public int[] where() {
		return destination;
	}
	public void changePlace(int m, int n) {
		destination[0] = m;
		destination[1] = n;
	}
}