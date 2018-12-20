import java.util.Vector;

//30x30
public class HuLuBattle {
    private int row;
    private int col;
    //  private Vector<Space> spaces = new Vector<Space>(10);
    private boolean[][] place;
    private String[][] lives;

    Leader yeye=new YeYe();
    Leader sj=new SJ();
    //YeYe yeye = new YeYe();
    //SJ sj = new SJ();

    HuLuBro[] bro = {HuLuBro.RED, HuLuBro.YELLOW, HuLuBro.GREEN, HuLuBro.ORANGE, HuLuBro.CYAN, HuLuBro.BLUE, HuLuBro.PURPLE};
    Enemy[] enemy = {Enemy.XZJ, Enemy.XLL1, Enemy.XLL2, Enemy.XLL3, Enemy.XLL4, Enemy.XLL5, Enemy.XLL6, Enemy.XLL7, Enemy.XLL8};

    public HuLuBattle(int row, int col) {
        this.row = row;
        this.col = col;
        place = new boolean[row][col];//长宽设置，可以设置为作为参数修改
        lives = new String[row][col];//长宽设置，可以设置为作为参数修改
        //clean初始化
        clean();

        //爷爷and葫芦娃，可以改变位置，现在先不改，仅做初始化
        //蛇精and蝎子精and小喽啰，改变阵法
        //set();

        //        for (i = 0; i < bro.length; i++) {
//            spaces.addElement(bro[i].getSpace());
//            lives[bro[i].getX()][bro[i].getY()] = bro[i].getName();
//        }

//        spaces.addElement(sj.getSpace());
//        lives[sj.getX()][sj.getY()] = sj.getName();
//        for (i = 0; i < enemy.length; i++) {
//            spaces.addElement(enemy[i].getSpace());
//            lives[enemy[i].getX()][enemy[i].getY()] = enemy[i].getName();
//        }

    }

    public void clean() {
        int i = 0, j = 0;
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                place[i][j] = false;
            }
        }
    }

    public void set() {
        //set place and live(name)
        int i = 0, x = 0, y = 0;
        x = yeye.getX();
        y = yeye.getY();
        place[x][y] = true;
        lives[x][y] = yeye.getName();

        for (i = 0; i < bro.length; i++) {
            x = bro[i].getX();
            y = bro[i].getY();
            place[x][y] = true;
            lives[x][y] = bro[i].getName();
        }

        x = sj.getX();
        y = sj.getY();
        place[x][y] = true;
        lives[x][y] = sj.getName();

        for (i = 0; i < enemy.length; i++) {
            x = enemy[i].getX();
            y = enemy[i].getY();
            place[x][y] = true;
            lives[x][y] = enemy[i].getName();
        }

    }

    public void change(int no) {
        if (no == 0) {
            System.out.print("雁行阵\n");
            enemy[0].setSpace(0, 6);
            enemy[1].setSpace(1, 7);
            enemy[2].setSpace(2, 8);
            enemy[3].setSpace(3, 9);
            enemy[4].setSpace(4, 10);
            enemy[5].setSpace(5, 11);
            enemy[6].setSpace(6, 12);
            enemy[7].setSpace(7, 13);
            enemy[8].setSpace(8, 17);
        }
        else if(no==1) {
            System.out.print("鹤翼阵\n");
            enemy[1].setSpace(0, 6);
            enemy[2].setSpace(1, 7);
            enemy[3].setSpace(2, 8);
            enemy[4].setSpace(3, 9);
            enemy[0].setSpace(4, 10);
            enemy[5].setSpace(3, 11);
            enemy[6].setSpace(2, 12);
            enemy[7].setSpace(1, 13);
            enemy[8].setSpace(0, 14);

        }
        else if(no==2){
            System.out.print("锋矢阵\n");
            enemy[1].setSpace(2, 6);
            enemy[2].setSpace(1, 7);
            enemy[3].setSpace(0, 8);
            enemy[4].setSpace(1, 8);
            enemy[0].setSpace(2, 8);
            enemy[5].setSpace(3, 8);
            enemy[6].setSpace(4, 8);
            enemy[7].setSpace(1, 9);
            enemy[8].setSpace(2, 10);

        }
        //
    }

    public void printIt0(int no) {
        int i = 0, j = 0;
        //做打印准备
        change(no);
        set();
        //打印
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                if (place[i][j])
                    System.out.print(lives[i][j]);
                else
                    System.out.print(" ");
            }
            System.out.print("\n");
        }
        clean();

    }

    public static void main(String[] args) {

        HuLuBattle battle = new HuLuBattle(10, 20);
        //雁行
        battle.printIt0(0);
        //鹤翼
        battle.printIt0(1);
        //锋矢
        battle.printIt0(2);
    }

}
