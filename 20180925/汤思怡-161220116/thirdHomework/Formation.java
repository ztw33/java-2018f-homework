package thirdHomework;

public enum Formation {
	/*
	 * 变换队形：鹤翼、雁行、冲轭、长蛇、鱼鳞、方円、偃月、锋失
	 */
	CRANE("鹤翼"), GOOSE("雁行"), YOKE("冲轭"), SNAKE("长蛇"), FISH("鱼鳞"), SQAURE("方円"), MOON("偃月"), FRONT("锋失");
	private String name;

	private Formation(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
