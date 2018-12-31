package regulate;

import java.util.ArrayList;

import creature.Being;
import creature.Human;
import space.Square;

/**
* @ClassName: GoodManAdminister
* @Description: 描述同BadManAdminister
* @author 13745
* @date 2018年11月4日
*
*/
public class GoodManAdminister {
	public static HuLuWaAdminister huLuWaAdminister=new HuLuWaAdminister();
	
	public  void putGrandPa(ArrayList<ArrayList<Square<Being>>> board){
		board.get(0).get(0).setBeing(Human.grandPa);
	}	
	public  void putHuLuWaInFormation(ArrayList<Square<Being>> formation){
		for(int i=0;i<huLuWaAdminister.getBrothers().size();i++){
			formation.get(i).setBeing(huLuWaAdminister.getBrothers().get(i));
		}
	}
	public  void shuffleHuLus(){
		huLuWaAdminister.shuffleHuLuWas();
	}
	public  void sortHuLus(){
		huLuWaAdminister.sortHuLuWas();
	}
	public void grandpaEncourageHuLuWa(){
		Human.grandPa.cheerUp();
	}
}
