package Formation;
enum Color{红色, 橙色, 黄色, 绿色, 青色, 蓝色, 紫色}
enum CalabashName{老大, 老二, 老三, 老四, 老五, 老六, 老七}
class Calabash{
    public int rank;
    public Color color;
    public CalabashName name;
    Calabash(int rank)
    {
        this.rank = rank;
        this.color = Color.values()[rank];
        this.name = CalabashName.values()[rank];
    }
}

class Grandpa{
    public String name;
    Grandpa()
    {
        this.name = "爷爷";
    }
}

enum GoblinName{蛇精,蝎子精,小喽啰}
class Goblin{
    public int rank;
    public GoblinName name;
    Goblin(int rank)
    {
        this.rank = rank;
        this.name = GoblinName.values()[rank];
    }
}

public class Main {
    public static void main(String[] args) {
        int []Rank = {0,3,2,5,1,6,4};
        Calabash []brothers = new Calabash[7];
        for(int i=0;i<7;i++) {
            brothers[i] = new Calabash(Rank[i]);
        }
        Grandpa grandpa = new Grandpa();
        Formation.SingleLineBattleArray(brothers,grandpa);
        Goblin []goblins = new Goblin[10];
        for(int i=0;i<3;i++) {
                goblins[i] = new Goblin(i);
        }
        System.out.println("\n");
        Formation.GoblinArray1(goblins);
        System.out.println("\n"+"\n");
        Formation.SingleLineBattleArray(brothers,grandpa);
        System.out.println("\n");
        Formation.GoblinArray2(goblins);
    }
}
