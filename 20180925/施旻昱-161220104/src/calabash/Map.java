package calabash;

public class Map {
    final int mapsize = 15;
    private Creature map[][];
    private boolean vacancy[][];
    Map(){
        map = new Creature[mapsize][mapsize];
        vacancy = new boolean[mapsize][mapsize];
        for(int i = 0; i < mapsize; i++)
            for(int j = 0; j < mapsize; j++) {
                vacancy[i][j] = false;
                map[i][j] = new None();
            }
    }
    public void setmap(Creature c1, Location l){
        map[l.getx()][l.gety()] = c1;
        vacancy[l.getx()][l.gety()] = true;
        //creaturecome(l);
    }
    public Creature getmapinfomation(Location l){
        return map[l.getx()][l.gety()];
    }
    public void creatureleave(Location l) {
        vacancy[l.getx()][l.gety()] = false;
        map[l.getx()][l.gety()] = new None();
    }
    /*public void creaturecome(Location l){
        vacancy[l.getx()][l.gety()] = true;
    }*/
    public boolean checkisntempty(Location l){
        return vacancy[l.getx()][l.gety()];
    }
    public void printmap(){
        for(int i = 0; i < mapsize; i++) {
            for (int j = 0; j < mapsize; j++) {
                if (vacancy[i][j]) {
                    System.out.print(map[i][j].getprintindex());
                } else {
                    System.out.print(" ");
                }
                System.out.print(" ");
            }
            System.out.print("\n");
        }
        System.out.println("----------------------------------------------------");
    }
}

class Location{
    private int x;
    private int y;
    Location(Location l){
        x = l.getx();
        y = l.gety();
    }
    Location(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }
}