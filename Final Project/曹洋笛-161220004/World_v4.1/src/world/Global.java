package world;

import world.util.*;
import world.xml.*;

/**	
 *	全局常量变量和全局函数.
 *	包括：定值，特殊位置，胜利概率，随机计算等
 *	
 *	@author Mirror
	*/
public final class Global {

	/**	行数 {@value}	*/
	public static final int rowNum = 17; // 0 ~ 16
	
	/**	列数 {@value}	*/
	public static final int colNum = 18; // 0 ~ 17

	/**	左侧战场中心点	*/
	public static final Point leftCenterP = new Point(7, 4);

	/**	右侧战场中心点	*/
	public static final Point rightCenterP = new Point(7, 13);	

	/**	窗口位置 {@value}	*/
	public static final double winLocationXY = 0;
	
	/**	窗口宽 {@value}	*/
	public static final double winWidth = 906;
	
	/**	窗口高 {@value}	*/
	public static final double winHeight = 917;

	/**	背景图片宽 {@value}	*/
	public static final double groundWidth = 900;
	
	/**	背景图片高  {@value}	*/
	public static final double groundHeight = 850;	

	/**	实体图片长 {@value}	*/
	public static final double entityWidth = 100;
	
	/**	实体图片宽 {@value}	*/
	public static final double entityHeight = 100;
	
	/**	GridPane的偏移x（原因不明） {@value}	*/
	public static final double marginX = -25;
	
	/**	GridPane的偏移y（原因不明） {@value}	*/
	public static final double marginY = -400;
	
	/**	网格宽度 {@value}	*/
	public static final double span = 50;
	
	/**	双方保持原阵型的半回合数	*/
	public static final int keepFormationRoundNum = 2;
	
	/**	双方保持原阵型的半回合数	*/
	public static int keepFormationRound = keepFormationRoundNum;

	/**	相遇时葫芦娃的胜率	*/
	public static final int BroWinPercent = 50;
	
	/**	相遇时妖怪的胜率	*/
	public static final int MonWinPercent = 100 - BroWinPercent;
	
	/**	动画持续时间(ms)	*/
	public static final int durTime = 500;

	/**	战斗回合数	*/
	public static int roundNum = 0;

	/**	战斗是否开始	*/
	public static boolean battleStart = false;
	
	/**	战斗是否结束	*/
	public static boolean battleEnd = false;
	
	/**	判断战斗是否结束	*/
	public static boolean isEnded() {
		boolean hasBro = false;
		boolean hasMon = false;
		for (Entity en: CoreWorld.entities.values()) {
			if ((en.state == EntityState.LIVE) && (en.creature.getGroup() == GroupType.Bro))
				hasBro = true;
			if ((en.state == EntityState.LIVE) && (en.creature.getGroup() == GroupType.Mon))
				hasMon = true;
		}
		return !(hasBro && hasMon);
	}
	
	/**	保存战斗	*/
	public static XMLRecordWriter recordWriter = null;
	
	/**	读取战斗	*/
	public static XMLRecordReader recordReader = null;
	
	/**	默认保存文件	*/
	public static final String defaultFilename = "records/defaultRecordFile.xml";
	
}
