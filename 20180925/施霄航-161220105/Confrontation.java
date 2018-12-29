package njuics.java2018.cb_confrontation;

//学一下enum类的使用方式
enum Creature{
    Empty("null","null",0,0,0),
    //葫芦娃阵营的生物
    CB1("葫芦娃老大","葫芦娃",1,0,0),
    CB2("葫芦娃老二","葫芦娃",2,0,0),
    CB3("葫芦娃老三","葫芦娃",3,0,0),
    CB4("葫芦娃老四","葫芦娃",4,0,0),
    CB5("葫芦娃老五","葫芦娃",5,0,0),
    CB6("葫芦娃老六","葫芦娃",6,0,0),
    CB7("葫芦娃老七","葫芦娃",7,0,0),
    Grandpa("老爷爷","葫芦娃",0,0,0),
    //妖精阵营的生物
    Scorpion_Essence("蝎子精","妖精",1,0,0),
    Dogface("喽啰","妖精",2,0,0),
    //Dogface2("喽啰2","妖精",3,0,0),
    //Dogface3("喽啰3","妖精",4,0,0),
    //Dogface4("喽啰4","妖精",5,0,0),
    //Dogface5("喽啰5","妖精",6,0,0),
    //Dogface6("喽啰6","妖精",7,0,0),
    Snake_Spirit("蛇精","妖精",0,0,0);


    private final String name;
    private final String faction;
    private final int no;
    private int pos_x;
    private int pos_y;


    Creature(String NAME, String FACTION, int No, int X, int Y){
        this.name = NAME;
        this.faction = FACTION;
        this.no = No;
        this.pos_x = X;
        this.pos_y = Y;
    }

    public void modify_pos(int new_X, int new_Y){
        pos_x = new_X;
        pos_y = new_Y;
    }


}

//地图管理器
class Map{
    private Creature[][] r = new Creature[20][20];//指示变量：-1天灾；0空；1近卫
    Map(){
        for(int i = 0; i < 20; i++)
            for(int j = 0; j < 20; j++)
                r[i][j] = Creature.Empty;
        //初始化所有位置都是空的
    }
    public void Modify_map_condition(int x, int y, Creature m){
        r[x][y] = m;
    }

    public void print_situation() {
        for (int j = 0; j < 20; j++) {
            if (j == 10) {
                for (int n = 0; n < 20; n++)
                    System.out.print('-');
                System.out.print("Border" + '\n');

            }
            for (int i = 0; i < 20; i++) {
                switch (r[i][j]) {
                    case CB1:
                        System.out.print('1');
                        break;
                    case CB2:
                        System.out.print('2');
                        break;
                    case CB3:
                        System.out.print('3');
                        break;
                    case CB4:
                        System.out.print('4');
                        break;
                    case CB5:
                        System.out.print('5');
                        break;
                    case CB6:
                        System.out.print('6');
                        break;
                    case CB7:
                        System.out.print('7');
                        break;
                    case Grandpa:
                        System.out.print('G');
                        break;
                    case Scorpion_Essence:
                        System.out.print('#');
                        break;
                    case Snake_Spirit:
                        System.out.print('S');
                        break;
                    case Dogface:
                        System.out.print('*');
                        break;
                    case Empty:
                        System.out.print(' ');
                        break;
                }
            }

            if(j == 9)
                System.out.print("葫芦娃阵营");
            if(j == 10)
                System.out.print("妖精阵营");
            System.out.print('\n');
        }
    }


}

enum Faction{
    //定义地图
    //葫芦娃阵营的生物是固定的，但是妖精阵营生物种类固定，而数量不固定，说明这两个阵营是有区别的，但是地图却要共用一张，这个问题暂且放着.
    //定义了两个阵营，阵营中有各自应有的7个生物
    Sentinel("葫芦娃",Creature.Grandpa,Creature.CB1,Creature.CB2,Creature.CB3,Creature.CB4,Creature.CB5,Creature.CB6,Creature.CB7),
    Scourge("妖精",Creature.Snake_Spirit,Creature.Scorpion_Essence,Creature.Dogface,Creature.Dogface,Creature.Dogface,Creature.Dogface,
            Creature.Dogface,Creature.Dogface);
    private static Map map = new Map();
    private final String name;
    private Creature creatures[] = new Creature[8];
    Faction(String NAME,Creature C0,Creature C1,Creature C2,Creature C3, Creature C4, Creature C5, Creature C6, Creature C7){
        this.name = NAME;
        this.creatures[0] = C0;
        this.creatures[1] = C1;
        this.creatures[2] = C2;
        this.creatures[3] = C3;
        this.creatures[4] = C4;
        this.creatures[5] = C5;
        this.creatures[6] = C6;
        this.creatures[7] = C7;

    }

    //两个阵营的生物通过合作，学会了布各种阵
    //长蛇阵
    public void single_line(){
        if(name == "葫芦娃"){
            creatures[0].modify_pos(0,7);
            creatures[1].modify_pos(10,10);
            creatures[2].modify_pos(10,9);
            creatures[3].modify_pos(10,8);
            creatures[4].modify_pos(10,7);
            creatures[5].modify_pos(10,6);
            creatures[6].modify_pos(10,5);
            creatures[7].modify_pos(10,4);


            for(int i = 0; i < 20; i++)
                for(int j = 0; j < 10; j++)
                    map.Modify_map_condition(i,j,Creature.Empty);
            map.Modify_map_condition(0,7,Creature.Grandpa);
            map.Modify_map_condition(10,9,Creature.CB1);
            map.Modify_map_condition(10,8,Creature.CB2);
            map.Modify_map_condition(10,7,Creature.CB3);
            map.Modify_map_condition(10,6,Creature.CB4);
            map.Modify_map_condition(10,5,Creature.CB5);
            map.Modify_map_condition(10,4,Creature.CB6);
            map.Modify_map_condition(10,3,Creature.CB7);
        }
        else
            System.out.println("妖精阵营：没有学会长蛇阵><");


    }

    //鹤翼阵
    public void crane_wing(){
        if(name == "妖精"){
            creatures[0].modify_pos(0,12);
            creatures[1].modify_pos(10,10);
            creatures[2].modify_pos(9,11);
            creatures[3].modify_pos(8,12);
            creatures[4].modify_pos(7,13);
            creatures[5].modify_pos(11,11);
            creatures[6].modify_pos(12,12);
            creatures[7].modify_pos(13,13);


            for(int i = 0; i < 20; i++)
                for(int j = 10; j < 20; j++)
                    map.Modify_map_condition(i,j,Creature.Empty);
            map.Modify_map_condition(0,12,Creature.Snake_Spirit);
            map.Modify_map_condition(10,10,Creature.Scorpion_Essence);
            map.Modify_map_condition(9,11,Creature.Dogface);
            map.Modify_map_condition(8,12,Creature.Dogface);
            map.Modify_map_condition(7,13,Creature.Dogface);
            map.Modify_map_condition(11,11,Creature.Dogface);
            map.Modify_map_condition(12,12,Creature.Dogface);
            map.Modify_map_condition(13,13,Creature.Dogface);
        }
        else;
    }


    public void wild_goose_fly(){
        if(name == "妖精"){

            creatures[0].modify_pos(0,12);
            creatures[1].modify_pos(13,10);
            creatures[2].modify_pos(12,11);
            creatures[3].modify_pos(11,12);
            creatures[4].modify_pos(10,13);
            creatures[5].modify_pos(9,14);
            creatures[6].modify_pos(8,15);
            creatures[7].modify_pos(7,16);


            for(int i = 0; i < 20; i++)
                for(int j = 10; j < 20; j++)
                    map.Modify_map_condition(i,j,Creature.Empty);
            map.Modify_map_condition(0,12,Creature.Snake_Spirit);
            map.Modify_map_condition(13,10,Creature.Scorpion_Essence);
            map.Modify_map_condition(12,11,Creature.Dogface);
            map.Modify_map_condition(11,12,Creature.Dogface);
            map.Modify_map_condition(10,13,Creature.Dogface);
            map.Modify_map_condition(9,14,Creature.Dogface);
            map.Modify_map_condition(8,15,Creature.Dogface);
            map.Modify_map_condition(7,16,Creature.Dogface);
        }
        else;
    }
    public Map getMap() {
        return map;
    }
}




public class Confrontation {
    public static void main(String[] args) {
        Faction f1 = Faction.Sentinel;
        Faction f2 = Faction.Scourge;
        f1.single_line();
        f2.crane_wing();
        f1.getMap().print_situation();
        System.out.println("妖精阵营变阵：");

        f2.wild_goose_fly();
        f1.getMap().print_situation();

    }
}
