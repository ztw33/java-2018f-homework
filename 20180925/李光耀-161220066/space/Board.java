package space;


import creature.Creature;
import creature.CreatureType;
import creature.Human;
import creature.SnakeEssence;
import gui.Gui;


//注意这里的x、y坐标轴与惯常的不同
public class Board{
	
		
	private Square[][] board;
	private static final int xLines=Gui.N;
	private static final int yLines=Gui.N;
	
		
	public Board(){
		board=new Square[yLines][xLines];
		for(int i=0;i<yLines;i++){
			for(int j=0;j<xLines;j++)
				board[i][j]=new Square(i,j,null);
		}
	}
	public boolean putFormation(Square[] formation){
		boolean flag=true;
		for(Square a:formation){
			int c=a.getY();
			int r=a.getX();
			if(board[r][c].getBeing()!=null){
				flag=false;
			}
		}
		
		if(flag==false){
			return false;
		}
		for(Square a:formation){
			int c=a.getY();
			int r=a.getX();
			
			board[r][c]=a;
		}
		return true;
	}
	
	public void clearBoardMonster(){
		for(int i=0;i<xLines;i++){
			for(int j=0;j<yLines;j++){
				if(board[i][j].getBeing()!=null){
					Creature temp=(Creature)board[i][j].getBeing();
					if(temp.getType()==CreatureType.LITTLEMONSTER || temp.getType()==CreatureType.SCORPION){
						board[i][j].setBeing(null);
					}
				}
			}
		}
	}
	public void clearBoardHuLuWa(){
		for(int i=0;i<xLines;i++){
			for(int j=0;j<yLines;j++){
				if(board[i][j].getBeing()!=null){
					Creature temp=(Creature)board[i][j].getBeing();
					if(temp.getType()==CreatureType.HULUWA){
						board[i][j].setBeing(null);
					}
				}
			}
		}
	}
	
	public void putGrandPa(){
		board[0][0].setBeing(Human.grandPa);
	}
	
	public void putSnake(){
		board[xLines-1][0].setBeing(SnakeEssence.snakeWoman);
	}
	public Square[][] getBoard(){
		return board;
	}
	
	public void moveManual(CreatureType c,int x,int y){
//		for(int i=0;i<xLines;i++){
//			for(int j=0;j<yLines;j++){
//				if(board[i][j].getBeing()!=null){
//					System.out.print("*");
//				}
//				else{
//					System.out.print("-");
//				}
//			}
//			System.out.println("");
//		}
		
		for(int i=0;i<xLines;i++){
			for(int j=0;j<yLines;j++){
				if(board[i][j].getBeing()!=null){
					Creature temp=(Creature)board[i][j].getBeing();
					System.out.println(temp.getType());
					System.out.println(c);
					if(temp.getType()==c){
						if((i+x)>=0&&(i+x)<xLines&&(j+y)>=0&&(j+y)<yLines){
							if(board[i+x][j+y].getBeing()==null){
								//System.out.println("x:"+x+" y:"+y+" i:"+i+" j:"+j);
								Square squaretemp=board[i+x][j+y];
								board[i+x][j+y]=board[i][j];
								board[i][j]=squaretemp;
								return;
							}
						}
					}
				}
			}
		}
		return;
	}
	
	public void show(){
		for(int i=0;i<xLines;i++){
			for(int j=0;j<yLines;j++){
				if(board[i][j].getBeing()!=null)
					System.out.print("*");
				else
					System.out.print("-");
			}
			System.out.println("");
		}
	}
	
	
}
