package space;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import application.Main;
import creature.*;
import formation.Conjurable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CalabashWorld {
	
	private static final int BATTLEFIELD_ROW = 11;
	private static final int BATTLEFIELD_COLUMN = 15;
	private static final int MINIONS_NUM = 7;
	
	private static final int CANVAS_WIDTH = 1100;
	private static final int CANVAS_HEIGHT = 600;
	
	private BattleField battleField;
	
	private ArrayList<CalabashBrother> brothers = new ArrayList<>();
	private Grandpa grandpa;
	private Scorpion scorpion;
	private Snake snake;
	private ArrayList<Minion> minions = new ArrayList<>(Collections.nCopies(MINIONS_NUM,new Minion()));
	
	Stage primaryStage;
	Canvas canvas;
	
	public CalabashWorld(Stage primaryStage) {
		// TODO Auto-generated constructor stub
		
		battleField = new BattleField(BATTLEFIELD_ROW, BATTLEFIELD_COLUMN);
		initBrothers();
		grandpa = new Grandpa();
		scorpion = new Scorpion();
		snake = new Snake();
		
		StackPane root=new StackPane();
	    root.setAlignment(Pos.CENTER);
	    root.setPadding(new Insets(25, 25, 25, 25));
	    
	    canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        
        root.getChildren().add(canvas);
        Scene scene = new Scene(root,1100,600);
		scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void initBrothers() {
		CalabashBrother theOldest = new CalabashBrother(1, "老大", COLOR.RED);
		CalabashBrother theSecond = new CalabashBrother(2, "老二", COLOR.ORANGE);
		CalabashBrother theThird = new CalabashBrother(3, "老三", COLOR.YELLOW);
		CalabashBrother theForth = new CalabashBrother(4, "老四", COLOR.GREEN);
		CalabashBrother theFifth = new CalabashBrother(5, "老五", COLOR.CYAN);
		CalabashBrother theSixth = new CalabashBrother(6, "老六", COLOR.BLUE);
		CalabashBrother theYoungest = new CalabashBrother(7, "老七", COLOR.PURPLE);		
		
		brothers.add(theOldest);
		brothers.add(theSecond);
		brothers.add(theThird);
		brothers.add(theForth);
		brothers.add(theFifth);
		brothers.add(theSixth);
		brothers.add(theYoungest);
	}
	
	public void brothersShuffle() {
		// 葫芦娃乱序
		Collections.shuffle(brothers);
        System.out.println("葫芦娃乱序：");
        for(CalabashBrother k : brothers) {
        	System.out.print(k.getName() + " ");
        }
        System.out.println();
	}
	
	public void brothersSort() {
		Collections.sort(brothers);
		System.out.println("葫芦娃排序：");
        for(CalabashBrother k : brothers) {
        	System.out.print(k.getName() + " ");
        }
        System.out.println();
	}

	public void displayField() {
		System.out.print(battleField);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		battleField.guiDisplay(gc);
	}
	
	public void setBrothers(Conjurable formation, int startRow, int startColumn) {
		formation.conjure(battleField, brothers, startRow, startColumn);
	}
	
	public void setMonsters(Conjurable formation, int startRow, int startColumn) {
		ArrayList<Bad> bads = new ArrayList<>();
		for (int i = 0; i < MINIONS_NUM; i++) {
			bads.add(minions.get(i));
		}
		bads.add(scorpion);
		
		formation.conjure(battleField, bads, startRow, startColumn);
	}
	
	public void setCheerleaders() {
		Random random = new Random();
		while(true) {
			int randRow = random.nextInt(BATTLEFIELD_ROW);
	        int randColumn = random.nextInt(BATTLEFIELD_COLUMN / 2);
	        if (battleField.setCreatrue(grandpa, randRow, randColumn)) {
	        	break;
	        }
		}
		while(true) {
			int randRow = random.nextInt(BATTLEFIELD_ROW);
	        int randColumn = random.nextInt((BATTLEFIELD_COLUMN+1)/2) + BATTLEFIELD_COLUMN/2;
	        if (battleField.setCreatrue(snake, randRow, randColumn)) {
	        	break;
	        }
		}
	}

	public void clearBattleField() {
		battleField.clear();
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
	}
	
}
