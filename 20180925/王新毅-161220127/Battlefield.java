import java.util.Random;

enum Type {CALABASH, GRANNDPA, SCORPION, SNAKE, MINIONS, NONEXISTENET}
class Creature{
    public Type type;
    public boolean flag;
    public String name;
    Creature(){
        this.type = Type.NONEXISTENET;
        this.flag = false;
    }
    public void printinfo(){
        System.out.print("口口");
    }
}

enum Color{红色, 橙色, 黄色, 绿色,  青色, 蓝色, 紫色}
enum Rank{老大, 老二, 老三, 老四, 老五, 老六, 老七}

class Brothers extends Creature{
    private Rank rank;
    private Color color;
    Brothers(int ranking) {
        String []Names = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
       this.type = Type.CALABASH;
       this.flag = true;
       this.name = Names[ranking-1];
        Color[] values = Color.values();
        Rank[] ranks = Rank.values();
        this.color = values[ranking - 1];
        this.rank = ranks[ranking - 1];
    }
    public Rank GetRank() {
        return this.rank;
    }

    public Color GetColor() {
        return this.color;
    }
    public String Getname(){return this.name;}
    @Override
    public void printinfo(){
        System.out.print(this.name);
    }
}
class CalabashBrothers {
    private final int NUM = 7;
    public Brothers[] brothers = new Brothers[NUM];

    CalabashBrothers() {
        for (int i = 0; i < NUM; i++) {
            brothers[i] = new Brothers(i + 1);
        }
    }

    public void RandomArray() {
        Random random = new Random();
        for (int i = NUM - 1; i >= 0; i--) {
            int index = random.nextInt(i + 1);
            Brothers temp = brothers[i];
            brothers[i] = brothers[index];
            brothers[index] = temp;
        }
    }

    public void BubbleSort() {
        for (int i = 0; i < NUM - 1; i++)
            for (int j = 0; j < NUM - 1 - i; j++) {
                if (brothers[j].GetRank().ordinal() > brothers[j + 1].GetRank().ordinal()) {
                    Brothers temp = brothers[j];
                    brothers[j] = brothers[j + 1];
                    brothers[j + 1] = temp;
                }
            }
    }
    public void ShowRank(){
        for(int i = 0; i < NUM; i++){
            System.out.print(brothers[i].GetRank() + " ");
        }
        System.out.print("\n");
    }
}

class Grandpa extends Creature{
    Grandpa(){
        this.type = Type.GRANNDPA;
        this.flag = true;
        this.name = "爷爷";
    }
    @Override
    public void printinfo(){
        System.out.print(this.name);
    }
}

class Scorpion extends Creature{
    Scorpion(){
        this.type = Type.SCORPION;
        this.flag = true;
        this.name = "蝎子";
    }
    @Override
    public void printinfo(){
        System.out.print(this.name);
    }
}

class Snake extends Creature{
    Snake(){
        this.type = Type.SNAKE;
        this.flag = true;
        this.name = "蛇精";
    }
    @Override
    public void printinfo(){
        System.out.print(this.name);
    }
}

class Minions extends Creature{
    Minions(){
        this.type = Type.MINIONS;
        this.flag = true;
        this.name = "喽啰";
    }
    @Override
    public void printinfo(){
        System.out.print(this.name);
    }
}


class Block{
    public Creature creature;
    public boolean empty;
    Block(){
        creature = new Creature();
        empty = true;
    }
    public void init(){
        creature = new Creature();
        empty = true;
    }
    public boolean put(Creature crea){
        if(this.empty){
            this.creature = crea;
            this.empty = false;
            return true;
        }
        else
            return false;
    }
    public void print(){
        this.creature.printinfo();
    }
}

enum Shape{鹤翼, 雁行, 衡轨, 鱼鳞, 方门, 偃月, 锋矢,长蛇}
class Troop{
    public Shape shape;
    public int num;
    public int length;
    public int width;
    public int []x = new int[30];
    public int []y = new int[30];
    Troop(){
      num = 0;
      length = 0;
      width = 0;
      for(int i = 0; i < 30;i ++){
          x[i] = -1;
          y[i] = -1;
      }
    }
}

class TroopArray{
    public Troop []troops = new Troop[8];
    TroopArray() {
        for (int i = 0; i < 8; i++) {
            troops[i] = new Troop();
        }
        int []shapex0 = {0, 1, 2, 3, 2, 1, 0};
        int []shapey0 = {0, 1, 2, 3, 4, 5, 6};
        troops[0].shape =  Shape.values()[0];
        troops[0].num = 7;
        troops[0].length = 4;
        troops[0].width = 7;
        System.arraycopy(shapex0, 0, troops[0].x, 0, 7);
        System.arraycopy(shapey0, 0, troops[0].y, 0, 7);

        int []shapex1 = {0, 1, 2, 3, 4};
        int []shapey1 = {0, -1, -2, -3, -4};
        troops[1].shape = Shape.values()[1];
        troops[1].num = 5;
        troops[1].length = 5;
        troops[1].width = 5;
        System.arraycopy(shapex1, 0, troops[1].x, 0, troops[1].num);
        System.arraycopy(shapey1, 0, troops[1].y, 0, troops[1].num);

        int []shapex2 = {0, 1, 2, 3, 4, 5};
        int []shapey2 = {0, -1, 0, -1, 0, -1};
        troops[2].shape = Shape.values()[2];
        troops[2].num = 6;
        troops[2].length = 6;
        troops[2].width = 2;
        System.arraycopy(shapex2, 0, troops[2].x, 0, 6);
        System.arraycopy(shapey2, 0, troops[2].y, 0, 6);

        int []shapex3 = {0, 1, 2, 2, 2, 3, 3, 3, 3, 4};
        int []shapey3 = {0, 1, -1, 0, 1, -2, -1, 1, 2, 0};
        troops[3].shape = Shape.values()[3];
        troops[3].num = 10;
        troops[3].length = 5;
        troops[3].width = 5;
        System.arraycopy(shapex3, 0, troops[3].x, 0, troops[3].num);
        System.arraycopy(shapey3, 0, troops[3].y, 0, troops[3].num);

        int []shapex4 = {0, 1, 1, 2, 2, 3, 3, 4};
        int []shapey4 = {0, -1, 1, -2, 2, -1, 1, 0};
        troops[4].shape = Shape.values()[4];
        troops[4].num = 8;
        troops[4].length = 5;
        troops[4].width = 5;
        System.arraycopy(shapex4, 0, troops[4].x, 0, 8);

        System.arraycopy(shapey4, 0, troops[4].y, 0, 8);

        int []shapex5 = {0, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 7, 7, 8};
        int []shapey5 = {0, -2, -1, -3, -2, -4, -3, -2, -4, -3, -2, -4, -3, -2, -3, -2, -2, -1, 0};
        troops[5].shape = Shape.values()[5];
        troops[5].num = 19;
        troops[5].length = 9;
        troops[5].width = 5;
        System.arraycopy(shapex5, 0, troops[5].x, 0, 19);
        System.arraycopy(shapey5, 0, troops[5].y, 0, 19);

        int []shapex6 = {0, 1, 1, 2, 3, 3, 4, 5, 5, 6, 7, 8};
        int []shapey6 = {0, -1, 1, 0, -2, 2, 0, -3, 3, 0, 0, 0};
        troops[6].shape = Shape.values()[6];
        troops[6].num = 12;
        troops[6].length = 9;
        troops[6].width = 7;
        System.arraycopy(shapex6, 0, troops[6].x, 0, troops[6].num);
        System.arraycopy(shapey6, 0, troops[6].y, 0, troops[6].num);

        int []shapex7 = {0, 1, 2, 3, 4, 5, 6};
        int []shapey7 = {0, 0, 0, 0, 0, 0, 0};
        troops[7].shape = Shape.values()[7];
        troops[7].num = 7;
        troops[7].length = 7;
        troops[7].width = 1;
        System.arraycopy(shapex7, 0, troops[7].x, 0, troops[7].num);
        System.arraycopy(shapey7, 0, troops[7].y, 0, troops[7].num);
    }
    public Troop choose(int i) {
        return troops[i];
    }
}

public class Battlefield {
    private CalabashBrothers calabash;
    private Grandpa grandpa;
    private Scorpion scorpion;
    private Snake snake;
    private Minions minion;
    private final int N = 20;
    private Block [][]battlefield = new Block[N][N];
    private TroopArray trooparray;

    Battlefield(){
        calabash = new CalabashBrothers();
        grandpa = new Grandpa();
        scorpion = new Scorpion();
        snake = new Snake();
        minion = new Minions();
        trooparray = new TroopArray();

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                battlefield[i][j] = new Block();
            }
        }
    }
    public void init(){
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                battlefield[i][j].init();
            }
        }
    }

    public void Calabashtroop(int x, int y){

        Troop temp = trooparray.choose(7);
        for(int i = 0; i < 7; i ++){
            battlefield[x+temp.x[i]][y+temp.y[i]].put(calabash.brothers[i]);
        }
        int grand_x,grand_y;
        grand_y = y + temp.width/2;
        if(x+temp.length/2 > 9)
            grand_x = x - 3;
        else
            grand_x = x + temp.length + 3;
        battlefield[grand_x][grand_y].put(grandpa);

    }
    public void Monstertroop(int x, int y, int select){

        Troop temp = trooparray.choose(select);

        battlefield[x][y].put(scorpion);
        for(int i = 1; i < temp.num; i ++){

            battlefield[x+temp.x[i]][y+temp.y[i]].put(minion);
        }

        int snake_x,snake_y;

        snake_y = y;

        if(x+temp.length/2 > 9)
            snake_x = x - 3;
        else
            snake_x = x + temp.length + 3;

        battlefield[snake_x][snake_y].put(snake);
    }

    public void Showbattle(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j ++){
                battlefield[i][j].print();
            }
            System.out.print("\n");
        }

    }
    public static void main(String[] args) {
        Battlefield p = new Battlefield();
        p.calabash.RandomArray();
        p.calabash.ShowRank();
        p.calabash.BubbleSort();
        p.calabash.ShowRank();
        int calax,calay;
        int scorx, scory;
        Random random = new Random();
        calax =  random.nextInt(10)+1;
        calay = 6;
        int select_shape = random.nextInt(6);

        TroopArray shape = new TroopArray();
        scory = 19 -calay;
        scorx = calax + shape.troops[7].length/2 - shape.troops[select_shape].length/2;

        p.Calabashtroop(calax, calay);
        p.Monstertroop(scorx, scory, select_shape);
        p.Showbattle();
        System.out.print("\n\n");
        p.init();
        select_shape = (select_shape+1)%7;
        scorx = 0;
        scorx = calax + shape.troops[7].length/2 - shape.troops[select_shape].length/2;
        p.Calabashtroop(calax, calay);
        p.Monstertroop(scorx, scory, select_shape);
        p.Showbattle();
    }

}
