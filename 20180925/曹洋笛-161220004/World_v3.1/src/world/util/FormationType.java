package world.util;

/**	
 *	阵型类型（共8种）
 * 
 *	@author Mirror
 */
public enum FormationType {
	
	HY("鹤翼阵"),
	YX("雁行阵"),
	CE("冲轭阵"),
	CS("长蛇阵"),
	YL("鱼鳞阵"),
	FY("方円阵"),
	YY("偃月阵"),
	FS("锋矢阵");
	
	public String name;
	private FormationType(String name) { // 构造方法
		this.name = name;
	}
}
