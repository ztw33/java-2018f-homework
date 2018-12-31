import java.util.List;

/**
 * Map大小初始化设定为11
 */
public class Map {
	// TODO: 2018/10/7 蛇精怎么放？随机码？
	private Creature[][] creaturesMap;  // 使用一个二维数组来表示二维空间，储存各个生物体的名字，使用接口类型来定义数组
//	private GoodPeople[] goodPeople;
//	private Demon[] demons;
	private List<Creature> goodPeople;
	private List<Creature> demons;
	private GoodPeopleHolder goodPeopleHolder;
	private DemonHolder demonHolder;
	private int rowNum;
	private int columnNum;

	public Map(int N,int numOfFollowing) {
		this.creaturesMap = new Creature[N][N];  // N>10
		goodPeopleHolder=new GoodPeopleHolder();
		demonHolder = new DemonHolder(numOfFollowing);
		goodPeople=goodPeopleHolder.getGoodPeople();
		demons=demonHolder.getDemons();
		this.rowNum=this.creaturesMap.length;
		this.columnNum=this.creaturesMap[0].length;

		initMap();
	}

	/**
	 * 初始化Creature，将goodPeople、demons放在map上
	 * goodPeople先随机选择一个队形
	 * demons按顺序排成长蛇队形
	 */
	public void initCreature() {
		initGoodPeople();
		initDemons();
	}

	/**
	 * 更改demons的队形
	 * @param battleModel 新的battleModel
	 */
	public void changeDemonsBattleModel(BattleModel battleModel) {
		demonHolder.changeBattleModel(battleModel);  // 修改demonHolder的成员变量
		refreshMap();  // 每次更改demons的battleModel，就重新更新一次map
	}

	public void printMap() {
		for (int i = 0; i < creaturesMap.length; i++) {
			for (int j = 0; j < creaturesMap[0].length; j++) {
				System.out.print(creaturesMap[i][j].getSymbol()+" ");
			}
			System.out.println();
		}
		// 输出分割线
		for (int i = 0; i < this.columnNum; i++) {
			System.out.print("---");
		}
		System.out.println();
	}

//	public boolean isEmpty(int x, int y) {
//		return creaturesMap[x][y]==NoPerson.NO_PERSON;
//	}
//
//	public void setCreature(int x, int y,Creature creature) {
//		creaturesMap[x][y]=creature;
//	}

	/**
	 * *     *
	 *  *   *
	 *   * *
	 *    *（奇偶性）
	 *    *（蝎子精）
	 * @param creatures
	 */
	private void changeToCRANE_WING(List<Creature> creatures) {
		if (creatures.get(0) instanceof Demon) {
			int numOfFollowing=creatures.size()-2;
			int rowOfFollowing =(int) Math.ceil(numOfFollowing / 2.0);
			int startRowNum=(this.rowNum-(rowOfFollowing+1))/2;
			int startColumnNum=this.columnNum-rowOfFollowing*2+numOfFollowing%2;
			int endRowRowNum=startRowNum+rowOfFollowing-1;
			int endColumnNum=startColumnNum+rowOfFollowing-1;
			int index=2;
			// 放入小喽啰们
			int j=startColumnNum;
			for (int i = startRowNum; i <= endRowRowNum; i++) {
				creaturesMap[i][j++] = creatures.get(index++);
			}
			if (numOfFollowing % 2 == 0) {
				creaturesMap[endRowRowNum][j++] = creatures.get(index++);
			}
			for (int i = endRowRowNum - 1; i >= startRowNum; i--) {
				creaturesMap[i][j++] = creatures.get(index++);
			}

			// 放入领队的蝎子精
			creaturesMap[endRowRowNum+1][endColumnNum] = creatures.get(1);
			// 放入蛇精，呐喊助威用的
			creaturesMap[this.rowNum-1][this.columnNum-1] = creatures.get(0);
		}
	}

	/**
	 *        *
	 *       *
	 *      *
	 *     *
	 *    *
	 *   *
	 *  *
	 * @param creatures
	 */
	private void changeToWILD_GOOSE(List<Creature> creatures) {
		if (creatures.get(0) instanceof Demon) {
			int startRowNum=(creaturesMap.length-creatures.size()+1)/2;
			int index=creatures.size()-1;
			// 放入小喽啰和领队的蝎子精
			for (int i = startRowNum; i < startRowNum + creatures.size()-1; i++) {
				creaturesMap[i][startRowNum+creaturesMap[0].length-1-i] = creatures.get(index);
				index--;
				}
			}
			// 放入蛇精，呐喊助威用的
			creaturesMap[creaturesMap.length - 1][creaturesMap[0].length - 1]=creatures.get(0);
	}

	/**
	 *    *
	 *   *
	 *    *
	 *   *
	 *    *
	 *   *
	 *    *
	 * 假定了小喽啰的数量不会超过两列
	 * @param creatures
	 */
	private void changeToWOOD(List<Creature> creatures) {
		if (creatures.get(0) instanceof Demon) {
			int startRowNum=(creaturesMap.length-(creatures.size()-2))/2;
			// 将小哈喽们分成两队，第一对的人数<=第二队的人数
			int partOneNum=(creatures.size()-2)/2;
			int partTwoNum=creatures.size()-2-partOneNum;
			int index=2;
			// 放入小哈喽们
			for (int i = startRowNum; i <= startRowNum + 2*(partTwoNum-1); i+=2) {
				creaturesMap[i][creaturesMap[0].length - 1] = creatures.get(index);
				index++;
			}
			for (int i = startRowNum + 1; i <= 1+startRowNum + 2*(partOneNum-1); i += 2) {
				creaturesMap[i][creaturesMap[0].length-2]=creatures.get(index);
				index++;
			}
			// 放入蝎子精
			creaturesMap[creaturesMap.length/2][creaturesMap[0].length-3] = creatures.get(1);
			// 放入蛇精，呐喊助威用的
			creaturesMap[creaturesMap.length - 1][creaturesMap[0].length - 1] = creatures.get(0);
		}
	}

	/**
	 *  *
	 *  *
	 *  *
	 *  *
	 *  *
	 *  *
	 *  *
	 * @param creatures  demons并不使用这个队形
	 */
	private void changeToLONG_SNAKE(List<Creature> creatures) {
		// 将葫芦娃们放入map
		if (creatures.get(0) instanceof GoodPeople) {
			int startRowNum=(this.rowNum-(creatures.size()-1))>>1;
			int index=1;
			for (int i = startRowNum; i < startRowNum+creatures.size()-1; i++) {
				creaturesMap[i][1]=creatures.get(index++);
			}
			// 将爷爷放入map
			creaturesMap[this.rowNum>>1][0]=creatures.get(0);
		}
	}

	/**
	 *     *
	 *   * * *
	 * *   *   *
	 *     *  这里至少要有两个 below
	 *     *  这里至少要有两个 below 规定这个是蝎子精
	 * @param creatures
	 */
	private void changeToARROW(List<Creature> creatures) {
		int numOfThree=((creatures.size()-2)-2)/3;  // 计算出一行中有三个并列的情况有多少个，两次"-2"的含义分别是：扣掉蝎子精、蛇精；再扣掉最顶上、最底下的两个喽啰的耗损
		int numOfVertical=creatures.size()-2-3*numOfThree+numOfThree+1;  // 最后加的1是添上的蝎子精
		int startRowNum=(this.rowNum-numOfVertical)/2;
		// 先把一竖条的喽啰摆放好，暂时先不放蝎子精
		int index=2;
		int startColumnNum=this.columnNum-numOfThree-1;
		for (int i = startRowNum; i < startRowNum + numOfVertical-1; i++) {
			creaturesMap[i][startColumnNum]=creatures.get(index);
			index++;
		}
		// 把斜条上的小喽啰放上，先左边，后右边
		int j=startColumnNum+1;
		for (int i = startRowNum + 1; i <= startRowNum + numOfThree; i++) {
			creaturesMap[i][startRowNum+startColumnNum-i]=creatures.get(index);
			index++;
			creaturesMap[i][j++]=creatures.get(index);
			index++;
		}
		// 放上蝎子精、蛇精
		creaturesMap[startRowNum + numOfVertical - 1][startColumnNum]=creatures.get(1);
		creaturesMap[this.rowNum - 1][this.columnNum - 1] = creatures.get(0);
	}

	/**
	 *     *（startRowNum，startColumnNum）
	 *    * *
	 *  **   *（middleRow）
	 *    * *
	 *     *（endRowNum，endColumnNum）
	 * @param creatures
	 */
	private void changeToCIRCLE(List<Creature> creatures) {
		// TODO: 2018/10/9 判断是否为Demon
		if (creatures.get(0) instanceof Demon) {
			int numOfFollowing=creatures.size()-2;
			int numOfTwo=(numOfFollowing-2)/2;  // 一列中有两个的情况数量
			int numOfOne = numOfFollowing - 2 * numOfTwo;  // 一列中只有一个的情况数量
			int numOfVercital=(numOfTwo+1)/2*2+1;

			int startRowNum=(this.rowNum-numOfVercital)/2;
			int startColumnNum = (this.columnNum - 1) - (numOfTwo / 2 + 1);
			int endRowNum=startRowNum+numOfVercital-1;
			int endColumnNum=startColumnNum;
			int middleRowNum = startRowNum + numOfVercital / 2;
			int middleColumnNum = this.columnNum-1-1-numOfTwo;

			int index=2;
			int j=startColumnNum+1;

			// 先把最上面、最下面的单个（或多个）小喽啰放上去
			creaturesMap[startRowNum][startColumnNum] = creatures.get(index++);
			creaturesMap[endRowNum][endColumnNum] = creatures.get(index++);
			if (numOfTwo % 2 == 0) {
				creaturesMap[startRowNum][startColumnNum+1] = creatures.get(index++);
				creaturesMap[endRowNum][endColumnNum+1] = creatures.get(index++);
			}
			for (int i = startRowNum+1; i <=middleRowNum; i++) {
				creaturesMap[i][startRowNum + startColumnNum - i] = creatures.get(index++);
				creaturesMap[i][(1+numOfTwo)%2+j++] = creatures.get(index++);
			}
			j=endColumnNum-1;  // 恢复j的值
			for (int i = endRowNum-1; i > middleRowNum; i--) {
				creaturesMap[i][j--] = creatures.get(index++);
				creaturesMap[i][(1+numOfTwo)%2+endRowNum+endColumnNum-i] = creatures.get(index++);
			}
			// 把多余下来的单个小喽啰、蝎子精放上去
			int leftFollowing = numOfOne-2;
			if (leftFollowing > 0) {
				creaturesMap[middleRowNum][middleColumnNum - 1] = creatures.get(index++);  // TODO: 2018/10/9
				// 这里index可以不用++？？？
				creaturesMap[middleRowNum][middleColumnNum - 2] = creatures.get(1);
			} else {
				creaturesMap[middleRowNum][middleColumnNum - 1] = creatures.get(1);
			}
			// 放入蛇精
			creaturesMap[this.rowNum - 1][this.columnNum - 1] = creatures.get(0);
		}
	}

	/**
	 *     * 1
	 *    ** 2
	 *   *** 3
	 *  ***  3
	 *   **  2
	 *    *  1
	 *     * 1
	 *  1354
	 * @param creatures
	 */
	private void changeToMOON(List<Creature> creatures) {
		int numOfFollowing = creatures.size() - 2;
		int columnOfFollowing=(int)Math.ceil(Math.sqrt(numOfFollowing));
		int startRowNum=this.rowNum>>1;
		int startColumnNum=this.columnNum-columnOfFollowing;
		int index=2;
		// 放入小喽啰
		int count=0;
		for (int j = startColumnNum; j < startColumnNum + columnOfFollowing; j++) {
			for (int i = startRowNum - count; i <= startRowNum; i++) {
				if (index >= creatures.size()) {
					break;
				}
				if (startRowNum * 2 - i == startRowNum) {
					creaturesMap[i][j] = creatures.get(index++);
				}else{
					creaturesMap[i][j] = creatures.get(index++);
					if (index >= creatures.size()) {
						break;
					}
					creaturesMap[startRowNum * 2 - i][j] = creatures.get(index++);
				}
			}
			count++;
		}
		// 放入蝎子精、蛇精
		creaturesMap[startRowNum][startColumnNum - 1] = creatures.get(1);
		creaturesMap[startRowNum + 1][startColumnNum - 1] = creatures.get(0);
	}

	/**
	 *        *
	 *      * * *
	 *    * * * * *
	 *  * * * * * * *
	 *        *（蝎子精）
	 *       todo 有问题！！！
	 * @param creatures
	 */
	private void changeToFISH_SCALE(List<Creature> creatures) {
		int numOfFollowing = creatures.size() - 2;
		int rowOfTriangle = (int) Math.ceil(Math.sqrt(numOfFollowing));
		int numOfVertical = rowOfTriangle + 1;
		int startRowNum = (this.rowNum - numOfVertical) >> 1;
		int startColumnNum = this.columnNum - rowOfTriangle;
		int index = 2;
		int count=0;
		// 先放入小喽啰们构成的三角形
		for (int i = startRowNum; i < startRowNum + rowOfTriangle; i++) {
			for (int j = startColumnNum-count; j<=startColumnNum+count; j++) {
				creaturesMap[i][j]=creatures.get(index++);
				if (index >= creatures.size()) {
					break;
				}
			}
			count++;
		}
		// 放入蝎子精、蛇精
		creaturesMap[startRowNum + rowOfTriangle][startColumnNum] = creatures.get(1);
		creaturesMap[this.rowNum-1][this.columnNum-1] = creatures.get(0);
	}

	/**
	 * 初始化map，在一开始map上全都置为NO_PERSON
	 */
	private void initMap() {
		for (int i = 0; i < creaturesMap.length; i++) {
			for (int j = 0; j < creaturesMap[0].length; j++) {
				creaturesMap[i][j]=NoPerson.NO_PERSON;
			}
		}
	}

	/**
	 * 刷新map，首先要清空上一次的demons分布队形，并将demons重新摆放在map上
	 */
	private void refreshMap() {
		switch (demonHolder.getBattleModel()) {
			case CRANE_WING:
				clearDemons();
				changeToCRANE_WING(demons);
				break;
			case WILD_GOOSE:
				clearDemons();
				changeToWILD_GOOSE(demons);
				break;
			case WOOD:
				clearDemons();
				changeToWOOD(demons);
				break;
			case LONG_SNAKE:  // 只有葫芦娃们使用这个队形
				clearDemons();
				changeToLONG_SNAKE(demons);
				break;
			case FISH_SCALE:
				clearDemons();
				changeToFISH_SCALE(demons);
				break;
			case CIRCLE:
				clearDemons();
				changeToCIRCLE(demons);
				break;
			case MOON:
				clearDemons();
				changeToMOON(demons);
				break;
			case ARROW:
				clearDemons();
				changeToARROW(demons);
				break;
			default:
				break;
		}
	}

	private void clearDemons() {
		for (int i = 0; i < creaturesMap.length; i++) {
			for (int j = 0; j < creaturesMap[0].length; j++) {
				if (creaturesMap[i][j] instanceof Demon) {
					creaturesMap[i][j]=NoPerson.NO_PERSON;
				}
			}
		}
	}

	/**
	 * 随机选择一个队形将demons排列在map上
	 */
	private void initDemons() {
		BattleModel randomBattleModel=BattleModel.getRandomBattleModel();
		changeDemonsBattleModel(randomBattleModel);
	}

	/**
	 * 将初始乱序的葫芦娃们排好序，并放入map
	 */
	private void initGoodPeople() {
		goodPeopleHolder.sortByRank();
		changeToLONG_SNAKE(goodPeople);
	}

//	public void test() {
//		changeToMOON(demons);
//	}
//
//	public static void main(String[] args) {
//		Map map = new Map(11,8);
//		map.initMap();
//		map.printMap();
//		System.out.println("\n");
//		map.test();
//		map.printMap();
//	}
}
