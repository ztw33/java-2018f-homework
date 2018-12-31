public class Battlefield {
    public static int LENGTH;
    public Position[][] positions;
    public JusticeLeague justiceLeague;
    public Formation justiceLeagueFormation;
    public Formation evilLeagueFormation;
    public evilLeague evilLeague;
    public Battlefield(int length, JusticeLeague justiceLeague, evilLeague evilLeague){
        this.LENGTH = length;
        this.justiceLeague = justiceLeague;
        this.evilLeague = evilLeague;
        if(length*length/2 <= evilLeague.NUMBER){
            System.out.println("战场太小了，重新建个大点的！");
            return;
        }
        this.positions = new Position[length][length];
        int conut1 = justiceLeague.NUMBER;
        int conut2 = evilLeague.NUMBER;
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                this.positions[i][j] = new Position(i,j,null);
                if(conut1>0){
                    justiceLeague.creatures[conut1-1].position = this.positions[i][j];
                    this.positions[i][j].creature = justiceLeague.creatures[conut1-1];
                    conut1--;
                }else if (conut1 == 0){
                    justiceLeague.justiceLeader.position = this.positions[i][j];
                    this.positions[i][j].creature = justiceLeague.justiceLeader;
                    conut1--;
                }else if(conut2>0){
                    evilLeague.creatures[conut2-1].position = this.positions[i][j];
                    this.positions[i][j].creature = evilLeague.creatures[conut2-1];
                    conut2--;
                }else if(conut2==0){
                    evilLeague.evilLeader.position = this.positions[i][j];
                    this.positions[i][j].creature = evilLeague.evilLeader;
                    conut2--;
                }
            }
        }
        justiceLeagueFormation = new Formation(justiceLeague.creatures,justiceLeague.justiceLeader, positions, false);
        evilLeagueFormation = new Formation(evilLeague.creatures, evilLeague.evilLeader,positions, true);
    }

    public void printSituation(){
        for(int i=0;i<LENGTH;i++){
            for(int j=0;j<LENGTH;j++){
                if(positions[i][j].creature == null){
                    System.out.print(" ---- ");

                }else{
                    System.out.print(' '+ positions[i][j].creature.tellName()+' ');
                }
            }
            System.out.println();
        }
    }
}
