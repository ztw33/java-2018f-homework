public class BattleField {
    private int[][] battlefield;
    private int field_size;
    BattleField(){
        battlefield=new int[20][20];
        field_size=20;
    }
    BattleField(int size){
        if(size>=20){
            battlefield=new int[size][size];
            field_size=size;
        }
        else{
            battlefield=new int[20][20];
            field_size=20;
        }
    }
    public int show_one(int x,int y){
        return battlefield[x][y];
    }
    public void clear_one(int x,int y){
        battlefield[x][y]=0;
    }
    public void clear_all(){
        for(int i=0;i<field_size;i++){
            for(int j=0;j<field_size;j++){
                battlefield[i][j]=0;
            }
        }
    }
    public boolean set_one(int x,int y,int val){
        if(x<field_size&&y<field_size){
            if(battlefield[x][y]==0) {
                battlefield[x][y] = val;
                return true;
            }
            else
                return false;
        }
        return false;
    }

}
