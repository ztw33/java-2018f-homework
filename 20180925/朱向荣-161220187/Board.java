public class Board {
    private Object[][] board;
    private static final int Rows = 40;
    private static final int Lines = 11;
    public Board(){
        board = new Object[Lines][Rows];
        for(int i=0 ; i<Lines ; i++){
            for(int j=0 ; j<Rows ; j++){
                board[i][j] = null;
            }
        }
    }
    public void clear(){
        for(int i=0 ; i<Lines ; ++i){
            for(int j=0 ; j<Rows ; ++j){
                board[i][j] = null;
            }
        }
    }
    public void setmap1(HuLuBros hulubros,Monsters mons){
        Block[] blocklist = hulubros.HuLustand(15,5);
        for(Block a:blocklist){
            board[a.ylines][a.xrows] = a.creature;
        }
        board[5][0] = new Creature(CreatureType.HUMAN,"爷爷");
        blocklist = mons.map1(20,5,39);
        for(Block a:blocklist){
            board[a.ylines][a.xrows] = a.creature;
        }
    }
    public void setmap2(HuLuBros hulubros,Monsters mons){
        Block[] blocklist = hulubros.HuLustand(15,5);
        for(Block a:blocklist){
            board[a.ylines][a.xrows] = a.creature;
        }
        board[5][0] = new Creature(CreatureType.HUMAN,"爷爷");
        blocklist = mons.map2(20,5,39);
        for(Block a:blocklist){
            board[a.ylines][a.xrows] = a.creature;
        }
    }
    public void setmap3(HuLuBros hulubros,Monsters mons){
        Block[] blocklist = hulubros.HuLustand(15,5);
        for(Block a:blocklist){
            board[a.ylines][a.xrows] = a.creature;
        }
        board[5][0] = new Creature(CreatureType.HUMAN,"爷爷");
        blocklist = mons.map3(20,5,39);
        for(Block a:blocklist){
            board[a.ylines][a.xrows] = a.creature;
        }
    }
    public void setmap4(HuLuBros hulubros,Monsters mons){
        Block[] blocklist = hulubros.HuLustand(15,5);
        for(Block a:blocklist){
            board[a.ylines][a.xrows] = a.creature;
        }
        board[5][0] = new Creature(CreatureType.HUMAN,"爷爷");
        blocklist = mons.map4(20,5,39);
        for(Block a:blocklist){
            board[a.ylines][a.xrows] = a.creature;
        }
    }
    public void setmap5(HuLuBros hulubros,Monsters mons){
        Block[] blocklist = hulubros.HuLustand(15,5);
        for(Block a:blocklist){
            board[a.ylines][a.xrows] = a.creature;
        }
        board[5][0] = new Creature(CreatureType.HUMAN,"爷爷");
        blocklist = mons.map5(20,5,39);
        for(Block a:blocklist){
            board[a.ylines][a.xrows] = a.creature;
        }
    }
    public void printmap(){
        for(int i=0 ; i<Lines ; ++i){
            for(int j=0 ; j<Rows ; ++j){
                if(board[i][j]==null){
                    System.out.print("\t");
                }
                else {
                    System.out.print(((Creature)board[i][j]).getname()+"\t");
                }
            }
            System.out.println("|");
        }
        System.out.println("-------------------------------------------------");
    }
}
