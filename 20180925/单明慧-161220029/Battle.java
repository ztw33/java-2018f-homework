package battle;

class Tile{
	String[][] situation = new String[5][5];
	Tile() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++)
				situation[i][j] = "  ";
		}
		for(int i = 0; i < 5; i++) {
			situation[4][i] = "--";
		}
		for(int i = 1; i < 5;i++) {
			situation[i][4] = "|";
		}
	}
	void stood(Creature onePerson) {
		int strLen = onePerson.tellName().length();
		for(int i = 0; i < strLen; i++) {
			situation[1 + i][1] = onePerson.tellName().substring(i, i + 1);
		}
	}
}

class BattleField{
	Tile[][] field = new Tile[15][15];
	BattleField() {
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				field[i][j] = new Tile();
			}
		}
	}
	void show() {
		for(int i = 0; i < 5 * 15; i++) {
			for (int j = 0; j < 5 * 15; j++) {
				System.out.print(field[i / 5][j / 5].situation[i % 5][j % 5]);
			}
			System.out.print("\n");
		}
	}
	void standOn(Creature onePerson) {
		field[onePerson.x][onePerson.y].stood(onePerson);
	}
	void cleanRight() {
		for(int i = 0; i < 15; i++) {
			for(int j = 6; j < 15; j++) {
				field[i][j] = new Tile();
			}
		}
	}//由于蝎子精变换阵型，故需要清屏右边
}

class Creature{
	protected String name;
	int x, y;
	Creature(){
		x = -1;
		y = -1;
	}
	String tellName() {
		return this.name;
	}
	void setPos(int x ,int y) {
		this.x = x;
		this.y = y;
	}
}

enum COLOR {
	RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE
}

class OneCalabash extends Creature{
	private int number;
	private String colorName;
	private COLOR color;
	
	OneCalabash(int no, String colorName, COLOR color, String name){
		this.number = no;
		this.colorName = colorName;
		this.color = color;
		this.name = name;
	}
	int tellNo() {
    	return this.number;
    }
    String tellColorName() {
    	return this.colorName;
    }
    COLOR tellColor() {
    	return this.color;
    }	
}

class CalabashBrothers{
	OneCalabash[] sevenBro = new OneCalabash[7];
	CalabashBrothers() {
		sevenBro[0] = new OneCalabash(0, "红色", COLOR.RED, "老大");
		sevenBro[1] = new OneCalabash(1, "橙色", COLOR.ORANGE, "老二");
		sevenBro[2] = new OneCalabash(2, "黄色", COLOR.YELLOW, "老三");
		sevenBro[3] = new OneCalabash(3, "绿色", COLOR.GREEN, "老四");
		sevenBro[4] = new OneCalabash(4, "青色", COLOR.CYAN, "老五");
		sevenBro[5] = new OneCalabash(5, "蓝色", COLOR.BLUE, "老六");
		sevenBro[6] = new OneCalabash(6, "紫色", COLOR.PURPLE, "老七");
	}
}

class Sort{
	private int[] queue = new int[7];
	OneCalabash[] sevenBrothers = new OneCalabash[7];
	Sort(OneCalabash[] sevenBrothers){
		this.sevenBrothers = sevenBrothers;
	}
	
	private void initQueue() {
		queue[0] = 3;
		queue[1] = 1;
		queue[2] = 6;
		queue[3] = 2;
		queue[4] = 0;
		queue[5] = 4;
		queue[6] = 5;
	}
	void sortByNo() {
		initQueue();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6 - i; j++) {
				if (sevenBrothers[queue[j]].tellNo() > sevenBrothers[queue[j + 1]].tellNo()) {
					int tmp = queue[j];
					queue[j] = queue[j + 1];
					queue[j + 1] = tmp;
					System.out.print(sevenBrothers[queue[j + 1]].tellName() + ": "+ (j + 1) + " -> " + (j + 2) + " ");
					System.out.println(sevenBrothers[queue[j]].tellName() + ": "+ (j + 2) + " -> " + (j + 1));
				}
			}
		}
		System.out.println("葫芦兄弟开始报数……");
		for (int i = 0; i < 7; i++) {		
			System.out.print(sevenBrothers[queue[i]].tellName() + " ");
		}
		System.out.print("\n");
	}
}

class Grandpa extends Creature{
	Grandpa(){
		this.name = "老爷爷";
	}
}

class Underlyings extends Creature{
	Underlyings(){
		this.name = "小喽啰";
	}
}

class Snake extends Creature{
	Snake(){
		this.name = "蛇精";
	}
}

class Scorpion extends Creature{
	Scorpion(){
		this.name = "蝎子精";
	}
}

class Form{
	CalabashBrothers calabashBro;
	Grandpa oneGrandpa;
	Underlyings severalUnderlying[] = new Underlyings[20];
	Snake oneSnake;
	Scorpion oneScorpion;
	int lastFormation;//阵型要和上次不一样
	Form(){
		calabashBro = new CalabashBrothers();
		oneGrandpa = new Grandpa();
		System.out.println("葫芦兄弟开始排队……");
		Sort sortCalabash = new Sort(calabashBro.sevenBro);
		sortCalabash.sortByNo();//按照姓名排队
		oneSnake = new Snake();
		oneScorpion = new Scorpion();
		for(int i = 0; i < 20; i++) {
			severalUnderlying[i] = new Underlyings();
		}
	}
	void formForGood(){
		calabashBro.sevenBro[0].setPos(3, 4);
		calabashBro.sevenBro[1].setPos(4, 4);
		calabashBro.sevenBro[2].setPos(5, 4);
		calabashBro.sevenBro[3].setPos(6, 4);
		calabashBro.sevenBro[4].setPos(7, 4);
		calabashBro.sevenBro[5].setPos(8, 4);
		calabashBro.sevenBro[6].setPos(9, 4);
		oneGrandpa.setPos(6, 2);
	}
	//反派要变换的阵型
	int HE_YI() {
		oneScorpion.setPos(6, 8);
		severalUnderlying[0].setPos(7, 9);
		severalUnderlying[1].setPos(8, 10);
		severalUnderlying[2].setPos(9, 11);
		severalUnderlying[3].setPos(8, 12);
		severalUnderlying[4].setPos(7, 13);
		severalUnderlying[5].setPos(6, 14);
		oneSnake.setPos(7, 11);
		return 6;
	}
	int YAN_XING() {
		oneScorpion.setPos(7, 9);
		severalUnderlying[0].setPos(6, 10);
		severalUnderlying[1].setPos(5, 11);
		severalUnderlying[2].setPos(4, 12);
		severalUnderlying[3].setPos(3, 13);
		oneSnake.setPos(6, 12);
		return 4;
	}
	int HENG_E() {
		oneScorpion.setPos(6, 8);
		severalUnderlying[0].setPos(7, 8);
		severalUnderlying[1].setPos(8, 8);
		severalUnderlying[2].setPos(5, 9);
		severalUnderlying[3].setPos(6, 9);
		severalUnderlying[4].setPos(7, 9);
		oneSnake.setPos(6, 11);
		return 5;
	}
	int YU_LIN() {
		oneScorpion.setPos(6, 9);
		severalUnderlying[0].setPos(6, 10);
		severalUnderlying[1].setPos(6, 11);
		severalUnderlying[2].setPos(6, 12);
		severalUnderlying[3].setPos(7, 11);
		severalUnderlying[4].setPos(5, 9);
		severalUnderlying[5].setPos(5, 10);
		severalUnderlying[6].setPos(5, 11);
		severalUnderlying[7].setPos(4, 10);
		severalUnderlying[8].setPos(3, 9);
		oneSnake.setPos(6, 13);
		return 9;
	}
	int FANG_YUAN() {
		oneScorpion.setPos(6, 8);
		severalUnderlying[0].setPos(7, 9);
		severalUnderlying[1].setPos(5, 9);
		severalUnderlying[2].setPos(4, 10);
		severalUnderlying[3].setPos(8, 10);
		severalUnderlying[4].setPos(5, 11);
		severalUnderlying[5].setPos(7, 11);
		severalUnderlying[6].setPos(6, 12);
		oneSnake.setPos(6, 10);
		return 7;
	}
	int YAN_YUE(){
		oneScorpion.setPos(6, 8);
		severalUnderlying[0].setPos(5, 8);
		severalUnderlying[1].setPos(7, 8);
		severalUnderlying[2].setPos(5, 9);
		severalUnderlying[3].setPos(6, 9);
		severalUnderlying[4].setPos(7, 9);
		severalUnderlying[5].setPos(4, 10);
		severalUnderlying[6].setPos(3, 11);
		severalUnderlying[7].setPos(8, 10);
		severalUnderlying[8].setPos(9, 11);
		severalUnderlying[9].setPos(5, 10);
		severalUnderlying[10].setPos(6, 10);
		severalUnderlying[11].setPos(7, 10);
		severalUnderlying[12].setPos(4, 11);
		severalUnderlying[13].setPos(3, 12);
		severalUnderlying[14].setPos(2, 13);
		severalUnderlying[15].setPos(8, 11);
		severalUnderlying[16].setPos(9, 12);
		severalUnderlying[17].setPos(10, 13);
		oneSnake.setPos(6, 11);
		return 18;
	}
	int FENG_SHI() {
		oneScorpion.setPos(3, 11);
		severalUnderlying[0].setPos(6, 8);
		severalUnderlying[1].setPos(5, 9);
		severalUnderlying[2].setPos(4, 10);
		severalUnderlying[3].setPos(4, 11);
		severalUnderlying[4].setPos(4, 12);
		severalUnderlying[5].setPos(5, 13);
		severalUnderlying[6].setPos(6, 14);
		severalUnderlying[7].setPos(5, 11);
		severalUnderlying[8].setPos(6, 11);
		severalUnderlying[9].setPos(7, 11);
		severalUnderlying[10].setPos(8, 11);
		oneSnake.setPos(6, 12);
		return 11;
	}
	int formForBad() {
		int rand = (int)(1 + Math.random() * ( 7 - 1 + 1));//�����ѡһ������
		while(rand == lastFormation) {
			rand = (int)(1 + Math.random() * ( 7 - 1 + 1));
		}
		lastFormation = rand;
		switch(rand) {
		case 1:
			System.out.println("蝎子精：鹤翼阵！");
			return HE_YI();
		case 2:
			System.out.println("蝎子精：雁行阵！");
			return YAN_XING();
		case 3:
			System.out.println("蝎子精：衡轭阵！");
			return HENG_E();
		case 4:
			System.out.println("蝎子精：鱼鳞阵！");
			return YU_LIN();
		case 5:
			System.out.println("蝎子精：方圆阵！");
			return FANG_YUAN();
		case 6:
			System.out.println("蝎子精：偃月阵！");
			return YAN_YUE();
		case 7:
			System.out.println("蝎子精：锋矢阵！");
			return FENG_SHI();
		default:
			return -1;
		}
	}
}

public class Battle {
	public static void main(String[] args) {
		BattleField oneBattleField = new BattleField();//ս�����
		Form formTeam = new Form();
		System.out.println("葫芦兄弟开始排阵……");
		formTeam.formForGood();//葫芦兄弟布阵
		System.out.println("葫芦兄弟开始上战场……");
		for(int i = 0; i < 7; i++) {
			oneBattleField.standOn(formTeam.calabashBro.sevenBro[i]);
		}//葫芦兄弟上战场
		System.out.println("老爷爷呐喊助威……");
		oneBattleField.standOn(formTeam.oneGrandpa);//老爷爷呐喊助威
		oneBattleField.show();//只有正派
		for(int i = 0; i < 6; i++) {
			oneBattleField.cleanRight();
			System.out.println("这是反派第" + (i + 1) + "次排阵……");
			int underlyingsNeed = formTeam.formForBad();
			System.out.println("反派开始上战场……");
			oneBattleField.standOn(formTeam.oneScorpion);
			for(int j = 0; j < underlyingsNeed; j++) {
				oneBattleField.standOn(formTeam.severalUnderlying[j]);
			}
			System.out.println("蛇精呐喊助威……");
			oneBattleField.standOn(formTeam.oneSnake);
			oneBattleField.show();
		}
		return;
	}
}
