package thirdHomework;

/*
 * 邪恶的一方：蝎子精、蛇精、小喽啰
 */
public class EvilSide implements Formate {
	private Snake snake = new Snake();
	private Scorpion scorpion = new Scorpion();
	private Minion minions[];

	public EvilSide() {

	}

	// 鹤翼
	private void craneForm(Creature dimension[][]) {
		minions = new Minion[6];
		for (int index = 0; index < 6; index++) {
			minions[index] = new Minion(index);
		}
		scorpion.stand(dimension, 8, 6);
		minions[0].stand(dimension, 5, 3);
		minions[1].stand(dimension, 6, 4);
		minions[2].stand(dimension, 7, 5);
		minions[3].stand(dimension, 7, 7);
		minions[4].stand(dimension, 6, 8);
		minions[5].stand(dimension, 5, 9);
	}

	// 雁行
	private void gooseForm(Creature dimension[][]) {
		minions = new Minion[6];
		for (int index = 0; index < 6; index++) {
			minions[index] = new Minion(index);
		}
		scorpion.stand(dimension, 9, 3);
		minions[0].stand(dimension, 8, 4);
		minions[1].stand(dimension, 7, 5);
		minions[2].stand(dimension, 6, 6);
		minions[3].stand(dimension, 5, 7);
		minions[4].stand(dimension, 4, 8);
		minions[5].stand(dimension, 3, 9);
	}

	// 冲轭
	private void yokeForm(Creature dimension[][]) {
		minions = new Minion[8];
		for (int index = 0; index < 8; index++) {
			minions[index] = new Minion(index);
		}
		scorpion.stand(dimension, 2, 4);
		minions[0].stand(dimension, 3, 3);
		minions[1].stand(dimension, 4, 4);
		minions[2].stand(dimension, 5, 3);
		minions[3].stand(dimension, 6, 4);
		minions[4].stand(dimension, 7, 3);
		minions[5].stand(dimension, 8, 4);
		minions[6].stand(dimension, 9, 3);
		minions[7].stand(dimension, 10, 4);
	}

	// 鱼鳞
	private void fishForm(Creature dimension[][]) {
		minions = new Minion[10];
		for (int index = 0; index < 10; index++) {
			minions[index] = new Minion(index);
		}
		scorpion.stand(dimension, 4, 5);
		minions[0].stand(dimension, 5, 6);
		minions[1].stand(dimension, 6, 4);
		minions[2].stand(dimension, 6, 5);
		minions[3].stand(dimension, 6, 6);
		minions[4].stand(dimension, 7, 3);
		minions[5].stand(dimension, 7, 4);
		minions[6].stand(dimension, 7, 5);
		minions[7].stand(dimension, 7, 6);
		minions[8].stand(dimension, 7, 7);
		minions[9].stand(dimension, 8, 5);
	}

	// 方円
	private void squareForm(Creature dimension[][]) {
		minions = new Minion[7];
		for (int index = 0; index < 7; index++) {
			minions[index] = new Minion(index);
		}
		scorpion.stand(dimension, 4, 5);
		minions[0].stand(dimension, 5, 4);
		minions[1].stand(dimension, 5, 6);
		minions[2].stand(dimension, 6, 3);
		minions[3].stand(dimension, 6, 7);
		minions[4].stand(dimension, 7, 4);
		minions[5].stand(dimension, 7, 6);
		minions[6].stand(dimension, 8, 5);

	}

	// 偃月
	private void moonForm(Creature dimension[][]) {
		minions = new Minion[18];
		for (int index = 0; index < 18; index++) {
			minions[index] = new Minion(index);
		}
		scorpion.stand(dimension, 6, 3);
		minions[0].stand(dimension, 2, 8);
		minions[1].stand(dimension, 3, 6);
		minions[2].stand(dimension, 3, 7);
		minions[3].stand(dimension, 4, 5);
		minions[4].stand(dimension, 4, 6);
		minions[5].stand(dimension, 5, 3);
		minions[6].stand(dimension, 5, 4);
		minions[7].stand(dimension, 5, 5);
		minions[8].stand(dimension, 6, 4);
		minions[9].stand(dimension, 6, 5);
		minions[10].stand(dimension, 7, 3);
		minions[11].stand(dimension, 7, 4);
		minions[12].stand(dimension, 7, 5);
		minions[13].stand(dimension, 8, 5);
		minions[14].stand(dimension, 8, 6);
		minions[15].stand(dimension, 9, 6);
		minions[16].stand(dimension, 9, 7);
		minions[17].stand(dimension, 10, 8);
	}

	// 锋失
	private void frontForm(Creature dimension[][]) {
		minions = new Minion[12];
		for (int index = 0; index < 12; index++) {
			minions[index] = new Minion(index);
		}
		scorpion.stand(dimension, 3, 6);
		minions[0].stand(dimension, 4, 5);
		minions[1].stand(dimension, 4, 6);
		minions[2].stand(dimension, 4, 7);
		minions[3].stand(dimension, 5, 4);
		minions[4].stand(dimension, 5, 6);
		minions[5].stand(dimension, 5, 8);
		minions[6].stand(dimension, 6, 3);
		minions[7].stand(dimension, 6, 6);
		minions[8].stand(dimension, 6, 9);
		minions[9].stand(dimension, 7, 6);
		minions[10].stand(dimension, 8, 6);
		minions[11].stand(dimension, 9, 6);
	}

	@Override
	public void formate(Creature[][] dimension, Formation form) {
		// TODO Auto-generated method stub
		snake.stand(dimension, 6, 11);
		switch (form) {
		case CRANE:
			craneForm(dimension);
			break;
		case GOOSE:
			gooseForm(dimension);
			break;
		case YOKE:
			yokeForm(dimension);
			break;
		case SNAKE:
			System.out.println("数量太多，不能排长蛇队");
			break;
		case FISH:
			fishForm(dimension);
			break;
		case SQAURE:
			squareForm(dimension);
			break;
		case MOON:
			moonForm(dimension);
			break;
		case FRONT:
			frontForm(dimension);
			break;
		default:
			break;
		}
	}

	@Override
	public void formate(Creature[][] dimension) {
		// TODO Auto-generated method stub
		System.out.println("请输入要变换的阵型");
	}
}