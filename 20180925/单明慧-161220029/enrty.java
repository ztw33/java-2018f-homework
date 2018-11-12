import battlefield.*;
import form.*;

public class enrty {
	public static void main(String[] args) {
		BattleField oneBattleField = new BattleField();//建立战场
		Form formTeam = new Form();
		System.out.println("葫芦兄弟开始排阵……");
		formTeam.formForGood();//葫芦兄弟布阵
		System.out.println("葫芦兄弟开始上战场……");
		for(int i = 0; i < 7; i++) {
			oneBattleField.standOn(formTeam.calabashBro.sevenBro[i]);
		}//葫芦兄弟上战场
		System.out.println("老爷爷呐喊助威……");
		oneBattleField.standOn(formTeam.oneGrandpa);//老爷爷呐喊助威
		oneBattleField.show();//只有正派
		for(int i = 0; i < 6; i++) {
			oneBattleField.cleanRight();
			System.out.println("这是反派第" + (i + 1) + "次排阵……");
			int underlyingsNeed = formTeam.formForBad();
			System.out.println("反派开始上战场……");
			oneBattleField.standOn(formTeam.oneScorpion);
			for(int j = 0; j < underlyingsNeed; j++) {
				oneBattleField.standOn(formTeam.severalUnderlying.get(j));
			}
			System.out.println("蛇精呐喊助威……");
			oneBattleField.standOn(formTeam.oneSnake);
			oneBattleField.show();
		}
		return;
	}
}
