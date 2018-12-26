package regulate;


import java.util.ArrayList;

import creature.Being;
import creature.Creature;
import creature.HuLuWa;
import creature.LittleMonster;
import creature.Scorpion;
import space.DirectionVector;
import space.FormationFactory;
import space.Square;

/**
* @ClassName: BoardAdminister
* @Description: 实现对整个Board的管理 清除、添加等
* @author 13745
* @date 2018年11月4日
*
*/
public class BoardAdminister {
	//定义上下左右
	public static DirectionVector boardLeftDirection=new DirectionVector(-1,0);
	public static DirectionVector boardRightDirection=new DirectionVector(1,0);
	public static DirectionVector boardUpDirection=new DirectionVector(0,-1);
	public static DirectionVector boardDownDirection=new DirectionVector(0,1);
	
	/**
	* @Title: moveManual
	* @Description: 控制特定类型生物的移动 实际上只有老人和蛇精
	*/
	public  void moveManual(Class<?> c,DirectionVector directionVector,ArrayList<ArrayList<Square<Being>>> board){
		int x=directionVector.getX();
		int y=directionVector.getY();
		for(int i=0;i<Administer.xLines;i++){
			for(int j=0;j<Administer.yLines;j++){
				if(board.get(i).get(j).getBeing()!=null){
					Creature temp=(Creature)board.get(i).get(j).getBeing();
					if(c.isInstance(temp)){
						if((i+x)>=0&&(i+x)<Administer.xLines&&(j+y)>=0&&(j+y)<Administer.yLines){
							if(board.get(i+x).get(j+y).getBeing()==null){
								Square<Being> squaretemp=board.get(i+x).get(j+y);
								board.get(i+x).set(j+y,board.get(i).get(j));
								board.get(i).set(j, squaretemp);
								return;
							}
						}
					}
				}
			}
		}
		return;
	}
	
	/**
	* @Title: putFormationInBoard
	* @Description: 将formation放置在棋盘上，可能会失败(原因:老人和蛇精位置阻碍了阵型的放置)
	*/
	public  boolean putFormationInBoard(ArrayList<Square<Being>> formation,ArrayList<ArrayList<Square<Being>>> board){
		boolean flag=true;
		for(Square<Being> a:formation){
			int c=a.getY();
			int r=a.getX();
			if(board.get(r).get(c).getBeing()!=null){
				flag=false;
			}
		}
		if(flag==false){
			return false;
		}
		for(Square<Being> a:formation){
			int c=a.getY();
			int r=a.getX();
			board.get(r).set(c,a);
		}
		new FormationFactory().showCurFormation();
		return true;
	}
	public  void clearBoardMonster(ArrayList<ArrayList<Square<Being>>> board){
		for(int i=0;i<Administer.xLines;i++){
			for(int j=0;j<Administer.yLines;j++){
				if(board.get(i).get(j).getBeing()!=null){
					Being temp=board.get(i).get(j).getBeing();
					if(temp instanceof LittleMonster || temp instanceof Scorpion){
						board.get(i).get(j).setBeing(null);
					}
				}
			}
		}
	}
	public  void clearBoardHuLuWa(ArrayList<ArrayList<Square<Being>>> board){
		for(int i=0;i<Administer.xLines;i++){
			for(int j=0;j<Administer.yLines;j++){
				if(board.get(i).get(j).getBeing()!=null){
					Being temp=board.get(i).get(j).getBeing();
					if(temp instanceof HuLuWa){
						board.get(i).get(j).setBeing(null);
					}
				}
			}
		}
	}
}
