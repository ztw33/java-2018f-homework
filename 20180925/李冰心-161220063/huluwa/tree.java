package huluwa;
import java.util.*;

public class tree {
	private int row,col;
	private where[][] space;
	private Vector<lives> boys;
	private Vector<lives> mons;
	private cheer yeye;
	private cheer snake;
	private boss Boss;
	
	public tree(int row,int col)
	{
		this.row=row;
		this.col=col;
		
		this.space=new where[row+1][col+1];
		for (int i = 0; i < row; i++) {
		      for (int j = 0; j < col; j++) {
		        this.space[i][j] = new where(i, j);
		      }
		   }
		
		this.boys=new Vector<lives>();
		this.mons=new Vector<lives>();
		for(int i=1;i<=7;i++)
		{
			huluwa tmp=new huluwa(i);
			tmp.set(space[1][i]);
			this.boys.addElement(tmp);
		}
		
		boss t1=new boss();
		t1.set(space[5][5]);
		this.Boss=t1;
		this.mons.addElement(t1);
		for(int i=1;i<7;i++)
		{
			mst t2=new mst();
			t2.set(space[6][6+i]);
			this.mons.addElement(t2);
		}
		
		this.yeye=new cheer(0);
		this.yeye.set(space[0][0]);
		this.snake=new cheer(1);
		this.snake.set(space[row-1][col-1]);

	}
	
//	public int getRow() { return this.row; }

	public int getCol() { return this.col; }

	  public where[][] getSpace() { return this.space; }

	  public Vector<lives> getBoys() { return this.boys; }

	  public Vector<lives> getMons() { return this.mons; }

	  public boss getBoss() { return this.Boss; }

	  public cheer getSnake() { return this.snake; }

	  public cheer getYeye() { return this.yeye; }

	  public boolean inSpace(int x, int y) {
	    if (x >= 0 && x < this.row && y >= 0 && y < this.col)
	      return true;
	    else return false;
	  }
	
	  public void start()
	  {
		  Collections.shuffle(this.boys);
		  Collections.shuffle(this.mons);
		  
		  //printBoys();
		  //printMons();	
	  }
	  
	  public void printBoys()
	  {
		  for(int i=0;i<this.boys.size();i++)
		  {
			  this.boys.elementAt(i).print();
		  }
	  }
	  
	  public void printMons()
	  {
		  for(int i=0;i<this.mons.size();i++)
		  {
			  this.mons.elementAt(i).print();
		  }
	  }
	  
	  
	  
	public static void main(String[] args)
	{
		tree all=new tree(20,20);
		all.start();
		
		list.changshe(all,all.getBoys(),1,3);
		list.yanxing(all,all.getMons(),10,10);
		all.print();
		
		all.yeye.cheers();
		all.snake.cheers();
		
		list.heyi(all,all.getMons(),10,10);
		all.print();
		
	}
	
	public void print()
	{

		for(int i=0;i<col;i++)
		{
			for(int j=0;j<row;j++)
			{
				if(space[i][j].isEmpty())
				{
					System.out.printf("_ ");
				}
				else {
					space[i][j].getLives().print();
					System.out.printf(" ");
				}
			}
			System.out.print('\n');
		}
		
		System.out.println("*********ENDIF**********");
	}
	

}
