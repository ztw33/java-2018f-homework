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
	            case 鹤翼:
	                for (int i = 0; i < 5; i++) {	               
	                    	monsters[2*i].setplace(positions[i][i]);		
	                    //	monsters[2*i].report();                    
	                    monsters[2*i+1].setplace(positions[i][10-i]);
	                }
	                scorpion.setplace(positions[5][5]);
	                break;
	            case 雁行:
	            	scorpion.setplace(positions[0][5]);
	            	
	       
	                break;
	            case 冲轭:
	                break;
	            case 长蛇:
	                break;
	            case 鱼鳞:
	                break;
	            case 方门:
	                break;
	            case 偃月:
	                break;
	            case 锋矢:
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

	    //将蝎子精和小喽啰作为整体传入棋盘
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
