import java.util.concurrent.atomic.LongAccumulator;

public class Map {

    public static Creature LandCreature[][] = new Creature[15][15];
    private static Creature EmptyCreature = new Creature("none",Global.EMPTY,0,' ');

    Map(){;}

    public static void Init_Map(){
        for(int i = 0; i < 15; i++)
            for(int j = 0; j < 15; j++){
                LandCreature[i][j] = EmptyCreature;
            }
    }

    public static void SetSite(Creature anyone,int x, int y) {
        if(anyone.sitey != -1 || anyone.sitex!= -1){
        LandCreature[anyone.sitey][anyone.sitex] = EmptyCreature;
        anyone.sitey = y;
        anyone.sitex = x;
        LandCreature[anyone.sitey][anyone.sitex] = anyone;
        }
        else {
            anyone.sitex = x;
            anyone.sitey = y;
            LandCreature[anyone.sitey][anyone.sitex] = anyone;
        }
    }

    public Creature GetSiteMes(int x, int y){
        return LandCreature[x][y];
    }

    public static void PrintMap(){
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 14; j++){
                System.out.print(LandCreature[i][j].GetSymbol());
            }
                System.out.println(LandCreature[i][14].GetSymbol());
        }
    }
}
