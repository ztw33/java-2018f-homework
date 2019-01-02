public class Map {
    private Creature m[][];

    Map(){
        m = new Creature[10][10];
    }

    public void set(int x,int y,Creature c){
        m[x][y] = c;
    }

    public void printAll(){
        for(int i = 0;i< 10;i++){
            for(int j = 0;j < 10;j++){
                if(m[i][j] == null)
                    System.out.print("一");
                else
                    System.out.print(m[i][j].toString());
            }
            System.out.println();
        }
        System.out.println();
    }

   public void clearAll(){
        for(int i = 0;i< 10;i++) {
            for (int j = 0; j < 10; j++) {
                m[i][j] =null;
            }
        }
    }
}
