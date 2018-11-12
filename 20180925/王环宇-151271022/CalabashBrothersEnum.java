package javahw3;

// this enum file is prepared for better manage CalabashBrothers
// but not used now, it can be used in the future version
public enum CalabashBrothersEnum {
	´óÍŞ("ºì",1), ¶şÍŞ("³È",2), ÈıÍŞ("»Æ",3), ËÄÍŞ("ÂÌ",4), ÎåÍŞ("Çà",5), ÁùÍŞ("À¶",6), ÆßÍŞ("×Ï",7);
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
