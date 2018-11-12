/*
 * 以造世主的角度，创建双方上场的战士，并将其组织放入战场中。
 * @see class FightFileld, class Formation, Class Team.
 * @author why
 * @Time 2018-11-5
 * @version 2.0
 * 
 * version 3.0 修改建议：
 * 修改目标，用collection来完善这个葫芦娃的程序       finished
 * 选取更合适的collection，将已有的实现用自带的方法实现    finished
 * 增加乱序操作和排序操作，使得程序更加符合要求 undo
 * 增加Interface
 * 
 * */

package javahw3;
//import java.util.ArrayList;
import java.util.Scanner;

public class FightField {
	/*
	 * 程序主要的执行入口，在此类中导入战场，加入战士，选择阵型，显示战场信息.
	 * <p>
	 *     在此类中生成Warrior的成员，作为参与战斗的主体成员<br>
	 *     此类中还用到的Team类的成员以及Formation类的成员<br>
	 *     所有的执行性动作在本类中完成。<br>
	 * @param true: 正确, false: 错误
	 * @return： boolean 
	 * */
	private static final int N = 15;
	public Warrior[][] fields;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		FightField ff = new FightField();
		//登录每队的战士，并且显示其基本信息
		Team teamGood = new Team("GoodMan");
		Team teamBad = new Team("BadMan");
		loading(teamGood, teamBad);
		try {
			teamGood.checkMember();
			teamBad.checkMember();
		}catch(MyException e) {
		}
		teamGood.showWarriors();
		teamBad.showWarriors();
		//初始化阵型
		Formation.initialization();
		/*-----------------------ROUND 1------------------------*/
		System.out.println("ROUND1");
		ff.round(teamGood, teamBad, in);
		ff.showFields();
		
		System.out.println();
		/*-----------------------ROUND 2------------------------*/
		ff.initialization();
		System.out.println("ROUND2");
		ff.round(teamGood, teamBad, in);
		ff.showFields();
		
		in.close();
		
		teamGood.showWarriors();
		teamBad.showWarriors();
	}
	//Constructor
	private FightField() {
		initialization();
	}

	private void initialization() {
		fields = new Warrior[N][N];
	}
	
	private static void loading(Team teamGood, Team teamBad) {
		System.out.println("创建即将上场进行对决的对象......");
		String name = "大二三四五六七";
		for (int i=0; i<7; i++) {
			teamGood.add(new CalabashBrothers(name.charAt(i) + "娃", ""));
		}
		teamGood.add(new Warrior("老爷爷", "看戏", teamBad.getSide()));
		teamBad.add(new Warrior("蝎子精", "领队", teamBad.getSide()));
		for (int i=0; i<5; i++) {
			teamBad.add(new Warrior("小兵"+i, "冲锋", teamBad.getSide()));
		}
		teamBad.add(new Warrior("小兵"+6, "冲锋", teamGood.getSide()));
		teamBad.add(new Warrior("蛇精", "看戏", teamBad.getSide()));
		// 此处需要一个打乱顺序的操作以及一个排序操作
		// 但Java中能不能够像C++那样自定义排序？
	}
	
	// show the fields
	private void showFields() {
		System.out.println("***************************************************战场对阵情况****************************************************");
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if(fields[i][j]==null)
					System.out.print("---");
				else
					System.out.print(fields[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
		System.out.println("***************************************************战场对阵情况****************************************************");
	}
	
	//将双方的武将送上战场
	private void goBattle(Team team, int[][] place) {
		team.goBattle(fields, place);
	}
	
	//自定义选择双方的阵型
	private void round(Team teamGood, Team teamBad, Scanner in) {
		System.out.println("************双方战士上场*************");
		System.out.println("********请选择妖精上场的阵型*********");
		System.out.println("**********0----------长蛇阵**********");
		System.out.println("**********1----------雁形阵**********");
		System.out.println("**********2----------鹤翼阵**********");
		System.out.println("**********3----------冲轭阵**********");
		int f1 = -1;
		// deal with the error: index out of bounds
		this.goBattle(teamGood, Formation.getForm(0, 1));
		try {
			f1 = in.nextInt();
			this.goBattle(teamBad, Formation.getForm(f1, 2));
		}catch( IndexOutOfBoundsException e){
			System.out.println("your input is out of bound! please input again!");
			f1 = in.nextInt();
			this.goBattle(teamBad, Formation.getForm(f1, 2));
		}
	}
}


