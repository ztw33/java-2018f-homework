package world.gui;

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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import world.*;
import world.util.*;

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
	private Label observer; // 用于打印战斗结果
	
	@FXML
	private TextField receiver; // 用于设置键盘监听
	
	/**	网格Label二维数组	*/
	private Label cells[][] = new Label[Global.rowNum][Global.colNum];

	/**	动画Label集	*/
	public static Map<Integer, Label> animItems = new HashMap<>();

	/**	初始化GUIWindow.
     *	在加载WorldWindow.fxml完成后自动调用	*/
    @FXML
    private void initialize() {
    	// 初始化背景
    	Image backImg = new Image("file:img/BackGround.png");
    	background.setGraphic(new ImageView(backImg));
    	// GridPane偏移（原因不明）
    	entityLayer.setTranslateX(Global.marginX);
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
            }
        });
    }

    /**	每单击键盘空格调用	*/
	private void pressKeySpace() {
		Global.battleStart = true;
		if (!Global.battleEnd) { // 战斗未结束
			clearWindow(); // 无动画
			// 回合数加1（从“第1回合”开始）
			Global.roundNum += 1; 
			System.out.print("第" + (Global.roundNum + 1) / 2 + "回合：[");
			if (Global.roundNum % 2 == 1) System.out.print("葫芦娃");
			else System.out.print("妖怪");
			System.out.println("]行动回合");
	        start(Global.roundNum);
			// 临时存储
			Global.recordWriter.addRoundElements(Global.roundNum);
			// 等待所有线程执行完再打印
	        try { 
	            Thread.sleep(100);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
			Global.keepFormationRound -= 1;
			cWrd.showWorld();
			paintWindow(); // 无动画
			// 最后判断一下战斗是否结束
			Global.battleEnd = Global.isEnded();
			// 如果结束了就输出到默认文件
			if (Global.battleEnd)
				Global.recordWriter.saveRecord(Global.defaultFilename);
		}
	}

	/**	开启所有实体的线程并播放动画	*/
	public void start(int n) {
		for (Entity en: CoreWorld.entities.values()) {
			// 奇数回合葫芦娃动，偶数回合妖怪动
			if (((n % 2 == 1) && (en.creature.getGroup() == GroupType.Bro))
					|| ((n % 2 == 0) && (en.creature.getGroup() == GroupType.Mon))) {
				if (en.state != EntityState.LIVE)
					continue;
				// 开始移动
            	en.start(); // 可能会死
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
		if (en.state == EntityState.DEAD) { 
			animFade = new ParallelTransition(animItems.get(en.id), ft);
			animFade.play();
		}
		// 在这一回合击败了敌人
		if (en.hasWined) {
			animFade = new ParallelTransition(animItems.get(en.target.id), ft);
			animFade.play();
		}
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
			animLayer.getChildren().add(tmpLab);
			animItems.put(item.getKey(), tmpLab);
		}
	}
	
	/**	初始化CoreWorld	*/
    public void setWin(CoreWorld cw) {
    	cWrd = cw;
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
