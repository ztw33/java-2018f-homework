import java.util.Random;

public class GoodPeopleHolder implements Holder {
	private GoodPeople[] goodPeople;
	private final int NUM_OF_GOODPEOPLE = 8;  // 把"爷爷"也算进去了，这是一个固定的值
	private BattleModel battleModel;

	public GoodPeopleHolder() {
		goodPeople = new GoodPeople[NUM_OF_GOODPEOPLE];
		// TODO: 2018/9/25 到底要不要把"爷爷"放进去？？？要的，把爷爷放进去，就固定在[0]上
		goodPeople[0] = GoodPeople.GrandPa;
		// 随机放入葫芦娃们，也可以调用sortByRandom()函数
		goodPeople[1] = GoodPeople.BrotherFive;
		goodPeople[2] = GoodPeople.BrotherFour;
		goodPeople[3] = GoodPeople.BrotherOne;
		goodPeople[4] = GoodPeople.BrotherSeven;
		goodPeople[5] = GoodPeople.BrotherSix;
		goodPeople[6] = GoodPeople.BrotherThree;
		goodPeople[7] = GoodPeople.BrotherTwo;
		// 可以在调用一次随机排序
		sortByRandom();
	}

	public GoodPeople[] getGoodPeople() {
		return goodPeople;
	}

	@Override
	public void changeBattleModel(BattleModel newBattleModel) {
		this.battleModel = newBattleModel;
	}

	@Override
	public BattleModel getBattleModel() {
		return this.battleModel;
	}

	/**
	 * 冒泡排序
	 * <p>
	 * 将七个葫芦娃按大小排序
	 * 将爷爷放在第一个
	 */
	public void sortByRank() {
		for (int i = 0; i < NUM_OF_GOODPEOPLE; i++) {
			for (int j = 0; j < NUM_OF_GOODPEOPLE - i-1; j++) {
				if (goodPeople[j+1].less(goodPeople[j]))
					swap(j, j + 1);
			}
		}
	}

	/**
	 * 将七个葫芦娃随机排序
	 */
//	@Override
	private void sortByRandom() {
		// 除了爷爷外，将七个葫芦娃随机排序
		int randomIndex;
		Random random = new Random();
		for (int i = 1; i < NUM_OF_GOODPEOPLE-1; i++) {
			randomIndex = random.nextInt(NUM_OF_GOODPEOPLE-1) + 1;   //范围为介于[1, NUM_OF_GOODPEOPLE]之间的整数
//			System.out.print(randomIndex);
			swap(i, randomIndex);
		}
	}

//	private void printGoodPeople() {
//		for (GoodPeople goodPeople : goodPeople) {
//			System.out.print(goodPeople.getSymbol()+" ");
//		}
//		System.out.println();
//	}

	//	@Override
	private void swap(int x, int y) {
		GoodPeople temp = goodPeople[x];
		goodPeople[x] = goodPeople[y];
		goodPeople[y] = temp;
	}

//	public static void main(String[] args) {
//		GoodPeopleHolder goodPeopleHolder = new GoodPeopleHolder();
//		goodPeopleHolder.printGoodPeople();
//		for (int i = 0; i < 10; i++) {
//			goodPeopleHolder.sortByRandom();
//			System.out.print("乱序的    ");
//			goodPeopleHolder.printGoodPeople();
//			goodPeopleHolder.sortByRank();
//			System.out.print("排好序    ");
//			goodPeopleHolder.printGoodPeople();
//		}
//
//	}
}
