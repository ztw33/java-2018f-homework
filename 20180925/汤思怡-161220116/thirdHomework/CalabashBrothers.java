package thirdHomework;

import javax.swing.ImageIcon;

/*
 * 葫芦娃兄弟
 */

//排行的枚举类
enum Rank {
	ONE("大娃", "image/one.jpg"), TWO("二娃", "image/two.jpg"), THREE("三娃", "image/three.jpg"),
	FOUR("四娃", "image/four.jpg"), FIVE("五娃", "image/five.jpg"), SIX("六娃", "image/six.jpg"),
	SEVEN("七娃", "image/seven.jpg");
	private String rank;
	private String path;

	private Rank(String rank, String path) {
		this.rank = rank;
		this.path = path;
	}

	public String getRank() {
		return this.rank;
	}

	public String getPath() {
		return this.path;
	}
};

public class CalabashBrothers implements Constants {

	private final int NUM = 7;

	// 葫芦娃内部类 初始化每个葫芦娃
	private class Calabash extends Creature {
		public Calabash(int index) {
			super(index);
			this.name = Rank.values()[index].getRank();
			this.species = Species.CALABASH;
			this.icon = new ImageIcon(Rank.values()[index].getPath());
			this.standardIcon();
		}

		protected Rank getName() {
			for (int index = 0; index < NUM; index++) {
				if (Rank.values()[index].getRank() == name)
					return Rank.values()[index];
			}
			return null;
		}
	}

	// 葫芦娃兄弟
	private Calabash calabashBrothers[] = new Calabash[NUM];

	// 构造函数：初始化葫芦兄弟站队顺序
	public CalabashBrothers(int order[]) {
		for (int i = 0; i < NUM; i++) {
			Calabash calabash = new Calabash(order[i]);
			calabashBrothers[i] = calabash;
		}
	}

	// 对葫芦娃进行二分法排序
	public void sort() {
		// TODO Auto-generated method stub
		Calabash temp = null;
		for (int i = 1; i < NUM; i++) {
			temp = calabashBrothers[i];
			int left = 0, right = i - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (calabashBrothers[mid].getName().ordinal() > temp.getName().ordinal())
					right = mid - 1;
				else
					left = mid + 1;
			}
			for (int j = i - 1; j > right; j--) {
				calabashBrothers[j + 1] = calabashBrothers[j];
			}
			calabashBrothers[right + 1] = temp;
		}
	}

	// 葫芦娃站出长蛇阵
	protected void snakeForm(Creature dimension[][]) {
		calabashBrothers[0].stand(dimension, 3, 1);
		calabashBrothers[1].stand(dimension, 4, 1);
		calabashBrothers[2].stand(dimension, 5, 1);
		calabashBrothers[3].stand(dimension, 6, 1);
		calabashBrothers[4].stand(dimension, 7, 1);
		calabashBrothers[5].stand(dimension, 8, 1);
		calabashBrothers[6].stand(dimension, 9, 1);
	}

}