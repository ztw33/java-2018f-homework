public class BattleField {
    private int N;
    private Creature[][] creatures;
    BattleField(){
        N = 15;
        creatures = new Creature[N][N];
    }
    BattleField(int N){
        if(N>10){
            this.N=N;
            creatures = new Creature[N][N];
        }
        else{
            System.out.println("BattleField TOO SMALL...!");
        }
    }
    public int getSize(){
        return N;
    }

    public void printBattleFieldStatus(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(isLocationEmpty(i, j)){
                    System.out.print("- ");
                }
                else
                    System.out.print(creatures[i][j].reportIdentifier() + " ");
            }
            System.out.println();
        }
    }

    private boolean checkLocationOutOfBound(int x, int y){
        if(x==-1 && y==-1){
            System.out.println("Func \"checkOutOfBound\" report: (x,y) is not inside the battlefield(in initial location(-1, -1)).");
            return false;
        }
        else if(!(x<N && y<N && x>=0 && y>=0)){
            System.out.println("Func \"checkOutOfBound\" report: (x,y) is not inside the battlefield(out of bound).");
            return true;
        }
        else{
            return false;
        }
    }
    private static boolean isLocationInitial(int x, int y){
        return (x==-1 && y==-1);
    }
    private boolean isLocationEmpty(int x, int y){
        return creatures[x][y]==null;
    }
    private void moveCreatureOutOfBattleField(Creature ct){
        //The order of following two instructions MUST be like this.
        //"ct" can be reference of creature[][], and also can be "enumeration" in main.
        if(ct != null && !isLocationInitial(ct.reportLocationX(), ct.reportLocationY())) {
            int x=ct.reportLocationX();
            int y=ct.reportLocationY();
            ct.moveToLocation(-1, -1);
            creatures[x][y] = null;
        }
    }
    public void clearBattleField(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                moveCreatureOutOfBattleField(creatures[i][j]);
            }
        }
    }
    public void removeCreaturesFromBattleField(Creature[] ct){
        for(int i=0; i<ct.length; i++)
            moveCreatureOutOfBattleField(ct[i]);
    }
    public void removeCreatureFromBattleField(Creature ct){
        moveCreatureOutOfBattleField(ct);
    }
    public void setCreatureToProperLocation(Creature ct, int x, int y){
        if(!checkLocationOutOfBound(x,y)){
            moveCreatureOutOfBattleField(creatures[x][y]);
            creatures[x][y]=ct;
            ct.moveToLocation(x, y);
        }
    }
    public void setCheeringCreatureLocation(Creature ct, boolean onright){
        int random = (int)(1+Math.random()*(10-1+1));
        if(onright){
            if(random<=5){
                setCreatureToProperLocation(ct, 0, 3*N/4);
            }
            else{
                setCreatureToProperLocation(ct, N-1, 3*N/4);
            }
        }
        else{
            if(random<=5){
                setCreatureToProperLocation(ct, 0, N/4);
            }
            else{
                setCreatureToProperLocation(ct, N-1, N/4);
            }
        }
    }
    //perhaps useless function...comment it temporarily
    /*private void swapTwoCreatures(Creature ct1, Creature ct2){
        if(!checkLocationOutOfBound(ct1.reportLocationX(), ct1.reportLocationY()) && !checkLocationOutOfBound(ct2.reportLocationX(), ct2.reportLocationY())){
            int x1=ct1.reportLocationX(), y1=ct1.reportLocationY(), x2=ct2.reportLocationX(), y2=ct2.reportLocationY();
            setCreatureToProperLocation(ct1, x2, y2);
            setCreatureToProperLocation(ct2, x1, y1);
        }
        else{
            System.out.println("Location OUT of the battlefield...!");
        }
    }*/

    //onright==true: deploy the force in the right part of the battlefield.
    private  int[] getLeaderLocation(boolean onright){
        int[] result = new int[2];
        if(onright){
            result[1]=N/2+2;
            result[0]=N/2;
        }
        else{
            result[1]=N/2-2;
            result[0]=N/2;
        }
        return result;
    }

    //Followings are Deployments
    void deployHeYiZhen(Creature leader, Creature[] member, boolean onright) {
        int[] pairloc=getLeaderLocation(onright);
        int x=pairloc[0], y=pairloc[1];
        setCreatureToProperLocation(leader, x, y);
        if(onright){
            for(int i=0; i<3; i++){
                setCreatureToProperLocation(member[2*i], x-i-1, y+i+1);
                setCreatureToProperLocation(member[2*i+1], x+i+1, y+i+1);
            }
        }
        else{
            for(int i=0; i<3; i++){
                setCreatureToProperLocation(member[2*i], x-i-1, y-i-1);
                setCreatureToProperLocation(member[2*i+1], x+i+1, y-i-1);
            }
        }
    }
    void deployYanXingZhen(Creature leader, Creature[] member, boolean onright){
        int[] pairloc=getLeaderLocation(onright);
        int x=pairloc[0], y=pairloc[1];
        creatures[x][y]=leader;
        leader.moveToLocation(x, y);
        if(onright){

        }
        else{

        }
    }
    void deployHengEZhen(Creature leader, Creature[] member, boolean onright){
        int[] pairloc=getLeaderLocation(onright);
        int x=pairloc[0], y=pairloc[1];
        creatures[x][y]=leader;
        leader.moveToLocation(x, y);
        if(onright){

        }
        else{

        }
    }
    void deployChangSheZhen(Creature leader, Creature[] member, boolean onright){
        int[] pairloc=getLeaderLocation(onright);
        int x=pairloc[0], y=pairloc[1];
        creatures[x][y]=leader;
        leader.moveToLocation(x, y);
        if(onright){

        }
        else{

        }
    }
    void deployYuLinZhen(Creature leader, Creature[] member, boolean onright){
        int[] pairloc=getLeaderLocation(onright);
        int x=pairloc[0], y=pairloc[1];
        creatures[x][y]=leader;
        leader.moveToLocation(x, y);
        if(onright){

        }
        else{

        }
    }
    void deployFangYuanZhen(Creature leader, Creature[] member, boolean onright){
        int[] pairloc=getLeaderLocation(onright);
        int x=pairloc[0], y=pairloc[1];
        creatures[x][y]=leader;
        leader.moveToLocation(x, y);
        if(onright){

        }
        else{

        }
    }
    void deployYanYueZhen(Creature leader, Creature[] member, boolean onright){
        int[] pairloc=getLeaderLocation(onright);
        int x=pairloc[0], y=pairloc[1];
        creatures[x][y]=leader;
        leader.moveToLocation(x, y);
        if(onright){

        }
        else{

        }
    }
    void deployFengShiZhen(Creature leader, Creature[] member, boolean onright){
        int[] pairloc=getLeaderLocation(onright);
        int x=pairloc[0], y=pairloc[1];
        creatures[x][y]=leader;
        leader.moveToLocation(x, y);
        if(onright){

        }
        else{

        }
    }
    //Developments end...

}
