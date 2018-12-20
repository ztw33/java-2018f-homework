package world;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

	/**	网格宽度 {@value}	*/
	public static final double span = 50;

	/**	背景图片宽 {@value}	*/
	public static final double groundWidth = colNum * span; // 900
	
	/**	背景图片高  {@value}	*/
	public static final double groundHeight = rowNum * span; // 850

	/**	窗口位置 {@value}	*/
	public static final double winLocationXY = 0;
	
	/**	窗口宽 {@value}	*/
	public static final double winWidth = 906;
	
	/**	窗口高 {@value}	*/
	public static final double winHeight = 917;

	/**	实体图片宽 {@value}	*/
	public static final double entityWidth = 100;
	
	/**	实体图片高 {@value}	*/
	public static final double entityHeight = 100;
	
	/**	说明标签中每个字的宽 {@value}	*/
	public static final double labelFontWidth = 24;

	/**	说明标签宽 {@value}	*/
	public static final double labelWidth(int n) { return (labelFontWidth * n); }
	
	/**	说明标签高 {@value}	*/
	public static final double labelHeight = 48;
	
	/**	GridPane的偏移x {@value}	*/
	public static final double marginX = -span / 2; // -25
	
	/**	GridPane的偏移y {@value}	*/
	public static final double marginY = (span - groundHeight) / 2; // -400

	/**	Label的偏移x {@value}	*/
	public static final double marginLabelX(int n) { return (labelWidth(n) - groundWidth) / 2; }
	
	/**	Label的偏移y {@value}	*/
	public static final double marginLabelY = (labelHeight - groundHeight) / 2;
	
	/**	左侧战场中心点	*/
	public static final Point leftCenterP = new Point(7, 4);

	/**	右侧战场中心点	*/
	public static final Point rightCenterP = new Point(7, 13);	

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

	/**	判断是否是本阵营的行动回合	*/
	public static boolean isActionRound(GroupType type) {
		if (roundNum % 2 == 1)
			return (type == GroupType.Bro);
		else return (type == GroupType.Mon);
	}
	
	/**	战斗是否开始	*/
	public static boolean battleStart = false;
	
	/**	战斗是否结束	*/
	public static boolean battleEnd = false;

	/**	战斗胜利方	*/
	public static GroupType battleWin;
	
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
		if (hasBro && hasMon)
			return false;
		else {
			if (hasBro) battleWin = GroupType.Bro;
			else battleWin = GroupType.Mon;
			return true;
		}
	}
	
	/**	是否正在回放战斗过程	*/
	public static boolean battlePlayingBack = false;
	
	/**	保存战斗	*/
	public static XMLRecordWriter recordWriter = null;
	
	/**	读取战斗	*/
	public static XMLRecordReader recordReader = null;
	
	/**	默认保存文件	*/
	public static final String defaultFilename = "records/defaultRecordFile.xml";

	/**	默认保存路径	*/
	public static final String defaultPath = "records/";
	
	/**	战斗结束后（非回放模式）	*/
	public static boolean isAfterBattleNotPlayback() {
		return (!battlePlayingBack && battleStart && battleEnd);
	}
	
	/**	战斗开始前或战斗结束后或回放时	*/
	public static boolean isBeforeOrAfterOrPlayback() {
		if (battlePlayingBack)
			return true;
		if ((!battleStart && !battleEnd) || (battleStart && battleEnd))
			return true;
		return false;
	}

    /**	弹出提示框
     *	@param head 提示框标题内容
     *	@param content 详细说明	*/
	public static void showAlertDialog(String head, String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("提示");
		alert.initOwner(Main.worldStage);
		alert.setHeaderText(head);
		alert.setContentText(content);
		alert.showAndWait();
	}
    
}
