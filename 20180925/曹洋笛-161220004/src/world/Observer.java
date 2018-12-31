package world;

import java.util.Scanner;
import world.tools.*;

/* 超脱于世界系统之外的旁观者 */

public class Observer {

	public static void main(String[] args) {
		WorldMap world = new WorldMap();
		Scanner sc = new Scanner(System.in);
		while (true) {
			world.showWorld();
			System.out.println("请选择1/2/3/4/5（输入q退出）：");
			System.out.println("1. 移动葫芦娃");
			System.out.println("2. 移动妖怪");
			System.out.println("3. 移动老爷爷");
			System.out.println("4. 移动蛇精");
			System.out.println("5. 改变妖怪阵型");
			String cmd = sc.next();
			if (cmd.equals("q") || cmd.equals("\n")) break;
			if (cmd.equals("5")) {
				System.out.println("改变为以下哪种阵型？");
				System.out.println("1. 鹤翼阵；2. 雁行阵；3. 冲轭阵；4. 鱼鳞阵；5. 方円阵；6. 偃月阵；7. 锋矢阵；其他输入：退出");
				int choice = sc.nextInt();
				switch (choice) {
				case 1: world.setMonType(Types.HY); break;
				case 2: world.setMonType(Types.YX); break;
				case 3: world.setMonType(Types.CE); break;
				case 4: world.setMonType(Types.YL); break;
				case 5: world.setMonType(Types.FY); break;
				case 6: world.setMonType(Types.YY); break;
				case 7: world.setMonType(Types.FS); break;
				default: continue;
				}
			}
			else if (cmd.equals("1") || cmd.equals("2") || cmd.equals("3") || cmd.equals("4")) {
				System.out.print("垂直移动（向上负，向下正）：");
				int dr = sc.nextInt();
				System.out.print("水平移动（向左负，向右正）：");
				int dc = sc.nextInt();
				if (cmd.equals("1"))
					world.movBroPosition(dr, dc);
				else if (cmd.equals("2"))
					world.movMonPosition(dr, dc);
				else if (cmd.equals("3"))
					world.movEldPosition(dr, dc);
				else
					world.movSnkPosition(dr, dc);
			}
		}
		sc.close();
	}
}
