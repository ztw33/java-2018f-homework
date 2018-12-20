public class Battle {
    // 每个位置的下标代表生物体的下标
    private int [][]map;

    private final int SIZE = 12;

    //0 爷爷, 1~7 葫芦娃, 8 蝎子精 剩余小喽啰
    private Creature[] creatures;

    // 生物体总数
    private final int N = 30;

    // 初始化所有生物 定位爷爷和蝎子精
    Battle() {
        // 构建生物体
        creatures = new Creature[N];
        creatures[0] = new Grandpa();
        for (int i = 0; i < 7; i++) {
            creatures[i + 1] = new Huluwa(i);
        }
        creatures[8] = new SheJing();
        creatures[9] = new XieziJing();
        for (int i = 10; i < N; i++) {
            creatures[i] = new Louluo();
        }

        // 位置初始化
        map = new int[SIZE][];
        for (int i = 0; i < SIZE; i++) {
            map[i] = new int[SIZE];
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = -1;
            }
        }

        //爷爷
        map[0][2] = 0;

        // 蝎子精
        map[0][8] = 8;
    }

    // 打印
    void print() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] != -1 && map[i][j] < N) {
                    System.out.print(creatures[map[i][j]].getType());
                }
                else {
                    System.out.print("   ");
                }
            }
            System.out.print("\n");
        }
    }

    // 葫芦娃 随机排列
    void huluwaRandom() {
        int startLine = 3, startCol = 2;
        int[] arguement = {1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < 7; i++) {
            int a = (int)(Math.random() * 7);
            int b = (int)(Math.random() * 7);
            int tmp = arguement[a];
            arguement[a] = arguement[b];
            arguement[b] = tmp;
        }
        for (int i = startLine; i < startLine + 7; i++) {
            map[i][startCol] = arguement[i - startLine];
        }
    }

    // 清空并且重新初始化
    private void clearAndSet() {
        for (int i = 1; i < SIZE; i++) {
            for (int j = 4; j < SIZE; j++) {
                map[i][j] = -1;
            }
        }
    }

    // 鹤翼
    void heyi() {
        clearAndSet();
        int startRow = 4, startCol = 5;
        int j = 9; // 第一个喽啰的index
        for (int i = startRow; i < startRow + 4; i++) {
            map[i][startCol + i - startRow] = j++;
            map[i][startCol + startRow + 6 - i] = j++;
        }
    }

    // 雁行
    void yanxing() {
        clearAndSet();
        int startRow = 4, startCol = 10;
        int j = 9;
        for (int i = startRow; i < startRow + 5; ++i) {
            map[i][startCol - i + startRow] = j++;
        }
    }

    // 衡轭
    void henge() {
        clearAndSet();
        int startRow = 3, startCol = 7;
        int j = 9;
        for (int i = startRow; i < startRow + 6; i++) {
            map[i][startCol + (i - startRow + 1) % 2] = j++;
        }
    }

    // 长蛇
    void changshe() {
        clearAndSet();
        int startRow = 3, startCol = 8;
        int j = 9;
        for (int i = startRow; i < startRow + 7; i++) {
            map[i][startCol] = j++;
        }
    }

    // 鱼鳞
    void yulin() {
        clearAndSet();
        int startRow = 4, startCol = 5;
        int j = 9;
        for (int i = startRow; i < startRow + 4; i++) {
            for (int k = 0; k < (i - startRow) * 2 + 1; k++) {
                map[i][startRow + startCol + 3 - i + k] = j++;
            }
        }
        map[startRow + 4][startCol + 2] = map[startRow + 1][startCol + 2];
        map[startRow + 1][startCol + 2] = -1;
        map[startRow + 4][startCol + 3] = map[startRow + 1][startCol + 3];
        map[startRow + 1][startCol + 3] = -1;
    }

    // 方円
    void fangyuan() {
        clearAndSet();
        int startRow = 4, startCol = 6;
        int j = 9;
        map[startRow][startCol + 2] = j++;
        for (int i = startRow + 1; i < startRow + 5; i++) {
            map[i][startCol + Math.abs(i - startRow - 2)] = j++;
            map[i][startCol + 4 - Math.abs(i - startRow - 2)] = j++;
        }
    }

    // 偃月
    void yanyue() {
        clearAndSet();
        int startRow = 2, startCol = 6;
        int j = 9;
        for (int i = startRow; i < startRow + 4; i++) {
            map[i][startCol + startRow + 3 - i] = j++;
            map[i + 1][startCol + startRow + 3 - i] = j++;
        }
        for (int i = startRow + 4; i < startRow + 8; i++) {
            map[i][startCol + i - startRow - 4] = j++;
            map[i + 1][startCol + i - startRow - 4] = j++;
        }
        map[startRow + 4][startCol + 1] = j;
    }

    // 锋矢
    void fengshi() {
        clearAndSet();
        int startRow = 3, startCol = 5;
        int j = 9;
        map[startRow][startCol + 3] = j++;
        for (int i = startRow + 1; i < startRow + 4; i++) {
            map[i][startCol + i - startRow + 3] = j++;
            map[i][startCol + startRow + 3 - i] = j++;
        }
        for (int i = startRow + 1; i < startRow + 7; i++) {
            map[i][startCol + 3] = j++;
        }
    }




}
