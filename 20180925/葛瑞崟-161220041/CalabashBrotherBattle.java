
public class CalabashBrotherBattle {
    public static Creature[] creatures;
    public static final int NUM = 40;
    public static final int N = 15;
    public static void initialize(){
        creatures = new Creature[NUM];
        creatures[0] = new Grandpa();
        creatures[1] = new CalabashBrother(CalabashBrother.Feature.FIRST);
        creatures[2] = new CalabashBrother(CalabashBrother.Feature.SECOND);
        creatures[3] = new CalabashBrother(CalabashBrother.Feature.THIRD);
        creatures[4] = new CalabashBrother(CalabashBrother.Feature.FORTH);
        creatures[5] = new CalabashBrother(CalabashBrother.Feature.FIFTH);
        creatures[6] = new CalabashBrother(CalabashBrother.Feature.SIXTH);
        creatures[7] = new CalabashBrother(CalabashBrother.Feature.SEVENTH);
        creatures[8] = new Snake();
        creatures[9] = new Scorpion();
        for (int i = 10; i < NUM; i++)
            creatures[i] = new Creep();
    }
    public static void main(String[] args){
        initialize();
        BattleGround battleGround = new BattleGround();
        CalabashFormation CBformaiton = new CalabashFormation();
        MonsterFormation Mformation = new MonsterFormation();
        CBformaiton.Sort();
        Mformation.changeFormation(Formation.Name.HEYI);
        battleGround.deploy(CBformaiton, 0);
        battleGround.deploy(Mformation, 1);
        battleGround.print();

        Mformation.changeFormation(Formation.Name.YANXING);
        battleGround.deploy(Mformation, 1);
        battleGround.print();

        Mformation.changeFormation(Formation.Name.CHONGE);
        battleGround.deploy(Mformation, 1);
        battleGround.print();

        Mformation.changeFormation(Formation.Name.YULIN);
        battleGround.deploy(Mformation, 1);
        battleGround.print();

        Mformation.changeFormation(Formation.Name.FANGYUAN);
        battleGround.deploy(Mformation, 1);
        battleGround.print();

        Mformation.changeFormation(Formation.Name.YANYUE);
        battleGround.deploy(Mformation, 1);
        battleGround.print();

        Mformation.changeFormation(Formation.Name.FENGSHI);
        battleGround.deploy(Mformation, 1);
        battleGround.print();
        return;
    }
}

class Creature{
   // private static int max_id = 0;
    int id;
    char symbol;

    /*Creature(){
        id = max_id;
        max_id++;
    }*/
}

class CalabashBrother extends Creature{
    private Feature feature;
    enum Feature{
        FIRST("老大", "红色"), SECOND("老二", "橙色"), THIRD("老三", "黄色"),
        FORTH("老四", "绿色"), FIFTH("老五","青色"), SIXTH("老六", "蓝色"), SEVENTH("老七", "紫色");

        private String name;
        private String color;

        Feature(String name, String color){
            this.name = name;
            this.color = color;
        }
    }

    CalabashBrother(Feature feature){
        this.feature = feature;
        id = feature.ordinal() + 1;
        symbol = (char)(id + '0');
    }
}

class Grandpa extends Creature{
    Grandpa(){
        id = 0;
        symbol = 'G';
    }
}

class Snake extends Creature{
    Snake(){
        id = 8;
        symbol = 'S';
    }
}

class Scorpion extends Creature{
    Scorpion(){
        id = 9;
        symbol = 's';
    }
}

class Creep extends Creature{
    private static int start = 10;
    Creep(){
        id = start;
        start++;
        symbol = 'c';
    }
}

class Formation{
    protected int[][] formation;
    protected Name name;
    enum Name{
        HEYI(4, 7), YANXING(4, 4), CHONGE(2, 6), CHANGSHE(1, 7),
        YULIN(4, 5), FANGYUAN(5, 5), YANYUE(4, 9), FENGSHI(6, 5);

        protected int length, width;

        Name(int length, int width){
            this.length = length;
            this.width = width;
        }
    }
    protected void changeSize(Name name){
        this.name = name;
        formation = new int[name.width][name.length];
        for (int i = 0; i < name.width; i++)
            for (int j = 0; j < name.length; j++)
                formation[i][j] = -1;
    }
}

class CalabashFormation extends Formation{
    CalabashFormation(){
        changeSize(Name.CHANGSHE);
        random();
    }
    private boolean contains(int num) {
        for (int i = 0; i < name.width; i++) {
            if (formation[i][0] == num)
                return true;
        }
        return false;
    }
    private void random() {
        for (int i = 0; i < name.width; i++)
            formation[i][0] = -1;
        for (int i = 0; i < name.width; i++) {
            int num = (int) (Math.random() * 7 + 1);
            if (contains(num))
                i--;
            else {
                formation[i][0] = num;
                //brothers[num].rePos(i);
            }
        }
    }
    void Sort() {
        for (int i = 0; i < name.width - 1; i++){
            for (int j = 0; j < name.width - i - 1; j++){
                if (formation[j][0] > formation[j + 1][0]) {
                    System.out.println();
                    int temp = formation[j][0];
                    formation[j][0] = formation[j + 1][0];
                    formation[j + 1][0] = temp;
                }
            }
        }
    }
}

class MonsterFormation extends Formation{
    MonsterFormation(){
        changeSize(Name.HEYI);
    }
    void changeFormation(Name name){
        changeSize(name);
        int start = 10;
        switch (name){
            case HEYI:{
                formation[3][0] = 9;
                for (int i = 2, j = 1; j < name.length; i--, j++)
                    formation[i][j] = start++;
                for (int i = 4, j = 1; j < name.length; i++, j++)
                    formation[i][j] = start++;
                break;
            }
            case YANXING:{
                formation[3][0] = 9;
                for (int i = 2, j = 1; j < name.length; i--, j++)
                    formation[i][j] = start++;
                break;
            }
            case CHONGE:{
                formation[1][0] = 9;
                for (int i = 3, j = 0; i < name.width; i += 2)
                    formation[i][j] = start++;
                for (int i = 0, j = 1; i < name.width; i += 2)
                    formation[i][j] = start++;
                break;
            }
            case YULIN:{
                formation[2][0] = 9;
                for (int i = 1, j = 1, k = 0; k < 3; i++, k++)
                    formation[i][j] = start++;
                for (int i = 0, j = 2, k = 0; k < 5; i++, k++)
                    formation[i][j] = start++;
                formation[2][3] = start++;
                break;
            }
            case FANGYUAN:{
                formation[2][0] = 9;
                for (int i = 1, j = 1; i < name.width; i += 2)
                    formation[i][j] = start++;
                for (int i = 0, j = 2; i < name.width; i += 4)
                    formation[i][j] = start++;
                for (int i = 1, j = 3; i < name.width; i += 2)
                    formation[i][j] = start++;
                formation[2][4] = start++;
                break;
            }
            case YANYUE:{
                formation[4][0] = 9;
                for (int i = 3, j = 0; j < name.length; i--, j++)
                    formation[i][j] = start++;
                for (int i = 3, j = 1; j < name.length; i--, j++)
                    formation[i][j] = start++;
                for (int i = 5, j = 0; j < name.length; i++, j++)
                    formation[i][j] = start++;
                for (int i = 5, j = 1; j < name.length; i++, j++)
                    formation[i][j] = start++;
                formation[4][1] = start++;
                for (int i = 3, j = 2, k = 0; k < 3; i++, k++)
                    formation[i][j] = start++;
                break;
            }
            case FENGSHI:{
                formation[2][0] = 9;
                for (int i = 1, j = 1; i >= 0; i--, j++)
                    formation[i][j] = start++;
                for (int i = 2, j = 1; j < name.length; j++)
                    formation[i][j] = start++;
                for (int i = 3, j = 1; i < name.width; i++, j++)
                    formation[i][j] = start++;
                break;
            }
        }
    }
}

class BattleGround{
    private int[][] battleGround;
    BattleGround(){
        battleGround = new int[CalabashBrotherBattle.N][CalabashBrotherBattle.N];
        for (int i = 0; i < CalabashBrotherBattle.N; i++)
            for (int j = 0; j < CalabashBrotherBattle.N; j++)
                battleGround[i][j] = -1;
    }

    void deploy(Formation formation, int camp){
        if(camp == 0){
            for (int i = 4, m = 0; m < formation.name.width; i++, m++)
                for (int j = 3, n = 0; n < formation.name.length; j++, n++)
                    battleGround[i][j] = formation.formation[m][n];
        }else{
            for (int i = 0; i < CalabashBrotherBattle.N; i++)
                for (int j = 0; j < CalabashBrotherBattle.N; j++)
                    if (battleGround[i][j] >= 9)
                        battleGround[i][j] = -1;
            for (int i = 7 - formation.name.width / 2, m = 0; m < formation.name.width; i++, m++)
                for (int j = 11 - formation.name.length / 2, n = 0; n < formation.name.length; j++, n++)
                    battleGround[i][j] = formation.formation[m][n];
        }
        battleGround[14][0] = 0;
        battleGround[0][14] = 8;
    }

    void print(){
        System.out.println("-----------------------------------------");
        for (int i = 0; i < CalabashBrotherBattle.N; i++) {
            for (int j = 0; j < CalabashBrotherBattle.N; j++) {
                switch (battleGround[i][j]) {
                    case -1:
                        System.out.print("."); break;
                    default:
                        System.out.print(CalabashBrotherBattle.creatures[battleGround[i][j]].symbol);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------");
    }
}


