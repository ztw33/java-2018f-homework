

public class Creature{
    Coordinate Location;
    char symbol;
    Creature(){
        Location = new Coordinate(-1,-1);
    }
}

class LittleMonster extends Creature {
    LittleMonster(char name){
        symbol=name;
    }
}

class Scorpion extends Creature {
    Scorpion(char name){
        symbol=name;
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
    int rank;
    char color;
    Calabash(CalabashRank r){
        rank=r.id;
        color=r.color;
        symbol=r.color;
    }
}


class GoodBoss extends Creature
        implements CanCheer{
   GoodBoss(char name){
        symbol=name;
    }
    public void cheer() { }
}

class BadBoss extends Creature
        implements CanCheer{
    BadBoss(char name){
        symbol=name;
    }
    public void cheer(){}

}