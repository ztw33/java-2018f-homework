package world.gui;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javafx.fxml.FXML;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;

import world.*;
import world.util.*;
import world.xml.XMLRecordReader;

public class GUIWindow {

	/**	CoreWorld指针	*/
	public CoreWorld cWrd = null;
	
	@FXML
	private Label background; // 背景图片标签
	
	@FXML
	public GridPane entityLayer; // 人物层指针
	
	@FXML
	public GridPane animLayer; // 动画层指针
	
	@FXML
	private Label modeLabel; // 模式：[战斗]或[回放]；状态：[准备]或[进行中]或[结束]

	@FXML
	private Label groupLabel; // 行动方：[葫芦娃]或[妖怪]
	
	@FXML
	private Label roundLabel; // 显示回合数
	
	@FXML
	private Label observer; // 用于打印战斗结果
	
	@FXML
	private TextField receiver; // 用于设置键盘监听
	
	/**	网格Label二维数组	*/
	private Label cells[][] = new Label[Global.rowNum][Global.colNum];

	/**	动画Label集	*/
	public static Map<Integer, Label> animItems = new HashMap<>();

	/**	初始化CoreWorld	*/
    public void setWin(CoreWorld cw) {
    	cWrd = cw;
    }

	/**	初始化模式状态/回合数标签	*/
    public void initLabels(boolean onlyText) {
    	if (Global.battlePlayingBack)
    		modeLabel.setText("回放准备");
    	else modeLabel.setText("战斗准备");
		roundLabel.setText("回合数：0");
		groupLabel.setText("行动方：---");
		observer.setVisible(false);
    	if (onlyText) return;
		modeLabel.setPrefWidth(Global.labelWidth(6));
		modeLabel.setPrefHeight(Global.labelHeight);
		modeLabel.setTranslateX(Global.marginLabelX(6));
		modeLabel.setTranslateY(Global.marginLabelY);
		modeLabel.setBackground(new Background(new BackgroundFill(new Color(1, 1, 1, 0.5), null, null)));
		roundLabel.setPrefWidth(Global.labelWidth(6));
		roundLabel.setPrefHeight(Global.labelHeight);
		roundLabel.setTranslateX(-Global.marginLabelX(6) - Global.labelWidth(8));
		roundLabel.setTranslateY(Global.marginLabelY);
		roundLabel.setBackground(new Background(new BackgroundFill(new Color(1, 1, 1, 0.5), null, null)));
		groupLabel.setPrefWidth(Global.labelWidth(8));
		groupLabel.setPrefHeight(Global.labelHeight);
		groupLabel.setTranslateX(-Global.marginLabelX(8));
		groupLabel.setTranslateY(Global.marginLabelY);
		groupLabel.setBackground(new Background(new BackgroundFill(new Color(1, 1, 1, 0.5), null, null)));
		observer.setPrefHeight(2 * Global.labelHeight);
		observer.setBackground(new Background(new BackgroundFill(new Color(1, 1, 1, 0.5), null, null)));
	}

    /**	初始化固定标签二维数组cells	*/
    private void initCells() {
		for (int i = 0; i < Global.rowNum; i++) {
			for (int j = 0; j < Global.colNum; j++) {
				// 初始化所有格子
				cells[i][j] = new Label();
				setEntityImage(cells[i][j], null); // 添加透明图片
				cells[i][j].setScaleX(Global.span / Global.entityWidth); // 标签整体缩放
				cells[i][j].setScaleY(Global.span / Global.entityHeight);
				entityLayer.add(cells[i][j], j, i); // 放置到世界地图上
			}
		}
    }

	/**	根据entities重新写入初始化的animItems	*/
	public void initAnimItems() {
		// 先移除以前的全部Label
		Iterator<Integer> it = animItems.keySet().iterator();
        while (it.hasNext()) {
            animLayer.getChildren().remove(animItems.get(it.next()));
            it.remove();
        }
		// 根据entities重新写入
		for (Entry<Integer, Entity> item : CoreWorld.entities.entrySet()) {
			Label tmpLab = new Label();
			setEntityImage(tmpLab, item.getValue().creature.getType()); // 添加图片
			tmpLab.setScaleX(Global.span / Global.entityWidth); // 标签整体缩放
			tmpLab.setScaleY(Global.span / Global.entityHeight);
			tmpLab.setTranslateX(Global.marginX + item.getValue().position.col() * Global.span); // 标签位移
			tmpLab.setTranslateY(Global.marginY + item.getValue().position.row() * Global.span);
			animLayer.getChildren().add(tmpLab); // 放置到动画层
			animItems.put(item.getKey(), tmpLab);
		}
	}
	
	/**	初始化GUIWindow.
     *	在加载WorldWindow.fxml完成后自动调用	*/
    @FXML
    private void initialize() {
    	// 初始化背景
    	Image backImg = new Image("file:img/BackGround.png");
    	background.setGraphic(new ImageView(backImg));
    	// GridPane偏移
    	entityLayer.setTranslateX(Global.marginX);
    	// 初始化说明标签
    	initLabels(false);
    	// 初始化cells（无动画）或animItems（负责动画）
		initAnimItems();
		initCells();
		paintWindow(); // 绘制窗口（无动画）
		// 初始化默认有动画
		entityLayer.setVisible(false);
		animLayer.setVisible(true);
		// 设置键盘事件
		receiver.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.SPACE && cWrd != null) {
                	pressKeySpace();
                }
                if (event.getCode() == KeyCode.L && cWrd != null) {
                	pressKeyL();
                }
                if (event.getCode() == KeyCode.S && cWrd != null) {
                	pressKeyS();
                }
                if (event.getCode() == KeyCode.R && cWrd != null) {
                	pressKeyR();
                }
                if (event.getCode() == KeyCode.P && cWrd != null) {
                	pressKeyP();
                }
            }
        });
    }

    /**	每单击键盘R调用	*/
    public void pressKeyR() {
		clearWindow(); // 清除所有生物
		System.out.println("重置");
		cWrd.initAll();
		initLabels(true);
		initAnimItems();
		cWrd.showWorld();
		paintWindow(); // 绘制所有生物
    }

    /**	每单击键盘P调用	*/
    private void pressKeyP() {
    	if (Global.isAfterBattleNotPlayback()) // 战斗结束时（非回放模式）
    		loadRecord(true);
    	else {
    		String head = "本局回放失败";
    		String content = "请在[战斗]模式下，本局[结束]后键入“P”以回放本局";
    		Global.showAlertDialog(head, content);
    	}
    }

    /**	每单击键盘L调用	*/
    private void pressKeyL() {
    	if (Global.isBeforeOrAfterOrPlayback()) // 回放中或战斗开始前或战斗结束时
    		loadRecord(false);
    	else {
    		String head = "读取记录失败";
    		String content = "请在：(1)[回放]模式下，或 (2)[战斗]模式下的[准备]时和[结束]后，键入“L”以读取记录";
    		Global.showAlertDialog(head, content);
    	}
    }

    /**	加载数据	*/
    public void loadRecord(boolean isDefault) {
    	if (isDefault)
    		Global.recordReader = new XMLRecordReader(Global.defaultFilename); // 读取默认文件
    	else {
        	File xmlFile = Main.showOpenXMLChooser();
        	if (xmlFile == null) {
        		System.out.println("取消读取对战记录");
        		return;
        	}
    		Global.recordReader = new XMLRecordReader(xmlFile.getPath()); // 读取文件
    	}
		// 初始化窗口，准备回放
		clearWindow(); // 清除所有生物
		cWrd.initGlobal(true); // 初始化全局变量
		initLabels(true);
		initAnimItems(); // 初始化动画
		cWrd.showWorld();
		paintWindow(); // 绘制所有生物
    }
    
    /**	每单击键盘S调用	*/
    public void pressKeyS() {
    	if (Global.isAfterBattleNotPlayback()) { // 战斗结束时（非回放模式）
        	File xmlFile = Main.showSaveXMLChooser();
        	if (xmlFile == null) {
        		System.out.println("取消保存对战记录");
        		return;
        	}
    		Global.recordWriter.saveRecord(xmlFile.getPath()); // 保存xml战斗记录
    	}
    	else {
    		String head = "保存记录失败";
    		String content = "请在[战斗]模式下，本局[结束]后键入“S”以保存记录";
    		Global.showAlertDialog(head, content);
    	}
    }
    
    /**	设置回合数等描述并输出到控制台以及显示到标签	*/
    private void showRoundDescription() {
		if (Global.battlePlayingBack) {
			System.out.print("[回放中] ");
			modeLabel.setText("回放中...");
		}
		else {
			System.out.print("[战斗中] ");
			modeLabel.setText("战斗中...");
		}
		System.out.print("第" + (Global.roundNum + 1) / 2 + "回合：[");
		roundLabel.setText("回合数：" + (Global.roundNum + 1) / 2);
		if (Global.roundNum % 2 == 1) {
			System.out.print("葫芦娃");
	    	groupLabel.setText("行动方：葫芦娃");
		}
		else {
			System.out.print("妖怪");
	    	groupLabel.setText("行动方：妖怪");
		}
		System.out.println("]行动回合");
    }
    
    /**	每单击键盘空格调用	*/
	private void pressKeySpace() {
		Global.battleStart = true;
		if (!Global.battleEnd) { // 战斗未结束
	    	// 回合数加1（从“第1回合”开始）
			Global.roundNum += 1; 
			showRoundDescription(); // 显示描述信息
			clearWindow();
			// 行动
	        start(); 
	        try { // 等待所有线程执行完再打印
	            Thread.sleep(100);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
			cWrd.showWorld();
			paintWindow();
			Global.keepFormationRound -= 1;
			// 临时存储
			if (!Global.battlePlayingBack) // 回放模式不存储
				Global.recordWriter.addRoundElements(Global.roundNum); 
			Global.battleEnd = Global.isEnded();
			// 如果战斗/回放[结束]
			if (Global.battleEnd) {
				observer.setText("  胜利方：" + Global.battleWin.label + "  ");
				observer.setVisible(true);
				if (Global.battlePlayingBack) { // 回放模式不存储
					System.out.println("回放结束，键入“R”重置");
					modeLabel.setText("回放结束");
				}
				else { // 导出到默认文件
					System.out.println("战斗结束，键入“R”重置，键入“P”回放本局");
					modeLabel.setText("战斗结束");
					Global.recordWriter.saveRecord(Global.defaultFilename);
				}
			}
		}
	}

	/**	开启所有实体的线程并播放动画	*/
	public void start() {
		for (Entity en: CoreWorld.entities.values()) {
			// 通过回放或线程改变en的运动属性
			if (Global.battlePlayingBack) // 回放模式
				Global.recordReader.setEntityByRound(en, Global.roundNum);
			else if (Global.isActionRound(en.creature.getGroup()))
				en.start(); // 开始移动
			else en.stand(); // 静止
			
			// 添加时间轴
			Timeline timeline = new Timeline(); // 不循环
	        KeyFrame keyFrame = new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {  
	            @Override  
	            public void handle(ActionEvent event) { 
	            	playAnimation(en); // 动画效果
	            }  
	        });  
	        timeline.getKeyFrames().add(keyFrame); 
	        timeline.play(); // 开始播放
		}
	}
    
	/**	设置动画	*/
	private void playAnimation(Entity en) {
		if (!en.position.equals(new Point(0, 0))) {
			// 移动动画
			TranslateTransition tt = new TranslateTransition(Duration.millis(Global.durTime));
	        tt.setByX(en.direction.col() * Global.span); // x位移
	        tt.setByY(en.direction.row() * Global.span); // y位移
	        ParallelTransition animMov = new ParallelTransition(animItems.get(en.id), tt);
	        // 放到时间轴上
        	animMov.play(); // 移动
		}
        // 消失动画
        FadeTransition ft = new FadeTransition(Duration.millis(Global.durTime));
        ft.setToValue(0);
        ParallelTransition animFade = null;
        // 自己在这一回合死掉了
		if (en.state == EntityState.DEAD) { // 给自己一个消失动画
			animFade = new ParallelTransition(animItems.get(en.id), ft);
			animFade.play();
		}
		// 在这一回合击败了敌人
		if (en.hasWined) { // 给敌人一个消失动画
			animFade = new ParallelTransition(animItems.get(en.enemy.id), ft);
			animFade.play();
		}
	}
	
	/**	根据生物类型获取对应的图像	*/
	private Image getEntityImage(CreatureType ctype) {
    	Image creatureImg = null;
    	if (ctype == null)
    		creatureImg = new Image("file:img/none.png");
			//creatureImg = new Image("file:img/debug.png");
    	else
    		creatureImg = new Image("file:img/" + ctype.imgName + ".png");
    	return creatureImg;
	}
	
	/**	设置一个格子的图像	*/
    private void setEntityImage(Label cellLabel, CreatureType ctype) {
    	cellLabel.setGraphic(new ImageView(getEntityImage(ctype)));
    }

    /**	清空全部网格（无动画）	*/
    public void clearWindow() {
		for (Entity en: CoreWorld.entities.values()) {
			if (en.state == EntityState.LIVE) {
				setEntityImage(cells[en.position.row()][en.position.col()], null);
			}
		}
    }
    
    /**	根据entities绘制全部网格（无动画）	*/
    public void paintWindow() {
		for (Entity en: CoreWorld.entities.values()) {
			if (en.state == EntityState.LIVE) 
				setEntityImage(cells[en.position.row()][en.position.col()], en.creature.getType());
		}
	}
}
