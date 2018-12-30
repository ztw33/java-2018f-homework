package creatures;

public class CalabashBrother extends GoodCampCreature {
	private String color;
	private int index;
	public CalabashBrother(int i) {
		index = i;
		switch (i) {
		case 0:
			name = "老大";
			color = "红娃";
			break;
		case 1:
			name = "老二";
			color = "橙娃";
			break;
		case 2:
			name = "老三";
			color = "黄娃";
			break;
		case 3:
			name = "老四";
			color = "绿娃";
			break;
		case 4:
			name = "老五";
			color = "青娃";
			break;
		case 5:
			name = "老六";
			color = "蓝娃";
			break;
		case 6:
			name = "老七";
			color = "紫娃";
			break;
		default:
			throw new IndexOutOfBoundsException("You are trying to build calabashbrother which is not existing");
		}
	}
	public int getIndex() {
		return index;
	}
	public String getColor() {
		return color;
	}
}
