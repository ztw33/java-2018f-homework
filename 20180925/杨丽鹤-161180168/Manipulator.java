import java.util.Random;

class Manipulator {
	private HuluBrother[] huluBro;
	private LittleMonster[] littleMonster;
	private GrandPa grandPa;
	private ScorpionMonster scorpion;
	private SnakerMonster snake;
	private BattleField battleField;

	public Manipulator() {
		battleField = new BattleField(80, 21);
		huluBro = new HuluBrother[7];
		littleMonster = new LittleMonster[9];
		String color = "红橙黄绿青蓝紫";
		for (int i = 0; i < 7; i++) {
			huluBro[i] = new HuluBrother(-1, -1, color.charAt(i) + "娃", i+1);
		}
		for (int i = 0; i < 9; i++) {
			littleMonster[i] = new LittleMonster(-1, -1, "小喽啰");
		}
		grandPa = new GrandPa(-1, -1, "老爷爷");
		scorpion = new ScorpionMonster(-1, -1, "蝎子精");
		snake = new SnakerMonster(-1, -1, "蛇精");
	}

	public void setFieldSize(int lenX, int lenY) {
		battleField = new BattleField(lenX, lenY);
	}

	public void setHuluBro(int rank, int posX, int posY) {
		huluBro[rank-1].changePosX(posX);
		huluBro[rank-1].changePosY(posY);
	}

	public void setLittleMonster(int number, int posX, int posY) {
		littleMonster[number-1].changePosX(posX);
		littleMonster[number-1].changePosY(posY);
	}

	public void setGrandPa(int posX, int posY) {
		grandPa.changePosX(posX);
		grandPa.changePosY(posY);
	}

	public void ScorpionMonster(int posX, int posY) {
		grandPa.changePosX(posX);
		grandPa.changePosY(posY);
	}

	public void SnakerMonster(int posX, int posY) {
		grandPa.changePosX(posX);
		grandPa.changePosY(posY);
	}

	public void placeCreature(int round) {
		if (round == 1) {
			//set HuluBrother's position
			for (int i = 0; i < 7; i++) {
				huluBro[i].changePos(5, i+7);
			}
			//shuffle their position
			Random r = new Random(99);
			for (int i = 0; i < 20; i++) {
				int index1 = r.nextInt(6), index2 = r.nextInt(6);
				int x = huluBro[index1].getX(), y = huluBro[index1].getY();
				huluBro[index1].changePos(huluBro[index2].getX(), huluBro[index2].getY());
				huluBro[index2].changePos(x, y);
			}
		} else if (round == 2) {
			scorpion.changePos(55, 10);
			for (int i = 0; i < 3; i++) {
				littleMonster[i].changePos(61+6*i, 10);
			}
			for (int i = 0; i < 3; i++) {
				littleMonster[3+i].changePos(57+2*i, 11+i);
				littleMonster[6+i].changePos(57+2*i, 9-i);
			}
		} else if (round == 3) {
			placeCreature(1);
			placeCreature(2);
		} else if (round == 4) {
			placeCreature(3);
			grandPa.changePos(12, 10);
			snake.changePos(48, 10);
		} else if (round == 5) {
			placeCreature(1);
			for (int i = 0; i < 9; i++) {
				littleMonster[i].changePos(72-i, 6+i);
			}
			scorpion.changePos(63, 15);
		} else if (round == 6) {
			placeCreature(5);
			grandPa.changePos(12, 10);
			snake.changePos(61, 10);
		} else {
			System.out.println("Round Not defined");
		}
	}

	public void displayField(int round) {
		if (round == 1) {
			battleField.displayField(huluBro);
			
		} else if (round == 2) {
			Creature[] creature = new Creature[littleMonster.length+1];
			for (int i = 0; i < littleMonster.length; i++)
				creature[i] = littleMonster[i];
			creature[littleMonster.length] = scorpion;
			battleField.displayField(creature);

		} else if (round == 3) {
			Creature[] creature = new Creature[littleMonster.length+8];
			for (int i = 0; i < littleMonster.length; i++)
				creature[i] = littleMonster[i];
			creature[littleMonster.length] = scorpion;
			for (int i = 0; i < huluBro.length; i++)
				creature[littleMonster.length+1+i] = huluBro[i];
			battleField.displayField(creature);

		} else if (round == 4) {
			Creature[] creature = new Creature[littleMonster.length+10];
			for (int i = 0; i < littleMonster.length; i++)
				creature[i] = littleMonster[i];
			creature[littleMonster.length] = scorpion;
			for (int i = 0; i < huluBro.length; i++)
				creature[littleMonster.length+1+i] = huluBro[i];
			creature[littleMonster.length+8] = grandPa;
			creature[littleMonster.length+9] = snake;
			battleField.displayField(creature);

		} else if (round == 5) {
			Creature[] creature = new Creature[littleMonster.length+8];
			for (int i = 0; i < littleMonster.length; i++)
				creature[i] = littleMonster[i];
			creature[littleMonster.length] = scorpion;
			for (int i = 0; i < huluBro.length; i++)
				creature[littleMonster.length+1+i] = huluBro[i];
			battleField.displayField(creature);

		} else if (round == 6) {
			Creature[] creature = new Creature[littleMonster.length+10];
			for (int i = 0; i < littleMonster.length; i++)
				creature[i] = littleMonster[i];
			creature[littleMonster.length] = scorpion;
			for (int i = 0; i < huluBro.length; i++)
				creature[littleMonster.length+1+i] = huluBro[i];
			creature[littleMonster.length+8] = grandPa;
			creature[littleMonster.length+9] = snake;
			battleField.displayField(creature);

		} else {
			System.out.println("Round Not defined");
		}
	}
}