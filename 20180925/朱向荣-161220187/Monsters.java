import java.util.ArrayList;
import java.util.List;

public class Monsters {
    private List<Monster> mons;
    Monsters(){
        mons = new ArrayList<Monster>();
    }

    public Block[] map1(int x,int y,int z){
        Block[] monmap = new Block[8];
        for(int i=0 ; i<8 ; ++i){
            monmap[i] = new Block();
        }
        mons.clear();
        Monster temp;
        temp = new Monster("蝎精");
        mons.add(temp);
        monmap[0].xrows = x;
        monmap[0].ylines = y;
        monmap[0].creature = temp;
        for(int i=1;i<4;++i){
            monmap[i].xrows = x+i;
            monmap[i].ylines = y+i;
            temp = new Monster("喽啰");
            mons.add(temp);
            monmap[i].creature = temp;
            monmap[7-i].xrows = x+i;
            monmap[7-i].ylines = y-i;
            temp = new Monster("喽啰");
            mons.add(temp);
            monmap[7-i].creature = temp;
        }
        monmap[7].xrows = z;
        monmap[7].ylines = y;
        temp = new Monster("蛇精");
        mons.add(temp);
        monmap[7].creature = temp;
        return monmap;
    }

    public Block[] map2(int x,int y , int z){
        Block[] monmap = new Block[6];
        for(int i=0 ; i<6 ; ++i){
            monmap[i] = new Block();
        }
        mons.clear();
        Monster temp;
        monmap[0].xrows = x;
        monmap[0].ylines = y;
        temp = new Monster("蝎精");
        mons.add(temp);
        monmap[0].creature = temp;
        for(int i=1 ; i<5 ; ++i){
            monmap[i].xrows = x+i;
            monmap[i].ylines = y-i;
            temp = new Monster("喽啰");
            mons.add(temp);
            monmap[i].creature = temp;
        }
        monmap[5].xrows = z;
        monmap[5].ylines = y;
        temp = new Monster("蛇精");
        mons.add(temp);
        monmap[5].creature = temp;
        return monmap;
    }

    public Block[] map3(int x , int y, int z){
        Block[] monmap = new Block[7];
        for(int i=0 ; i<7 ; ++i){
            monmap[i] = new Block();
        }
        mons.clear();
        Monster temp;
        monmap[0].xrows = x;
        monmap[0].ylines = y;
        temp = new Monster("蝎精");
        mons.add(temp);
        monmap[0].creature = temp;
        for(int i=1 ; i<3 ; ++i){
            monmap[i].xrows = x+2*i;
            monmap[i].ylines = y;
            temp = new Monster("喽啰");
            mons.add(temp);
            monmap[i].creature = temp;
        }
        for(int i=3 ; i<6 ; ++i){
            monmap[i].xrows = x+2*(i-3)+1;
            monmap[i].ylines = y+1;
            temp = new Monster("喽啰");
            mons.add(temp);
            monmap[i].creature = temp;
        }
        monmap[6].xrows = z;
        monmap[6].ylines = y;
        temp = new Monster("蛇精");
        mons.add(temp);
        monmap[6].creature = temp;
        return monmap;
    }

    public Block[] map4(int x , int y, int z){
        Block[] monmap = new Block[12];
        for(int i=0 ; i<12 ; ++i){
            monmap[i] = new Block();
        }
        mons.clear();
        Monster temp;
        monmap[0].xrows = x;
        monmap[0].ylines = y;
        temp = new Monster("蝎精");
        mons.add(temp);
        monmap[0].creature = temp;
        for(int i=1 ; i<3 ; ++i){
            monmap[i].xrows = x+1;
            monmap[i].ylines = y-3+2*i;
            temp = new Monster("喽啰");
            mons.add(temp);
            monmap[i].creature = temp;
        }
        for(int i=3 ; i<6 ; ++i){
            monmap[i].xrows = x+2;
            monmap[i].ylines = y+2*i-8;
            temp = new Monster("喽啰");
            mons.add(temp);
            monmap[i].creature = temp;
        }
        for(int i=6 ; i<10 ; ++i){
            monmap[i].xrows = x+3;
            monmap[i].ylines = y+2*i-15;
            temp = new Monster("喽啰");
            mons.add(temp);
            monmap[i].creature = temp;
        }
        monmap[10].xrows = x+4;
        monmap[10].ylines = y;
        temp = new Monster("喽啰");
        mons.add(temp);
        monmap[10].creature = temp;
        monmap[11].xrows = z;
        monmap[11].ylines = y;
        temp = new Monster("蛇精");
        mons.add(temp);
        monmap[11].creature = temp;
        return monmap;
    }

    public Block[] map5(int x , int y, int z){
        Block[] monmap = new Block[10];
        for(int i=0 ; i<10 ; ++i){
            monmap[i] = new Block();
        }
        mons.clear();
        Monster temp;
        monmap[0].xrows = x;
        monmap[0].ylines = y;
        temp = new Monster("蝎精");
        mons.add(temp);
        monmap[0].creature = temp;
        for(int i=1 ; i<3 ; ++i){
            monmap[i].xrows = x+i;
            monmap[i].ylines = y-i;
            temp = new Monster("喽啰");
            mons.add(temp);
            monmap[i].creature = temp;
        }
        for(int i=3 ; i<5 ; ++i){
            monmap[i].xrows = x+i-2;
            monmap[i].ylines = y+i-2;
            temp = new Monster("喽啰");
            mons.add(temp);
            monmap[i].creature = temp;
        }
        for(int i=5 ; i<9 ; ++i){
            monmap[i].xrows = x+i-4;
            monmap[i].ylines = y;
            temp = new Monster("喽啰");
            mons.add(temp);
            monmap[i].creature = temp;
        }
        monmap[9].xrows = z;
        monmap[9].ylines = y;
        temp = new Monster("蛇精");
        mons.add(temp);
        monmap[9].creature = temp;
        return monmap;
    }
}
