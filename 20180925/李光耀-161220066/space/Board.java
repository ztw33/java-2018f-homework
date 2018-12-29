package space;

import java.util.ArrayList;

import creature.Being;
import creature.Human;
import creature.SnakeEssence;
import regulate.Administer;


//注意这里的x、y坐标轴与惯常的不同
/**
* @ClassName: Board
* @Description: 描述整个棋盘
* @author 13745
* @date 2018年11月4日
*
*/
public class Board{
	
	ArrayList<ArrayList<Square<Being>>> board=new ArrayList<>();	
//	private Square[][] board;
//	private static final int xLines=Gui.N;
//	private static final int yLines=Gui.N;
	
		
	public Board(){
		//board=new Square[yLines][xLines];
		for(int i=0;i<Administer.yLines;i++){
			ArrayList<Square<Being>> temp=new ArrayList<>();
			for(int j=0;j<Administer.xLines;j++)
				temp.add(new Square<Being>(i,j,null));
			board.add(temp);
		}
	}
	
	public void putGrandPa(){
		board.get(0).get(0).setBeing(Human.grandPa);
	}
	
	public void putSnake(){
		board.get(Administer.xLines-1).get(0).setBeing(SnakeEssence.snakeWoman);
	}
	public ArrayList<ArrayList<Square<Being>>> getBoard(){
		return board;
	}
	
	
	
// 可以废弃 曾经用于字符阵列的打印
//	public void show(){
//		for(int i=0;i<xLines;i++){
//			for(int j=0;j<yLines;j++){
//				if(board[i][j].getBeing()!=null)
//					System.out.print("*");
//				else
//					System.out.print("-");
//			}
//			System.out.println("");
//		}
//	}
	
	
}
