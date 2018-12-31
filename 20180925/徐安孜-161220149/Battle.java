import java.util.ArrayList;

interface CanCheer{
    void cheer();
}

class Creature{
    int hp;
    int atk;
    int def;
    int x,y;
    char symbol;
    Creature(){
        x=-1;
        y=-1;
    }
}

enum CalabashRank{
    FIRST(1,"老大",'赤'),
    SECOND(2,"老二",'橙'),
    THIRD(3,"老三",'黄'),
    FORTH(4,"老四",'绿'),
    FIFTH(5,"老五",'青'),
    SIXTH(6,"老六",'蓝'),
    SEVENTH(7,"老七",'紫');
    int id;
    String name;
    char color;
    CalabashRank(int a,String b , char c){
        id=a;
        name=b;
        color=c;
    }
}

class Calabash extends Creature {
    CalabashRank rank;
    Calabash(CalabashRank r){
        hp = 200;
        atk = 100;
        def = 100;
        rank = r;
        symbol=rank.color;
    }
}

class LittleMonster extends Creature {
    LittleMonster(){
        hp = 80;
        atk = 50;
        def = 50;
        symbol='喽';
    }
}

class Scorpion extends Creature {
    Scorpion(){
        hp = 100;
        atk = 80;
        def = 80;
        symbol='蝎';
    }
}

class Grandpa extends Creature
    implements CanCheer{
    Grandpa(){
        hp = 200;
        atk = 150;
        def = 180;
        symbol='爷';
    }
    public void cheer() {
        System.out.println("爷爷：孩子们加油！！！");
    }
}

class Snake extends Creature
    implements CanCheer{
    Snake(){
        hp = 200;
        atk = 150;
        def = 180;
        symbol='蛇';
    }
    public void cheer() {
        System.out.println("蛇精：小的们加油！！！");
    }
}

enum Formation{
    SNAKE(1,1,7,7),
    WING(2,4,7,7),
    SPEAR(3,6,5,12);
    final int snake[][]={{1},{1},{1},{1},{1},{1},{1}};
    final int wing[][]={{0,0,0,1},{0,0,1,0},{0,1,0,0},{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
    final int spear[][]={{0,0,1,1,0,0},{0,1,0,0,0,0},{1,1,1,1,1,1},{0,1,0,0,0,0},{0,0,1,1,0,0}};
    int arr[][];
    int length,width,num;//num is the number of characters required for the formation
    ArrayList<Creature> members;
    Formation(int index, int length,int width,int num){
        switch (index) {
            case 1:arr=snake;break;
            case 2:arr=wing;break;
            case 3:arr=spear;break;
        }
        this.length=length;
        this.width=width;
        this.num=num;
        this.members = new ArrayList<>();
    }
}

class Space{
    private int length,width;
    private Creature map[][];

    Space(int l,int w){
        length = l;
        width = w;
        map = new Creature[length][width];
        for(int i=0;i<13;i++)
            for(int j=0;j<13;j++)
                map[i][j]=null;
    }
    boolean Validation(int x,int y){
        return (map[x][y]==null && x<width && y<length);
    }
    void Display(){
        for(int i=0;i<width;i++) {
            for (int j = 0; j < length; j++) {
                if (map[i][j] != null)
                    System.out.print(map[i][j].symbol);
                else
                    System.out.print("□");
            }
            System.out.println();
        }
        System.out.println();
    }
    void CharacterEnterSpace(Creature c, int x, int y){
        map[x][y]=c;
    }
    void CharacterLeaveSpace(int x,int y){
        map[x][y]=null;
    }
}

class Manipulator {
    Scorpion CreateScorpion(){
        return new Scorpion();
    }
    LittleMonster CreateLittleMonster(){
        return new LittleMonster();
    }
    Grandpa CreateGoodBoss(){
        return new Grandpa();
    }
    Snake CreateBadBoss(){
        return new Snake();
    }
    Calabash[] CreateCalabashBrothers(){
        CalabashRank[] r= {
                CalabashRank.FIRST,
                CalabashRank.SECOND,
                CalabashRank.THIRD,
                CalabashRank.FORTH,
                CalabashRank.FIFTH,
                CalabashRank.SIXTH,
                CalabashRank.SEVENTH,
        };
        Calabash temp[]={
                new Calabash(r[2]),
                new Calabash(r[1]),
                new Calabash(r[5]),
                new Calabash(r[0]),
                new Calabash(r[3]),
                new Calabash(r[4]),
                new Calabash(r[6]),
        };
        return temp;
    }

    void Swap(Calabash[] brothers,int i,int j){
        Calabash temp = brothers[i];
        brothers[i]=brothers[j];
        brothers[j]=temp;
    }
    void CalabashSort(Calabash[] brothers){
        for(int i=0;i<brothers.length-1;i++)
            for(int j=0;j<brothers.length-1-i;j++) {
                if (brothers[j].rank.ordinal() > brothers[j+1].rank.ordinal()) {
                    Swap(brothers,j, j+1);
                }
            }
    }
    void PlaceCharacter(Space bf, Creature c, int x, int y){
        c.x=x;
        c.y=y;
        bf.CharacterEnterSpace(c,x,y);
    }
    void RemoveCharacter(Space bf, Creature c){
        bf.CharacterLeaveSpace(c.x,c.y);
        c.x=-1;
        c.y=-1;
    }
    void PlaceFormation(Space bf,Formation f,int x,int y){
        //(x,y)is the coordinate of the upper-left corner of the formation
        int index=0;
        for(int i=0;i<f.width;i++)
            for(int j=0;j<f.length;j++){
                if(f.arr[i][j]==1) {
                    PlaceCharacter(bf, f.members.get(index), x + i, y + j);
                    index++;
                }
            }
    }
    void RemoveFormation(Space bf, Formation f){
        for(int i=0;i<f.members.size();i++)
            RemoveCharacter(bf,f.members.get(i));
    }
}

public class Battle{
    public static void main(String[] args){
        Space battlefield = new Space(15,15);
        Manipulator god = new Manipulator();//almighty god creates and controls everything

        Calabash CalabashBrothers[] = god.CreateCalabashBrothers();
        god.CalabashSort(CalabashBrothers);
        Formation CalabashSquad = Formation.SNAKE;
        for(Creature c:CalabashBrothers) {
            CalabashSquad.members.add(c);
        }

        Formation ScorpionSquad = Formation.SPEAR;
        Scorpion scorpion=god.CreateScorpion();
        ScorpionSquad.members.add(scorpion);
        for(int i=0;i<ScorpionSquad.num-1;i++)
            ScorpionSquad.members.add(god.CreateLittleMonster());
        god.PlaceFormation(battlefield,CalabashSquad,3,2);
        god.PlaceFormation(battlefield,ScorpionSquad,4,9);

        Grandpa grandpa = god.CreateGoodBoss();
        Snake snake = god.CreateBadBoss();
        god.PlaceCharacter(battlefield,grandpa,6,0);
        god.PlaceCharacter(battlefield,snake,6,7);
        grandpa.cheer();
        snake.cheer();
        battlefield.Display();


        god.RemoveFormation(battlefield,ScorpionSquad);
        ScorpionSquad=Formation.WING;
        ScorpionSquad.members.add(scorpion);
        for(int i=0;i<ScorpionSquad.num-1;i++)
            ScorpionSquad.members.add(god.CreateLittleMonster());


        god.PlaceFormation(battlefield,ScorpionSquad,3,9);
        grandpa.cheer();
        snake.cheer();
        battlefield.Display();


    }
}
