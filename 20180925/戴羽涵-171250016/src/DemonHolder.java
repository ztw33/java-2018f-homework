import java.util.ArrayList;
import java.util.List;

public class DemonHolder implements Holder {
	// TODO: 2018/9/25 初始化、设置Map到底放在那个类中？？？
//	private Demon[] demons;
	private List<Creature> demons = new ArrayList<>();
	private BattleModel battleModel;

	/**
	 * 创造出"妖精们"
	 *
	 * @param numOfFollowing 要创建的下喽啰们的数量，初始化设置为6个小喽啰
	 */
	public DemonHolder(int numOfFollowing) {
		// 数组中依次存放：蛇精、蝎子精小喽啰们
//		demons = new Demon[numOfFollowing+2];
//		demons[0] = Demon.SNAKE;
//		demons[1] = Demon.SCORPION;
		demons.add(Demon.SNAKE);
		demons.add(Demon.SCORPION);
		for (int i = 0; i < numOfFollowing; i++) {
			demons.add(Demon.FOLLOWING);
		}
	}

//	@Override
//	public void swap(Creature a, Creature b) {
//		Creature temp=
//	}

	public List<Creature> getDemons() {
		return demons;
	}

	@Override
	public void changeBattleModel(BattleModel newBattleModel) {
		this.battleModel = newBattleModel;

	}

	@Override
	public BattleModel getBattleModel() {
		return this.battleModel;
	}

//	// TODO: 2018/9/25 妖怪是否需要随机排序呢？？？
//	@Override
//	public void sortByRandom() {
//		int randomIndex;
//		Random random = new Random();
//		for (int i = 0; i < demons.length; i++) {
//			randomIndex = random.nextInt(demons.length);  // 范围为介于[0, demons.length)之间的整数
//			swap(i,randomIndex);
//		}
//	}
//
//	@Override
//	public void swap(int x, int y) {
//		Demon temp = demons[x];
//		demons[x] = demons[y];
//		demons[y]=temp;
//	}
}
