package world.util;

import world.formations.ChangShe;
import world.formations.ChongE;
import world.formations.FangYuan;
import world.formations.FengShi;
import world.formations.Formation;
import world.formations.HeYi;
import world.formations.YanXing;
import world.formations.YanYue;
import world.formations.YuLin;

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
	
	/**	@param type 阵营
	 *	@return 对应的阵型对象 */
	public Formation getFormation(GroupType type) {
		switch (this) {
		case HY: return new HeYi(type); 
		case YX: return new YanXing(type); 
		case CE: return new ChongE(type);
		case CS: return new ChangShe(type);
		case YL: return new YuLin(type);
		case FY: return new FangYuan(type);
		case YY: return new YanYue(type);
		case FS: return new FengShi(type);
		default: return new ChangShe(type); 
		}
	}
}
