package homework;

public class TheBigBattle {
	RandomNumber randN = new RandomNumber();
	int[] cucurbitSnackArray = randN.randNumber(7);
	 SomerSaultCloud cloudA = new SomerSaultCloud(Cucurbit.RED);
	 SomerSaultCloud cloudB = new SomerSaultCloud(Cucurbit.ORANGE);
	 SomerSaultCloud cloudC = new SomerSaultCloud(Cucurbit.YELLOW);
	 SomerSaultCloud cloudD = new SomerSaultCloud(Cucurbit.GREEN);
	 SomerSaultCloud cloudE = new SomerSaultCloud(Cucurbit.BLUE);
	 SomerSaultCloud cloudF = new SomerSaultCloud(Cucurbit.INDIGO);
	 SomerSaultCloud cloudG = new SomerSaultCloud(Cucurbit.PURPLE);
	
	public static void main(String[] args) {
		RandomNumber randN = new RandomNumber();
		Map startMap = new Map();
		Scorpoin scorpoin = new Scorpoin();
		startMap.printMap(randN.randNumber(7), scorpoin.commendFour());
		startMap.printMap(randN.randNumber(7), scorpoin.commendFive());
		startMap.printMap(randN.randNumber(7), scorpoin.commendOne(7));
		startMap.printMap(randN.randNumber(7), scorpoin.commendSeven(7));
		startMap.printMap(randN.randNumber(7), scorpoin.commendSix());
		startMap.printMap(randN.randNumber(7), scorpoin.commendTow(7));
		startMap.printMap(randN.randNumber(7), scorpoin.commendThree(7));
	}
}
