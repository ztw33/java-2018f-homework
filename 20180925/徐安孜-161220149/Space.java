



public class Space{
    private int length,width;
    private Creature map[][];

    Space(int l,int w){
        length = l;
        width = w;
        map = new Creature[length][width];
        for(int i=0;i<length;i++)
            for(int j=0;j<width;j++)
                map[i][j]=null;
    }
    boolean validation(int x,int y){
        return (map[x][y]==null && x<width && y<length);
    }
    void display(){
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
    void creatureEnterSpace(Creature c, int x, int y){
        map[x][y]=c;
    }
    void creatureLeaveSpace(int x, int y){
        map[x][y]=null;
    }
}

