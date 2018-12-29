package Map;

import Creature.Creature;
import Creature.CalabashTeam;
import Creature.EnemyTeam;


public class Graph {
    private int size;
    private Creature[][] graph;
    public Graph(){
        size=10;
        graph=new Creature[size+1][2*size+1];
        for (int i=0;i<=size;i++)
            for (int j=0;j<=size*2;j++)
                graph[i][j]=new Creature();
    }

    public int getSize(){
        return this.size;
    }
    public void clearMap(){
        for (int i=0;i<=size;i++){
            for (int j=0;j<=2*size;j++){
                graph[i][j]=new Creature();
            }
        }
    }

    public void setCalabash(int type){
        CalabashTeam calabashteam=new CalabashTeam();
        calabashteam.calabashLinedUp(this,type);

    }

    public void setEnemy(int type){
        EnemyTeam enemyteam=new EnemyTeam();
        enemyteam.enemyLinedUp(this,type);
    }

    public void printMap(){
        for (int i=0;i<=size;i++) {
            for (int j = 0; j <= 2 * size; j++) {
               // System.out.println("enter"+i+j+" ");
                graph[i][j].tellName();
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------");

    }

    public void putCreature(Creature creature, int x, int y){
        graph[x][y]=creature;
    }
}

