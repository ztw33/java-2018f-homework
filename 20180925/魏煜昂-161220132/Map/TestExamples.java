package Map;

import java.util.Map;
import java.util.Scanner;

public class TestExamples {
    public static void main(String[] args) {
        Scanner scan_input = new Scanner(System.in);
        int calabashtype = 1;
        int enemytype = 1;
        Graph g = new Graph();
        while (true) {
            System.out.println("请输入需要形成的葫芦娃阵列：1.鹤翼；2.雁行；3.横轭；4.长蛇。");
            calabashtype = scan_input.nextInt();
            g.setCalabash(calabashtype);
            g.printMap();

            System.out.println("请输入需要形成的妖精阵列：1.鹤翼；2.雁行；3.横轭；4.长蛇；5.鱼鳞。");
            enemytype = scan_input.nextInt();
            g.setEnemy(enemytype);
            g.printMap();
            g.clearMap();
        }
    }
}
