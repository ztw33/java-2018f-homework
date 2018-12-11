public class Map {
    private Creature[][] map;
    private int size;

    Map(int size){
        this.size=size;
        map = new Creature[size][size];
    }
    void setCreature(Creature creature, int x, int y){
        map[y][x] = creature;
    }
    void removeCreature(int x, int y){
        map[y][x] = null;
    }
    int getSize(){
        return size;
    }
    void printWholeMap(){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                String shouldPrint = "_ ";
                if(map[i][j]!=null) {
                    switch(map[i][j].name){
                        case Calabash1:     shouldPrint = "1 ";break;
                        case Calabash2:     shouldPrint = "2 ";break;
                        case Calabash3:     shouldPrint = "3 ";break;
                        case Calabash4:     shouldPrint = "4 ";break;
                        case Calabash5:     shouldPrint = "5 ";break;
                        case Calabash6:     shouldPrint = "6 ";break;
                        case Calabash7:     shouldPrint = "7 ";break;
                        case GrandFather:   shouldPrint = "G ";break;
                        case Snake:         shouldPrint = "S ";break;
                        case Scorpion:      shouldPrint = "X ";break;
                        case Underling:     shouldPrint = "x ";break;
                        case Undefined:     shouldPrint = "? ";break;
                    }
                }
                System.out.print(shouldPrint);
            }
            System.out.print("\n");
        }
    }
    void clearHalfMap(String direction){
        if(direction.equals("Left")){
            for(int x=0;x<size/2;x++){
                for(int y=0;y<size;y++)
                    map[x][y] = null;
            }
        }
        else if(direction.equals("Right")){
            for(int x=0;x<size;x++){
                for(int y=size/2;y<size;y++)
                    map[x][y] = null;
            }
        }
    }
    void clearAllMap(){
        clearHalfMap("Left");
        clearHalfMap("Right");
    }
}
