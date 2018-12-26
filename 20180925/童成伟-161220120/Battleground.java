package home3;

public class Battleground {
	
	private int size;//大小
	private Space ground[][];//二维数组表示空间位置
	
	
	private CalabashBro calabashbro;
	private Grandpa grandpa;
	private Snake snake;
	private Scorpion scorpion;
	private Minion minions[];
	
	public Battleground(int n) {//初始化
		size = n;
		ground = new Space[n][n];
		
		calabashbro = new CalabashBro();
		grandpa = new Grandpa(n/2,1);
		snake = new Snake(n/2,n-2);
		scorpion = new Scorpion();
		minions = new Minion[6];
		for(int i = 0; i <6; i++)
			minions[i] = new Minion();
		
		for(int i = 0; i < n;i++) {
			for(int j = 0; j < n;j++) {
				ground[i][j] = new Space(i, j);
			}
		}
	}
	
	public int getsize() {
		return size;
	}
	
	public Scorpion getscorpion() {
		return scorpion;
	}
	
	public void printbattle() {
		for(int i=0; i < size;i++) {
			System.out.print("*——————\t");//打印边界
		}
		System.out.println();
		for(int i=0; i < size;i++) {
			//System.out.print("|"+"\t");
			System.out.print("|");
			for(int j = 0; j <size;j++) {
				if(!ground[i][j].isEmpty()) {
					System.out.print(ground[i][j].getcreature().getname()+"\t");
				}
				else
					System.out.print("\t");
			}
			System.out.print("|");
			System.out.println();
		}
		for(int i=0; i < size;i++) {
			//System.out.print("——\t");//打印边界
			System.out.print("*——————\t");//打印边界
		}
		System.out.println();
	}
	
	public void clearbattle() {
		for(int i=0; i < size;i++) {
			for(int j = 0; j <size;j++) {
				if(!ground[i][j].isEmpty()) {
					ground[i][j].getcreature().LeaveBattle(ground[i][j]);
				}
			}
		}
	}
	
	
	public static void main(String[] arg) {
		Battleground battle = new Battleground(17);
		Formation formation = new Formation();
		battle.calabashbro.messbro();
		System.out.println("葫芦兄弟抵达战场摆出长蛇阵：爷爷我们来保护你！");
		formation.initformation("长蛇", battle.grandpa, battle.calabashbro.bro, battle, battle.ground);
		battle.printbattle();
		
		System.out.println("蛇精带领蝎子精小喽啰抵达战场：抓住他们炼丹！");
		formation.initformation("鹤翼", battle.snake, battle.minions, battle, battle.ground);
		battle.printbattle();
		
		battle.clearbattle();
		//清理战场重新排序
		battle.calabashbro.CalabashBubble();

		/*while(true) {
			System.out.println("请选择新阵型");
			break;
			
		}*/
		
		formation.initformation("长蛇", battle.grandpa, battle.calabashbro.bro, battle, battle.ground);
		System.out.println("妖怪们变换阵型");
		formation.initformation("锋矢", battle.snake, battle.minions, battle, battle.ground);
		battle.printbattle();
		
		battle.clearbattle();
		formation.initformation("长蛇", battle.grandpa, battle.calabashbro.bro, battle, battle.ground);
		System.out.println("妖怪们变换阵型");
		formation.initformation("鱼鳞", battle.snake, battle.minions, battle, battle.ground);
		battle.printbattle();
	}
	
}
