package hw3.space;

import hw3.creature.*;

public class BattleField {
    private Block[][] battlefield;
    private final int N = 12;
    public BattleField() {
        battlefield = new Block[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                battlefield[i][j] = new Block();
            }
        }
    }

    public void clearBattleFiled() {
        for (int i = 0; i < N; i++) {
            for (int j = 5; j < N; j++) {
                if (battlefield[i][j].showCreature() instanceof Loluo) {
                    battlefield[i][j].eraseCreature();
                }
            }
        }
    }

    public void printBattleField() {
        System.out.println("------------------------------------------------");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (battlefield[i][j].showCreature() != null)
                    System.out.print(battlefield[i][j].showCreature().printName());
                else
                    System.out.print("    ");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------");
    }

    public void changShe(Creature[] creatures) {
        for (int i = 0; i < creatures.length; i++) {
            battlefield[i+2][2].putCreature(creatures[i]);
        }
    }

    public void heYi(Creature[] creatures) {
        for (int i = 0; i < 4; i++) {
            battlefield[i+4][i+5].putCreature(creatures[i]);
        }
        for (int i = 0; i < 3; i++) {
            battlefield[6-i][i+9].putCreature(creatures[i+4]);
        }
    }

    public void yanXing(Creature[] creatures) {
        for (int i = 0; i < 8; i++) {
            battlefield[i][11-i].putCreature(creatures[i]);
        }
    }

    public void chongE(Creature[] creatures) {
        for (int i = 0; i < 8; i += 2) {
            battlefield[2+i][7].putCreature(creatures[i]);
            battlefield[3+i][8].putCreature(creatures[i+1]);
        }
    }

    public void yuLin(Creature[] creatures) {
        battlefield[4][8].putCreature(creatures[0]);
        battlefield[5][9].putCreature(creatures[1]);
        battlefield[6][6].putCreature(creatures[2]);
        battlefield[6][8].putCreature(creatures[3]);
        battlefield[6][10].putCreature(creatures[4]);
        battlefield[7][5].putCreature(creatures[5]);
        battlefield[7][7].putCreature(creatures[6]);
        battlefield[7][9].putCreature(creatures[7]);
        battlefield[7][11].putCreature(creatures[8]);
        battlefield[8][8].putCreature(creatures[9]);
    }

    public void fangYuan(Creature[] creatures) {
        battlefield[3][8].putCreature(creatures[0]);
        int cnt = 1;
        for (int i = 1; i < 3; i++) {
            battlefield[3+i][8-i].putCreature(creatures[cnt++]);
            battlefield[3+i][8+i].putCreature(creatures[cnt++]);
        }
        battlefield[6][7].putCreature(creatures[cnt++]);
        battlefield[6][9].putCreature(creatures[cnt++]);
        battlefield[7][8].putCreature(creatures[cnt++]);
    }

    public void putGrandpa(Grandpa grandpa) {
        battlefield[5][0].putCreature(grandpa);
        grandpa.cheer();
    }

    public void putSnake(Snake snake) {
        battlefield[9][11].putCreature(snake);
        snake.cheer();
    }

    public void putScorpion(Scorpion scorpion) {
        battlefield[10][11].putCreature(scorpion);
    }
}
