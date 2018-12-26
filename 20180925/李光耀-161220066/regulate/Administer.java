package regulate;


import java.util.ArrayList;

import creature.Being;
import gui.Gui;
import space.Board;
import space.Square;
/**
* @ClassName: Administer
* @Description: 用于联系UI和内部真实事物
* @author 13745
* @date 2018年11月4日
*
*/
public class Administer implements LinkGUI2Inside{
//  无需声明下列对象 应为将方法申明为了static
	public static BoardAdminister boardAdminister=new BoardAdminister();
	public static GoodManAdminister goodManAdminister=new GoodManAdminister();
	public static BadManAdminister badManAdminister=new BadManAdminister();
	public static FormationAdminister formationAdminister=new FormationAdminister();
	
	public static final int xLines=Gui.N;
	public static final int yLines=Gui.N;
	private Board myBoard=new Board();	//需要固定
	

	/**
	* @Title: getputNextMonsterFormation
	* @Description: formationAdminister用于生成阵型坐标，badManAdminister对formation进行生物填充，boardAdminister用于最后的放置
	*/
	public void getputNextMonsterFormation(){
		ArrayList<Square<Being>> formation=formationAdminister.getNextMonsterFormation().getFormation();
		badManAdminister.putNextMonsterFormation(formation);
		if(boardAdminister.putFormationInBoard(formation, myBoard.getBoard())==false){	//fix bug
			formation=formationAdminister.getPreMonsterFormation().getFormation();
			badManAdminister.putNextMonsterFormation(formation);
			boardAdminister.putFormationInBoard(formation, myBoard.getBoard());
		}
	}
	
	/**
	* @Title: getputHuLuFormation
	* @Description: 同上
	*/
	public void getputHuLuFormation(){
		ArrayList<Square<Being>> formation=formationAdminister.getHuLuFormation().getFormation();
		goodManAdminister.putHuLuWaInFormation(formation);
		boardAdminister.putFormationInBoard(formation, myBoard.getBoard());
	}
	
	
	/**
	* @Title: putGrandPa
	* @Description: 初始放置老人
	*/
	public void putGrandPa(){
		goodManAdminister.putGrandPa(myBoard.getBoard());
	}
	
	/**
	* @Title: putSnake
	* @Description: 初始放置蛇精
	*/
	public void putSnake(){
		badManAdminister.putSnake(myBoard.getBoard());
	}
	
	/**
	* @Title: clearHuLuWas
	* @Description: 将棋盘上葫芦娃清理出去，便于下次重新放置
	*/
	public void clearHuLuWas(){
		boardAdminister.clearBoardHuLuWa(myBoard.getBoard());
	}
	
	/**
	* @Title: clearMonsters
	* @Description: 同上
	*/
	public void clearMonsters(){
		boardAdminister.clearBoardMonster(myBoard.getBoard());
	}
	
	/**
	* @Title: moveRightManual
	* @Description: 用于老人和蛇精的移动
	*/
	public void moveRightManual(Class<?> c){
		boardAdminister.moveManual(c, BoardAdminister.boardRightDirection, myBoard.getBoard());
	}
	
	/**
	* @Title: moveLeftManual
	* @Description: 同上
	*/
	public void moveLeftManual(Class<?> c){
		boardAdminister.moveManual(c, BoardAdminister.boardLeftDirection, myBoard.getBoard());
	}
	
	/**
	* @Title: moveLeftManual
	* @Description: 同上
	*/
	public void moveUpManual(Class<?> c){
		boardAdminister.moveManual(c, BoardAdminister.boardUpDirection, myBoard.getBoard());
		//myBoard.moveManual(c,0,-1);
	}
	
	/**
	* @Title: moveLeftManual
	* @Description: 同上
	*/
	public void moveDownManual(Class<?> c){
		boardAdminister.moveManual(c, BoardAdminister.boardDownDirection, myBoard.getBoard());
		//myBoard.moveManual(c,0,1);
	}
	
	/**
	* @Title: getBoard
	* @Description: 供UI使用 实现每一个JPanel和Square的映射关系
	*/
	public Board getBoard(){
		return myBoard;
	}

	/**
	* @Title: shuffleGoodHuLus
	* @Description: 用于对葫芦娃乱序
	*/
	public void shuffleGoodHuLus(){
		goodManAdminister.shuffleHuLus();
	}
	/**
	* @Title: sortGoodHuLus
	* @Description: 用于排序
	*/
	public void sortGoodHuLus(){
		goodManAdminister.sortHuLus();
	}
	/**
	* @Title: grandpaCheer
	* @Description: 进行内部老人实现加油助威
	*/
	public void grandpaCheer(){
		goodManAdminister.grandpaEncourageHuLuWa();
	}
	/**
	* @Title: snakeCheer
	* @Description: 同上
	*/
	public void snakeCheer(){
		badManAdminister.snakeEncourageMonster();
	}
// 可以废弃 曾经用于字符阵列的打印
//	public void show(){
//		myBoard.show();
//	}

}


