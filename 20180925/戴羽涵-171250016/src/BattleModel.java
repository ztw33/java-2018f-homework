import java.util.Random;

public enum BattleModel {
	CRANE_WING,  // 鹤翼
	WILD_GOOSE,  // 雁行
	WOOD,  // 行轭
	LONG_SNAKE,  // 长蛇，只有葫芦娃使用这个队形
	FISH_SCALE,  // 鱼鳞
	CIRCLE,  // 方圆
	MOON,  // 偃月
	ARROW;  // 锋矢

	public static BattleModel getRandomBattleModel() {
		Random random = new Random();
		int randomNum=random.nextInt(8);
		BattleModel[] battleModels = BattleModel.values();
		while (randomNum == 4) {
			randomNum = random.nextInt(8);
		}
		return battleModels[randomNum];
	}
}
