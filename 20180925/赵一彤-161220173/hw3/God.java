package hw3;
import hw3.creature.*;
import hw3.space.BattleField;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class God {
    private BattleField battleField;
    private Huluwa[] hulubros;
    private Grandpa grandpa;
    private Snake snake;
    private Scorpion scorpion;
    private Loluo[] loluos;

    public static void main(String[] args) {
        God me = new God();
        me.sortHuluBros();
        me.embattle();
    }

    public God() {
        battleField = new BattleField();
        createHuluBros();
        grandpa = new Grandpa();
        createMonsters();
    }

    public void sortHuluBros() {
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                if (hulubros[i].rank() > hulubros[j].rank()) {
                    Huluwa tmp = hulubros[i];
                    hulubros[i] = hulubros[j];
                    hulubros[j] = tmp;
                }
            }
        }
        System.out.println("排序后的葫芦兄弟");
        for (int i = 0; i < 7; i++) {
            System.out.print(hulubros[i].printName() + " ");
        }
        System.out.println('\n' + "------------------------------------------------");
    }

    public void embattle() {
        System.out.println("开始列队 —— 方円阵");
        battleField.changShe(hulubros);
        battleField.fangYuan(loluos);
        battleField.putGrandpa(grandpa);
        battleField.putSnake(snake);
        battleField.putScorpion(scorpion);
        battleField.printBattleField();
        battleField.clearBattleFiled();
        System.out.println("开始列队 —— 雁行阵");
        battleField.yanXing(loluos);
        battleField.printBattleField();
    }

    private void createMonsters() {
        snake = new Snake();
        scorpion = new Scorpion();
        loluos = new Loluo[20];
        for (int i = 0; i < 20; i++)
            loluos[i] = new Loluo();
    }


    private void createHuluBros() {
        hulubros = new Huluwa[7];
        Random random = new Random();
        List list = new ArrayList();

        while (list.size() != 7) {
            int num = random.nextInt(7);
            if (!list.contains(num)) {
                hulubros[list.size()] = new Huluwa(num);
                list.add(num);
            }
        }

        System.out.println("随机站的葫芦兄弟");
        for (int i = 0; i < 7; i++) {
            System.out.print(hulubros[i].printName() + " ");
        }
        System.out.println();
    }

}
