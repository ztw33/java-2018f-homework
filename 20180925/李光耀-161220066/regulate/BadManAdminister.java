package regulate;


import java.util.ArrayList;

import creature.Being;
import creature.LittleMonster;
import creature.Scorpion;
import creature.SnakeEssence;
import space.Square;


/**
* @ClassName: BadManAdminister
* @Description: 完成对formation上生物体的填充
* @author 13745
* @date 2018年11月4日
*
*/
public class BadManAdminister {
	public  void putNextMonsterFormation(ArrayList<Square<Being>> formation){
		for(int i=0;i<formation.size();i++){
			if(i==0){
				formation.get(i).setBeing(Scorpion.scorpionMan);
			}
			else{
				formation.get(i).setBeing(new LittleMonster(""));
			}
		}
	}
	/**
	* @Title: putSnake
	* @Description: 蛇精初始的放置
	*/
	public  void putSnake(ArrayList<ArrayList<Square<Being>>> board){
		board.get(Administer.xLines-1).get(0).setBeing(SnakeEssence.snakeWoman);
	}
	/**
	* @Title: snakeEncourageMonster
	* @Description:控制蛇精加油
	*/
	public void snakeEncourageMonster(){
		SnakeEssence.snakeWoman.cheerUp();
	}
}
