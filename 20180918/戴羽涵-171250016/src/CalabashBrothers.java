public enum CalabashBrothers {
	BrotherOne("红娃"),
	BrotherTwo("橙娃"),
	BrotherThree("黄娃"),
	BrotherFour("绿娃"),
	BrotherFive("青娃"),
	BrotherSix("蓝娃"),
	BrotherSeven("紫娃");

	private String name;
	private String smallName;
	private int num;
	private int location;
	private String color;

	CalabashBrothers(String name) {
		this.name=name;
		switch (name) {
			case "红娃":
				this.num = 1;
				this.smallName="老大";
				this.color = "红色";
				break;
			case "橙娃":
				this.num = 2;
				this.smallName="老二";
				this.color = "橙色";
				break;
			case "黄娃":
				this.num = 3;
				this.smallName="老三";
				this.color = "黄色";
				break;
			case "绿娃":
				this.num = 4;
				this.smallName="老四";
				this.color = "绿色";
				break;
			case "青娃":
				this.num = 5;
				this.smallName="老五";
				this.color = "青色";
				break;
			case "蓝娃":
				this.num = 6;
				this.smallName="老六";
				this.color = "蓝色";
				break;
			case "紫娃":
				this.num = 7;
				this.smallName="老七";
				this.color = "紫色";
				break;
			default:
				break;
		}
	}

	public String getName() {
		return this.name;
	}

	public String getSmallName() {
		return this.smallName;
	}

	public int getNum() {
		return this.num;
	}

	public int getLocation() {
		return this.location;
	}

	public String getColor() {
		return this.color;
	}

	public void setLocation(int location) {
		this.location=location;
	}

	public boolean lessOfNum(CalabashBrothers m) {
		return this.getNum() < m.getNum();
	}

	public boolean lessOfColor(CalabashBrothers person) {
		return lessOfNum(person);
	}

	public void increseLocation() {
		this.location++;
	}

}
