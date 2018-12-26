package secondHomework;

//颜色的枚举类
enum Color {
	RED("红娃"), ORANGE("橙娃"), YELLOW("黄娃"), GREEN("绿娃"), CYAN("青娃"), BLUE("蓝色"), PURPLE("紫色");
	private String color;

	private Color(String color) {
		this.color = color;
	}

	public String toString() {
		return this.color;
	}
};

//排行的枚举类
enum Rank {
	ONE("大娃"), TWO("二娃"), THREE("三娃"), FOUR("四娃"), FIVE("五娃"), SIX("六娃"), SEVEN("七娃");
	private String rank;

	private Rank(String rank) {
		this.rank = rank;
	}

	public String toString() {
		return this.rank;
	}
};

//葫芦娃兄弟类
public class CalabashBrothers {
	// 葫芦娃个数
	private final static int NUM = 7, COLOR = 0, RANK = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a1[] = { 1, 0, 3, 6, 2, 5, 4 };
		CalabashBrothers c1 = new CalabashBrothers(a1);
		c1.binarySort();

		int a2[] = { 3, 6, 1, 5, 4, 2, 0 };
		CalabashBrothers c2 = new CalabashBrothers(a2);
		c2.bubbleSort();
	}

	// 葫芦娃类
	private class Calabash {
		private Color color;
		private Rank rank;

		protected Calabash(int index) {
			// TODO Auto-generated constructor stub
			this.color = Color.values()[index];
			this.rank = Rank.values()[index];
		}

		protected Color getColor() {
			return this.color;
		}

		protected Rank getRank() {
			return this.rank;
		}
	}

	// 葫芦娃数组
	private Calabash calabashBrothers[] = new Calabash[NUM];

	public CalabashBrothers(int[] array) {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < NUM; i++) {
			Calabash calabash = new Calabash(array[i]);
			calabashBrothers[i] = calabash;
		}
	}

	// 按冒泡法依照各自排行排序
	public void bubbleSort() {
		System.out.println("按冒泡法依照各自排行排序：");
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6 - i; j++) {
				if (calabashBrothers[j].getRank().ordinal() > calabashBrothers[j + 1].getRank().ordinal()) {
					// 位置从0计数
					System.out.println(swapProcess(calabashBrothers[j], j, j + 1, RANK));
					System.out.println(swapProcess(calabashBrothers[j + 1], j + 1, j, RANK));
					Calabash temp = calabashBrothers[j];
					calabashBrothers[j] = calabashBrothers[j + 1];
					calabashBrothers[j + 1] = temp;

				}
			}
		}
		for (int i = 0; i < NUM; i++) {
			System.out.print(calabashBrothers[i].rank.toString() + " ");
		}
		System.out.println("\n");
	}

	// 按二分法依照各自颜色排序
	public void binarySort() {
		System.out.println("按二分法依照各自颜色排序：");
		Calabash temp = null;
		for (int i = 1; i < NUM; i++) {
			temp = calabashBrothers[i];
			int left = 0, right = i - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (calabashBrothers[mid].getColor().ordinal() > temp.getColor().ordinal())
					right = mid - 1;
				else
					left = mid + 1;
			}
			for (int j = i - 1; j > right; j--) {
				calabashBrothers[j + 1] = calabashBrothers[j];
				System.out.println(swapProcess(calabashBrothers[j], j, j + 1, COLOR));
			}
			calabashBrothers[right + 1] = temp;
			System.out.println(swapProcess(temp, i, right + 1, COLOR));
		}
		for (int i = 0; i < NUM; i++) {
			System.out.print(calabashBrothers[i].color.toString() + " ");
		}
		System.out.println("\n");
	}

	// 返回交换过程的字符串
	private String swapProcess(Calabash calabash, int i, int j, int func) {
		String temp = null;
		switch (func) {
		case COLOR:
			temp = calabash.getColor().toString() + "：" + i + "->" + j;
			break;
		case RANK:
			temp = calabash.getRank().toString() + "：" + i + "->" + j;
			break;
		default:
			break;
		}
		return temp;
	}

}
