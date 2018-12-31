import java.util.Scanner;

public class Game {
	private Map map;

	public Game(int sizeOfMap, int numOfFollowing) {
		this.map = new Map(sizeOfMap, numOfFollowing);
	}

	public void playGame() {
		this.map.initCreature();  // 葫芦娃按顺序排成长蛇，demons随机选择一个队形
		// 然后更改demons的队形（每种队形都尝试一遍）
		this.map.changeDemonsBattleModel(BattleModel.CRANE_WING);
		this.map.printMap();
		this.map.changeDemonsBattleModel(BattleModel.WILD_GOOSE);
		this.map.printMap();
		this.map.changeDemonsBattleModel(BattleModel.WOOD);
		this.map.printMap();
		this.map.changeDemonsBattleModel(BattleModel.FISH_SCALE);
		this.map.printMap();
		this.map.changeDemonsBattleModel(BattleModel.CIRCLE);
		this.map.printMap();
		this.map.changeDemonsBattleModel(BattleModel.MOON);
		this.map.printMap();
		this.map.changeDemonsBattleModel(BattleModel.ARROW);
		this.map.printMap();
	}

	public static void main(String[] args) {
		int sizeOfMap, numOfFollowing;

		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("请输入地图的大小（>10）：");
			sizeOfMap = scanner.nextInt();
			System.out.print("请输入小喽啰的数量（至少比地图大小小2）：");
			numOfFollowing = scanner.nextInt();
			if (sizeOfMap > numOfFollowing+1&&sizeOfMap>10) {
				break;
			}
			System.out.println("请输入有效的参数值\n");
		}

		Game game = new Game(sizeOfMap, numOfFollowing);
		game.playGame();
	}
}
