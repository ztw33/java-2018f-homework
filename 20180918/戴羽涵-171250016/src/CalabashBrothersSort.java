public class CalabashBrothersSort {
	/**
	 * 冒泡排序
	 *
	 * @param calabashBrothers
	 */
	public void sortedByNum(CalabashBrothers[] calabashBrothers) {
		// 数组中的索引即为七兄弟的站队顺序
		initLocation(calabashBrothers);

		System.out.println("按各自排行排序");

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {
				CalabashBrothers m = calabashBrothers[j];
				CalabashBrothers n = calabashBrothers[j + 1];
				if (n.lessOfNum(m))
					swap(calabashBrothers, m, n);
			}
		}
		printSmallName(calabashBrothers);
	}

	/**
	 * 二分插入法
	 *
	 * @param calabashBrothers 要排序的葫芦兄弟数组
	 */
	public void sortedByColor(CalabashBrothers[] calabashBrothers) {
		// 数组中的索引即为七兄弟的站队顺序
		initLocation(calabashBrothers);
		System.out.println("按颜色排序");
		int left, right, mid;
		CalabashBrothers tempBrother;
		// i表示将要插入的元素的索引；right表示搜索的上界，即left-right都是有序的
		for (int i = 1; i < 7; i++) {
			tempBrother = calabashBrothers[i];
			left = 0;
			right = i - 1;
			// 最后的循环结果会是left代表的索引就是元素应该插入的地方，mid代表的索引是在要插入的元素前面
			while (left <= right) {
				mid = (left + right) >> 1;
				// 这里不存在相等的情况
				if (calabashBrothers[mid].getNum() < tempBrother.getNum())
					left = mid + 1;
				if (calabashBrothers[mid].getNum() > tempBrother.getNum())
					right = mid - 1;
			}
			// 将mid后面的元素向后移动一位
			moveBehind(calabashBrothers, calabashBrothers[left], calabashBrothers[i - 1]);
			// 将tempBrother插入到合适的位置
			tempBrother.setLocation(left);
			calabashBrothers[left] = tempBrother;
			System.out.println(tempBrother.getSmallName() + ": " + i + " -> " + tempBrother.getLocation());
			System.out.println("----------------------------------------------");
		}
		printColor(calabashBrothers);
	}

	/**
	 *
	 * @param calabashBrothers 葫芦兄弟在数组中存放的索引就是他们的location
	 */
	private void initLocation(CalabashBrothers[] calabashBrothers) {
		for (int i = 0; i < 7; i++) {
			calabashBrothers[i].setLocation(i);
		}
	}

	private void swap(CalabashBrothers[] calabashBrothers, CalabashBrothers m, CalabashBrothers n) {
		calabashBrothers[m.getLocation()] = n;
		calabashBrothers[n.getLocation()] = m;
		int locationTemp = m.getLocation();
		m.setLocation(n.getLocation());
		n.setLocation(locationTemp);
		System.out.println(m.getSmallName() + ": " + n.getLocation() + " -> " + m.getLocation());
		System.out.println(n.getSmallName() + ": " + m.getLocation() + " -> " + n.getLocation());
		System.out.println("----------------------------------------------");
	}

	/**
	 * @param calabashBrothers 要排序的数组
	 * @param start            要移动的葫芦娃的开始索引
	 * @param end              要移动的葫芦娃的结束索引
	 */
	private void moveBehind(CalabashBrothers[] calabashBrothers, CalabashBrothers start, CalabashBrothers end) {
		for (int i = end.getLocation(); i >= start.getLocation(); i--) {
			CalabashBrothers present = calabashBrothers[i];
			calabashBrothers[i + 1] = present;
			System.out.println(calabashBrothers[i].getSmallName() + ": " + calabashBrothers[i].getLocation() + " -> " + "" + (calabashBrothers[i].getLocation() + 1));
			calabashBrothers[i].increseLocation();
		}
	}

	private void printColor(CalabashBrothers[] calabashBrothers) {
		for (CalabashBrothers person : calabashBrothers) {
			System.out.print(person.getColor() + " ");
		}
	}

	private void printSmallName(CalabashBrothers[] calabashBrothers) {
		for (CalabashBrothers person : calabashBrothers) {
			System.out.print(person.getSmallName()+" ");
		}
	}

	public static void main(String[] args) {
		CalabashBrothers one = CalabashBrothers.BrotherOne;
		CalabashBrothers two = CalabashBrothers.BrotherTwo;
		CalabashBrothers three = CalabashBrothers.BrotherThree;
		CalabashBrothers four = CalabashBrothers.BrotherFour;
		CalabashBrothers five = CalabashBrothers.BrotherFive;
		CalabashBrothers six = CalabashBrothers.BrotherSix;
		CalabashBrothers seven = CalabashBrothers.BrotherSeven;

		// 七兄弟随意站队，按各自排行排序
		CalabashBrothers[] calabashBrothers = new CalabashBrothers[7];
		calabashBrothers[6] = one;
		calabashBrothers[2] = two;
		calabashBrothers[3] = three;
		calabashBrothers[4] = four;
		calabashBrothers[1] = five;
		calabashBrothers[0] = six;
		calabashBrothers[5] = seven;
		new CalabashBrothersSort().sortedByNum(calabashBrothers);

		System.out.println();
		System.out.println();

		// 七兄弟再次随意站队，按各自颜色排序
		calabashBrothers[6] = one;
		calabashBrothers[2] = two;
		calabashBrothers[3] = three;
		calabashBrothers[4] = four;
		calabashBrothers[1] = five;
		calabashBrothers[0] = six;
		calabashBrothers[5] = seven;
		new CalabashBrothersSort().sortedByColor(calabashBrothers);
	}
}
