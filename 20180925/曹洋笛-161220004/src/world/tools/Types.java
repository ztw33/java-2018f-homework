package world.tools;

public enum Types {
	
	HY("鹤翼阵"),
	YX("雁行阵"),
	CE("冲轭阵"),
	CS("长蛇阵"),
	YL("鱼鳞阵"),
	FY("方円阵"),
	YY("偃月阵"),
	FS("锋矢阵");
	
	public String name;
	private Types(String name) { // 构造方法
		this.name = name;
	}
}
