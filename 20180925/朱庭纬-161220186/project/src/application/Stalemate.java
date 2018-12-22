package application;

import creature.Bad;
import creature.CalabashBrother;
import formation.Changshe;
import formation.Henge;
import formation.Heyi;
import formation.Yanxing;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import space.CalabashWorld;

public class Stalemate {

	public static void begin(Stage primaryStage) {
		// TODO Auto-generated method stub
		
		//初始化
		CalabashWorld world = new CalabashWorld(primaryStage);
		//葫芦娃乱序
		world.brothersShuffle();
	
		//葫芦娃排序，长蛇阵，投放
		world.brothersSort();
		world.setBrothers(new Changshe<CalabashBrother>(), 2, 1);
		
		//蝎子精、小喽啰选择阵型，投放
		world.setMonsters(new Heyi<Bad>(), 1, 10);
		
		//老爷爷、蛇精投放，加油
		world.setCheerleaders();
		//输出
		world.displayField();
		
		Timeline ThreeSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(3), new EventHandler<ActionEvent>() {
			private int i = 1;
		    @Override
		    public void handle(ActionEvent event) {
		        switch (i) {
				case 1:
					world.clearBattleField();					
					world.setBrothers(new Changshe<CalabashBrother>(), 2, 3);
					world.setMonsters(new Henge<Bad>(), 1, 13);
					world.setCheerleaders();
					world.displayField();
					break;
				case 2:
					world.clearBattleField(); 			
					world.setBrothers(new Changshe<CalabashBrother>(), 2, 2);
					world.setMonsters(new Yanxing<Bad>(), 1, 6);
					world.setCheerleaders();
					world.displayField();
					break;
				default:
					break;
				}
		        i++;
		    }
		}));		
		ThreeSecondsWonder.setCycleCount(2);
		ThreeSecondsWonder.play();
		
	}

}