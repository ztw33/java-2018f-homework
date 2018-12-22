package world.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuItem;

import world.*;
import world.util.*;


public class GUIBorder {

	/**	CoreWorld指针	*/
	private CoreWorld cWrd = null;
	/**	GUIWindow指针	*/
	private GUIWindow gWin = null;
	
	@FXML
    private MenuItem menuItReset; // 重置
	@FXML
    private MenuItem menuItSaveAs; // 保存为
	@FXML
    private MenuItem menuItReadFrom; // 读取
	@FXML
	private MenuItem menuBroItHY; // 葫芦娃鹤翼阵
	@FXML
	private MenuItem menuBroItYX; // 葫芦娃雁行阵
	@FXML
	private MenuItem menuBroItCE; // 葫芦娃冲轭阵
	@FXML
	private MenuItem menuBroItCS; // 葫芦娃长蛇阵
	@FXML
	private MenuItem menuBroItYL; // 葫芦娃鱼鳞阵
	@FXML
	private MenuItem menuBroItFY; // 葫芦娃方円阵
	@FXML
	private MenuItem menuBroItYY; // 葫芦娃偃月阵
	@FXML
	private MenuItem menuBroItFS; // 葫芦娃锋矢阵
	@FXML
	private MenuItem menuMonItHY; // 妖怪鹤翼阵
	@FXML
	private MenuItem menuMonItYX; // 妖怪雁行阵
	@FXML
	private MenuItem menuMonItCE; // 妖怪冲轭阵
	@FXML
	private MenuItem menuMonItCS; // 妖怪长蛇阵
	@FXML
	private MenuItem menuMonItYL; // 妖怪鱼鳞阵
	@FXML
	private MenuItem menuMonItFY; // 妖怪方円阵
	@FXML
	private MenuItem menuMonItYY; // 妖怪偃月阵
	@FXML
	private MenuItem menuMonItFS; // 妖怪锋矢阵

	@FXML
	private CheckMenuItem menuCheckAnim; // 是否显示动画
	
	/**	初始化GUIBorder.
     *	在加载WorldBorder.fxml完成后自动调用	*/
    @FXML
    private void initialize() {
    	menuItReset.setOnAction((ActionEvent t) -> {
    		handleReset();
        });
    	menuItSaveAs.setOnAction((ActionEvent t) -> {
    		handleSaveAs();
        });
    	menuItReadFrom.setOnAction((ActionEvent t) -> {
    		handleReadFrom();
        });
    	menuBroItHY.setOnAction((ActionEvent t) -> {
    		handleForm(FormationType.HY, GroupType.Bro);
        });
    	menuBroItYX.setOnAction((ActionEvent t) -> {
    		handleForm(FormationType.YX, GroupType.Bro);
        });
    	menuBroItCE.setOnAction((ActionEvent t) -> {
    		handleForm(FormationType.CE, GroupType.Bro);
        });
    	menuBroItCS.setOnAction((ActionEvent t) -> {
    		handleForm(FormationType.CS, GroupType.Bro);
        });
    	menuBroItYL.setOnAction((ActionEvent t) -> {
    		handleForm(FormationType.YL, GroupType.Bro);
        });
    	menuBroItFY.setOnAction((ActionEvent t) -> {
    		handleForm(FormationType.FY, GroupType.Bro);
        });
    	menuBroItYY.setOnAction((ActionEvent t) -> {
    		handleForm(FormationType.YY, GroupType.Bro);
        });
    	menuBroItFS.setOnAction((ActionEvent t) -> {
    		handleForm(FormationType.FS, GroupType.Bro);
        });
    	menuMonItHY.setOnAction((ActionEvent t) -> {
    		handleForm(FormationType.HY, GroupType.Mon);
        });
    	menuMonItYX.setOnAction((ActionEvent t) -> {
    		handleForm(FormationType.YX, GroupType.Mon);
        });
    	menuMonItCE.setOnAction((ActionEvent t) -> {
    		handleForm(FormationType.CE, GroupType.Mon);
        });
    	menuMonItCS.setOnAction((ActionEvent t) -> {
    		handleForm(FormationType.CS, GroupType.Mon);
        });
    	menuMonItYL.setOnAction((ActionEvent t) -> {
    		handleForm(FormationType.YL, GroupType.Mon);
        });
    	menuMonItFY.setOnAction((ActionEvent t) -> {
    		handleForm(FormationType.FY, GroupType.Mon);
        });
    	menuMonItYY.setOnAction((ActionEvent t) -> {
    		handleForm(FormationType.YY, GroupType.Mon);
        });
    	menuMonItFS.setOnAction((ActionEvent t) -> {
    		handleForm(FormationType.FS, GroupType.Mon);
        });
    	menuCheckAnim.setSelected(true);
    	menuCheckAnim.setOnAction((ActionEvent t) -> {
    		handleSetAnim();
        });
    }
    
    /**	初始化GUIWindow和CoreWorld	*/
    public void setWin(GUIWindow gw) {
    	gWin = gw;
    	cWrd = gw.cWrd;
    }
	
    /**	菜单项 —— 重置	*/
	private void handleReset() {
		if (cWrd != null && gWin != null) 
			gWin.pressKeyR();
		else System.out.println("error@GUIBorder: 未加载CharWindow/GUIWindow");
	}

    /**	菜单项 —— 保存为	*/
	private void handleSaveAs() {
		gWin.pressKeyS();
	}

    /**	菜单项 —— 读取	*/
	private void handleReadFrom() {
		gWin.loadRecord(false);
	}

    /**	菜单项 —— 改变阵型	*/
	private void handleForm(FormationType ftype, GroupType gtype) {
		if (!Global.battlePlayingBack) { // 战斗模式
			if (cWrd != null && gWin != null) {
				gWin.clearWindow(); // 清除所有生物
				System.out.println("改变" + gtype.label + "阵型至" + ftype.name);
				cWrd.initFormation(ftype, gtype);
				gWin.initLabels(true);
				gWin.initAnimItems();
				cWrd.showWorld();
				gWin.paintWindow(); // 绘制所有生物
			}
			else System.out.println("error@GUIBorder: 未加载CharWindow/GUIWindow");
		}
    	else {
    		String head = "改变阵型失败";
    		String content = "请在[战斗]模式下改变阵型";
    		Global.showAlertDialog(head, content);
    	}
	}

    /**	菜单项（可选） —— 显示动画	*/
	private void handleSetAnim() {
		if (menuCheckAnim.isSelected()) {
			gWin.animLayer.setVisible(true);
			gWin.entityLayer.setVisible(false);
		}
		else {
			gWin.animLayer.setVisible(false);
			gWin.entityLayer.setVisible(true);
		}
	}
}
