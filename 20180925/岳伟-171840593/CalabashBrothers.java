package CalabashBros;
public enum  CalabashBrothers //定义枚举类：葫芦兄弟
{
	R("老大",1,"红色"),O("老二",2,"橙色"),Y("老三",3,"黄色"),G("老四",4,"绿色"),C("老五",5,"青色"),B("老六",6,"蓝色"),P("老七",7,"紫色"),;
    public int rank;//葫芦娃的序号
    public String colour;//葫芦娃的颜色
	public String name;//葫芦娃的名字
    public Position position;//葫芦娃的位置
    private CalabashBrothers(String name,int rank,String colour)//构造函数
   {
	this.name=name;
	this.rank=rank;
	this.colour=colour;
	position =new Position();
   }  
	public static void main(String[] args) 
	{
		CalabashBrothers[] bros= {R,O,Y,G,C,B,P};
		Space space=new Space(23);
		Snake snake=new Snake();
		Scorpion scorpion=new Scorpion();
		Underling underlings[] =new Underling[10];
		for(int i=0;i<10;i++){underlings[i]=new Underling();}
		Grandpa grandpa=new Grandpa();
		Formations formations=new Formations();
		formations.first_queue(13, bros, underlings, scorpion, snake, grandpa,space);
	}
}

class Position//二维空间的某一个位置,包含x,y坐标
{
	public int x=0;
	public int y=0;
	Position(){};
	public Position(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}
class Space//二维空间,包含了N✖️N的position，分别是(0,0)、(0,1)、...、(N-1,0)、(1,0)、...、(N-1,N-1)
{
	public int N;
	Position [][]position;
	public Space(int N)
	{
		position=new Position[N][N];
		this.N=N;
		int i=0,j=0;
		for(i=0;i<N;i++)
		{
			for(j=0;j<N;j++)
			{
				position[i][j]=new Position();
				this.position[i][j].x=i;
				this.position[i][j].y=j;
			}
		}
	}
}
class Biosome
{
	public String name;//生物体的名字
	public String identity;//生物体的标志
	public Position position;//生物体的位置
}

class Grandpa extends Biosome
{
	public Grandpa()
	{
    this.name="老爷爷";
	this.identity="@";
	this.position=new Position();
	
	}
}

class Snake extends Biosome
{

	public Snake()
	{
    this.name="蛇精";
	this.identity="#";
	this.position=new Position();
	}
	
}

class Scorpion extends Biosome//蝎子精
{
	public Scorpion()
	{
    this.name="蝎子精";
	this.identity="$";
	this.position=new Position();
	}
}

class Underling extends Biosome//小喽啰
{

	public Underling()
	{
    this.name="小喽啰";
	this.identity="*";
	this.position=new Position();
	this.position.x=0;
	this.position.y=0;
	}
}

class Formations//不同的阵型
{
	public Formations() {};
	public void first_queue(int N,CalabashBrothers bros[],Underling underlings[],Scorpion scorpion,Snake snake,Grandpa grandpa,Space space)
	{
		for(int i=(N-7)/2;i<7+(N-7)/2;i++)
		{
			bros[i-(N-7)/2].position=space.position[i][0];
		}
	    underlings[0].position=space.position[(N-7)/2][N-7];
	    underlings[1].position=space.position[(N-7)/2+2][N-6];
	    underlings[2].position=space.position[(N-7)/2+4][N-5];
	    scorpion.position=space.position[(N-7)/2+6][N-4];
	    underlings[3].position=space.position[(N-7)/2+4][N-3];
	    underlings[4].position=space.position[(N-7)/2+2][N-2];
	    underlings[5].position=space.position[(N-7)/2][N-1];
	    
	    grandpa.position=space.position[0][0];
	    snake.position=space.position[0][N-4];
	    System.out.print(grandpa.identity);
	    for(int i=grandpa.position.y+1;i<snake.position.y;i++){System.out.print(" ");}
	    System.out.print(snake.identity);
	    for(int i=snake.position.y+1;i<=N-1;i++) {System.out.print(" ");}
	    for(int i=1;i<=bros[0].position.x-1;i++) 
	    {for(int j=0;j<=N-1;j++) {System.out.print(" ");}System.out.println();}
	    {
	    System.out.print(bros[0].rank);
	    for(int i=1;i<underlings[0].position.y;i++) {System.out.print(" ");}
	    System.out.print(underlings[0].identity);
	    for(int i=underlings[0].position.y+1;i<underlings[5].position.y;i++) {System.out.print(" ");}
	    System.out.print(underlings[5].identity);
	    System.out.println();
	    }
	    {
		    System.out.print(bros[1].rank);
		    for(int i=1;i<N;i++) {System.out.print(" ");}
		    System.out.println();
		    }
	    {
	    	System.out.print(bros[2].rank);
		    for(int i=1;i<underlings[1].position.y;i++) {System.out.print(" ");}
		    System.out.print(underlings[1].identity);
		    for(int i=underlings[1].position.y+1;i<underlings[4].position.y;i++) {System.out.print(" ");}
		    System.out.print(underlings[4].identity);
		    System.out.print(" ");
		    System.out.println();
		    }
	    {
		    System.out.print(bros[3].rank);
		    for(int i=1;i<N;i++) {System.out.print(" ");}
		    System.out.println();
		    }
	    {
	    	System.out.print(bros[4].rank);
		    for(int i=1;i<underlings[2].position.y;i++) {System.out.print(" ");}
		    System.out.print(underlings[2].identity);
		    for(int i=underlings[2].position.y+1;i<underlings[3].position.y;i++) {System.out.print(" ");}
		    System.out.print(underlings[3].identity);
		    System.out.print(" ");
		    System.out.print(" ");
		    System.out.println();
		    }
	    {
		    System.out.print(bros[5].rank);
		    for(int i=1;i<N;i++) {System.out.print(" ");}
		    System.out.println();
		    }
	    {
		    System.out.print(bros[6].rank);
		    for(int i=1;i<scorpion.position.y;i++) {System.out.print(" ");}
		    System.out.print(scorpion.identity);
		    for(int i=1;i<=3;i++) {System.out.print(" ");}
		    System.out.println();
		    }
	}
	public void second_queue(int N,CalabashBrothers bros[],Underling underlings[],Scorpion scorpion,Snake snake,Grandpa grandpa,Space space)
	{
		for(int i=(N-7)/2;i<7+(N-7)/2;i++)
		{
			bros[i-(N-7)/2].position=space.position[i][0];
		}
		 grandpa.position=space.position[0][0];
		 snake.position=space.position[0][N-1];
		 for(int i=(N-7)/2;i<(N-7)/2+6;i++)
		 {
			 underlings[i-(N-7)/2].position=space.position[i][(3*N-9)/2-i];
		 }
		 scorpion.position=space.position[(N-7)/2+6][N-7];
		 System.out.print(grandpa.identity);
		 for(int i=grandpa.position.y+1;i<snake.position.y;i++){System.out.print(" ");}
		 System.out.println(snake.identity);
		 for(int i=1;i<=bros[0].position.x-1;i++) 
		 {for(int j=0;j<=N-1;j++) {System.out.print(" ");}System.out.println();}   
		 System.out.print(bros[0].rank);
		 for(int i=1;i<underlings[0].position.y;i++) {System.out.print(" ");}
		 System.out.println(underlings[0].identity);
		 for(int i=1;i<6;i++)
		 {
		 System.out.print(bros[i].rank);
		 for(int j=1;j<underlings[i].position.y;j++) {System.out.print(" ");}
		 System.out.print(underlings[i].identity);
		 for(int j=0;j<i;j++) {System.out.print(" ");}
		 System.out.println();
		 }
		 System.out.print(bros[6].rank);
		 for(int i=1;i<scorpion.position.y;i++) {System.out.print(" ");}
		 System.out.println(scorpion.identity);
		 for(int i=1;i<=6;i++) {System.out.print(" ");}
		 System.out.println();
	}
}