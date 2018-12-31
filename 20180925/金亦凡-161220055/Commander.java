import java.util.Scanner;

public class Commander {
    private Creature[][] creatures = new Creature[12][12];

    private int[][] CalabashLocation = new int[7][2];
    private int[][] MinionLocation = new int[20][2];
    private int[][] ScorpionLocation = new int[1][2];
    private int MinionNum;

    private Commander() {
        for(int i = 0; i < 12; i++) {
            for(int j = 0; j < 12; j++) {
                creatures[i][j] = new Creature();
            }
        }
    }

    public static void main(String[] argv) {
        Commander commander = new Commander();
        commander.placeGrandpa();
        commander.placeSnake();
        commander.placeCalabash();
        commander.battleArray(6);
        commander.printBattleField();
        commander.battleArray();
        commander.printBattleField();
    }

    private void placeGrandpa() {
        creatures[11][0] = new Grandpa();
    }

    private void placeSnake() {
        creatures[11][11] = new Snake();
    }

    private void placeCalabash() {
        int CalabashTemp[][] = {{2, 2}, {3, 2}, {4, 2}, {5, 2}, {6, 2}, {7, 2}, {8, 2}};
        Huluwa[] huluwas = Huluwa.values();
        for(int i = 0; i < 7; i++) {
            CalabashLocation[i][0] = CalabashTemp[i][0];
            CalabashLocation[i][1] = CalabashTemp[i][1];
            creatures[CalabashLocation[i][0]][CalabashLocation[i][1]] = new Calabash(huluwas[i]);
        }
    }

    private void deleteArray() {
        this.creatures[ScorpionLocation[0][0]][ScorpionLocation[0][1]] = new Creature();
        for(int i = 0; i < MinionNum; i++) {
            this.creatures[MinionLocation[i][0]][MinionLocation[i][1]] = new Creature();
        }
    }

    private void chooseArray(int n) {
        switch(n) {
            case 1:
                this.HeYi(); break;
            case 2:
                this.YanXing(); break;
            case 3:
                this.ChongE(); break;
            case 4:
                this.YuLin(); break;
            case 5:
                this.FangYuan(); break;
            case 6:
                this.YanYue(); break;
            case 7:
                this.FengShi(); break;
            default:
                break;
        }
    }

    private void battleArray() {
        this.deleteArray();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入阵型：1鹤翼，2雁行，3冲轭，4鱼鳞，5方圆，6偃月，7锋矢。");
        int n = input.nextInt();
        this.chooseArray(n);
        this.creatures[ScorpionLocation[0][0]][ScorpionLocation[0][1]] = new Scorpion();
        for(int i = 0; i < MinionNum; i++)
            this.creatures[MinionLocation[i][0]][MinionLocation[i][1]] = new Minion();
    }

    private void battleArray(int n) {
        this.chooseArray(n);
        this.creatures[ScorpionLocation[0][0]][ScorpionLocation[0][1]] = new Scorpion();
        for(int i = 0; i < MinionNum; i++)
            this.creatures[MinionLocation[i][0]][MinionLocation[i][1]] = new Minion();
    }

    private void printBattleField() {
        System.out.println("当前对峙情形如下：");
        for(int i = 0; i < 12; i++) {
            for(int j = 0; j < 12; j++) {
                creatures[i][j].Print();
            }
            System.out.print('\n');
        }
    }

    private void HeYi() {
        ScorpionLocation[0][0] = 7;
        ScorpionLocation[0][1] = 8;
        MinionNum = 6;
        int MinionTemp[][] = {{6, 7}, {5, 6}, {4, 5}, {6, 9}, {5, 10}, {4, 11}};
        for(int i = 0; i < MinionNum; i++) {
            MinionLocation[i][0] = MinionTemp[i][0];
            MinionLocation[i][1] = MinionTemp[i][1];
        }
    }

    private void YanXing() {
        ScorpionLocation[0][0] = 5;
        ScorpionLocation[0][1] = 8;
        MinionNum = 6;
        int MinionTemp[][] = {{6, 7}, {7, 6}, {8, 5}, {4, 9}, {3, 10}, {2, 11}};
        for(int i = 0; i < MinionNum; i++) {
            MinionLocation[i][0] = MinionTemp[i][0];
            MinionLocation[i][1] = MinionTemp[i][1];
        }
    }

    private void ChongE() {
        ScorpionLocation[0][0] = 5;
        ScorpionLocation[0][1] = 9;
        MinionNum = 6;
        int MinionTemp[][] = {{4, 8}, {3, 9}, {2, 8}, {6, 8}, {7, 9}, {8, 8}};
        for(int i = 0; i < MinionNum; i++) {
            MinionLocation[i][0] = MinionTemp[i][0];
            MinionLocation[i][1] = MinionTemp[i][1];
        }
    }

    private void YuLin() {
        ScorpionLocation[0][0] = 5;
        ScorpionLocation[0][1] = 8;
        MinionNum = 10;
        int MinionTemp[][] = {{5, 7}, {5, 9}, {6, 6}, {6, 7}, {6, 8}, {6, 9}, {6, 10}, {7, 8}, {4, 8}, {3, 7}};
        for(int i = 0; i < MinionNum; i++) {
            MinionLocation[i][0] = MinionTemp[i][0];
            MinionLocation[i][1] = MinionTemp[i][1];
        }
    }

    private void FangYuan() {
        ScorpionLocation[0][0] = 5;
        ScorpionLocation[0][1] = 8;
        MinionNum = 8;
        int MinionTemp[][] = {{3, 8}, {4, 9}, {5, 10}, {6, 9}, {7, 8}, {6, 7}, {5, 6}, {4, 7}};
        for(int i = 0; i < MinionNum; i++) {
            MinionLocation[i][0] = MinionTemp[i][0];
            MinionLocation[i][1] = MinionTemp[i][1];
        }
    }

    private void YanYue() {
        ScorpionLocation[0][0] = 5;
        ScorpionLocation[0][1] = 6;
        MinionNum = 18;
        int MinionTemp[][] = {{5, 5}, {6, 5}, {6, 6}, {6, 7}, {5, 7}, {4, 7}, {4, 6}, {4, 5}, {3, 6}, {3, 7}, {7, 6}, {7, 7}, {2, 7}, {2, 8}, {8, 7}, {8, 8}, {1, 9}, {9, 9}};
        for(int i = 0; i < MinionNum; i++) {
            MinionLocation[i][0] = MinionTemp[i][0];
            MinionLocation[i][1] = MinionTemp[i][1];
        }
    }

    private void FengShi() {
        ScorpionLocation[0][0] = 2;
        ScorpionLocation[0][1] = 7;
        MinionNum = 12;
        int MinionTemp[][] = {{3, 6}, {4, 5}, {5, 4}, {3, 8}, {4, 9}, {5, 10}, {3, 7}, {4, 7}, {5, 7}, {6, 7}, {7, 7}, {8, 7}};
        for(int i = 0; i < MinionNum; i++) {
            MinionLocation[i][0] = MinionTemp[i][0];
            MinionLocation[i][1] = MinionTemp[i][1];
        }
    }
}
