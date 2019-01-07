package work3_huluwa;
public class Checks {
	//this is the battle field
	private Point[][] field;
	private final static int N = 20;
	private Hululist hululist;
	
	public void setHolder(Point position) {
        field[position.get_x()][position.get_y()].set_placeholder(position.get_placeholder());
}
	public Checks(){
	//初始化

		this.field = new Point[N][N];
		 for(int i = 0; i < N; i++)
	            field[i] = new Point[N];
	        for(int i = 0; i < N; i++){
	            for(int j = 0; j < N; j++)
	            	field[i][j] = new Point(i,j);
	        }
	 }      
	
	/* 
	 * public void Set_battlefield(Huluwa[] brothers, Smallmonster[] guys,Scorpion sp,Grandpa gp, Snake sk)
	 
	 {
	  	for(int i=0;i<N;i++)
	  	{
	  		for(int j=0;j<N;j++)
	  		{
	  			this.field[i][j]=new Point(-1,-1);
	  		}
	   	}
	  	for(int i=0;i< 7;i++) {
	  		int a=brothers[i].getplace().get_x();
	  		int b=brothers[i].getplace().get_y();
	  		this.field[a][b] = new Point(a,b);
	  		this.field[a][b].set_placeholder(brothers[i].getplace().get_placeholder());
	   	}
		for(int i=0;i< guys.length;i++) {
			int a=guys[i].getplace().get_x();
			int b=guys[i].getplace().get_y();
			this.field[a][b] = new Point(a,b);
			this.field[a][b].set_placeholder(guys[i].getplace().get_placeholder());
	   }	   
		this.field[sp.getplace().get_x()][sp.getplace().get_y()]=new Point(sp.getplace().get_x(),sp.getplace().get_y());
		this.field[sp.getplace().get_x()][sp.getplace().get_y()].set_placeholder(sp.getplace().get_placeholder());
	  
		this.field[gp.getplace().get_x()][gp.getplace().get_y()]=new Point(gp.getplace().get_x(),gp.getplace().get_y());
		this.field[gp.getplace().get_x()][gp.getplace().get_y()].set_placeholder(gp.getplace().get_placeholder());
	   
		this.field[sk.getplace().get_x()][sk.getplace().get_y()]=new Point(sk.getplace().get_x(),sk.getplace().get_y());
		this.field[sk.getplace().get_x()][sk.getplace().get_y()].set_placeholder(sk.getplace().get_placeholder());
	 }
	 //上述代码全部使用creature接口
	*/
	public void setfield(Creature[] creatures, int x, int y){
        for(Creature creature: creatures){
            Point position = creature.getplace();
            System.out.print(position.get_y());
            Point position_temp = new Point(position.get_x()+x, position.get_y()+y);
            creature.setplace(position_temp);
            setHolder(position_temp);
        }
        
	}
	public void setfield(Creature creature){
        setHolder(creature.getplace());
	}
	 public void clear(Creature[] creatures){
	        for(Creature creature: creatures){
	            field[creature.getplace().get_x()][creature.getplace().get_y()].set_placeholder(null);
	            creature.setplace(null);
	        }
	    }
	 
	    public void clear(Creature creature){
	        field[creature.getplace().get_x()][creature.getplace().get_y()].set_placeholder(null);
	        creature.setplace(null);
	}
	public void reportfield(){
        for(int i = 0; i < N; i++)
            System.out.print("--");
        System.out.println("");
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++){
                if(field[i][j].get_placeholder() != null){
                	field[i][j].get_placeholder().report(); //打印棋盘
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
        for(int i = 0; i < N; i++)
            System.out.print("--");
        System.out.println("");		
	}
	public static void main(String[] args) {
        //故事人物的登场
        Huluwa[] huluwa = new Huluwa[7];
        for(int i = 0; i < 7; i++){
            huluwa[i] = new Huluwa(i);
        }
        Grandpa grandFather = new Grandpa();
        Snake snake = new Snake();
        Scorpion scorpion = new Scorpion();
        Smallmonster[] minions = new Smallmonster[10];
        for(int i = 0; i < 10; i++){
            minions[i] = new Smallmonster();
        }
        //葫芦娃排队,
        Hululist list = new Hululist(huluwa);
        //蝎子精和小喽啰的排队
        EnemySort enemy = new EnemySort(scorpion, minions);
        enemy.formate(Queuename.锋矢);
        
        Checks check = new Checks();
        check.setfield(list.getCreature(),N-7, N / 2);
        check.setfield(enemy.getCreature(), 0, N/2 - 5);
        //老爷爷和蛇精分别加入
        grandFather.setplace(check.field[N-7][N/2-4]);
        check.setfield(grandFather);
        snake.setplace(check.field[5][5]);
        check.setfield(snake);
        //打印局面
        check.reportfield();

        //蝎子小喽啰变换阵型
        check.clear(enemy.getCreature());
        enemy.formate(Queuename.鹤翼);
        //再次进入二维空间
        check.setfield(enemy.getCreature(), 0, N/2 - 3);
        //再次打印局面
        check.reportfield();

    } 
}
