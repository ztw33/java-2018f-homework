
package main.java;

public class Creature{
    Coordinate Location;
    String imageURL;
    Creature(String url){
        Location = new Coordinate(-1,-1);
        imageURL =url;
    }
}

class LittleMonster extends Creature {
    LittleMonster(String url){
        super(url);
    }
}

class Scorpion extends Creature {
    Scorpion(String url){
        super(url);
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
    Calabash(CalabashRank r,String url){
        super(url);
        rank=r.id;
        color=r.color;
    }
}


class GoodBoss extends Creature
        implements CanCheer{
   GoodBoss(String url){
        super(url);
    }
    public void cheer() { }
}

class BadBoss extends Creature
        implements CanCheer{
    BadBoss(String url){
        super(url);
    }
    public void cheer(){}

}