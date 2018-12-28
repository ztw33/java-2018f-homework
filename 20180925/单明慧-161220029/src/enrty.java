import battlefield.*;
import form.*;

public class enrty {
	public static void main(String[] args) {
		BattleField oneBattleField = new BattleField();//建立战场
		oneBattleField.show();
		Form formTeam = new Form();
		oneBattleField.appendInfo("葫芦兄弟开始排阵……\n");
		formTeam.formForGood();//葫芦兄弟布阵
		oneBattleField.appendInfo("葫芦兄弟开始上战场……\n");
		for(int i = 0; i < 7; i++) {
			oneBattleField.standOn(formTeam.calabashBro.sevenBro[i]);
		}//葫芦兄弟上战场
		oneBattleField.appendInfo("老爷爷呐喊助威……\n");
		oneBattleField.standOn(formTeam.oneGrandpa);//老爷爷呐喊助威
		for(int i = 0; i < 6; i++) {
			oneBattleField.cleanRight();
			oneBattleField.appendInfo("这是反派第" + (i + 1) + "次排阵……\n");
			int underlyingsNeed = formTeam.formForBad(oneBattleField.tellText());
			oneBattleField.appendInfo("反派开始上战场……\n");
			oneBattleField.standOn(formTeam.oneScorpion);
			for(int j = 0; j < underlyingsNeed; j++) {
				oneBattleField.standOn(formTeam.severalUnderlying.get(j));
			}
			oneBattleField.appendInfo("蛇精呐喊助威……\n");
			oneBattleField.standOn(formTeam.oneSnake);
			oneBattleField.show();
		}
		return;
	}
}
