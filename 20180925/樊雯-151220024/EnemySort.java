package work3_huluwa;

public class EnemySort {
	 private Point[][] positions;
	    private Scorpion scorpion;
	    private Smallmonster[] monsters;
	    private Queuename formation;
	    private static final int N = 20;

	    public EnemySort(Scorpion scorpion, Smallmonster[] monster) {
	        this.scorpion = scorpion;
	        this.monsters = monster;
	        positions = new Point[N][N];
	        for(int i = 0; i < N; i++)
	            positions[i] = new Point[N];
	        for(int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++)
	                positions[i][j] = new Point(i, j);
	        }
	    }

	    public void formate(Queuename formation) {
	        this.formation = formation;
	        int indexOfMinion = 0;
	        switch (formation) {
	            case ����:
	                for (int i = 0; i < 5; i++) {	               
	                    	monsters[2*i].setplace(positions[i][i]);		
	                    //	monsters[2*i].report();                    
	                    monsters[2*i+1].setplace(positions[i][10-i]);
	                }
	                scorpion.setplace(positions[5][5]);
	                break;
	            case ����:
	            	scorpion.setplace(positions[0][5]);
	            	
	       
	                break;
	            case ����:
	                break;
	            case ����:
	                break;
	            case ����:
	                break;
	            case ����:
	                break;
	            case ����:
	                break;
	            case ��ʸ:
	                scorpion.setplace(positions[4][3]);
	                for(int i = 0; i < 4; i++)
	                	monsters[indexOfMinion++].setplace(positions[i][3]);
	                for(int i = 1; i <= 3; i++){
	                    int j = 0;
	                    for(; j < i - 1; j++)
	                    	monsters[indexOfMinion++].setplace(positions[i][j++]);
	                    j = 7-j;
	                    monsters[indexOfMinion++].setplace(positions[i][j]);
	                   // System.out.println("");
	                }
	                break;
	        }
	    }

	    //��Ы�Ӿ���Сආ���Ϊ���崫������
	    public Creature[] getCreature() {
	        Creature[] creatures = new Creature[monsters.length];
	        creatures[0] = scorpion;
	        for(int i = 1; i < creatures.length; i++)
	            creatures[i] = monsters[i-1];
	        //for(int i = 0; i < creatures.length; i++)
	        //	creatures[i].report();
	        return creatures;
	}
}
